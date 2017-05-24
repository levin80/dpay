package com.mi.dpay.common;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具类
 * 
 * @author
 * 
 */
public class DateUtil {

	public String date = "";

	/**
	 * @param:DATA[yyyyMMddHHmmss]
	 */
	public static final String aDATE = "yyyyMMddHHmmss";
	/**
	 * @param:DATA:[yyyy-MM-dd HH:mm:ss]
	 */
	public static final String bDATE = "yyyy-MM-dd HH:mm:ss";
	/**
	 * @param:DATA:[yyyy年MM月dd日HH时mm分ss秒]
	 */
	public static final String cDATE = "yyyy年MM月dd日HH时mm分ss秒";
	/**
	 * @param:DATA:[yyyy/MM/dd HH:mm:ss]
	 */
	public static final String dDATE = "yyyy/MM/dd HH:mm:ss";
	/**
	 * @param:DATA:[yyyyMMdd]
	 */
	public static final String eDATE = "yyyyMMdd";
	/**
	 * @param:DATA:[HHmmss]
	 */
	public static final String fDATE = "HHmmss";
	/**
	 * @param:DATA:[yyyyMMddHHmmssSSS]
	 */
	public static final String gDATE = "yyyyMMddHHmmssSSS";
	/**
	 * @param:DATA:[yyyyMM]
	 */
	public static final String hDATE = "yyyyMM";
	/**
	 * @param:DATA:[yyyy-MM-dd HH:mm:ss.SSS]
	 */
	public static final String iDATE = "yyyy-MM-dd HH:mm:ss.SSS";
	/**
	 * @param:DATA:[yyyy-MM-dd]
	 */
	public static final String jDATE = "yyyy-MM-dd";

	/**
	 * @param:DATA:[yyyy-MM-dd 00-00-00]
	 */
	public static final String tBENTIME = "yyyy-MM-dd 00:00:00";

	/**
	 * @param:DATA:[yyyy-MM-dd 23-59-59]
	 */
	public static final String tENDTIME = "yyyy-MM-dd 23:59:59";

	public DateUtil() {
	}

	private static final DateUtil iData = new DateUtil();

	// 静态工厂方法
	public static DateUtil getInstance() {
		return iData;
	}

	/**
	 * 
	 * @param DateUtil
	 *            format格式化参数
	 * @return String
	 * @author YanJun Xu
	 * @date Nov 15, 2012 12:51:52 AM
	 */
	public static String getStrDate(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

	/**
	 * 
	 * @param String
	 *            date字符串
	 * @param format
	 *            格式化参数
	 * @return java.util.Date
	 * @author YanJun Xu
	 * @date Nov 15, 2012 12:53:51 AM
	 */
	public static Date getDate(String date, String format) {
		if (date == null) {
			return null;
		}
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 
	 * @param Date
	 *            date时间对象
	 * @param format
	 *            格式化参数
	 * @return String类型的时间字符串
	 * @author YanJun Xu
	 * @date Nov 15, 2012 12:53:51 AM
	 */
	public static String formatDate(Date date, String format) {
		String dateString = "";
		if (date != null && null != date.toString() && !"".equals(date.toString())) {
			dateString = new SimpleDateFormat(format).format(date);
		}

		return dateString;
	}

	/**
	 * 将字符串转换为日期格式
	 * 
	 * @param str
	 *            字符串
	 * @param fm
	 *            日期格式
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDates(String str, String fm) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(fm);
		return format.parse(str);
	}

	/**
	 * 日期14位+5位随机数生成 备注：注意必须是19位，否则无法转成long型，
	 */
	public static String getDateRadomNo() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		int n = 0;
		n = (int) (Math.random() * 10000);
		while (n < 1000 || !handle(n)) {
			n = (int) (Math.random() * 10000);
		}
		String date = df.format(new Date());
		return date + n;
	}

	public static boolean handle(int n) {
		int[] list = new int[5];
		for (int i = 0; i < 5; i++) {
			list[i] = n % 10;
			n = n / 10;
		}
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (list[i] == list[j])
					return false;
			}
		}
		return true;
	}

	/**
	 * 获取当前月第一天
	 * 
	 * @return
	 */
	public static String getFisrtDayOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String firstday, lastday;
		Calendar cale = null;
		// 获取前月的第一天
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		firstday = format.format(cale.getTime());
		return firstday;
	}

	/**
	 * 获取下个月第一天
	 */
	public static String getFirstDayOfNextMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String firstday, lastday;
		Calendar cale = null;
		// 获取前月的第一天
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		firstday = format.format(cale.getTime());
		return firstday;
	}

	/**
	 * 时间转字符串
	 * 
	 * @param aDteValue
	 * @param aFmtDate
	 * @return
	 */
	public static String dateToStr(Date aDteValue, String aFmtDate) {
		String strRtn = null;
		if (aFmtDate.length() == 0) {
			aFmtDate = "yyyyMMddHHmmss";
		}
		Format fmtDate = new SimpleDateFormat(aFmtDate);
		try {
			strRtn = fmtDate.format(aDteValue);
		} catch (Exception e) {
		}
		return strRtn;
	}

	/**
	 * 获取几个月后的时间,返回String
	 * 
	 * @param format
	 * @param addMonth
	 * @return
	 */
	public static String getAddMonthTime(String format, int addMonth) {
		String monthTime = "";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, +addMonth);// 几个月后
		monthTime = new SimpleDateFormat(format).format(cal.getTime());
		return monthTime;
	}

	/**
	 * Description:计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            开始时间
	 * @param bdate
	 *            结束时间
	 * @return
	 * @throws ParseException
	 *             int
	 */
	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * Description:获取给定时间的间隔几天
	 * 
	 * @param smdate
	 * @param day
	 * @return Date
	 */
	public static Date getDayNext(Date smdate, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(smdate);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, day); // 设置当前时间的后几天
		Date d = calendar.getTime(); // 得到时间
		return d;
	}

	/**
	 * @param args
	 * @author Honghui Zhang
	 * @throws ParseException
	 * @date 2013-3-31 上午11:53:23
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println(DateUtil.formatDate(parseDates("2015-08-07 08:00:00", jDATE), "yyyy-MM-dd"));
	}

}
