package com.example.spring_basic.autowired.allBean;

import com.example.spring_basic.AutoAppConfig;
import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        int discountPrice = discountService.discount(memberA, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int discountRatePrice = discountService.discount(memberA, 20000, "rateDiscountPolicy");

        assertThat(discountRatePrice).isEqualTo(2000);
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member memberA, int price, String discoutCode) {
            DiscountPolicy discountPolicy = policyMap.get(discoutCode);
            return discountPolicy.discount(memberA, price);
        }
    }
}
