package com.robertorodriguez.proyectorepuestos.service;

import com.robertorodriguez.proyectorepuestos.model.Ventas;
import com.robertorodriguez.proyectorepuestos.repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImplements implements VentaService{
    private final VentasRepository ventasRepository;

    public VentaServiceImplements(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getAllVentas() {
        return (List<Ventas>) ventasRepository.findAll();
    }

    @Override
    public Ventas getVentasById(int id) {
        return ventasRepository.findById(id).orElse(null);
    }

    @Override
    public Ventas saveVentas(Ventas ventas) {
        List<Ventas> lista = (List<Ventas>) ventasRepository.findAll();
        for (Ventas v :  lista) {
            if (v.getCantidad().equals(ventas.getCantidad())) {
                ventas.setCantidad(Integer.valueOf("ERROR_CANTIDAD_REPETIDO"));
                return ventas;
            }
        }
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) {
        Ventas  existingVentas= ventasRepository.findById(id).orElse(null);
        if (existingVentas != null) {
            List<Ventas> lista = (List<Ventas>) ventasRepository.findAll();
            for (Ventas v :  lista) {
                if (!v.getCantidad().equals(id)) {
                    if (v.getCantidad().equals(ventas.getCantidad())) {
                        ventas.setCantidad(Integer.valueOf("ERROR_CANTIDAD_REPETIDO"));
                        return ventas;
                    }
                }
            }
            existingVentas.setCantidad(ventas.getCantidad());
            existingVentas.setTotal(ventas.getTotal());
            existingVentas.setIdRepuesto(ventas.getIdRepuesto());
            existingVentas.setIdCliente(ventas.getIdCliente());
            return ventasRepository.save(existingVentas);
        }
        return null;
    }

    @Override
    public void deleteVentas(Integer id) {
        ventasRepository.deleteById(id);
    }
}
