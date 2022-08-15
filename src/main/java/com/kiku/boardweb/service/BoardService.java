package com.kiku.boardweb.service;

import com.kiku.boardweb.domain.Board;
import com.kiku.boardweb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long write(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoard(Long id) {
        return boardRepository.findById(id);
    }


}
