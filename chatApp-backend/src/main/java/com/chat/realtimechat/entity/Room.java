package com.chat.realtimechat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String roomId;

    @ElementCollection
    private List<String> userName = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonBackReference
    private List<Messages> messages = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<String> getUserNames() {
        return userName;
    }

    public void setUserNames(List<String> userNames) {
        this.userName = userNames;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    // Method to add a user to the room and also avoiding adding redundant names
    public void addUser(String userNames) {
        if (!userName.contains(userName)) {
            userName.add(userNames);
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomId='" + roomId + '\'' +
                ", messages=" + messages +
                '}';
    }
}
