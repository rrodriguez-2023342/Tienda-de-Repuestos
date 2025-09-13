package com.robertorodriguez.proyectorepuestos.repository;

import com.robertorodriguez.proyectorepuestos.model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedores, Integer> {

}
