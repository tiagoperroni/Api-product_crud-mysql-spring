package com.tiagoperroni.main.services;

import com.tiagoperroni.main.entity.Product;

import com.tiagoperroni.main.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        validCreate(product);
        return productRepository.save(product);
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(null);
    }

    public Product updateProducts(Product product, Long id) {
        findById(id);
        Product updateProduct = productRepository.getById(id);
        System.out.println(updateProduct);
        BeanUtils.copyProperties(product, updateProduct, "id");
        return productRepository.save(updateProduct);
    }

    public void deleteProduct(Long id) {
        findById(id);
       productRepository.deleteById(id);
    }

    public Product validCreate(Product product) {
        if(product.getName() == null ||product.getCategory() == null
                || product.getCostPrice() == null || product.getSalePrice() == null) {
            //throw new ValidationExceptionHandler("Todos os campos devem ser preenchidos");
        }
        return product;
    }
}
