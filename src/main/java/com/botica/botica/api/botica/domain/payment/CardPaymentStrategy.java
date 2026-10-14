package com.botica.botica.api.botica.domain.payment;

import java.math.BigDecimal;

public class CardPaymentStrategy implements PaymentStrategy{

    @Override
    public BigDecimal calculateTotal(BigDecimal baseTotal) {
        return baseTotal.multiply(new BigDecimal("1.05"));
    }
}
