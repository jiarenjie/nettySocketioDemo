package com.ocean.socketio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
/**
 * 数据监听
 * @author sunxiaojuan
 *
 */
public class DataPushListener implements DataListener<JSONObject> {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    private SocketIOServer server;

    public void setServer(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void onData(final SocketIOClient client, JSONObject data, AckRequest ackSender) throws Exception {
        // 推送端会话
        final String uuid = data.getString("uuid");
        log.info("query" + uuid);
    }
}
