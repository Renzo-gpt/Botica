package com.botica.botica.api.producto.application.port.in;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateProductCommand {

    private String name;
    private Integer stock;
    private BigDecimal price;
    private Boolean status;
    private LocalDate expirationDate;

    public CreateProductCommand(String name, Integer stock, BigDecimal price, Boolean status, LocalDate expirationDate) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
