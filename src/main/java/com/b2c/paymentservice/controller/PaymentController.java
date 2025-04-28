package com.b2c.paymentservice.controller;

import com.b2c.paymentservice.controller.wrappers.GlobalResponse;
import com.b2c.paymentservice.controller.wrappers.PaymentReqDTO;
import com.b2c.paymentservice.service.payment.PaymentService;
import com.b2c.paymentservice.service.payment.wrappers.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payment")
@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/init")
    public ResponseEntity<GlobalResponse> initPayment(@RequestBody PaymentReqDTO paymentReqDTO) {
        PaymentResponse paymentResponse = paymentService.initPayment(paymentReqDTO.getProvider(), paymentReqDTO.getAmount(),
                paymentReqDTO.getMsisdn(), paymentReqDTO.getDescription());
        GlobalResponse globalResponse = new GlobalResponse();
        if (paymentResponse != null) {
            globalResponse.setStatus("success");
            globalResponse.setMessage("Payment initiated successfully");
            globalResponse.setData(paymentResponse);
        } else {
            globalResponse.setStatus("failed");
            globalResponse.setMessage("Payment failed");
        }
        return ResponseEntity.ok(globalResponse);
    }
}
