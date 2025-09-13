package com.robertorodriguez.proyectorepuestos.controller;

import com.robertorodriguez.proyectorepuestos.model.Clientes;
import com.robertorodriguez.proyectorepuestos.service.ClientesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClientesService clientesService;

    public ClienteController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public List<Clientes> listarClientes(){
        return clientesService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Clientes getClientesPorId(@PathVariable Integer id){
        return clientesService.getClienteById(id);
    }

    @PostMapping
    public String createCliente(@RequestBody Clientes clientes){
        try {
            Clientes result = clientesService.saveClientes(clientes);
            if("ERROR_TELEFONO_REPETIDO".equals(result.getTelefonoCliente())){
                return "El telefono ya existe en la base de datos!";
            }
            if("ERROR_CORREO_REPETIDO".equals(result.getCorreoCliente())){
                return "El correo ya existe en la base de datos!";
            }
            return "Cliente agregado correctamente!";
        } catch (InvalidEmail invalid) {
            return invalid.getMessage();
        }

    }

    @PutMapping("/{id}")
    public String updateCliente(@PathVariable Integer id, @RequestBody Clientes clientes){
        try {
            Clientes result = clientesService.updateClientes(id, clientes);
            if (result == null) {
                return "Cliente no encontrado";
            }
            if("ERROR_TELEFONO_REPETIDO".equals(result.getTelefonoCliente())){
                return "El telefono ya existe en la base de datos!";
            }
            if("ERROR_CORREO_REPETIDO".equals(result.getCorreoCliente())){
                return "El correo ya existe en la base de datos!";
            }
            return "Cliente actualizado correctamente!";
        }  catch (InvalidEmail invalid) {
            return invalid.getMessage();
        }

    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable Integer id){
        clientesService.deleteClientes(id);
        return "Cliente eliminado correctamente!";
    }
}
