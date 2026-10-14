package com.botica.botica.api.botica.domain.payment;

import java.math.BigDecimal;

public interface PaymentStrategy {
    BigDecimal calculateTotal(BigDecimal baseTotal);
}
