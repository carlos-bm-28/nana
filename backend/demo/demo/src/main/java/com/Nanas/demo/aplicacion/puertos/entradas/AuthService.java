package com.Nanas.demo.aplicacion.puertos.entradas;

import com.Nanas.demo.dominio.modelos.Usuario;

public interface AuthService {
    Usuario iniciarSesion (String Correro, String contrasena);
}
