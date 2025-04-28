package com.b2c.paymentservice.controller.wrappers;

import lombok.Data;

@Data
public class GlobalResponse {
    String status;
    String message;
    Object data;
}
