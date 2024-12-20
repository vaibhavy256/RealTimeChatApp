package com.chat.realtimechat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.spi.LocaleNameProvider;


@Entity
public class Messages {
    @Id
    private Long id;
    private String content;
    private String sender;
    private LocalDateTime timeStamp;

    public Messages(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timeStamp= LocalDateTime.now();
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
