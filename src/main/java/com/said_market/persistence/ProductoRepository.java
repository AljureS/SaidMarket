package com.said_market.persistence;

import com.said_market.persistence.crud.ProductoCrudRepository;
import com.said_market.persistence.entities.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria (int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado ){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public List<Producto> getByPrice(){
        return productoCrudRepository.findAllByOrderByPrecioVentaAsc();
    }
}
