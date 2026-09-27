package com.botica.botica.api.controller;

import com.botica.botica.api.entity.Product;
import com.botica.botica.api.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll(){
        return this.productService.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return this.productService.create(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return this.productService.findById(id);
    }

    @DeleteMapping("/{id}")
    void delete (@PathVariable Long id){
        this.productService.delete(id);
    }
}
