package com.Nanas.demo.infraestructura.adaptadores.web.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nanas.demo.aplicacion.puertos.entradas.ClienteService;
import com.Nanas.demo.dominio.modelos.Cliente;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") 
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente nuevoCliente = clienteService.registrarCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
        } catch (IllegalArgumentException e) {
            // validacion si existe dni o correo
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al procesar el registro del cliente.");
        }
    }

    @GetMapping("/perfil/{idUsuario}")
    public ResponseEntity<?> obtenerPerfil(@PathVariable Integer idUsuario){

        try {

            Cliente cliente = clienteService.obtenerPerfil(idUsuario);

            return ResponseEntity.ok(cliente);

        } catch (IllegalArgumentException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());

    }

}

    @PutMapping("/perfil/{idUsuario}")
    public ResponseEntity<?> actualizarPerfil(
        @PathVariable Integer idUsuario,
        @RequestBody Cliente cliente){

        try{

            Cliente actualizado = 
                clienteService.actualizarPerfil(idUsuario, cliente);

            return ResponseEntity.ok(actualizado);


        }catch(Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar perfil");

        }

    }
}
