package com.example.spring_basic.member;

import com.example.spring_basic.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpringMemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(memberA);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(memberA).isEqualTo(findMember);
    }
}
