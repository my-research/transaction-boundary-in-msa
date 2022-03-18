package com.wonit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    OrderService sut;

    @Mock
    OrderDetailRepository repository;

    @Test
    void order_state() {
        String point = "1000";
        String type = "payment";

        OrderDetail actual = sut.orderWithPayment(point, type);

        assertThat(actual).isEqualTo(OrderDetail.builder()
                        .item("SOME_ITEM")
                        .point(point)
                        .type(type)
                .build());
    }

    @Test
    void order_behavior() {
        String point = "1000";
        String type = "payment";

        sut.orderWithPayment(point, type);

        verify(repository).save(any(OrderDetail.class));
    }
}