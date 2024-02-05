package com.example.reasonablebasicboard.domain.chat.Controller;

import com.example.reasonablebasicboard.domain.chat.dto.ChatRoomDto;
import com.example.reasonablebasicboard.domain.chat.repository.ChatRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 전체적인 채팅방을 조회, 생성, 입장 관리
@RestController
@RequestMapping("/chat")
@Slf4j
@RequiredArgsConstructor
public class ChatRoomController {

  private final ChatRepository chatRepository;

  // 채팅 리스트 화면
  // / 로 요청이 들어오면 전체 채팅룸 리스트를 담아서 return
  @GetMapping("/rooms")
  public ResponseEntity<List<ChatRoomDto>> getAllChatRooms() {
    log.info("SHOW ALL ChatList {}", chatRepository.findAllRoom());
    return new ResponseEntity<>(chatRepository.findAllRoom(), HttpStatus.OK);
  }

  // 채팅방 생성
  // 채팅방 생성 후 다시 / 로 return (RedirectAttributes : 실행 후 리다이랙팅 하고 싶은 경우 사용)
  @PostMapping("/createroom")
  public String createRoom(@RequestParam(name = "name") String name, RedirectAttributes rttr) {
    ChatRoomDto room = chatRepository.createChatRoomDto(name);
    log.info("CREATE Chat Room {}", room);
    rttr.addFlashAttribute("roomName", room);
    return "redirect:/";
  }

  // 채팅방 입장 화면
  // 파라미터로 넘어오는 roomId 를 확인후 해당 roomId 를 기준으로
  // 채팅방을 찾아서 클라이언트를 chatroom 으로 보낸다.
  @GetMapping("/room")
  public ResponseEntity<ChatRoomDto> roomDetail(@RequestParam(name = "roomId") String roomId){

    log.info("roomId {}", roomId);
    //model.addAttribute("room", chatRepository.findRoomById(roomId));
    ChatRoomDto roomById = chatRepository.findRoomById(roomId);
    return new ResponseEntity<>(roomById, HttpStatus.OK);
  }
}
