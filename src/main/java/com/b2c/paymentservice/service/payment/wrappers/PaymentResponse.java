package com.b2c.paymentservice.service.payment.wrappers;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class PaymentResponse {
    private String mnoPaymentId;
    private String statusCode;
    private String description;
}
