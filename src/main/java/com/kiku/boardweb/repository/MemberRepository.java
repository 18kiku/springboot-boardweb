package com.kiku.boardweb.repository;

import com.kiku.boardweb.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);

    Member findByNickname(String nickname);
}
