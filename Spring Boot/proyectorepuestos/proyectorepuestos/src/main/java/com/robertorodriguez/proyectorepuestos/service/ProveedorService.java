package com.robertorodriguez.proyectorepuestos.service;

import com.robertorodriguez.proyectorepuestos.model.Proveedores;

import java.util.List;

public interface ProveedorService {
    List<Proveedores> getAllProveedores();
    Proveedores getProveedorById(Integer id);
    Proveedores saveProveedores(Proveedores proveedores);
    Proveedores updateProveedores(Integer id, Proveedores proveedores);
    void deleteProveedores(Integer id);
}
