package com.b2c.paymentservice.service.payment.wrappers;

import lombok.Builder;

@Builder
public class PaymentReq {
    private String msisdn;
    private double amount;
    private String description;
}
