package com.Nanas.demo.aplicacion.servicios;

import org.springframework.stereotype.Service;

import com.Nanas.demo.aplicacion.puertos.entradas.ClienteService;
import com.Nanas.demo.dominio.modelos.Cliente;
import com.Nanas.demo.dominio.modelos.Usuario;
import com.Nanas.demo.dominio.puertos.salidas.UsuarioRepositoryPort;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;
    

    public ClienteServiceImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }


    @Override
    public Cliente registrarCliente(Cliente cliente) {


        if (usuarioRepositoryPort.existePorCorreo(cliente.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        if (usuarioRepositoryPort.existePorDni(cliente.getDni())) {
            throw new IllegalArgumentException("El DNI ya está registrado");
        }

        if(cliente.getApellido() == null || cliente.getApellido().isEmpty()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }

        cliente.setTipoUsuario("CLIENTE");
        if(cliente.getEstadoCuenta() == null ){
            cliente.setEstadoCuenta("PENDIENTE");
        }

        if(cliente.getTipoCliente() == null){
            cliente.setTipoCliente("PADRE"); //valor por defecto
        }

        return usuarioRepositoryPort.guardarCliente(cliente);
    }

    @Override
    public Cliente obtenerPerfil(Integer idUsuario) {

        Usuario usuario = usuarioRepositoryPort.buscarPorId(idUsuario)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cliente no encontrado"));

        Cliente cliente = new Cliente();

        cliente.setIdUsuario(usuario.getIdUsuario());
        cliente.setNombre(usuario.getNombre());
        cliente.setApellido(usuario.getApellido());
        cliente.setCorreo(usuario.getCorreo());
        cliente.setTelefono(usuario.getTelefono());
        cliente.setDni(usuario.getDni());
        cliente.setFechaNacimiento(usuario.getFechaNacimiento());
        cliente.setFotoPerfil(usuario.getFotoPerfil());
        cliente.setEstadoCuenta(usuario.getEstadoCuenta());
        cliente.setTipoUsuario(usuario.getTipoUsuario());

        return cliente;
    }

    @Override
        public Cliente actualizarPerfil(Integer idUsuario, Cliente cliente) {

            return usuarioRepositoryPort.actualizarCliente(idUsuario, cliente);

    }
    
}
