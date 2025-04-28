package com.b2c.paymentservice.service.payment;

import com.b2c.paymentservice.service.payment.wrappers.PaymentReq;
import com.b2c.paymentservice.service.payment.wrappers.PaymentResponse;

public interface PaymentPlatform {
    PaymentResponse initPayment(PaymentReq paymentReq);

    PaymentResponse getPaymentStatus(PaymentResponse paymentResponse);
}
