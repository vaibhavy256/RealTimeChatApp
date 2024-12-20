package com.chat.realtimechat.repository;

import com.chat.realtimechat.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomId(String roomId);

    @Query("SELECT r FROM Room r WHERE :userName MEMBER OF r.userName")
    Room findByUserName(String userName);
}
