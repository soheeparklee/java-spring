package com.example.java_spring.controller;

import com.example.java_spring.domain.Member;
import com.example.java_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) { //dependency injection
        this.memberService = memberService;
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findAllMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.signUp(member);
        return "redirect:/";
    }
}
