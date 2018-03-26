/**
 * 
 */
package com.jiabiango.profits.util;

import java.util.UUID;

/**
 * 生成项目内全球唯一的uuid码
 * @author XuHongrong
 * @version 1.0.0.1  
 * Copyright Copyright (c)  2014    
 */
public class UuidUtil {
	/**
	 * 生成32位的uuid
	 * @return	32位的uuid（不包含-）
	 */
	public static String uuid()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	/**
	 * 生成基于因子的64位的长uuid
	 * @param name		生成因子
	 * @return	32位的uuid（不包含-）
	 */
	public static String uuid(Object name)
	{
		
		UUID uuid = UUID.nameUUIDFromBytes(name.toString().getBytes());
		StringBuffer sb=new StringBuffer(uuid.toString().replace("-", ""));
		uuid = UUID.randomUUID();
		sb.append(uuid.toString().replace("-", ""));
		return sb.toString();
	}
}
