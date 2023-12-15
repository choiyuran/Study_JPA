package com.itbank.simpleboard.controller;

import com.itbank.simpleboard.domain.Board;
import com.itbank.simpleboard.domain.BoardDto;
import com.itbank.simpleboard.domain.Member;
import com.itbank.simpleboard.service.BoardService;
import com.itbank.simpleboard.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private final BoardService boardService;
    @Autowired
    private final MemberService memberService;

    @GetMapping("/list")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<BoardDto> list = boardService.findAll();
        mav.addObject("list", list);
        return mav;
    }

    @GetMapping("/write")
    public String write(HttpSession session) {
        Member member = (Member) session.getAttribute("login");
        if(member == null) {
            return "redirect:/member/login";
        }
        else {
            return "/board/write";
        }
    }

    @PostMapping("/write")
    public String writePro(BoardDto dto) {
        Member member = memberService.findById(dto.getMemberId());
        dto.setWriter(member);

        Board savedBoard = boardService.save(dto);
        if(savedBoard == null) {
            return "redirect:/board/write";
        }
        return "redirect:/board/list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("/board/view");
        Board board = boardService.findById(id);
        mav.addObject("board", board);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id) {
        boardService.deleteById(id);
        return "redirect:/board/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("/board/update");
        Board dto = boardService.findById(id);
        mav.addObject("dto", dto);
        return mav;
    }

    @PostMapping("/update/{id}")
    public String updatePro(@PathVariable("id") Long id, Board board) {
        board.setId(id);
        Board updateBoard = boardService.update(board);
        if(updateBoard == null) {
            System.out.println("수정 실패");
        }
        return "redirect:/board/view/" + id;

    }
}
