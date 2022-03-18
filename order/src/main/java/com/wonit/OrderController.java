package com.wonit;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/api/order")
    public String order(@RequestBody OrderRequest orderRequest) {
        OrderDetail orderDetail = orderService.orderWithPayment(orderRequest.getPoint(), orderRequest.getType());
        System.out.println("orderDetail = " + orderDetail);

        return "good";
    }
}
