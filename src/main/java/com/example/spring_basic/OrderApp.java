package com.example.spring_basic;

import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.MemberService;
import com.example.spring_basic.member.MemberServiceImpl;
import com.example.spring_basic.order.Order;
import com.example.spring_basic.order.OrderService;
import com.example.spring_basic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        OrderService orderService = appConfig.orderService();
        Order orderResult = orderService.createOrder(memberA.getId(), "milk", 5000);
        System.out.println("orderResult = " + orderResult);

        int result = orderResult.caculatePrice();
        System.out.println("result = " + result);
    }
}
