package com.chat.realtimechat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
public class Messages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String content;
    private String sender;
    private LocalDateTime timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public Messages(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timeStamp= LocalDateTime.now();
    }

    public Messages(Long id, String content, String sender, LocalDateTime timeStamp, Room room) {
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.timeStamp = timeStamp;
        this.room = room;
    }

    public Messages() {
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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}