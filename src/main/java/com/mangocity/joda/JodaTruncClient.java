package com.mangocity.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Days;
import org.junit.Test;

/**
 * 实现Oracle的trunc函数
 * 
 * @author mbr.yangjie 当前时间 2016-06-28 9:30
 */
public class JodaTruncClient {

	private void formatDateTime(DateTime withDayOfWeek) {
		System.out.println(withDayOfWeek.toString("yyyy-MM-dd HH:mm:ss"));
	}

	private void formatDateTime(String message, DateTime withDayOfWeek) {
		System.out.println(message + ": "
				+ withDayOfWeek.toString("yyyy-MM-dd HH:mm:ss"));
	}

	// 返回当年的第一天
	@Test
	public void testA() {
		DateTime dateTime = new DateTime();
		formatDateTime("当年的第一天", dateTime.withDayOfYear(1));
	}// output: 当年的第一天: 2016-01-01 09:29:10

	// 返回当月的第一天
	@Test
	public void testB() {
		DateTime dateTime = new DateTime();
		formatDateTime("当月的第一天", dateTime.withDayOfMonth(1));
	}// output: 当月的第一天: 2016-06-01 09:29:42

	// 返回星期的第一天
	@Test
	public void testC() {
		DateTime dateTime = new DateTime();
		formatDateTime("当前星期的第一天",
				dateTime.withDayOfWeek(DateTimeConstants.MONDAY));
	}// output: 当前星期的第一天: 2016-06-27 09:30:08

	// 离当前时间最近的周六
	@Test
	public void testD() {
		DateTime dateTime = new DateTime();
		DateTime currentWeek = dateTime
				.withDayOfWeek(DateTimeConstants.SATURDAY);// 当前周的周日
		DateTime lastWeek = dateTime.withDayOfWeek(DateTimeConstants.SATURDAY)
				.plusWeeks(-1);
		formatDateTime("当前星期的周六", currentWeek);
		formatDateTime("上一星期的周六", lastWeek);

		int durationCurrentWeek = Days.daysBetween(dateTime, currentWeek)
				.getDays();
		int durationLastWeek = Days.daysBetween(dateTime, lastWeek).getDays();

		System.out.println(durationCurrentWeek);
		System.out.println(durationLastWeek);
	}

	// 截取到上周末
	@Test
	public void testE() {
		DateTime dateTime = new DateTime();
		formatDateTime("上周末", dateTime.withDayOfWeek(DateTimeConstants.SUNDAY)
				.plusWeeks(-1));
	}// output:上周末: 2016-06-26 09:49:26

	// 本周第2天
	@Test
	public void testF() {
		DateTime dateTime = new DateTime();
		formatDateTime("本周第二天",
				dateTime.withDayOfWeek(DateTimeConstants.TUESDAY));
	}// output:本周第二天: 2016-06-28 09:49:11

	// 返回当月的第一个星期天
	@Test
	public void testG() {
		DateTime dateTime = new DateTime();
		formatDateTime("当月的第一个星期天", dateTime.withDayOfMonth(1).withDayOfWeek(7));
	}// output:当月的第一个星期天: 2016-06-05 09:58:41

	// 返回当月的第二个星期天
	@Test
	public void testH() {
		DateTime dateTime = new DateTime();
		formatDateTime("当月的第二个星期天", dateTime.withDayOfMonth(1).withDayOfWeek(7)
				.plusWeeks(1));
	}// output:当月的第二个星期天: 2016-06-12 09:59:53
}
