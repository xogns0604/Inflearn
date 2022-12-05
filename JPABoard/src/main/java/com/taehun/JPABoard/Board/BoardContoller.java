package com.taehun.JPABoard.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardContoller {

    @Autowired
    private  BoardService boardService;

    @RequestMapping("login")
    public String loginForm() {


        return "member/loginForm";
    }
}
