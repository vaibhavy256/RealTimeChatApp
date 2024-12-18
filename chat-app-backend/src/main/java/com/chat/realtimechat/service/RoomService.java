package com.chat.realtimechat.service;

import com.chat.realtimechat.entity.Room;
import com.chat.realtimechat.exception.NoRoomFound;
import com.chat.realtimechat.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoomService {
    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(String  roomId){
        if(roomRepository.findByRoomId(roomId)!=null){
            log.warn("Room already exists");
            return null;
        }
        Room room=new Room();
        room.setId(roomId);
        Room savedRoom=roomRepository.save(room);
        return savedRoom;
    }

}
