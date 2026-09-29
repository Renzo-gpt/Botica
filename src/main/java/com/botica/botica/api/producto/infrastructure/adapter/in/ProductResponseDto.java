package com.botica.botica.api.producto.infrastructure.adapter.in;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductResponseDto {

    private String name;
    private Integer stock;
    private BigDecimal price;
    private LocalDate expirationDate;

    public ProductResponseDto(){}

    public ProductResponseDto(String name, Integer stock, BigDecimal price, LocalDate expirationDate) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
