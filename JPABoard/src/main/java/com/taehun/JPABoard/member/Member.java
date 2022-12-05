package com.taehun.JPABoard.member;

import com.taehun.JPABoard.Board.Board;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class Member {

    @Id @GeneratedValue @Column(name = "MEMBER_ID")
    private Long id;
    @Column(unique = true)
    private String userId;
    private String userPwd;
    private String username;
    private int age;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public Member(Long id, String userId, String userPwd, String username, int age) {
        this.id = id;
        this.userId = userId;
        this.userPwd = userPwd;
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
