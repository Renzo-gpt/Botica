package com.botica.botica.api.botica.application.port.in;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateOrderCommand {

    private LocalDateTime date;
    private BigDecimal total;
    private String paymentType;

    public CreateOrderCommand(){}

    public CreateOrderCommand(LocalDateTime date, BigDecimal total, String paymentType) {
        this.date = date;
        this.total = total;
        this.paymentType = paymentType;
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
