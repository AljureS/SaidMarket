package com.said_market.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;
    

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Boolean getEstado() {
        return estado;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
    public Double getPrecioVenta() {
        return precioVenta;
    }


}
