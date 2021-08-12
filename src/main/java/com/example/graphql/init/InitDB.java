package com.example.graphql.init;

import com.example.graphql.entity.MemberEntity;
import com.example.graphql.entity.RoleEntity;
import com.example.graphql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class InitDB {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void initData(){
        RoleEntity admin = new RoleEntity();
        admin.setRole("admin");

        RoleEntity user = new RoleEntity();
        user.setRole("user");

        RoleEntity user2 = new RoleEntity();
        user2.setRole("user");

        MemberEntity member1 = MemberEntity.builder()
                .loginId("member1")
                .password("1234")
                .name("name1")
                .roles(new ArrayList<>())
                .build();

        member1.addRole(admin, user);


        MemberEntity member2 = MemberEntity.builder()
                .loginId("member2")
                .password("1234")
                .name("name2")
                .roles(new ArrayList<>())
                .build();

        member2.addRole(user2);

        memberRepository.saveAll(Arrays.asList(member1, member2));


    }
}
