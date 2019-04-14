package com.nsc.web.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nsc.backend.entity.Book;
import com.nsc.backend.entity.OrderSub;

public class OrderUtil {
	
	/**
	 * 生成18位数的随机数(10+x+(8-x))
	 * 10:时间戳
	 * x:storeId
	 * (8-x):随机数
	 */
	public static String getOrderNum(Integer Id){		
		
		String orderNumber = "" ;
		
		//时间戳
		Long timeStamp = System.currentTimeMillis() / 1000;
		
		orderNumber = "" + timeStamp + Id ;
		
		Random random = new Random();
		for (int i = orderNumber.length()+1; i <= 18; i++) {
			orderNumber += String.valueOf(random.nextInt(10));
		}

		return orderNumber;
	}
	

}
