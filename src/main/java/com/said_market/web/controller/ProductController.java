package com.said_market.web.controller;

import com.said_market.domain.Product;
import com.said_market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired // Sin necesidad de crear una instancia de la clase product Service
    private ProductService productService;

    @GetMapping("/all")
    @Operation(summary = "Get all the products")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    @Operation(summary = "Get product by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
    })
    public ResponseEntity<Product> getProduct(
            @Parameter(description = "ID del producto", required = true, example = "13",
                    in = ParameterIn.PATH, schema = @Schema(type = "integer"))
            @PathVariable("productId") int productId
    ){
        return  productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get category by ID")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/scarse/{quantity}")
    @Operation(summary = "Get all the products bellow {quantity}")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Product>> getScarseProducts(@PathVariable("quantity") int quantity){
        return productService.getScarseProducts(quantity)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/price")
    @Operation(summary = "Get all the products form the cheapest to the most expensive")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Product>> getByPrice(){
        return new ResponseEntity<>(productService.getByPrice(), HttpStatus.OK) ;
    }

    @PostMapping("/save")
    @Operation(summary = "Create a product")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a product by their ID")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity delete (@PathVariable("id") int productId){
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
