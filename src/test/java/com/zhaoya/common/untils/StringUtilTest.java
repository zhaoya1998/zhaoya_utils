package com.zhaoya.common.untils;

import java.util.Calendar;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testIsNumber() {
		boolean b = StringUtil.isNumber("12345.12");
		System.out.println(b);
	}

	@Test
	public void testEmail() {
		boolean b = StringUtil.isEmail("_34444444@qq.net");
		System.out.println(b);
	}

	@Test
	public void testPhone() {
		boolean b = StringUtil.isPhoneNumber(null);
		System.out.println(b);
	}

	@Test
	public void testHasLength() {
		boolean b = StringUtil.hasLength(null);
		System.out.println(b);
		boolean b2 = StringUtil.hasLength("");
		System.out.println(b2);
		boolean b3 = StringUtil.hasLength(" ");
		System.out.println(b3);
	}

	@Test
	public void testHasText() {

		boolean b = StringUtil.hasText(null);
		System.out.println(b);
		boolean b2 = StringUtil.hasText("");
		System.out.println(b2);
		boolean b3 = StringUtil.hasText(" ");
		System.out.println(b3);
	}

	@Test
	public void testRandomChineseString() {
		for (int i = 0; i < 10; i++) {
			String string = StringUtil.randomChineseString();
			System.out.print(string + "  ");
		}

	}

	@Test
	public void testGenerateChineseName() {
		String string = StringUtil.generateChineseName();
		System.out.println(string);
	}
	
	@Test
	public   void  testGetLastNumber() {
		String url="http://news.cnstock.com/news,yw-201908-4413224.htm";
		String string = StringUtil.getLastNumber(url);
		System.out.println(string);
	}
	
	@Test
	public void testHashTest() {
		// String src="abc";
		String src = "";
		boolean b = StringUtil.hasText(src);
		if (b) {
			System.out.println("有值得");
		} else {
			System.out.println("无值得");
		}
	}

	@Test
	public void testGetAge() {
		// 成功
		Calendar c = Calendar.getInstance();
		c.set(1997, 7, 2);
		int age = DateUtil.getAge(c.getTime());
		System.out.println(age);

	}
}
