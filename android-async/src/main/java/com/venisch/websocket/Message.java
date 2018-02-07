package com.venisch.websocket;

import com.google.gson.Gson;

/**
 * Created by shenwenjie on 2018/1/29.
 */

public class Message {
    private String message;
    private String fromUser;
    private String toUser;
    private String messageType;
    private String channel = "H5";
    private String token;

    public Message(){

    }

    public Message(String message, String fromUser, String toUser, String messageType) {
        this.message = message;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }
}
