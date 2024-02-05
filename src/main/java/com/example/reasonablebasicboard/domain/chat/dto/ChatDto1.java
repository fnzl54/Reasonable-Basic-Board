package com.example.reasonablebasicboard.domain.chat.dto;

import com.example.reasonablebasicboard.domain.chat.Entity.Chat;
import com.example.reasonablebasicboard.domain.chat.Entity.ChatRoom;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatDto1 {
  private Long chatRoomId; // 방 번호
  private Long senderId;
  private String message;
  private LocalDateTime sendTime;

  public Chat toEntity(ChatRoom chatRoom) {
    return Chat.builder()
        .chatRoom(chatRoom)
        .senderId(senderId)
        .message(message)
        .build();
  }

}
