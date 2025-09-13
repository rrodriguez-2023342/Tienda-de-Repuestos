package com.robertorodriguez.proyectorepuestos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Proveedores")

public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column (name = "telefono_proveedor")
    private String telefonProveedor;

    @Column(name = "correo_proveedor")
    private String correoProveedor;

    @Column(name = "direecion_proveedor")
    private String direecionProveedor;

    //Getter y Setter

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonProveedor() {
        return telefonProveedor;
    }

    public void setTelefonProveedor(String telefonProveedor) {
        this.telefonProveedor = telefonProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public String getDireecionProveedor() {
        return direecionProveedor;
    }

    public void setDireecionProveedor(String direecionProveedor) {
        this.direecionProveedor = direecionProveedor;
    }
}
