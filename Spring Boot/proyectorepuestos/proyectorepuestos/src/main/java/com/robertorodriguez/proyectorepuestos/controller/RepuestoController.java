package com.robertorodriguez.proyectorepuestos.controller;

import com.robertorodriguez.proyectorepuestos.model.Repuestos;
import com.robertorodriguez.proyectorepuestos.service.RepuestoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {
    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }

    @GetMapping
    public List<Repuestos> listarRepuestos() {
        return repuestoService.getAllRepuestos();
    }

    @GetMapping("/{id}")
    public Repuestos getRepuestosPorId(@PathVariable Integer id){
        return repuestoService.getRepuestoById(id);
    }

    @PostMapping
    public String createRepuestp(@RequestBody Repuestos repuestos){
        try {
            Repuestos result = repuestoService.saveRepuesto(repuestos);
            if("ERROR_STOCK_REPETIDO".equals(result.getStock())){
                return "El stock ya esta repetido!";
            }
            return "Repuesto agregado correctamente";
        } catch (Exception e) {
            if (e.getMessage().contains("FK_codigo_proveedor")) {
                return "Error: El proveedor no existe";
            }
            return "Error al crear el repuesto";
        }
    }

    @PutMapping("/{id}")
    public String updateRepuesto(@PathVariable Integer id, @RequestBody Repuestos repuestos){
        try {
            Repuestos result = repuestoService.updateRepuesto(id, repuestos);
            if (result == null) {
                return "Repuesto no encontrado";
            }
            if("ERROR_STOCK_REPETIDO".equals(result.getStock())){
                return "El stock esta repetido!";
            }
            return "Repuesto actualizado correctamente";
        } catch (Exception e) {
            if (e.getMessage().contains("FK_codigoProveedor")) {
                return "Error: El proveedor no existe";
            }
            return "Error al crear el repuesto";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteRepuesto(@PathVariable Integer id){
        repuestoService.deleteRepuesto(id);
        return "Repuesto eliminado correctamente!";
    }
}
