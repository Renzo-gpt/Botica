package com.botica.botica.api.botica.infrastructure.adapter.in.Dto;

import com.botica.botica.api.botica.domain.model.PaymentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderRequestDto {

    @NotNull(message = "La fecha es obligatoria")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime date;

    @NotNull(message = "El monto total es obligatorio")
    @Positive(message = "El total de la orden debe ser mayor a cero")
    private BigDecimal total;

    @NotBlank(message = "El tipo de pago es obligatorio")
    private String paymentType;

    public OrderRequestDto(){}

    public OrderRequestDto(LocalDateTime date, BigDecimal total, String paymentType) {
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
