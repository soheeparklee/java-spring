package com.example.spring_basic;

import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.discount.FixDiscountPolicy;
import com.example.spring_basic.discount.RateDiscountPolicy;
import com.example.spring_basic.member.MemberRepository;
import com.example.spring_basic.member.MemberService;
import com.example.spring_basic.member.MemberServiceImpl;
import com.example.spring_basic.member.MemoryMemberRepository;
import com.example.spring_basic.order.OrderService;
import com.example.spring_basic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){ //role, interface
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){ //role, interface
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository(); //implement specific class
    }

    private DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy(); //implement specific class
        return new RateDiscountPolicy();
    }
}
