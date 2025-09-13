package com.robertorodriguez.proyectorepuestos.service;

import com.robertorodriguez.proyectorepuestos.controller.ValidacionEmail;
import com.robertorodriguez.proyectorepuestos.model.Proveedores;
import com.robertorodriguez.proyectorepuestos.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImplements implements ProveedorService{
    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImplements(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedores> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedores getProveedorById(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedores saveProveedores(Proveedores proveedores) {
        ValidacionEmail.validarEmail(proveedores.getCorreoProveedor());
        List<Proveedores> lista = proveedorRepository.findAll();
        for (Proveedores p :  lista) {
            if (p.getTelefonProveedor().equalsIgnoreCase(proveedores.getTelefonProveedor())) {
                proveedores.setTelefonProveedor("ERROR_TELEFONO_REPETIDO");
                return proveedores;
            }
            if(p.getCorreoProveedor().equalsIgnoreCase(proveedores.getCorreoProveedor())) {
                proveedores.setCorreoProveedor("ERROR_CORREO_REPETIDO");
                return proveedores;
            }
        }
        return proveedorRepository.save(proveedores);
    }

    @Override
    public Proveedores updateProveedores(Integer id, Proveedores proveedores) {
        ValidacionEmail.validarEmail(proveedores.getCorreoProveedor());
        Proveedores existingProveedor = proveedorRepository.findById(id).orElse(null);
        if (existingProveedor != null) {
            List<Proveedores> lista = proveedorRepository.findAll();
            for (Proveedores p :  lista) {
                if (!p.getIdProveedor().equals(id)) {
                    if (p.getTelefonProveedor().equalsIgnoreCase(proveedores.getTelefonProveedor())) {
                        proveedores.setTelefonProveedor("ERROR_TELEFONO_REPETIDO");
                        return proveedores;
                    }
                    if(p.getCorreoProveedor().equalsIgnoreCase(proveedores.getCorreoProveedor())) {
                        proveedores.setCorreoProveedor("ERROR_CORREO_REPETIDO");
                        return proveedores;
                    }
                }
            }
            existingProveedor.setNombreProveedor(proveedores.getNombreProveedor());
            existingProveedor.setTelefonProveedor(proveedores.getTelefonProveedor());
            existingProveedor.setCorreoProveedor(proveedores.getCorreoProveedor());
            existingProveedor.setDireecionProveedor(proveedores.getDireecionProveedor());
            return proveedorRepository.save(existingProveedor);
        }
        return null;
    }

    @Override
    public void deleteProveedores(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
