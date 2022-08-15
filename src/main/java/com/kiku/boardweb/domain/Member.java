package com.kiku.boardweb.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String password;

    @Column(unique = true)
    private String nickname;

    private String name;
    private String email;

    @CreatedDate
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    // 비즈니스 로직
    public void update(String password, String nickname, String name, String email) {
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.email = email;
    }
}
