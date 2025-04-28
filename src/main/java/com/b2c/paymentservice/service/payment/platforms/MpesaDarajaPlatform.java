package com.b2c.paymentservice.service.payment.platforms;

import com.b2c.paymentservice.service.notification.SMSService;
import com.b2c.paymentservice.service.payment.PaymentPlatform;
import com.b2c.paymentservice.service.payment.wrappers.PaymentReq;
import com.b2c.paymentservice.service.payment.wrappers.PaymentResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("mpesa")
public class MpesaDarajaPlatform implements PaymentPlatform {

    private SMSService smsService;

    public MpesaDarajaPlatform(SMSService smsService) {
        this.smsService = smsService;
    }

    @Override
    public PaymentResponse initPayment(PaymentReq paymentReq) {
        return PaymentResponse.builder().mnoPaymentId(UUID.randomUUID().toString()).description("Payment Successfully Initiated").statusCode("200").build();
    }

    @Override
    public PaymentResponse getPaymentStatus(PaymentResponse paymentResponse) {
        int randomNumber = (int) (Math.random() * 100);
        if (randomNumber % 2 == 0) {
            //mock failure
            smsService.sendSms("msisdn", "Payment Failed");
            return PaymentResponse.builder().mnoPaymentId(UUID.randomUUID().toString()).description("Payment Could not be processed").statusCode("200").build();
        } else {
            //mock success
            smsService.sendSms("msisdn", "Payment successful");
            return PaymentResponse.builder().mnoPaymentId(UUID.randomUUID().toString()).description("Payment Successfully Initiated").statusCode("200").build();
        }
    }

}
