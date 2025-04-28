package com.b2c.paymentservice.controller.wrappers;

import lombok.Data;

@Data
public class MpesaCallBackDTO {
    private String msisdn;
    private double amount;
    private String description;
    private String paymentId;
    private String status;
}
