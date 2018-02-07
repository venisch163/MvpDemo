package com.venisch.websocket;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testGson(){
        System.out.print(buildTestPacket());
    }

    private String buildTestPacket() {
        BasePacket basePacket = new BasePacket();
        basePacket.setCmd("send_message");
        basePacket.setReqNo(System.currentTimeMillis()+"");
        Message message = new Message();
        message.setFromUser("jdcf_952801280c13159434f39ca2102df93c");
        message.setToUser("jdcf_8a6593b97adcdd8aab28bb757428dd98");
        message.setMessage("文杰web");
        message.setMessageType("text");
        basePacket.setParams(message);
        return basePacket.toString();
    }
}