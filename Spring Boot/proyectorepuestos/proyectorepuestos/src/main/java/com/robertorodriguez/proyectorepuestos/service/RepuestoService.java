package com.robertorodriguez.proyectorepuestos.service;

import com.robertorodriguez.proyectorepuestos.model.Repuestos;

import java.util.List;

public interface RepuestoService {
    List<Repuestos> getAllRepuestos();
    Repuestos getRepuestoById(int id);
    Repuestos saveRepuesto(Repuestos repuestos);
    Repuestos updateRepuesto(Integer id, Repuestos repuestos);
    void deleteRepuesto(Integer id);
}
