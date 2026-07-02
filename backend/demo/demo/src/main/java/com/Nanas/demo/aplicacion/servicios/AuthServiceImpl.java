package com.Nanas.demo.aplicacion.servicios;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.Nanas.demo.aplicacion.puertos.entradas.AuthService;
import com.Nanas.demo.dominio.modelos.Usuario;
import com.Nanas.demo.dominio.puertos.salidas.UsuarioRepositoryPort;


@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;
    
    public AuthServiceImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario iniciarSesion(String correo, String contrasena) {
        // buscamos y desenvolvemos el Optional correctamente en una sola línea
        Usuario usuario = usuarioRepositoryPort.buscarPorCorreo(correo)
                .orElseThrow(() -> new IllegalArgumentException("El correo electrónico no existe."));

        // Validamos la contraseña usando tu campo passwordHash
        if (!usuario.getPasswordHash().equals(contrasena)) {
            throw new IllegalArgumentException("Contraseña incorrecta.");
        }

        // validar si la cuenta no esta suspendida
        if (usuario.getEstadoCuenta() != null && "SUSPENDIDA".equalsIgnoreCase(usuario.getEstadoCuenta())) {
            throw new IllegalStateException("Esta cuenta se encuentra suspendida.");
        }

        // actualizamos el rastro del último ingreso en el objeto en memoria
        usuario.setUltimoLogin(LocalDateTime.now());
        
        
        return usuarioRepositoryPort.guardarUsuarioGenerico(usuario); 
    }
    
}
