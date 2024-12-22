package com.chat.realtimechat.service;

import com.chat.realtimechat.entity.Messages;
import com.chat.realtimechat.entity.Room;
import com.chat.realtimechat.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

    @Transactional
    public Room joinRoom(String roomId, String userName) {
        // Fetch the room by its ID
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            logger.warn("Room with ID {} does not exist", roomId);
            return null;
        }
         // Check if the user is already part of the room
        if (!room.getUserNames().contains(userName)) {
            // User is not in the room; add them and save the room
            room.addUser(userName);
            roomRepository.save(room);
            logger.info("User {} added to room {}", userName, roomId);
        } else {
            // User is already in the room; just log the event
            logger.info("User {} is already in room {}", userName, roomId);
        }

        return room; // Return the room object
    }


    public List<Messages> getMessages(String roomId){
        Room room=roomRepository.findByRoomId(roomId);
        if (room==null){
            return null;
        }
        System.out.println(room);
        List<Messages> messages = room.getMessages();
        System.out.println(messages);
        return messages;
    }
}
