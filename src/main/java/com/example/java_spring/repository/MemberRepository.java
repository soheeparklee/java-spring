package com.example.java_spring.repository;

import com.example.java_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    List<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
