package com.b2c.paymentservice.controller.wrappers;

import lombok.Data;

@Data
public class GlobalResponse {
    private String status;
    private String message;
    private Object data;
}
