package com.nkty.sms.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * ajax消息定义类.
 * <p><br>
 * @author 陈荣盛
 * @version 1.0.0, 2014-3-10
 */
public class AjaxMessage implements Serializable{
	/**
	 * 序列化唯一标识
	 */
	private static final long serialVersionUID = 7553214414644579886L;
	/**
	 * 成功标识
	 */
	private Boolean success;
	/**
	 * 消息
	 */
	private String msg;
	/**
	 * 消息对象集
	 */
	private Map<String,Object> map = new HashMap<String,Object>();
	
	/**
	 * 构造方法
	 * @param success 成功标识
	 */
	public AjaxMessage(Boolean success){
		this.success = success;
	}
	public AjaxMessage(Boolean success, String msg){
		this.success = success;
		this.msg = msg;
	}
	public AjaxMessage(Boolean success, Map<String, Object> map) {
		super();
		this.success = success;
		this.map = map;
	}

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    public String getMsg() {
		return msg;
	}
    
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Map<String, Object> getMap() {
        return map;
    }
	/**
     * 向消息对象集中加入数据
     * <br/>建议value实现序列化
     * @param key 
     *            键
     * @param value 
     *            值
     */
    public void add(String key,Object value){
        this.map.put(key, value);
    }
}