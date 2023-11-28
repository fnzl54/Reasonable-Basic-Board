package com.example.reasonablebasicboard.domain.board.dto;

import org.springframework.util.Assert;

public record AddBoardRequest(String title, String content) {
  public AddBoardRequest {
    Assert.hasText(title, "제목은 필수입니다.");
    Assert.hasText(content, "내용은 필수입니다.");
  }
}
