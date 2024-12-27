package com.chat.realtimechat.controller;

import com.chat.realtimechat.entity.Messages;
import com.chat.realtimechat.entity.Room;
import com.chat.realtimechat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("${frontend.url}")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create/{roomId}/{userName}")
    public ResponseEntity<?> createRoom(@PathVariable String roomId, @PathVariable String userName) {
        System.out.println(roomId + userName);
        //Room room= roomService.createRoom(roomId,userName);
        Object room = roomService.createRoom(roomId, userName);
        if (room instanceof Room) {
            return ResponseEntity.status(HttpStatus.CREATED).body(room);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(room);
    }

    @PostMapping("/join/{roomId}/{userName}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId, @PathVariable String userName) {
        Room room = roomService.joinRoom(roomId, userName);
        if (room == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room with ID " + roomId + " does not exist");
        }
        return ResponseEntity.status(HttpStatus.OK).body(room.getUserNames());// Return the updated messages
    }

    @GetMapping("/messages/{roomId}")
    public ResponseEntity<List<?>> getMessages(@PathVariable String roomId) {
        List<Messages> room = roomService.getMessages(roomId);
        if (room == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonList("Room with " + roomId + "not Exists"));
        }
        System.out.println("MEssages are "+room.toString());
        return ResponseEntity.ok(room);
    }
}
