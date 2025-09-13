package com.robertorodriguez.proyectorepuestos.repository;

import com.robertorodriguez.proyectorepuestos.model.Repuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestosRepository extends JpaRepository<Repuestos,Integer> {

}
