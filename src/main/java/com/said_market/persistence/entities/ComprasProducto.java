package com.said_market.persistence.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    // Anotacion para el id con clave primaria compuesta
    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    @ManyToOne // many de esatas para una compra
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne //mani ordener de compra para un producto
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;


    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
