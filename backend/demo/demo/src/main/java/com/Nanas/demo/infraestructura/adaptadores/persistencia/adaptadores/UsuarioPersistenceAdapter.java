package com.Nanas.demo.infraestructura.adaptadores.persistencia.adaptadores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.Nanas.demo.dominio.modelos.Cliente;
import com.Nanas.demo.dominio.modelos.Nana;
import com.Nanas.demo.dominio.modelos.Usuario;
import com.Nanas.demo.dominio.puertos.salidas.NanaRepositoryPort;
import com.Nanas.demo.dominio.puertos.salidas.UsuarioRepositoryPort;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.ClienteEntity;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.DireccionEntity;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.NanaEntity;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.UsuarioEntity;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios.SpringDataClienteRepository;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios.SpringDataDireccionRepository;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios.SpringDataNanaRepository;
import com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios.SpringDataUsuarioRepository;

@Component
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort, NanaRepositoryPort  {

    private final SpringDataUsuarioRepository usuarioRepository;
    private final SpringDataClienteRepository clienteRepository;
    private final SpringDataNanaRepository nanaRepository;
    private final SpringDataDireccionRepository direccionRepository;


    public UsuarioPersistenceAdapter(SpringDataUsuarioRepository usuarioRepository,
            SpringDataClienteRepository clienteRepository, SpringDataNanaRepository nanaRepository,
            SpringDataDireccionRepository direccionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.nanaRepository = nanaRepository;
        this.direccionRepository = direccionRepository;
    }

    

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo).map(entity -> {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(entity.getIdUsuario());
            usuario.setNombre(entity.getNombre());
            usuario.setApellido(entity.getApellido());
            usuario.setCorreo(entity.getCorreo());
            usuario.setTelefono(entity.getTelefono());
            usuario.setDni(entity.getDni());
            usuario.setPasswordHash(entity.getPasswordHash());
            usuario.setFechaNacimiento(entity.getFechaNacimiento());
            usuario.setFotoPerfil(entity.getFotoPerfil());
            usuario.setTipoUsuario(entity.getTipoUsuario());
            usuario.setEstadoCuenta(entity.getEstadoCuenta());
            usuario.setFechaRegistro(entity.getFechaRegistro());
            usuario.setUltimoLogin(entity.getUltimoLogin());
            return usuario;
        });
        
    }

    @Override
    public boolean existePorCorreo(String correo) {
        
        return usuarioRepository.existsByCorreo(correo);
    }

   @Override
    public boolean existePorDni(String dni) {
        
        return usuarioRepository.existsByDni(dni);
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        // Mapear los campos generales para cliente de usuarioEntity
        usuarioEntity.setNombre(cliente.getNombre());
        usuarioEntity.setApellido(cliente.getApellido());
        usuarioEntity.setCorreo(cliente.getCorreo());
        usuarioEntity.setTelefono(cliente.getTelefono());
        usuarioEntity.setDni(cliente.getDni());
        usuarioEntity.setPasswordHash(cliente.getPasswordHash());
        usuarioEntity.setFechaNacimiento(cliente.getFechaNacimiento());
        usuarioEntity.setTipoUsuario(cliente.getTipoUsuario());
        usuarioEntity.setEstadoCuenta(cliente.getEstadoCuenta());
        usuarioEntity.setFechaRegistro(LocalDateTime.now());

        ClienteEntity clienteEntity = new ClienteEntity();
        // Mapear los campos específicos de cliente 
        clienteEntity.setUsuario(usuarioEntity);
        clienteEntity.setTipoCliente(cliente.getTipoCliente());

        // Guardar el clienteEntity en la base de datos
        ClienteEntity guardado = clienteRepository.save(clienteEntity);
        cliente.setIdCliente(guardado.getIdCliente());
        cliente.setIdUsuario(guardado.getUsuario().getIdUsuario());
        cliente.setFechaRegistro(guardado.getUsuario().getFechaRegistro());
        cliente.setFechaCreacion(guardado.getFechaCreacion());
        return cliente;



    }

    @Override
    public Nana guardarNana(Nana nana) {
        
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        // Mapear los campos generales para nana de usuarioEntity
        usuarioEntity.setNombre(nana.getNombre());
        usuarioEntity.setApellido(nana.getApellido());
        usuarioEntity.setCorreo(nana.getCorreo());
        usuarioEntity.setTelefono(nana.getTelefono());
        usuarioEntity.setDni(nana.getDni());
        usuarioEntity.setPasswordHash(nana.getPasswordHash());
        usuarioEntity.setFechaNacimiento(nana.getFechaNacimiento());
        usuarioEntity.setTipoUsuario(nana.getTipoUsuario());
        usuarioEntity.setEstadoCuenta(nana.getEstadoCuenta());

        NanaEntity nanaEntity = new NanaEntity();
        // Mapear los campos específicos de nana    
        nanaEntity.setUsuario(usuarioEntity);
        nanaEntity.setIdUniversidad(nana.getIdUniversidad());
        nanaEntity.setCodigoUniversitario(nana.getCodigoUniversitario());
        nanaEntity.setCarrera(nana.getCarrera());
        nanaEntity.setCiclo(nana.getCiclo());
        nanaEntity.setDescripcion(nana.getDescripcion());
        nanaEntity.setExperiencia(nana.getExperiencia());
        nanaEntity.setTarifaHora(nana.getTarifaHora());

        // Guardar el nanaEntity en la base de datos
        NanaEntity guardada = nanaRepository.save(nanaEntity);
        nana.setIdNana(guardada.getIdNana());
        nana.setIdUsuario(guardada.getUsuario().getIdUsuario());
        nana.setFechaRegistro(guardada.getUsuario().getFechaRegistro());
        nana.setFechaCreacion(guardada.getFechaCreacion());
        
        return nana;
    }

    @Override
    public List<Nana> obtenerTodas() {
        
        //obtiene todas las nanas de la base de datos en formato de persistencia
        List<NanaEntity> nanaEntities = nanaRepository.findAll();
        //prepara el contenedor basio para transformar la entidades a objetos del dominio(objetos de negocio)
        List<Nana> dominioNanas = new ArrayList<>();
        for(NanaEntity entity : nanaEntities) {
            Nana nana = new Nana();
            nana.setIdNana(entity.getIdNana());
            nana.setIdUsuario(entity.getUsuario().getIdUsuario());
            nana.setNombre(entity.getUsuario().getNombre());
            nana.setApellido(entity.getUsuario().getApellido());
            nana.setCorreo(entity.getUsuario().getCorreo());
            nana.setTelefono(entity.getUsuario().getTelefono());
            nana.setTarifaHora(entity.getTarifaHora());
            nana.setCarrera(entity.getCarrera());
            nana.setCiclo(entity.getCiclo());

            //buscar coordenadas de la nana en la tabla direccion
            // Busca la primera dirección del usuario vinculado a esta entidad.
            Optional<DireccionEntity> dir = direccionRepository.findByIdUsuario(entity.getUsuario().getIdUsuario());
            //si encuentra la direccion, asigna las coordenadas a la nana
            if (dir.isPresent()) {
                nana.setLatitud(dir.get().getLatitud());
                nana.setLongitud(dir.get().getLongitud());
            } else {
                
                nana.setLatitud(0.0);
                nana.setLongitud(0.0);
            }
            dominioNanas.add(nana);
        }

        return dominioNanas;
    }



