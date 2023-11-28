package com.example.reasonablebasicboard.domain.board.service;

import com.example.reasonablebasicboard.domain.board.entity.Board;
import com.example.reasonablebasicboard.domain.board.repository.BoardRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
class BoardAdapter implements BoardPort {
  private final BoardRepository boardRepository;

  @Override
  public void save(final Board board) {
    boardRepository.save(board);
  }

  @Override
  public Board getBoard(final Long boardId) {
    return boardRepository.findById(boardId)
        .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
  }
}
