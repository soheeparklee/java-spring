package com.example.spring_basic.order;


import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.discount.FixDiscountPolicy;
import com.example.spring_basic.member.*;
import com.example.spring_basic.order.OrderService;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository repository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String name, int price) {
        Member member = repository.findById(memberId);
        int discount = discountPolicy.discount(member, price);
        Order order = new Order(memberId, name, price, discount);

        return order;
    }
}
