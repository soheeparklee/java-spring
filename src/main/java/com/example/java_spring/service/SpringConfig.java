package com.example.java_spring.service;

import com.example.java_spring.aop.TimeTraceApp;
import com.example.java_spring.repository.JdbcTemplateMemberRepository;
import com.example.java_spring.repository.MemberRepository;
import com.example.java_spring.repository.MemoryMemberRepository;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    //@Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

    @Bean
    public MemberRepository memberRepository(){
        return new JdbcTemplateMemberRepository(dataSource);
    }

    @Bean
    public TimeTraceApp timeTraceApp(){
        return new TimeTraceApp();

    }
}
