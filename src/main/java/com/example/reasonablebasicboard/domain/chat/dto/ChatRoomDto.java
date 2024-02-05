package com.example.reasonablebasicboard.domain.chat.dto;

import java.util.HashMap;
import java.util.UUID;
import lombok.Data;

@Data
public class ChatRoomDto {
  private String roomId; // 채팅방 아이디
  private String roomName; // 채팅방 이름
  private long userCount; // 채팅방 인원수

  // key: 유저UUID, value: 유저아이디
  private HashMap<String, String> userList = new HashMap<String, String>();

  public ChatRoomDto create(String roomName){
    ChatRoomDto chatRoomDto = new ChatRoomDto();
    chatRoomDto.roomId = UUID.randomUUID().toString();
    chatRoomDto.roomName = roomName;
    chatRoomDto.userCount = 2;

    return chatRoomDto;
  }
}