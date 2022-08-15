package com.kiku.boardweb.service;

import com.kiku.boardweb.domain.Member;
import com.kiku.boardweb.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        Member member = new Member();
        member.setNickname("치로루");
        member.setName("치로루");

        Long saveId = memberService.join(member);



        
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }

    @Test
    void deleteOne() {
    }
}