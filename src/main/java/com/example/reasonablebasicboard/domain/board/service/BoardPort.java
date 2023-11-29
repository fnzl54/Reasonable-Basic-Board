package com.example.reasonablebasicboard.domain.board.service;

import com.example.reasonablebasicboard.domain.board.entity.Board;
import java.util.List;

public interface BoardPort {
  void save(final Board board);

  Board getBoardById(Long boardId);
  List<Board> getBoardByTitle(String boardTitle);
}
