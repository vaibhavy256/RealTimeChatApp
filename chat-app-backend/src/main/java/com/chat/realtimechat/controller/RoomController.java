package com.chat.realtimechat.controller;

import com.chat.realtimechat.entity.Room;
import com.chat.realtimechat.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoomController {

    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create/{roomId}/{userName}")
    public ResponseEntity<?>createRoom(@PathVariable String roomId, @PathVariable String userName){
        Room room=roomService.createRoom(roomId,userName);
        if(room==null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Room with"+roomId+"already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
    @PostMapping("/join/{roomId}/{userName}")
    public ResponseEntity<?>joinRoom(@PathVariable String roomId, @PathVariable String userName){
        Room room=roomService.joinRoom(roomId,userName);
        if (room==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room with "+roomId+"not Exists");
        }
        return ResponseEntity.status(HttpStatus.OK).body(room.getUserNames());
    }

}
