package com.b2c.paymentservice.service.notification.smsproviders;

import com.b2c.paymentservice.service.notification.SMSService;
import org.springframework.stereotype.Component;

@Component("infobip")
public class InfobipSMS implements SMSService {
    @Override
    public String sendSms(String phoneNumber, String message) {
        return "Message sent to " + phoneNumber;
    }
}
