package com.wonit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository sut;

    @Test
    void save() {
        String item = "some_item";
        String point = "some_point";
        String type = "payment";

        OrderDetail actual = sut.save(OrderDetail.builder()
                        .item(item)
                        .point(point)
                        .type(type)
                .build());

        assertThat(actual.getItem()).isEqualTo(item);
    }
}