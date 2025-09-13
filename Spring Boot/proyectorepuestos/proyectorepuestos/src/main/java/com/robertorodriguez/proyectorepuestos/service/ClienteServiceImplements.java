package com.robertorodriguez.proyectorepuestos.service;

import com.robertorodriguez.proyectorepuestos.controller.ValidacionEmail;
import com.robertorodriguez.proyectorepuestos.model.Clientes;
import com.robertorodriguez.proyectorepuestos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClientesService{
    private final ClienteRepository clienteRepository;

    public ClienteServiceImplements(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Clientes> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Clientes getClienteById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Clientes saveClientes(Clientes clientes) {
        ValidacionEmail.validarEmail(clientes.getCorreoCliente());
        List<Clientes> listaClientes = clienteRepository.findAll();
        for (Clientes c :  listaClientes) {
            if (c.getTelefonoCliente().equalsIgnoreCase(clientes.getTelefonoCliente())) {
                clientes.setTelefonoCliente("ERROR_TELEFONO_REPETIDO");
                return clientes;
            }
            if(c.getCorreoCliente().equalsIgnoreCase(clientes.getCorreoCliente())) {
                clientes.setCorreoCliente("ERROR_CORREO_REPETIDO");
                return clientes;
            }
        }
        return clienteRepository.save(clientes);
    }

    @Override
    public Clientes updateClientes(Integer id, Clientes clientes) {
        ValidacionEmail.validarEmail(clientes.getCorreoCliente());
        Clientes existingCliente = clienteRepository.findById(id).orElse(null);
        if (existingCliente != null) {
            List<Clientes> listaClientes = clienteRepository.findAll();
            for (Clientes c :  listaClientes) {
                if (!c.getIdCliente().equals(id)) {
                    if (c.getTelefonoCliente().equalsIgnoreCase(clientes.getTelefonoCliente())) {
                        clientes.setTelefonoCliente("ERROR_TELEFONO_REPETIDO");
                        return clientes;
                    }
                    if(c.getCorreoCliente().equalsIgnoreCase(clientes.getCorreoCliente())) {
                        clientes.setCorreoCliente("ERROR_CORREO_REPETIDO");
                        return clientes;
                    }
                }
            }
            existingCliente.setNombreCliente(clientes.getNombreCliente());
            existingCliente.setApellidoCliente(clientes.getApellidoCliente());
            existingCliente.setTelefonoCliente(clientes.getTelefonoCliente());
            existingCliente.setCorreoCliente(clientes.getCorreoCliente());
            return clienteRepository.save(existingCliente);
        }
        return null;
    }

    @Override
    public void deleteClientes(Integer id) {
        clienteRepository.deleteById(id);
    }
}
