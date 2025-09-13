package com.robertorodriguez.proyectorepuestos.controller;

import com.robertorodriguez.proyectorepuestos.model.Proveedores;
import com.robertorodriguez.proyectorepuestos.service.ProveedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<Proveedores> listarProveedores(){
        return proveedorService.getAllProveedores();
    }

    @GetMapping("/{id}")
    public Proveedores getProveedoresPorId(@PathVariable Integer id){
        return proveedorService.getProveedorById(id);
    }

    @PostMapping
    public String createProveedor(@RequestBody Proveedores proveedores){
        try {
            Proveedores result = proveedorService.saveProveedores(proveedores);
            if("ERROR_TELEFONO_REPETIDO".equals(result.getTelefonProveedor())){
                return "El telefono ya existe en la base de datos!";
            }
            if("ERROR_CORREO_REPETIDO".equals(result.getCorreoProveedor())){
                return "El correo ya existe en la base de datos!";
            }
            return "Proveedor agregado correctamente!";
        } catch (InvalidEmail invalid) {
            return invalid.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updateProveedor(@PathVariable Integer id, @RequestBody Proveedores proveedores){
        try {
            Proveedores result = proveedorService.updateProveedores(id, proveedores);
            if (result == null) {
                return "Proveedor no encontrado";
            }
            if("ERROR_TELEFONO_REPETIDO".equals(result.getTelefonProveedor())){
                return "El telefono ya existe en la base de datos!";
            }
            if("ERROR_CORREO_REPETIDO".equals(result.getCorreoProveedor())){
                return "El correo ya existe en la base de datos!";
            }
            return "Proveedor actualizado correctamente!";
        } catch (InvalidEmail invalid) {
            return invalid.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProveedor(@PathVariable Integer id){
        proveedorService.deleteProveedores(id);
        return "Proveedor eliminado correctamente!";
    }
}
