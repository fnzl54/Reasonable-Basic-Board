package com.example.reasonablebasicboard.domain.board.service;

import com.example.reasonablebasicboard.domain.board.entity.Board;
import com.example.reasonablebasicboard.domain.board.repository.BoardRepository;
import java.util.ArrayList;
import java.util.List;
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
  public Board getBoardById(final Long boardId) {
    return boardRepository.findById(boardId)
        .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
  }

  @Override
  public List<Board> getBoardByTitle(final String boardTitle) {
    List<Board> boardList = boardRepository.findByTitle(boardTitle);

    if (boardList.isEmpty()) {
      throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
    }
    return boardList;
  }
}
