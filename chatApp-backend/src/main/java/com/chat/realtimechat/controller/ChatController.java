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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
@CrossOrigin(origins = "*")
public class ChatController {
    @Autowired
    RoomRepository roomRepository;

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Messages sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request){
        System.out.println(roomId+" "+request.toString());
        Room room=roomRepository.findByRoomId(roomId);
        System.out.println(room);
        Messages messages=new Messages();
        messages.setRoom(room);
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