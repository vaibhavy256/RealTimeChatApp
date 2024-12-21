package com.chat.realtimechat.service;

import com.chat.realtimechat.entity.Room;
import com.chat.realtimechat.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    private static final Logger logger = LoggerFactory.getLogger(Room.class);

    public Object createRoom(String  roomId,String userName){
        if(roomRepository.findByRoomId(roomId)!=null){
            logger.warn("Room {} exists already", roomId);
            return "Room "+ roomId + " exist already !!";
        }
        if (roomRepository.findByUserName(userName) != null) {
            logger.warn("Username {} is already in use", userName);
            return "Username "+ userName +" is already in use"; // Indicate that the username is taken
        }
        Room newRoom = new Room();
        newRoom.setRoomId(roomId);  // Set the unique room ID
        newRoom.setUserNames(Collections.singletonList(userName));
        return roomRepository.save(newRoom);
    }

    public Room joinRoom(String roomId,String userName){
            Room room=roomRepository.findByRoomId(roomId);
            if (room==null){
                logger.warn("Room with ID {} does not exists",roomId);
                return null;
            }
            room.addUser(userName);
            return roomRepository.save(room);
    }

    public Room getMessages(String roomId){
        Room room=roomRepository.findByRoomId(roomId);
        if (room==null){
            return null;
        }
        else {
            return room;
        }
    }


}
