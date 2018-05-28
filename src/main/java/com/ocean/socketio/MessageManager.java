package com.ocean.socketio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

/**
 * Socket消息管理类
 * @author sunxiaojuan
 *
 */
public final class MessageManager {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static MessageManager INSTANCE = new MessageManager();

    private static SocketIOServer server;
    
    public static SocketIOServer getServer() {
        return server;
    }

    private MessageManager() {}

    public static MessageManager getInstance() {
        return INSTANCE;
    }

    /**
     * 初始化SocketIO服务
     * @param config
     */
    public void initSocketIOServer(Configuration config) {
        if (null == server) {
            server = new SocketIOServer(config);
        }
    }

    /**
     * 启动SocketIO服务
     */
    public void startServer() {
        if (null != server) {
            server.start();
            log.info("=====启动SocketIO服务");
        }
    }

    /**
     * 关闭SocketIO服务
     */
    public void stopServer() {
        try {
            if (null != server) {
                server.stop();
                log.info( "-----关闭SocketIO服务");
            }
        } catch (Exception e) {
            log.info("-----关闭服务失败", e);
        }
    }
    
    /**
     * 启动监听
     */
    public void startListener() {
        if (null != server) {
            DataPushListener dataPushListener = new DataPushListener();
            dataPushListener.setServer(server);
            server.addEventListener("dataPush", JSONObject.class, dataPushListener);
        }
    }
    
    /**
     * 客户端连接监听器
     */
    public void startPush(){
        if (null != server) {
            server.addConnectListener(new ConnectListener() {
                @Override
                public void onConnect(SocketIOClient client) {
                    log.info(client.getRemoteAddress() + " web客户端接入");
                }
            });
        }
    }
    
}
