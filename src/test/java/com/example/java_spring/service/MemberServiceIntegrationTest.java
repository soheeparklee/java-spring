package com.example.java_spring.service;

import com.example.java_spring.domain.Member;
import com.example.java_spring.repository.MemberRepository;
import com.example.java_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository repository;
    @Test
    void signUp() {
        //given
        Member member = new Member();
        member.setName("aaa");
        //when
        Long saveId = memberService.signUp(member);
        //then
//        Member findMember = memberService.findOne(saveId).get();
//        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void signUpDuplicate() {
        //given
        Member member1 = new Member();
        member1.setName("bbb");

        Member member2 = new Member();
        member2.setName("bbb"); //same name trying to signUp
        //when
        memberService.signUp(member1);
        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.signUp(member2));
        assertThat(e.getMessage()).isEqualTo("member already exists");


        /*try{
            memberService.signUp(member2);
            fail();
        }catch(IllegalArgumentException e){
            assertThat(e.getMessage()).isEqualTo("member already exists");
        }*/


    }

}