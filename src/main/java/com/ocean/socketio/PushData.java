package com.ocean.socketio;
/**
 * 推送数据实体类
 * @author sunxiaojuan
 *
 */
public class PushData {
	/**
	 * 数据对象
	 */
	public Object sourcedata;
	
	public Integer code;//响应状态码
	public String message;//响应信息

	public Object getSourcedata() {
		return sourcedata;
	}

	public void setSourcedata(Object sourcedata) {
		this.sourcedata = sourcedata;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
