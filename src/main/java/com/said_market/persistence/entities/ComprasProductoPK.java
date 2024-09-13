package com.said_market.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ComprasProductoPK implements Serializable {

    @Column(name = "id_compra")
    public Integer idCompra;

    @Column(name = "id_producto")
    public Integer idProducto;


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
