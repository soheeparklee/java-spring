package com.example.spring_basic.order;

import com.example.spring_basic.AppConfig;
import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.MemberService;
import com.example.spring_basic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order orderResult = orderService.createOrder(memberA.getId(), "milk", 5000);
        Assertions.assertThat(orderResult.getDiscountPrice()).isEqualTo(500);

    }

}
