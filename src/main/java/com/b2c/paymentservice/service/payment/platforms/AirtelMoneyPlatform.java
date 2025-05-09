package com.b2c.paymentservice.service.payment.platforms;

import com.b2c.paymentservice.service.notification.SMSService;
import com.b2c.paymentservice.service.payment.PaymentPlatform;
import com.b2c.paymentservice.service.payment.wrappers.PaymentReq;
import com.b2c.paymentservice.service.payment.wrappers.PaymentResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component("airtelmoney")
public class AirtelMoneyPlatform implements PaymentPlatform {
    private final SMSService smsService;

    public AirtelMoneyPlatform(SMSService smsService) {
        this.smsService = smsService;
    }

    @Override
    public PaymentResponse initPayment(PaymentReq paymentReq) {
        //TODO save payment details to db
        return PaymentResponse.builder().mnoPaymentId(UUID.randomUUID().toString()).description("Payment Successfully Initiated").statusCode("200").build();
    }

    @Override
    public PaymentResponse getPaymentStatus(PaymentResponse paymentResponse) {
        //TODO retrieve paymentDetails {} from db to update status and get msisdn
        smsService.sendSms("msisdn", "Payment successful");
        return PaymentResponse.builder().mnoPaymentId(UUID.randomUUID().toString()).description("Payment Successfully Initiated").statusCode("200").build();
    }


}
