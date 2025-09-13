package com.robertorodriguez.proyectorepuestos.model;

import jakarta.persistence.*;

@Entity
@Table(name="Repuestos")

public class Repuestos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRepuesto;

    @Column(name = "nombre_repuesto")
    private String nombreRepuesto;

    @Column(name = "precio")
    private double precio;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "id_proveedor")
    private Integer idProveedor;

    //Getter y Setter


    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
}
