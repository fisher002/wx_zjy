package org.fisher.weixin.service;

import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXB;

import org.fisher.weixin.inmessage.InMessage;
import org.fisher.weixin.inmessage.event.EventInMessage;
import org.fisher.weixin.inmessage.image.ImageInMessage;
import org.fisher.weixin.inmessage.text.TextInMessage;
import org.fisher.weixin.inmessage.voice.VoiceInMessage;

public class MessageConvertHelper {

	// 1.使用一个Map来记录消息类型和Java类型的关系
	
	private static final Map<String,Class<? extends InMessage>> typeMap=new ConcurrentHashMap<>();
	
	static {
		typeMap.put("text", TextInMessage.class);
		typeMap.put("image", ImageInMessage.class);
		typeMap.put("vioce", VoiceInMessage.class);
		typeMap.put("event", EventInMessage.class);
	}
	
	public static Class<? extends InMessage> getClass(String xml) {
		// 获取类型
		String type = xml.substring(xml.indexOf("<MsgType><![CDATA[") + 18);
		type = type.substring(0, type.indexOf("]"));

		// 获取Java类
		Class<? extends InMessage> c = typeMap.get(type);
		
		return c;
	}

	// 2.提供一个静态的方法，可以传入XML，把XML转换为Java对象
	public static <T extends InMessage> T convert(String xml) {
		Class<? extends InMessage> c = getClass(xml);
		if (c == null) {
			return null;
		}

		// 使用JAXB转换
		@SuppressWarnings("unchecked")
		T msg = (T) JAXB.unmarshal(new StringReader(xml), c);

		return msg;
	}
	
}
