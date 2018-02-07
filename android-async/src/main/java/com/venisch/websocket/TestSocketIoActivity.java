package com.venisch.websocket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.socketio.Acknowledge;
import com.koushikdutta.async.http.socketio.ConnectCallback;
import com.koushikdutta.async.http.socketio.EventCallback;
import com.koushikdutta.async.http.socketio.JSONCallback;
import com.koushikdutta.async.http.socketio.SocketIOClient;
import com.koushikdutta.async.http.socketio.StringCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by shenwenjie on 2018/1/29.
 */

public class TestSocketIoActivity extends AppCompatActivity {
    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initData();
    }

    private void initData() {
        Button btnConnect = findViewById(R.id.btn_connect);
        btnConnect.setOnClickListener((v) -> testSocketIO());

    }

    private void testSocketIO(){
        SocketIOClient.connect(AsyncHttpClient.getDefaultInstance(), "https://test-minilive-socket.jdcf88.com:5004/client?roomNo=QHR10000011", new ConnectCallback() {
            @Override
            public void onConnectCompleted(Exception ex, SocketIOClient client) {
                if (ex != null) {
                    ex.printStackTrace();
                    return;
                }
                client.setStringCallback(new StringCallback() {
                    @Override
                    public void onString(String string, Acknowledge acknowledge) {
                        System.out.println(string);
                    }

                });
                client.on("someEvent", new EventCallback() {
                    @Override
                    public void onEvent(JSONArray argument, Acknowledge acknowledge) {
                        System.out.println("args: " + argument.toString());
                    }
                });
                client.setJSONCallback(new JSONCallback() {
                    @Override
                    public void onJSON(JSONObject json, Acknowledge acknowledge) {
                        System.out.println("json: " + json.toString());
                    }
                });
            }
        });
    }

}
