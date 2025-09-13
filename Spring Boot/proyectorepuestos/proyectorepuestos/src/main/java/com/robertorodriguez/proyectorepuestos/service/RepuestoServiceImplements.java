package com.robertorodriguez.proyectorepuestos.service;

import com.robertorodriguez.proyectorepuestos.model.Repuestos;
import com.robertorodriguez.proyectorepuestos.repository.RepuestosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImplements implements RepuestoService{
    private final RepuestosRepository repuestosRepository;

    public RepuestoServiceImplements(RepuestosRepository repuestosRepository) {
        this.repuestosRepository = repuestosRepository;
    }

    @Override
    public List<Repuestos> getAllRepuestos() {
        return (List<Repuestos>) repuestosRepository.findAll();
    }

    @Override
    public Repuestos getRepuestoById(int id) {
        return repuestosRepository.findById(id).orElse(null);
    }

    @Override
    public Repuestos saveRepuesto(Repuestos repuestos) {
        List<Repuestos> lista = (List<Repuestos>) repuestosRepository.findAll();
        for (Repuestos r :  lista) {
            if (r.getStock().equals(repuestos.getStock())) {
                repuestos.setStock(Integer.valueOf("ERROR_STOCK_REPETIDO"));
                return repuestos;
            }
        }
        return repuestosRepository.save(repuestos);
    }

    @Override
    public Repuestos updateRepuesto(Integer id, Repuestos repuestos) {
        Repuestos existingRepuesto = repuestosRepository.findById(id).orElse(null);
        if (existingRepuesto != null) {
            List<Repuestos> lista = (List<Repuestos>) repuestosRepository.findAll();
            for (Repuestos r :  lista) {
                if (!r.getStock().equals(id)) {
                    if (r.getStock().equals(repuestos.getStock())) {
                        repuestos.setStock(Integer.valueOf("ERROR_STOCK_REPETIDO"));
                        return repuestos;
                    }
                }
            }
            existingRepuesto.setNombreRepuesto(repuestos.getNombreRepuesto());
            existingRepuesto.setPrecio(repuestos.getPrecio());
            existingRepuesto.setStock(repuestos.getStock());
            existingRepuesto.setIdProveedor(repuestos.getIdProveedor());
            return repuestosRepository.save(existingRepuesto);
        }
        return null;
    }

    @Override
    public void deleteRepuesto(Integer id) {
        repuestosRepository.deleteById(id);
    }
}
