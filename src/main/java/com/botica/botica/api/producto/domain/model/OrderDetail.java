package com.botica.botica.api.producto.domain.model;

import java.math.BigDecimal;

public class OrderDetail {

    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;

    public OrderDetail(){
    }

    public OrderDetail(Long id, Integer quantity, BigDecimal price, BigDecimal subtotal) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
