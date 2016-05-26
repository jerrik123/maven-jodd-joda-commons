package com.mangocity.joda;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateClient {

	public static void main(String[] args) {
		calculateDaysBetweenTwoDate();

		addMonthOrDay();

		operateWithJDKDate();
	}

	// 与JDK进行操作
	private static void operateWithJDKDate() {
		Date date = new Date();
		DateTime dateTime = new DateTime(date);
		Calendar calendar = Calendar.getInstance();
		dateTime = new DateTime(calendar);
		// Joda-time 各种操作.....
		dateTime = dateTime.plusDays(1) // 增加天
				.plusYears(1)// 增加年
				.plusMonths(1)// 增加月
				.minusMillis(1)// 减分钟
				.minusHours(1)// 减小时
				.minusSeconds(1);// 减秒数
		//格式化日期对象
		DateTimeFormatter format = DateTimeFormat
				.forPattern("yyyy年MM月dd日 HH:mm:ss EE");
		System.out.println("operateWithJDKDate: " + dateTime.toString(format));
	}

	// 获取18天之后的某天在下个月的当前周的第一天日期
	private static void addMonthOrDay() {
		String dateStr = new DateTime().plusDays(18).plusMonths(1).dayOfWeek()
				.withMinimumValue().toString("yyyy-MM-dd HH:mm:ss");
		System.out.println("addMonthOrDay: " + dateStr);
	}

	// 计算两个日期之间的天数
	private static void calculateDaysBetweenTwoDate() {
		LocalDate start = new LocalDate(2016, 2, 12);
		LocalDate end = new LocalDate(2016, 5, 26);
		int days = Days.daysBetween(start, end).getDays();
		System.out.println("calculateDaysBetweenTwoDate: " + days);
	}

}
