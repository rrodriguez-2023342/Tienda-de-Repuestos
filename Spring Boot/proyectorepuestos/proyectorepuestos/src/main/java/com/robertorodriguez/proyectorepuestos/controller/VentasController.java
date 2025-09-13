package com.robertorodriguez.proyectorepuestos.controller;

import com.robertorodriguez.proyectorepuestos.model.Ventas;
import com.robertorodriguez.proyectorepuestos.service.VentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
    private final VentaService ventasService;

    public VentasController(VentaService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> listarVentas() {
        return ventasService.getAllVentas();
    }

    @GetMapping("/{id}")
    public Ventas getVentasPorId(@PathVariable Integer id){
        return ventasService.getVentasById(id);
    }

    @PostMapping
    public String createVenta(@RequestBody Ventas ventas){
        try {
            Ventas result = ventasService.saveVentas(ventas);
            if("ERROR_CANTIDAD_REPETIDO".equals(result.getCantidad())){
                return "La cantidad ya esta repetida!";
            }
            return "Venta agregada correctamente";
        } catch (Exception e) {
            if (e.getMessage().contains("FK_id_cliente")) {
                return "Error: El cliente no existe";
            }
            if (e.getMessage().contains("FK_id_repuesto")) {
                return "Error: El repuesto no existe";
            }
            return "Error al crear la venta!";
        }
    }

    @PutMapping("/{id}")
    public String updateVentas(@PathVariable Integer id, @RequestBody Ventas ventas){
        try {
            Ventas result = ventasService.updateVentas(id, ventas);
            if (result == null) {
                return "Venta no encontrada";
            }
            if("ERROR_CANTIDAD_REPETIDO".equals(result.getCantidad())){
                return "La cantidad esta repetida!";
            }
            return "Venta actualizada correctamente";
        } catch (Exception e) {
            if (e.getMessage().contains("FK_id_cliente")) {
                return "Error: El cliente no existe";
            }
            if (e.getMessage().contains("FK_id_repuesto")) {
                return "Error: El repuesto no existe";
            }
            return "Error al crear la venta!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteVenta(@PathVariable Integer id){
        ventasService.deleteVentas(id);
        return "Venta eliminada correctamente!";
    }
}
