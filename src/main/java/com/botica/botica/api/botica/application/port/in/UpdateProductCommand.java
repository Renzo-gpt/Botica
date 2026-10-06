package com.botica.botica.api.botica.application.port.in;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateProductCommand {

    private Long id;
    private String name;
    private Integer stock;
    private BigDecimal price;
    private Boolean status;
    private LocalDate expirationDate;


    public UpdateProductCommand(Long id, String name, Integer stock, BigDecimal price, Boolean status, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
