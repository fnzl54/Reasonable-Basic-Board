package com.example.reasonablebasicboard.domain.board.repository;

import com.example.reasonablebasicboard.domain.board.entity.Board;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

  @Query(value = "SELECT b FROM Board b WHERE b.title LIKE %:title%")
  List<Board> findByTitle(@Param("title") String title);
}
