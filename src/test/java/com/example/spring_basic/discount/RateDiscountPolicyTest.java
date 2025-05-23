package com.example.spring_basic.discount;

import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP needs 10% discount")
    void vip_o(){
        //given
        Member member = new Member(1L, "vip", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("not VIP no discount")
    void vip_X(){
        //given
        Member member = new Member(1L, "vip", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }


}