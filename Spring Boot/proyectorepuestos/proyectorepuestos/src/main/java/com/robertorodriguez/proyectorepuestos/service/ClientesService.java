package com.robertorodriguez.proyectorepuestos.service;

import com.robertorodriguez.proyectorepuestos.model.Clientes;

import java.util.List;

public interface ClientesService {
    List<Clientes> getAllClientes();
    Clientes getClienteById(Integer id);
    Clientes saveClientes(Clientes clientes);
    Clientes updateClientes(Integer id, Clientes clientes);
    void deleteClientes(Integer id);
}
