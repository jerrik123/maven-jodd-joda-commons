package com.mangocity.joda;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

public class JodaClient {

	@Test
	public void testA() {
		DateTime dateTime = new DateTime(2016, 6, 28, 8, 54);
		System.out.println(dateTime.toString("yyyy-MM-dd"));
	}

	@Test
	public void testB() {
		DateTime dateTime = new DateTime(2016, 6, 28, 8, 54);
		System.out.println(dateTime.plusMonths(3).plusMinutes(20)
				.toString("yyyy-MM-dd HH:mm:ss"));
	}
	
	//当前日期加3个月 当前周最后一天的日期(周日)
	@Test
	public void testC() {
		DateTime dateTime = new DateTime(2016, 6, 8, 8, 54);
		System.out.println(dateTime.plusMonths(3).dayOfWeek().withMaximumValue()
				.toString("yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void testD(){
		DateTime dateTime = new DateTime();
		int month = dateTime.getMonthOfYear(); //获取月份，5就是5月
		System.out.println(month);
		month = dateTime.monthOfYear().get(); //获取月份的另一种方式
		System.out.println(month);
		String monthDescription = dateTime.monthOfYear().getAsText(); //获取月份描述信息
		System.out.println(monthDescription);
	}
	
	@Test
	public void testE(){
		DateTime start = new DateTime(2015, 1, 1, 0, 0, 0);
		DateTime end = new DateTime(2015, 5, 19, 0, 0, 0);
		Interval interval = new Interval(start, end);
	}
	
	@Test
	public void testF(){
		DateTime dateTime = new DateTime();
		System.out.println(dateTime.toString("yyyy-MM-dd"));
	}
}
