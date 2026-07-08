package com.Nanas.demo.aplicacion.puertos.entradas;

import com.Nanas.demo.dominio.modelos.Cliente;

public interface ClienteService {
    Cliente registrarCliente(Cliente cliente);

    Cliente obtenerPerfil(Integer idUsuario);

    Cliente actualizarPerfil(Integer idUsuario, Cliente cliente);
}
