package com.kiku.boardweb.repository;

import com.kiku.boardweb.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    private EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        Member member = new Member();
        member.setPassword("1234");
        member.setNickname("치로루");
        member.setName("chiroru");
        member.setEmail("aaa");

        memberRepository.save(member);
        System.out.println("-----------------------");


        System.out.println("member = " + memberRepository.findByName(member.getName()).get(0).getNickname());
        System.out.println("member = " + memberRepository.findByNickname(member.getNickname()).getNickname());

        memberRepository.deleteById(member.getId());

    }
}