package com.ruiheng.utils;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间的工具类,专门用来处理各种各样的日期类型
 * @author yuantao
 */
public class DateUtil {

	/**
	 * 时间戳转换成日期格式
	 * @param time
	 * @return
	 */
	public static  String getCurrentDate(Long time){
		Date date = new Date(time);
		//你调用这个方法试试,你打字打的啥玩意,你微信打字我看123123
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}

	/**
	 * 将一个日期类型,转换为MM-dd格式的年月日的String类型
	 * @param timestampDate
	 * @return
	 */
	public static String formartDate(Timestamp timestampDate){
		Date date = new Date(String.valueOf(timestampDate));
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dates = sdf.format(date);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		return sdf.format(date);
		return dates;
	}


	/**
	 * 将一个日期类型,转换为yyyy-MM-dd格式的年月日的String类型
	 * @param date
	 * @return
	 */
	public static String formartYear(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public static String formartYearDateTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 hh:mm");
		return sdf.format(date);
	}
}
