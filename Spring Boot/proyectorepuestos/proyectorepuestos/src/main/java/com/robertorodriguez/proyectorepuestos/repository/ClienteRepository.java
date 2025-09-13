package com.robertorodriguez.proyectorepuestos.repository;

import com.robertorodriguez.proyectorepuestos.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
}
