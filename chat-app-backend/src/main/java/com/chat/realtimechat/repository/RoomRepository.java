package com.chat.realtimechat.repository;

import com.chat.realtimechat.entity.Room;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {
    Room findByRoomId(String roomId);

    Room findByUserName(String userName);
}
