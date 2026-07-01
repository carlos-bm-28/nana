package com.Nanas.demo.infraestructura.adaptadores.web.Controladores;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nanas.demo.aplicacion.puertos.entradas.AuthService;
import com.Nanas.demo.dominio.modelos.Usuario;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        try {
            String correo = credenciales.get("correo");
            String contrasena = credenciales.get("contrasena");

            if (correo == null || contrasena == null || correo.isEmpty() || contrasena.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Correo y contraseña son obligatorios"));
            }

            // Invoca el caso de uso transversal
            Usuario usuarioLogueado = authService.iniciarSesion(correo, contrasena);
            
            // Retorna el objeto completo a Angular
            return ResponseEntity.ok(usuarioLogueado);

        } catch (IllegalArgumentException e) {
            // Error 400: Datos incorrectos o inexistentes
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (IllegalStateException e) {
            // Error 403: Cuenta suspendida o inactiva
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            // Error 500: Cualquier caída inesperada en el servidor
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Ocurrió un error inesperado en el servidor"));
        }
    }
}
