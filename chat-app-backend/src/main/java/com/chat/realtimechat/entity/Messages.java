package com.chat.realtimechat.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.spi.LocaleNameProvider;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Messages {
    private String content;
    private String sender;
    private LocalDateTime timeStamp;

    public Messages(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timeStamp= LocalDateTime.now();
    }
}
