package com.wonit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RefundRequestService {

    private final RestTemplate rest;

    @Transactional
    public String requestRefund() {
        return rest.postForObject("http://localhost:8082/payment", "req", String.class);
    }
}
