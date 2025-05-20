package com.example.java_spring.service;

import com.example.java_spring.domain.Member;
import com.example.java_spring.repository.MemberRepository;
import com.example.java_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) { //dependency injection
        this.memberRepository = memberRepository;
    }

    public Long signUp(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){

        memberRepository.findByName(member.getName())
                .ifPresent(m-> { //optional로 감싸면 ➡️ ifPresent로 있는지 확인하고 throw가능
                    throw new IllegalStateException("member already exists");
                });
    }

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

