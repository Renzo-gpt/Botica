package com.botica.botica.api.botica.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    private Long id;
    private Long customerId;
    private LocalDateTime date;
    private BigDecimal total;
    private String paymentType;

    public Order() {}

    public Order(Long id, Long customerId, LocalDateTime date, BigDecimal total, String paymentType) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.total = total;
        this.paymentType = paymentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
