package com.hyf.test;

import com.hyf.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * API相关测试
 *
 * @author baB_hyf
 * @date 2021/02/27
 */
public class API {

    private Connection conn;
    private Channel    channel;

    @Test
    public void testOne() {
        // channel.queueDeclarePassive("");
        // conn.addShutdownListener();
        channel.addShutdownListener(e -> {
            System.out.println(1);
        });
        channel.addShutdownListener(System.out::println);
        channel.notifyListeners();
    }

    @Before
    public void before() throws IOException, TimeoutException {
        conn = ConnectionUtil.getConnection();
        channel = conn.createChannel();
    }

    @After
    public void after() throws IOException, TimeoutException {
        channel.close();
        conn.close();
    }
}
