package com.learn.parkinglot.repositories;

import com.learn.parkinglot.models.Payment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PaymentRepository {
    Map<Long, Payment> paymentMap = new HashMap<>();

    public Payment save(Payment payment) {
        paymentMap.put(payment.getTicketId(), payment);
        return payment;
    }

    public Payment update(Payment payment) {
        if (!paymentMap.containsKey(payment.getTicket())) {
            return null;
        }

        paymentMap.put(payment.getTicketId(), payment);
        return payment;
    }

    public Payment findById(Long id) {
        return paymentMap.getOrDefault(id, null);
    }
}
