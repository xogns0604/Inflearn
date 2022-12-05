package com.taehun.JPABoard.Board;

import com.taehun.JPABoard.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board {

    @Id @GeneratedValue
    private Long id; // PK
    private String title; // 제목
    private String content; // 내용
    private int hits; // 조회 수
    private char deleteYn; // 삭제 여부
    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일
    private LocalDateTime modifiedDate; // 수정일

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Builder
    public Board(String title, String content, int hits, char deleteYn, Member member) {
        this.title = title;
        this.content = content;
        this.hits = hits;
        this.deleteYn = deleteYn;
        this.member = member;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.modifiedDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", hits=" + hits +
                ", deleteYn=" + deleteYn +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
