package com.botica.botica.api.botica.domain.payment;

public class PaymentStrategyFactory {

    public static PaymentStrategy getStrategy(String paymentType){
        if (paymentType != null && paymentType.equalsIgnoreCase("TARJETA")){
            return new CardPaymentStrategy();
        }
        return new CashPaymentStrategy();
    }
}
