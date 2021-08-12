package com.example.graphql.resolver;

import com.example.graphql.dto.MemberDto;
import com.example.graphql.entity.MemberEntity;
import com.example.graphql.entity.RoleEntity;
import com.example.graphql.repository.MemberRepository;
import com.example.graphql.repository.RoleRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional
public class MemberMutation implements GraphQLMutationResolver {

    private final MemberRepository memberRepository;

    private final RoleRepository roleRepository;

    public MemberDto createMember(MemberDto memberDto) {
        MemberEntity member = memberRepository.save(MemberEntity.builder()
                .loginId(memberDto.getLoginId())
                .name(memberDto.getName())
                .password(memberDto.getPassword())
                .build());
        return MemberDto.from(member);
    }

    public Boolean deleteMember(int id){
        Optional<MemberEntity> optionalMember = memberRepository.findById(id);
//        RoleEntity role = roleRepository.findByMemberId(id);
        if(optionalMember.isPresent()) {
//            roleRepository.delete(role);
            memberRepository.delete(optionalMember.get());
        }
        return true;
    }
}