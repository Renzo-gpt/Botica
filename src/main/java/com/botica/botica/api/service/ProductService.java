package com.botica.botica.api.service;

import com.botica.botica.api.entity.Product;
import com.botica.botica.api.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    public Product findById(Long id){
        return this.productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto con " +id+ " no encontrado!"));
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    /* falta pulir
    public Product update(Long id){
        Product p = this.findById(id);
        return this.create(p);
    }
    */

    public void delete(Long id){
        productRepository.deleteById(id);
    }

}
