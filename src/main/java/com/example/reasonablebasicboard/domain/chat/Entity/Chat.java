package com.example.reasonablebasicboard.domain.chat.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
// 기본 생성자의 접근제어를 protected로 설정해놓게 되면 무분별한 객체 생성에 대해 한번 더 체크
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "chat_room_id")
  private ChatRoom chatRoom;

  private Long senderId;

  private String message;

  private LocalDateTime sendTime;

  @Builder
  public Chat(ChatRoom chatRoom, Long senderId, String message) {
    this.chatRoom =chatRoom;
    this.senderId = senderId;
    this.message = message;
    this.sendTime = LocalDateTime.now();
  }
}
