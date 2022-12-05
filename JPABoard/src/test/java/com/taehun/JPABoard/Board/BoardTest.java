package com.taehun.JPABoard.Board;

import com.taehun.JPABoard.member.Member;
import com.taehun.JPABoard.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void saveBoard(){
        Member member1 = Member.builder().username("이태훈1").userId("xogns0604").age(20).build();
        memberRepository.save(member1);

        Board board1 = Board.builder().title("1게시글").content("1내용").hits(0)
                .deleteYn('N').member(member1).build();

        boardRepository.save(board1);


    }
}
