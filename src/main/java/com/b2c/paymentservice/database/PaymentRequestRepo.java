package com.b2c.paymentservice.database;

import com.b2c.paymentservice.database.model.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRequestRepo extends JpaRepository<PaymentRequest, Long> {
}
