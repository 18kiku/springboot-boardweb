package com.kiku.boardweb.service;

import com.kiku.boardweb.domain.Member;
import com.kiku.boardweb.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        // exception
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Member> findById(Long id) { return memberRepository.findById(id); }

    @Transactional(readOnly = true)
    public Member findByNickname(String nickname) { return memberRepository.findByNickname(nickname); }

    public void update(Long id, String password, String nickname, String name, String email) {
        Optional<Member> member = memberRepository.findById(id);
        member.orElseThrow().setPassword(password);
        member.orElseThrow().setNickname(nickname);
        member.orElseThrow().setName(name);
        member.orElseThrow().setEmail(email);
    }

    public void deleteById(Long id) { memberRepository.deleteById(id);}
}
