package com.wonit;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final RefundRequestService refundRequestService;

    @GetMapping("/order")
    public String order() {
        return refundRequestService.requestRefund();
    }
}
