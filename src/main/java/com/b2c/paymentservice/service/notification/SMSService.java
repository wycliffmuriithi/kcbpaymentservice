package com.b2c.paymentservice.service.notification;

public interface SMSService {
    String sendSms(String phoneNumber, String message);
}
