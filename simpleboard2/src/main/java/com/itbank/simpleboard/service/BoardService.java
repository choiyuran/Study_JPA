package com.itbank.simpleboard.service;

import com.itbank.simpleboard.domain.Board;
import com.itbank.simpleboard.domain.BoardDto;
import com.itbank.simpleboard.repository.BoardRepository;
import com.itbank.simpleboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    @Autowired
    private final BoardRepository boardRepository;
    @Autowired
    private final MemberRepository memberRepository;

    public List<BoardDto> findAll() {
        List<Board> list = boardRepository.findAll();
        List<BoardDto> dtos = new ArrayList<>();        // 반환할 빈 리스트

        for(Board board : list) {
            BoardDto dto = new BoardDto();
            dto.setId(board.getId());
            dto.setTitle(board.getTitle());
            dto.setContent(board.getContent());
            dto.setWdate(board.getWdate());
            dto.setWriter(board.getMember());
//            dto.setUserid(board.getMember().getUserid());

            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public Board save(BoardDto dto) {
        Board savedBoard = new Board();
        savedBoard.setContent(dto.getContent());
        savedBoard.setTitle(dto.getTitle());
        savedBoard.setMember(dto.getWriter());

        Board board = boardRepository.save(savedBoard);
        return board;
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public Board update(Board board) {
        Board updateDto = findById(board.getId());
        updateDto.setTitle(board.getTitle());
        updateDto.setContent(board.getContent());

        return updateDto;
    }
}
