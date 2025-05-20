package com.example.java_spring.service;

import com.example.java_spring.domain.Member;
import com.example.java_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService  = new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void signUp() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.signUp(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void signUpDuplicate() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring"); //same name trying to signUp
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

    @Test
    void findAllMembers() {
        //given

        //when

        //then
    }

    @Test
    void findOne() {
        //given

        //when

        //then
    }
}