package com.example.graphql.resolver;

import com.example.graphql.dto.MemberDto;
import com.example.graphql.entity.MemberEntity;
import com.example.graphql.repository.MemberRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberQuery implements GraphQLQueryResolver {

    private final MemberRepository memberRepository;

    public MemberDto getMember(int id) {
        MemberEntity member = memberRepository.findById(id)
                .orElse(null);
        return MemberDto.from(member);
    }

    public MemberEntity getMemberEntity(int id){
        MemberEntity member = memberRepository.findById(id).get();
//        log.info("0번째 가지러감");
//        member.getRoles().get(0);
//        log.info("0번째 가져옴");

        //자식 까보는건 하나만 해도 select문이 모든 자식에게 나가기 때문에 두번할필요는 음슴 해도 쿼리안나감감
//       log.info("1번째 가지러감");
//        member.getRoles().get(1);
//        log.info("1번째 가져옴");
        return member;
    }
}