package com.example.reasonablebasicboard.domain.board.controller;

import com.example.reasonablebasicboard.domain.board.dto.AddBoardRequest;
import com.example.reasonablebasicboard.domain.board.dto.GetBoardResponse;
import com.example.reasonablebasicboard.domain.board.entity.Board;
import com.example.reasonablebasicboard.domain.board.service.BoardPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
  private final BoardPort boardPort;

  @PostMapping
  public ResponseEntity<Void> addBoard(@RequestBody final AddBoardRequest request) {
    final Board board = new Board(request.title(), request.content());

    boardPort.save(board);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{boardId}")
  public ResponseEntity<GetBoardResponse> getBoard(@PathVariable("boardId")  final String boardId) {
    Long boardLongId = Long.parseLong(boardId);
    final Board board = boardPort.getBoard(boardLongId);

    final GetBoardResponse response = new GetBoardResponse(
        board.getId(),
        board.getTitle(),
        board.getContent());
    return ResponseEntity.ok(response);
  }
}
