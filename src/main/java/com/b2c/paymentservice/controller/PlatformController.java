package com.b2c.paymentservice.controller;

import com.b2c.paymentservice.controller.wrappers.AirtelCallbackDTO;
import com.b2c.paymentservice.controller.wrappers.MpesaCallBackDTO;
import com.b2c.paymentservice.service.payment.platforms.AirtelMoneyPlatform;
import com.b2c.paymentservice.service.payment.platforms.MpesaDarajaPlatform;
import com.b2c.paymentservice.service.payment.wrappers.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
public class PlatformController {
    private final MpesaDarajaPlatform mpesaDarajaPlatform;
    private final AirtelMoneyPlatform airtelMoneyPlatform;

    public PlatformController(MpesaDarajaPlatform mpesaDarajaPlatform, AirtelMoneyPlatform airtelMoneyPlatform) {
        this.mpesaDarajaPlatform = mpesaDarajaPlatform;
        this.airtelMoneyPlatform = airtelMoneyPlatform;
    }

    @RequestMapping("/mpesa/callback")
    public ResponseEntity<String> receiveMpesaCallback(@RequestBody MpesaCallBackDTO mpesaCallBackDTO) {
        PaymentResponse paymentResponse = PaymentResponse.builder().statusCode(mpesaCallBackDTO.getStatus())
                .mnoPaymentId(mpesaCallBackDTO.getPaymentId())
                .description(mpesaCallBackDTO.getDescription())
                .build();
        mpesaDarajaPlatform.getPaymentStatus(paymentResponse);
        return ResponseEntity.ok("Callback received");
    }

    @RequestMapping("/airtel/callback")
    public ResponseEntity<String> receiveAirtelCallback(@RequestBody AirtelCallbackDTO airtelCallbackDTO) {
        PaymentResponse paymentResponse = PaymentResponse.builder().statusCode(airtelCallbackDTO.getStatus())
                .mnoPaymentId(airtelCallbackDTO.getPaymentId())
                .description(airtelCallbackDTO.getDescription())
                .build();
        airtelMoneyPlatform.getPaymentStatus(paymentResponse);
        return ResponseEntity.ok("Callback received");
    }
}
