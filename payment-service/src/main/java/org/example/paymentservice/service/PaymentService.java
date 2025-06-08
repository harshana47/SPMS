package org.example.paymentservice.service;

import org.example.paymentservice.dto.PaymentRequest;
import org.example.paymentservice.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment processPayment(PaymentRequest request);

    Payment getPaymentById(Long id);

    List<Payment> getPaymentsByUser(Long userId);

    String getReceipt(Long id);
}
