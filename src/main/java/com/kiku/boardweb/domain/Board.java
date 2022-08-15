package com.kiku.boardweb.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    private String view;

    @OneToMany(mappedBy = "board")
    @OrderBy("id asc")
    private List<Comment> comments;

    @CreatedDate
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 비즈니스 로직
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
