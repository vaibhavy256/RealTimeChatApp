package com.chat.realtimechat.payload;

import com.chat.realtimechat.entity.Room;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jdk.jfr.DataAmount;
import lombok.*;

import java.time.LocalDateTime;


public class MessageRequest {
    private String content;
    private String sender;
    private String roomId;
    private LocalDateTime messageTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


    public MessageRequest() {
    }

    public MessageRequest(String content, String sender, String roomId, LocalDateTime messageTime) {
        this.content = content;
        this.sender = sender;
        this.roomId = roomId;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalDateTime messageTime) {
        this.messageTime = messageTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }
}
