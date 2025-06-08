package org.example.paymentservice.service.impl;

import org.example.paymentservice.dto.PaymentRequest;
import org.example.paymentservice.entity.Payment;
import org.example.paymentservice.repo.PaymentRepository;
import org.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment processPayment(PaymentRequest request) {
        // Validate mock card (dummy check)
        if (!request.getCardNumber().startsWith("4")) {
            throw new RuntimeException("Invalid card number. Only mock Visa supported.");
        }

        Payment payment = new Payment();
        payment.setUserId(request.getUserId());
        payment.setParkingSpaceId(request.getParkingSpaceId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setStatus("SUCCESS");
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setTimestamp(LocalDateTime.now());

        // Generate receipt
        String receipt = generateReceipt(payment);
        payment.setReceipt(receipt);

        return paymentRepository.save(payment);
    }

    private String generateReceipt(Payment payment) {
        return """
            --- Smart Parking Receipt ---
            Transaction ID: %s
            Amount: %.2f
            Method: %s
            Status: %s
            User ID: %d
            Parking Space ID: %d
            Time: %s
            -----------------------------
            """.formatted(
                payment.getTransactionId(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getStatus(),
                payment.getUserId(),
                payment.getParkingSpaceId(),
                payment.getTimestamp().toString()
        );
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public List<Payment> getPaymentsByUser(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

    @Override
    public String getReceipt(Long id) {
        Payment payment = getPaymentById(id);
        return payment.getReceipt();
    }
}
