package com.example.spring_basic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int price);
}
