package com.example.spring_basic.order;


import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.discount.FixDiscountPolicy;
import com.example.spring_basic.discount.RateDiscountPolicy;
import com.example.spring_basic.member.*;
import com.example.spring_basic.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository repository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String name, int price) {
        Member member = repository.findById(memberId);
        int discount = discountPolicy.discount(member, price);
        Order order = new Order(memberId, name, price, discount);

        return order;
    }
}
