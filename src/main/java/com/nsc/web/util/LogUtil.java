package com.nsc.web.util;

/**
 * 
 * @Desc  打印信息
 * @author sjg
 * @Date 2019年4月11日
 */
public class LogUtil {
	public static void out(String classname,String methodname,String info) {
		System.out.println("info--"+classname+"--"+methodname+"--"+info);
	}
}
