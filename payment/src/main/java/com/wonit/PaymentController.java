package com.wonit;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/api/payments")
    public ResponseEntity<PaymentResult> payment(@RequestBody PaymentRequest request) {
        String type = request.getType();

        System.out.println("type = " + type);

        PaymentResult result = paymentService.doSomething(request);

        return ResponseEntity.ok(result);
    }
}
