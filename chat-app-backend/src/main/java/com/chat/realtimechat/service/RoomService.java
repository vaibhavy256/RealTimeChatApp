package com.chat.realtimechat.service;

import com.chat.realtimechat.entity.Room;
import com.chat.realtimechat.exception.NoRoomFound;
import com.chat.realtimechat.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class RoomService {
    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(String  roomId,String userName){
        if(roomRepository.findByRoomId(roomId)!=null){
            log.warn("Room already exists");
            return null;
        }
        if (roomRepository.findByUserName(userName) != null) {
            log.warn("Username {} is already in use", userName);
            return null; // Indicate that the username is taken
        }
        Room newRoom = new Room();
        newRoom.setRoomId(roomId);  // Set the unique room ID
        newRoom.setUserNames(userName);
        return roomRepository.save(newRoom);
    }

    public Room joinRoom(String roomId,String userName){
            Room room=roomRepository.findByRoomId(roomId);
            if (room==null){
                log.warn("Room with ID {} does not exists",roomId);
                return null;
            }
            room.setUserNames(userName);
            return roomRepository.save(room);
    }


}
