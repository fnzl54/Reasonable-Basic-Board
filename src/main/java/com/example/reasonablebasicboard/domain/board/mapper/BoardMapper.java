package com.example.reasonablebasicboard.domain.board.mapper;

import com.example.reasonablebasicboard.domain.board.dto.GetBoardResponse;
import com.example.reasonablebasicboard.domain.board.entity.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {
  public GetBoardResponse toGetBoardResponseDto(Board board) {
    return GetBoardResponse.builder()
        .id(board.getId())
        .title(board.getTitle())
        .content(board.getContent())
        .build();
  }

}
