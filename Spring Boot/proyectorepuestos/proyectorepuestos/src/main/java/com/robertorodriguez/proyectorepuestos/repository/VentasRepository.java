package com.robertorodriguez.proyectorepuestos.repository;

import com.robertorodriguez.proyectorepuestos.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas,Integer> {
}
