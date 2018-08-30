package com.example.demo2.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author lanxinghua
 * @date 2018/08/30 11:10
 * @description websocket 测试
 */
@ServerEndpoint(value = "/webSocketServer/{userName}")
@Component
public class WebsocketServer {

    private static final Set<WebsocketServer> connections = new CopyOnWriteArraySet<>();
    private String nickName;
    private Session session;

    private static String getDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    @OnOpen
    public void start(@PathParam("userName") String userName, Session session) {
        this.nickName = userName;
        this.session = session;
        connections.add(this);
        String msg = String.format("* %s %s", nickName, "加入聊天！");
        broadcast(msg);
    }

    @OnClose
    public void end() {
        connections.remove(this);
        String msg = String.format("* %s %s", nickName, "退出聊天！");
        broadcast(msg);
    }

    @OnMessage
    public void pushMsg(String msg) {
        broadcast("【" + this.nickName + "】" + getDateTime(new Date()) + " : " + msg);
    }

    @OnError
    public void onError(Throwable t) throws Throwable{
        System.out.println("发送错误："+t.getMessage());
    }

    //广播形式发送消息
    private void broadcast(String msg) {
        for (WebsocketServer client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                connections.remove(client);
                try {
                    client.session.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                String errMsg = String.format("* %s %s", client.nickName, "断开连接！");
                broadcast(errMsg);
            }
        }

    }

}