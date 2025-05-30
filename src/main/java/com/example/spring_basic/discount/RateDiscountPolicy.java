package com.example.spring_basic.discount;

import com.example.spring_basic.annotation.MainDiscountPolicy;
import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
//@Primary
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) return price * discountPercent / 100;
        else return 0;
    }
}
