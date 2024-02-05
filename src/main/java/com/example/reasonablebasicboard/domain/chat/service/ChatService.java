package com.example.reasonablebasicboard.domain.chat.service;

import com.example.reasonablebasicboard.domain.chat.Entity.Chat;
import com.example.reasonablebasicboard.domain.chat.Entity.ChatRoom;
import com.example.reasonablebasicboard.domain.chat.dto.ChatDto1;
import com.example.reasonablebasicboard.domain.chat.repository.ChatRepository;
import com.example.reasonablebasicboard.domain.chat.repository.ChatRepository1;
import com.example.reasonablebasicboard.domain.chat.repository.ChatRoomRepository1;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
  private final ChatRepository1 chatRepository;
  private final ChatRoomRepository1 chatRoomRepository;

  public void saveMessage (ChatDto1 chat) {
    ChatRoom chatRoom = chatRoomRepository.findById(chat.getChatRoomId())
        .orElseThrow(() -> new NoSuchElementException());

    chatRepository.save(chat.toEntity(chatRoom));

  }

}
