package com.robertorodriguez.proyectorepuestos.service;

import com.robertorodriguez.proyectorepuestos.model.Ventas;

import java.util.List;

public interface VentaService {
    List<Ventas> getAllVentas();
    Ventas getVentasById(int id);
    Ventas saveVentas(Ventas ventas);
    Ventas  updateVentas(Integer id, Ventas ventas);
    void deleteVentas(Integer id);
}
