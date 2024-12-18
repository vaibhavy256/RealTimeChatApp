package com.chat.realtimechat.controller;

import com.chat.realtimechat.entity.Room;
import com.chat.realtimechat.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoomController {

    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<?>createRoom(@RequestParam String roomId,@RequestParam String userName){
        Room room=roomService.createRoom(roomId,userName);
        if(room==null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Room with"+roomId+"already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

}
