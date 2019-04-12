package com.nsc.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * @Desc 生成日期  
 * @author sjg
 * @Date 2019年4月12日
 */
public class DateTimeGenerator {
	
	public static Date getDateTime() {
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//LocalDateTime dateDefault = LocalDateTime.parse("1970-01-01 08:00:00",df);
		LocalDateTime dateNow = null;
	    ZoneId zone = ZoneId.systemDefault();
	    Instant instant = null;
		Date tmp = null;
		SimpleDateFormat sdf = null;
		String formate = null;
		Date res = null;
		
		try {
			dateNow = LocalDateTime.now();
			instant = dateNow.atZone(zone).toInstant();
			tmp = Date.from(instant);
			sdf = new SimpleDateFormat();
			formate = sdf.format(tmp);
			res = sdf.parse(formate);
		}catch(ParseException e) {
			LogUtil.out("DateTimeGenerator", "getDateTime", "日期格式有误，无法正常格式化");
			//设置为默认日期，也即出现异常
			dateNow = LocalDateTime.parse("1970-01-01 08:00:00",df);
		    tmp = Date.from( dateNow.atZone(zone).toInstant() );
		    formate = sdf.format(tmp);
			try {
				res = sdf.parse(formate);
			} catch (ParseException e1) {
				LogUtil.out("DateTimeGenerator", "getDateTime", "日期格式有误，无法正常格式化");
				res = null;
			}
		}
			
		return res;
	}
}
