package com.example.java_spring.repository;

import com.example.java_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository respository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        respository.clearStore();
        //테스트는 순서 보장이 안 됨
        //테스트 하나 끝날 때마다 초기화
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        
        respository.save(member);
        Member result = respository.findById(member.getId()).get(1);
        //Assertions.assertEquals(result, member);
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        respository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        respository.save(member2);

        Member result = respository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        respository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        respository.save(member2);

        List<Member> result = respository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
