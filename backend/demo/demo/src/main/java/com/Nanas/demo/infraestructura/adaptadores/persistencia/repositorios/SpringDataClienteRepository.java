package com.Nanas.demo.infraestructura.adaptadores.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nanas.demo.infraestructura.adaptadores.persistencia.entidades.ClienteEntity;

public interface SpringDataClienteRepository extends JpaRepository<ClienteEntity, Integer>{
    
    
    
}
