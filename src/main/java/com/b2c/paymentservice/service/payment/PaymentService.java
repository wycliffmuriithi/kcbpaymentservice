package com.b2c.paymentservice.service.payment;

import com.b2c.paymentservice.service.payment.wrappers.PaymentReq;
import com.b2c.paymentservice.service.payment.wrappers.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class PaymentService {
    private final Map<String, PaymentPlatform> paymentPlatforms;

    public PaymentService(Map<String, PaymentPlatform> paymentPlatforms) {
        this.paymentPlatforms = paymentPlatforms;
    }

    public PaymentResponse initPayment(String platformID, double amount, String msisdn, String description) {
        PaymentPlatform paymentPlatform = paymentPlatforms.get(platformID);

        PaymentReq paymentReq = PaymentReq.builder()
                .amount(amount)
                .msisdn(msisdn)
                .description(description).build();

        return paymentPlatform.initPayment(paymentReq);
    }

    public PaymentResponse getPaymentStatus(String platformID, PaymentResponse paymentResponse) {
        PaymentPlatform paymentPlatform = paymentPlatforms.get(platformID);
        return paymentPlatform.getPaymentStatus(paymentResponse);
    }
}
