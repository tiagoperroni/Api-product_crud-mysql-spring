package com.tiagoperroni.main.controller;

import com.tiagoperroni.main.entity.Product;

import com.tiagoperroni.main.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Products")
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productsService;

    @ApiOperation(value = "Create Product")
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws Exception {
        Product newProduct = productsService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @ApiOperation(value = "List All")
    @GetMapping
    public ResponseEntity<List<Product>> listAllProducts() {
        return new ResponseEntity<>(productsService.listAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productsService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Update Product")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return new ResponseEntity<>(productsService.updateProducts(product, id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
