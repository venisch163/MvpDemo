//package com.venisch.websocket;
//
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.PersistableBundle;
//import android.support.annotation.Nullable;
//import android.support.annotation.RequiresApi;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import com.koushikdutta.async.AsyncSocket;
//import com.koushikdutta.async.ByteBufferList;
//import com.koushikdutta.async.DataEmitter;
//import com.koushikdutta.async.callback.DataCallback;
//import com.koushikdutta.async.http.AsyncHttpClient;
//import com.koushikdutta.async.http.AsyncHttpResponse;
//import com.koushikdutta.async.http.WebSocket;
//import com.koushikdutta.async.http.socketio.SocketIOClient;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//
///**
// * Created by shenwenjie on 2018/1/29.
// */
//
//public class TestActivity extends AppCompatActivity {
//    private static final String TAG = "TestActivity";
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
//        initData();
//    }
//
//    private void initData() {
//        Button btnConnect = findViewById(R.id.btn_connect);
//        btnConnect.setOnClickListener((v) -> connect());
//
//    }
//
//
//    private void connect() {
//        AsyncHttpClient.getDefaultInstance().websocket("ws://192.168.198.147:5000/im?t=test_v_010BCAE6C8A54ECAB2DFFC8EE2E40A53", null, new AsyncHttpClient.WebSocketConnectCallback() {
//            @Override
//            public void onCompleted(Exception ex, WebSocket webSocket) {
//
//                Log.d(TAG, "onCompleted");
//                if (ex != null) {
//                    ex.printStackTrace();
//                    return;
//                }
//
//
//                String msg =buildTestPacket();
//                try {
//                    byte[] encode = Base64.getUrlEncoder().encode(msg.getBytes("UTF-8"));
//                    webSocket.send(encode);
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
////                webSocket.send(/*buildTestPacket()*/"hello");
////
//
//                webSocket.setStringCallback(new WebSocket.StringCallback() {
//                    public void onStringAvailable(String s) {
//                        System.out.println("I got a string: " + s);
//                        Log.d(TAG, "I got a string:"+s);
//                    }
//                });
//                webSocket.setDataCallback(new DataCallback() {
//                    public void onDataAvailable(DataEmitter emitter, ByteBufferList byteBufferList) {
//                        byte[] allByteArray = byteBufferList.getAllByteArray();
//
//                        Log.d(TAG, "I got some bytes!"+new String(allByteArray));
//                        byte[] decode = Base64.getUrlDecoder().decode(allByteArray);
//                        try {
//                            String decode1 = URLDecoder.decode(new String(decode), "UTF-8");
//                            Log.d(TAG, ": "+decode1);
//                        } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace();
//                        }
//                        Log.d(TAG, "I got some bytes!"+new String(decode));
//                        // note that this data has been read
//                        byteBufferList.recycle();
//                    }
//                });
//            }
//        });
//    }
//
//    private String buildTestPacket() {
//        BasePacket basePacket = new BasePacket();
//        basePacket.setCmd("send_message");
//        basePacket.setReqNo(System.currentTimeMillis()+"");
//        Message message = new Message();
//        message.setFromUser("jdcf_952801280c13159434f39ca2102df93c");
//        message.setToUser("jdcf_8a6593b97adcdd8aab28bb757428dd98");
//        message.setMessage("文杰web");
//        message.setMessageType("text");
//        basePacket.setParams(message);
//        return basePacket.toString();
//    }
//}
