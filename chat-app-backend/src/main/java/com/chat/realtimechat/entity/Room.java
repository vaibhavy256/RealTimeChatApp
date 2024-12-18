package com.chat.realtimechat.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Room {
    private String id;
    private String roomId;
    @ElementCollection
    private List<String> userNames = new ArrayList<>();
    private List<Messages> messages=new ArrayList<>();
    // Method to add a user to the room
    public void addUser(String userName) {
        this.userNames.add(userName);
    }
}