@Override
public Nana buscarNanaPorId(Integer idNana) {
    // 1. Buscamos la entidad individual en la base de datos
    Optional<NanaEntity> entityOpt = nanaRepository.findById(idNana);
    
    if (entityOpt.isEmpty()) {
        throw new IllegalArgumentException("No se encontró ninguna nana registrada con el ID: " + idNana);
    }
    
    NanaEntity entity = entityOpt.get();
    
    Nana nana = new Nana();
    nana.setIdNana(entity.getIdNana());
    nana.setIdUsuario(entity.getUsuario().getIdUsuario());
    nana.setNombre(entity.getUsuario().getNombre());
    nana.setApellido(entity.getUsuario().getApellido());
    nana.setCorreo(entity.getUsuario().getCorreo());
    nana.setTelefono(entity.getUsuario().getTelefono());
    nana.setTarifaHora(entity.getTarifaHora());
    nana.setCarrera(entity.getCarrera());
    nana.setCiclo(entity.getCiclo());
    
    // Mapeamos también los campos del módulo de calificación
    nana.setRatingPromedio(entity.getRatingPromedio());
    nana.setCantidadReviews(entity.getCantidadReviews());
    
    return nana;
}

@Override
public Usuario guardarUsuarioGenerico(Usuario usuario) {
    // buscamos por el id al usuario 
    UsuarioEntity entity = usuarioRepository.findById(usuario.getIdUsuario())
            .orElseThrow(() -> new IllegalArgumentException("No se encontró el usuario a actualizar con ID: " + usuario.getIdUsuario()));

    // seteamos los campos que cambian al hacer el login 
    entity.setNombre(usuario.getNombre());
    entity.setApellido(usuario.getApellido());
    entity.setTelefono(usuario.getTelefono());
    entity.setFotoPerfil(usuario.getFotoPerfil());
    entity.setEstadoCuenta(usuario.getEstadoCuenta());
    entity.setUltimoLogin(usuario.getUltimoLogin());

    // guardamos los datos actualizados cno el  repositorio inyectado
    UsuarioEntity guardado = usuarioRepository.save(entity);

    // retornamos los valores para que el dominio los consuma
    Usuario usuarioD = new Usuario();
    usuarioD.setIdUsuario(guardado.getIdUsuario());
    usuarioD.setNombre(guardado.getNombre());
    usuarioD.setApellido(guardado.getApellido());
    usuarioD.setCorreo(guardado.getCorreo());
    usuarioD.setTelefono(guardado.getTelefono());
    usuarioD.setDni(guardado.getDni());
    usuarioD.setPasswordHash(guardado.getPasswordHash());
    usuarioD.setFechaNacimiento(guardado.getFechaNacimiento());
    usuarioD.setFotoPerfil(guardado.getFotoPerfil());
    usuarioD.setTipoUsuario(guardado.getTipoUsuario());
    usuarioD.setEstadoCuenta(guardado.getEstadoCuenta());
    usuarioD.setFechaRegistro(guardado.getFechaRegistro());
    usuarioD.setUltimoLogin(guardado.getUltimoLogin());

    return usuarioD;
}
    
    
}
