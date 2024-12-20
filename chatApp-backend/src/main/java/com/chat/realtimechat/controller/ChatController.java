package com.chat.realtimechat.controller;

import com.chat.realtimechat.entity.Messages;
import com.chat.realtimechat.entity.Room;
import com.chat.realtimechat.exception.NoRoomFound;
import com.chat.realtimechat.payload.MessageRequest;
import com.chat.realtimechat.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

public class ChatController {
    @Autowired
    RoomRepository roomRepository;

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Messages sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request){
        Room room=roomRepository.findByRoomId(request.getRoomId());

        Messages messages=new Messages();
        messages.setContent(request.getContent());
        messages.setSender(request.getSender());
        messages.setTimeStamp(LocalDateTime.now());
        if(room!=null){
            room.getMessages().add(messages);
            roomRepository.save(room);
        }
        else {
            throw new NoRoomFound("Room not found!");
        }
        return messages;
    }

}
