package com.example.reasonablebasicboard.domain.chat.repository;

import com.example.reasonablebasicboard.domain.chat.dto.ChatRoomDto;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRepository {

  // 채팅방을 만들어 저장
  private Map<String, ChatRoomDto> chatRoomMap;

  /*
      빈(Bean)이 생성된 후에 초기화 작업을 수행하는 메서드
   */
  @PostConstruct
  private void init() {
    chatRoomMap = new HashMap<>();
  }

  // 전체 채팅방 조회
  public List<ChatRoomDto> findAllRoom(){
    // 채팅방 생성 순서를 최근순으로 반환
    List chatRooms = new ArrayList<>(chatRoomMap.values());
    Collections.reverse(chatRooms);

    return chatRooms;
  }

  // roomID 기준으로 채팅방 찾기
  public ChatRoomDto findRoomById(String roomId){
    return chatRoomMap.get(roomId);
  }

  // roomName 로 채팅방 만들기
  public ChatRoomDto createChatRoomDto(String roomName){
    ChatRoomDto chatRoom = new ChatRoomDto().create(roomName); // 채팅룸 이름으로 채팅 룸 생성 후

    // map 에 채팅룸 아이디와 만들어진 채팅룸을 저장
    chatRoomMap.put(chatRoom.getRoomId(), chatRoom);

    return chatRoom;
  }

  // 채팅방 인원 + 1
  //  public void plusUserCnt(String roomId){
  //    ChatRoomDto room = chatRoomMap.get(roomId);
  //    room.setUserCount(room.getUserCount() + 1);
  //  }

  // 채팅방 인원 - 1
  //  public void minusUserCnt(String roomId){
  //    ChatRoomDto room = chatRoomMap.get(roomId);
  //    room.setUserCount(room.getUserCount() - 1);
  //  }

  // 채팅방 유저 리스트에 유저 추가
  public String addUser(String roomId, String userName){
    ChatRoomDto room = chatRoomMap.get(roomId);
    String userUUID = UUID.randomUUID().toString();

    // 아이디 중복 확인 후 userList 에 추가 - 1:1에서는 필요 없을 듯
    room.getUserList().put(userUUID, userName);

    return userUUID;
  }

  // 채팅방 유저 이름 중복 확인
  //  public String isDuplicateName(String roomId, String username){
  //    ChatRoomDto room = chatRoomMap.get(roomId);
  //    String tmp = username;
  //
  //    // 만약 userName 이 중복이라면 랜덤한 숫자를 붙임
  //    // 이때 랜덤한 숫자를 붙였을 때 getUserlist 안에 있는 닉네임이라면 다시 랜덤한 숫자 붙이기
  //    while(room.getUserList().containsValue(tmp)){
  //      int ranNum = (int) (Math.random() * 100) + 1;
  //
  //      tmp = username + ranNum;
  //    }
  //
  //    return tmp;
  //  }

  // 채팅방 유저 리스트 삭제
  //  public void delUser(String roomId, String userUUID){
  //    ChatRoomDto room = chatRoomMap.get(roomId);
  //    room.getUserList().remove(userUUID);
  //  }

  // 채팅방 userName 조회
  //    public String getUserName(String roomId, String userUUID){
  //      ChatRoomDto room = chatRoomMap.get(roomId);
  //      return room.getUserList().get(userUUID);
  //    }

  // 채팅방 전체 userlist 조회
  public ArrayList<String> getUserList(String roomId){
    ArrayList<String> list = new ArrayList<>();

    ChatRoomDto room = chatRoomMap.get(roomId);

    // hashmap 을 for 문을 돌린 후
    // value 값만 뽑아내서 list 에 저장 후 reutrn
    room.getUserList().forEach((key, value) -> list.add(value));
    return list;
  }
}
