package com.tiagoperroni.main.services;

import com.tiagoperroni.main.entity.Product;
import com.tiagoperroni.main.exceptionhandler.ProductNotFoundException;
import com.tiagoperroni.main.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) { 
        product.setDataCadastro(LocalDateTime.now());    
        return productRepository.save(product);
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ProductNotFoundException());
    }

    public Product updateProducts(Product product, Long id) {
        findById(id);
        Product updateProduct = productRepository.getById(id);     
        BeanUtils.copyProperties(product, updateProduct, "id");
        return productRepository.save(updateProduct);
    }

    public void deleteProduct(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }  
}
