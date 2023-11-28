package com.example.reasonablebasicboard.domain.board.dto;

import org.springframework.util.Assert;

public record GetBoardResponse(long id, String title, String content
) {
  public GetBoardResponse {
    Assert.notNull(id, "상품 ID는 필수입니다.");
    Assert.hasText(title, "제목은 필수입니다.");
    Assert.hasText(content, "내용은 필수입니다.");
  }
}
