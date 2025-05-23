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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){ //role, interface
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){ //role, interface
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); //implement specific class
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy(); //implement specific class
        return new RateDiscountPolicy();
    }
}
