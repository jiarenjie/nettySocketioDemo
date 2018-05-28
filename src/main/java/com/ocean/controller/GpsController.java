package com.ocean.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocean.socketio.PushData;
import com.ocean.socketio.WsSender;

/**定位相关的API接口类<br>
 * 2018年4月19日 下午1:28:20
 * @author mengqingquan
 */
@RestController
public class GpsController {
	
	@RequestMapping("/jingli")
	public PushData getJingLi(String jingli){
		System.out.println(jingli);
		PushData pushData = new PushData();
		pushData.setSourcedata(jingli);
		WsSender.sendMsg(pushData,"jingli");
		return pushData;
	}
	
}
