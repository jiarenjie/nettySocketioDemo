package com.ocean.socketio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
/**
 * 推送数据类
 * @author sunxiaojuan
 *
 */
public class WsSender {
	
	private final static Logger log = LoggerFactory.getLogger(WsSender.class);
	
	/**
	 * 封装推送数据对象
	 * @param data
	 * @return
	 */
    public static JSONObject getPushDataObject(PushData data){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("data", data.getSourcedata());
        return jsonObj;
    }
    
    /**
     * 推送数据
     * @param data
     */
    public static void sendMsg(PushData data,String eventName) {
        MessageManager.getServer().getBroadcastOperations().sendEvent(eventName, getPushDataObject(data));
        log.info("推送数据结束;");
    }

}
