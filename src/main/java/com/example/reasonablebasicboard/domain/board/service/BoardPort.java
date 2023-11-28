package com.example.reasonablebasicboard.domain.board.service;

import com.example.reasonablebasicboard.domain.board.entity.Board;

public interface BoardPort {
  void save(final Board board);

  Board getBoard(Long boardId);
}
