package com.example.graphql.controller;

import com.example.graphql.entity.MemberEntity;
import com.example.graphql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public MemberEntity getMembers(@PathVariable int id){
        return memberRepository.findById(id).get();
    }
}
