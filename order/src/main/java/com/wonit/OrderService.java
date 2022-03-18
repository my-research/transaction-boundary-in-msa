package com.wonit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDetailRepository repository;
    private final ExternalModule externalModule;

    @Transactional
    public OrderDetail orderWithPayment(String point, String type) {
        OrderDetail savedOrderDetail = repository.save(OrderDetail.builder()
                .item("SOME_ITEM")
                .type(type)
                .point(point)
                .build());

        if (externalModule.callPaymentModule(type) == 0) {
            throw new PaymentException();
        }

        return savedOrderDetail;
    }
}
