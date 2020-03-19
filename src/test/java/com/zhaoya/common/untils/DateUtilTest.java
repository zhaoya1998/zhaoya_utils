package com.zhaoya.common.untils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testSubDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = DateUtil.subDate(new Date());
		String format = df.format(date);
		System.out.println(format);
		
	}
	
	@Test
	public void testGetMonthEnd() {
		Calendar c = Calendar.getInstance();
		c.set(2008, 1, 23);

		Date init = DateUtil.getMonthEnd(c.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(init));
	}

	@Test
	public void testGetMonthInit() {
		Calendar c = Calendar.getInstance();
		c.set(2018, 8, 28);

		Date init = DateUtil.getMonthInit(c.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(init));
	}

	@Test
	public void testGetAge() {
		Calendar c = Calendar.getInstance();
		c.set(1998, 10, 02);

		int i = DateUtil.getAge(c.getTime());
		System.out.println(i);
	}


}
