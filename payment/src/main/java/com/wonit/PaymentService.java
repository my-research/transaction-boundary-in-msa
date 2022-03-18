package com.wonit;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PaymentService {
    public PaymentResult doSomething(PaymentRequest request) {
        String type = request.getType();
        if (!"payment".equals(type)) {
            return new PaymentResult(0);
        }

        return new PaymentResult(1);
    }
}
