package com.jdcf.socketio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

/**
 * Created by shenwenjie on 2018/2/7.
 */

public class SocketIoActivity extends AppCompatActivity {
    private static final String TAG = "SocketIoActivity";

    private Socket mSocket;

    {
        try {
            mSocket = IO.socket("https://test-minilive-socket.jdcf88.com:5004/client?roomNo=QHR10000011");
        } catch (URISyntaxException e) {
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();

    }

    private void initView() {
        View id = findViewById(R.id.btn_connect);
        id.setOnClickListener((v) -> {
            mSocket.disconnect();
            mSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener(){
                @Override
                public void call(Object... args) {
                    Log.d(TAG,"EVENT_CONNECT收到消息了>");
                }
            });
            mSocket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener(){
                @Override
                public void call(Object... args) {
                    Log.d(TAG,"EVENT_CONNECT_ERROR收到消息了");
                }
            });
            mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    Log.d(TAG,"EVENT_CONNECT_TIMEOUT收到消息了");
                }
            });
            mSocket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener(){
                @Override
                public void call(Object... args) {
                    Log.d(TAG,"EVENT_DISCONNECT>>收到消息了");
                }
            });
            mSocket.on(Socket.EVENT_MESSAGE, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    Log.d(TAG,"EVENT_MESSAGE 收到消息了");
                }
            });
            mSocket.on("broadcast", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    Log.d(TAG,"broadcast 收到消息了");
                }
            });
            mSocket.connect();
        });


    }

    private Emitter.Listener onNewMessage = args -> runOnUiThread(() -> {
        Log.d(TAG,"收到消息了");
//        JSONObject data = (JSONObject) args[0];
//        String username;
//        String message;
//        try {
//            username = data.getString("username");
//            message = data.getString("message");
//        } catch (JSONException e) {
//            return;
//        }
//
//        // add the message to view
//        //            addMessage(username, message);
//
//        Log.d(TAG, "username=" + username + ">>>");
    });
}
