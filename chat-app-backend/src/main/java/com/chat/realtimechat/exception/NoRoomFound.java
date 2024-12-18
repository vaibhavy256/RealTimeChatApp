package com.chat.realtimechat.exception;

public class NoRoomFound extends RuntimeException{
    private String message;

    public NoRoomFound(){

    }
    public NoRoomFound(String msg){
        super(msg);
        this.message=msg;
    }

}
