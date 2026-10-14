package com.botica.botica.api.botica.domain.payment;

import java.math.BigDecimal;

public class CashPaymentStrategy implements PaymentStrategy{

    @Override
    public BigDecimal calculateTotal(BigDecimal baseTotal) {
        return baseTotal;
    }
}
