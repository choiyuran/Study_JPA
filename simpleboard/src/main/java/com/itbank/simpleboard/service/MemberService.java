package com.itbank.simpleboard.service;

import com.itbank.simpleboard.domain.Member;
import com.itbank.simpleboard.domain.MemberDto;
import com.itbank.simpleboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public void join(MemberDto dto) {
        Member member = new Member();
        member.setUsername(dto.getUsername());
        member.setUserid(dto.getUserid());
        member.setUserpw(dto.getUserpw());
        member.setPnum(dto.getPnum());
        member.setAddress(dto.getAddress());

        Member savedMember = memberRepository.save(member);
        System.out.println(savedMember);
    }


    public Member login(MemberDto dto) {
        Optional<Member> member = memberRepository.findByUseridAndUserpw(dto.getUserid(), dto.getUserpw());
        return member.get();
    }
}
