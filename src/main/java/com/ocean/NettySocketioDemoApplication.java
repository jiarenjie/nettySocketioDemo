package com.ocean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ocean.config.SocketConfig;
import com.ocean.config.SpringUtil;

@SpringBootApplication
public class NettySocketioDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettySocketioDemoApplication.class, args);
		
		//初始化Socket配置
				SocketConfig sc = (SocketConfig)SpringUtil.getBean("socketConfig");
				sc.initSokectConfig();
	}
}
