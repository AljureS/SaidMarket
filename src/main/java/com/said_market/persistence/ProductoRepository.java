package com.said_market.persistence;

import com.said_market.domain.Product;
import com.said_market.domain.repository.ProductRepository;
import com.said_market.persistence.crud.ProductoCrudRepository;
import com.said_market.persistence.entities.Producto;
import com.said_market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Se encarga de manipular la BD
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos =(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods ->mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod ->mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public List<Product> getByPrice(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAllByOrderByPrecioVentaAsc();
        return mapper.toProducts(productos);
    }


    @Override
    public void delete (int productId){
        productoCrudRepository.deleteById(productId);
    }
}
