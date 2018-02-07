package com.venisch.websocket;

import com.google.gson.Gson;

/**
 * Created by shenwenjie on 2018/1/29.
 */

public class BasePacket<T> {
    String cmd;
    String reqNo;
    String user;
    T params;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
