package com.taehun.JPABoard.Member;

import com.taehun.JPABoard.Board.Board;
import com.taehun.JPABoard.Board.BoardRepository;
import com.taehun.JPABoard.member.Member;
import com.taehun.JPABoard.member.MemberRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BoardRepository boardRepository;

    @Test @Order(1) //회원등록 테스트
    void saveMember(){
        Member member1 = Member.builder().username("이태훈1").userId("xogns06041").age(20).build();
        Member member2 = Member.builder().username("이태훈2").userId("xogns06042").age(30).build();

        memberRepository.save(member1);
        memberRepository.save(member2);
    }

    @Test @Order(2) //회원조회 테스트
    void findAllMember(){
        List<Member> members = memberRepository.findAll();
        System.out.println("=============================");
        System.out.println("members = " + members);
    }

    @Test @Order(4) //회원삭제 테스트
    void deleteMember(){

        Member member1 = Member.builder().username("이태훈2").userId("xogns06045").age(20).build();
//        memberRepository.save(member1);

        Board board1 = Board.builder().title("1게시글").content("1내용").hits(0)
                .deleteYn('N').member(member1).build();
        member1.getBoards().add(board1);

        List<Board> boards = member1.getBoards();
        System.out.println("============");
        for (Board board : boards) {
            boardRepository.delete(board);
//            System.out.println("board = " + board);
        }

        memberRepository.delete(member1);
    }

    @Test @Order(3) //회원수정 테스트
    void changeMember(){

        Member member = memberRepository.findById(1L).get();
        member.setUsername("태훈아니다");

        memberRepository.save(member);
    }
}
