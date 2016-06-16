package com.ccg.util;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.ccg.vo.KuaidiInfo;
import com.ccg.vo.KuaidiSource;


public class Kuaidi100Util {
	
	/**
	 * 直接获取单号来源实体
	 * @author CCG 2016年6月16日
	 * @param text 单号
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static KuaidiSource getKuaidiSource(String text) throws JsonParseException, JsonMappingException, IOException{
		String url = "http://www.kuaidi100.com/autonumber/autoComNum?text="+text;
		String res = HttpUtil.sendGet(url, "utf-8");
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.readValue(res, KuaidiSource.class);
	}  
	
	/**
	 * 获取运单信息
	 * @author CCG 2016年6月16日
	 * @param type
	 * @param postId
	 * @return 运单对象
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static KuaidiInfo getKuaidiInfo(String type,String postId) throws JsonParseException, JsonMappingException, IOException{
		double temp = Math.random();
		String url = "http://www.kuaidi100.com/query?type="+type+"&postid="+postId
				+ "&id=1&valicode=&temp="+temp;  //0.6873234723477222
 		String res = HttpUtil.sendGet(url, "utf-8");
 		
 		ObjectMapper mapper = new ObjectMapper();
 		return mapper.readValue(res, KuaidiInfo.class);
	}
	
}
