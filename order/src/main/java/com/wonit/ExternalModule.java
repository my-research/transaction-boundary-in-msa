package com.wonit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ExternalModule {

    public static final String PAYMENT_URL = "http://localhost:8082/api/payments";

    private final RestTemplate restTemplate;

    public int callPaymentModule(String type) {
        PaymentResult paymentResult = restTemplate.postForObject(PAYMENT_URL, new PaymentRequest(type), PaymentResult.class);

        return paymentResult.getCode();
    }
}
