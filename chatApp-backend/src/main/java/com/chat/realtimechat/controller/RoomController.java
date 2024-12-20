package com.chat.realtimechat.controller;

import com.chat.realtimechat.entity.Room;
import com.chat.realtimechat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create/{roomId}/{userName}")
    public ResponseEntity<?>createRoom(@PathVariable String roomId, @PathVariable String userName){
        System.out.println(roomId+userName);
        Room room=roomService.createRoom(roomId,userName);
        if(room==null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Room with "+roomId+" already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
    @PostMapping("/join/{roomId}/{userName}")
    public ResponseEntity<?>joinRoom(@PathVariable String roomId, @PathVariable String userName){
        Room room=roomService.joinRoom(roomId,userName);
        if (room==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room with " +roomId+ " not Exists");
        }
        return ResponseEntity.status(HttpStatus.OK).body(room.getUserNames());
    }
    @GetMapping("/messages/{roomId}")
    public ResponseEntity<?>getMessages(@PathVariable String roomId){
        Room room=roomService.getMessages(roomId);
        if (room==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room with "+roomId+"not Exists");
        }
        return ResponseEntity.status(HttpStatus.OK).body(room.getMessages());
    }
}
