package com.b2c.paymentservice.service.payment;

import com.b2c.paymentservice.service.payment.platforms.MpesaDarajaPlatform;
import com.b2c.paymentservice.service.payment.wrappers.PaymentResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class PaymentServiceTest {
    @Mock
    PaymentPlatform paymentPlatform;
    @Mock
    MpesaDarajaPlatform mpesaDarajaPlatform;

    @InjectMocks
    PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testResponseFromPlatformIsNotEmpty() {
       PaymentResponse paymentResponse = paymentService.initPayment("test", 100, "1234567890", "test");
       Assertions.assertNotNull(paymentResponse);
    }
}