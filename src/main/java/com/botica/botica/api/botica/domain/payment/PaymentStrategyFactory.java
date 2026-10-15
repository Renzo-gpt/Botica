package com.botica.botica.api.botica.domain.payment;

import com.botica.botica.api.botica.domain.model.PaymentType;

public class PaymentStrategyFactory {

    public static PaymentStrategy getStrategy(PaymentType paymentType){
        if (paymentType != null){
            throw new IllegalArgumentException("El tipo de pago no puede ser nulo");
        }
        return switch (paymentType) {
            case TARJETA -> new CardPaymentStrategy();
            case EFECTIVO -> new CashPaymentStrategy();
        };
    }
}
