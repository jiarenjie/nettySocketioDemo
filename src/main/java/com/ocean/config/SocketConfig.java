package com.ocean.config;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.Configuration;
import com.ocean.socketio.MessageManager;

/**
 * 初始化Socket配置类
 */
@Service
public class SocketConfig {
	
	/**
	 * 初始化Socket配置
	 */
	public void initSokectConfig(){
		System.out.println("========开始初始化Socket配置========");
	    Configuration config = new Configuration();
	    config.setHostname("localhost");
	    config.setPort(8081);
	    MessageManager.getInstance().initSocketIOServer(config);
	    MessageManager.getInstance().startPush();
	    MessageManager.getInstance().startListener();
	    MessageManager.getInstance().startServer();
	    System.out.println("========初始化Socket配置结束========");
	}
	
//	/**
//	 * 测试
//	 * @throws InterruptedException
//	 */
//	public void test() throws InterruptedException {
//	    Configuration config = new Configuration();
//	    config.setHostname("15.184.19.10");
//	    config.setPort(8082);
//	    SocketIOServer server = new SocketIOServer(config);
//	    server.addConnectListener(new ConnectListener() {
//
//			@Override
//			public void onConnect(SocketIOClient client) {
//				// TODO Auto-generated method stub
//	            System.out.println(client.getRemoteAddress() + " web客户端接入");
//	            client.sendEvent("dataPush", "Hi,测试调通");
//			}
//	    });
//	                    // 握手请求
//	    server.addEventListener("dataPush", JSONObject.class, new DataListener<JSONObject>() {
//	        @Override
//	        public void onData(SocketIOClient client, JSONObject data, AckRequest ackRequest) {
//	            // 握手
//	                // send message back to client with ack callback
//	                // WITH data
//	                client.sendEvent("dataPush", new AckCallback<String>(String.class) {
//	                    @Override
//	                    public void onSuccess(String result) {
//	                        System.out.println("ack from client: " + client.getSessionId() + " data: " + result);
//	                    }
//	                });
//	        }
//	    });
//
//        server.start();
//        Thread.sleep(Integer.MAX_VALUE);
//        server.stop();
//	}
}
