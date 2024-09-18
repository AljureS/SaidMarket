package com.said_market.domain.repository;

import com.said_market.domain.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    //Aca solo van los nombres de los metodos que los repos con Product vayan a implementar

    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    //The one i made is in the next line
    List<Product> getByPrice();
    Optional<Product> getProduct (int productId);
    Product save(Product product);
    void delete (int productId);


}
