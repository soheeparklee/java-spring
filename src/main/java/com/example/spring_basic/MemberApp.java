package com.example.spring_basic;

import com.example.spring_basic.member.Grade;
import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.MemberService;
import com.example.spring_basic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + memberA.getName());
        System.out.println("findMember = " + findMember.getName());
    }

}
