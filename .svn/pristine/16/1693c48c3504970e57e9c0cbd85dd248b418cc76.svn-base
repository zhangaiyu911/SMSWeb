package com.nkty.sms.util;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * JSON格式相应工具类
 * <p><br>
 * @author 陈荣盛
 * @version 1.0.0, 2014-10-12
 */
public final class JsonUtil {

	/** ObjectMapper */
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 不可实例化
	 */
	private JsonUtil() {
	}

	/**
	 * 将对象转换为JSON字符串
	 * 
	 * @param value
	 *            对象
	 * @return JSOn字符串
	 */
	public static String toJson(Object value) {
		try {
			return mapper.writeValueAsString(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将JSON字符串转换为对象
	 * 
	 * @param json
	 *            JSON字符串
	 * @param valueType
	 *            对象类型
	 * @param <T> 实体
	 * 
	 * @return 对象
	 */
	public static <T> T toObject(String json, Class<T> valueType) {
		Assert.hasText(json);
		Assert.notNull(valueType);
		try {
			return mapper.readValue(json, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将JSON字符串转换为对象
	 * 
	 * @param json
	 *            JSON字符串
	 * @param typeReference
	 *            对象类型
	 *            
	 * @param <T> 实体
	 * 
	 * @return 对象
	 */
	public static <T> T toObject(String json, TypeReference<?> typeReference) {
		Assert.hasText(json);
		Assert.notNull(typeReference);
		try {
			return mapper.readValue(json, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将JSON字符串转换为对象
	 * 
	 * @param json
	 *            JSON字符串
	 * @param javaType
	 *            对象类型
	 * @param <T> 实体
	 * 
	 * @return 对象
	 */
	public static <T> T toObject(String json, JavaType javaType) {
		Assert.hasText(json);
		Assert.notNull(javaType);
		try {
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将对象转换为JSON流
	 * 
	 * @param writer
	 *            writer
	 * @param value
	 *            对象
	 */
	public static void writeValue(Writer writer, Object value) {
		try {
			mapper.writeValue(writer, value);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将json数组字符串转换成特定类型的对象列表.
	 * <p><b>创建人：</b><br>&nbsp;&nbsp; 陈荣盛 2014年10月12日 下午5:42:23<br>
	 * <p><b>修改人：</b><br>&nbsp;&nbsp; 2014年10月12日 下午5:42:23<br>
	 * <p><b>修改说明：</b><br>&nbsp;&nbsp;<br>
	 * @param json	json数组字符串
	 * @param valueType  要转换成的对象类型
	 * @return 对象类型的列表对象
	 */
	@SuppressWarnings("rawtypes")
	public static <T> List<T> toObjectList(String json, Class<T> valueType) {
		//将json字符串转换成json数组对象
		JSONArray js = JSONArray.fromObject(json);
		JSONObject jo = null;
		Iterator it = js.iterator();
		
		List<T> tList = new ArrayList<T>();
		T t = null;
		//遍历json数组对象
		while(it.hasNext()){
			//取得一个json对象
			jo = (JSONObject)it.next();
			
			//按类型转换
			t = JsonUtil.toObject(jo.toString(), valueType);
			tList.add(t);
		}
		
		return tList;
	}
	
	/**
     * 将Json对象转换成Map
     * 
     * @param jsonObject
     *            json对象
     * @return Map对象
     * @throws JSONException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map jsonToMap(String jsonString) {
    	JSONObject jsonObject = JSONObject.fromObject(jsonString); 
        
        Map result = new HashMap();
        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;
        
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);
        }
        return result;
    }
}