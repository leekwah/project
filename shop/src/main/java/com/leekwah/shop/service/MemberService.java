package com.leekwah.shop.service;

import com.leekwah.shop.entity.Member;
import com.leekwah.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    // 중복 가입된 멤버가 있는지 확인하는 메서드
    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail()); // unique key 는 email 이기 때문에 email 로 확인
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

}
