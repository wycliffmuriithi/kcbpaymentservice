package com.b2c.paymentservice.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table
@Data
public class PaymentRequest {
    @Id
    private UUID id;
    private String description;
    private double amount;
    private String msisdn;

}
