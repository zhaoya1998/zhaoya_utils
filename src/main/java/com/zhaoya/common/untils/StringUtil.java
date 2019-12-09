package com.zhaoya.common.untils;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	// ����1���ж�Դ�ַ����Ƿ���ֵ��������(�հ��ַ���)Ҳ��ûֵ (5��)
	public static boolean hasLength(String src) {
		return src != null && src.length() > 0;
	}

	// ����2���ж�Դ�ַ����Ƿ���ֵ��������(�հ��ַ���)�Ϳո�Ҳ��ûֵ (5��)
	public static boolean hasText(String src) {
		return src != null && src.trim().length() > 0;
	}

	/// �������һ�����ĺ���
	public static String randomChineseString() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(40)));// ���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(95));// λ�룬0xA0��ͷ����Χ��1~94��
		byte[] bArr = new byte[2];

		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312"); // ��λ����ϳɺ���
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	// ����3�����ز���length�����ĺ����ַ������ַ���������GB2312(�൱�����ļ���)��Χ�ڣ����硰��ѽ����(5��)
	public static String randomChineseString(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += randomChineseString();
		}
		return str;
	}

	// ����4������������������������ʵ�տ�ͷ���ټ����ڡ��������ټ��ա����ʹ��1-2���������(8��)���ڲ�����randomChineseString()����(3��)������ʾ��������ѽ��������ŷ����Ϊ��
	public static String generateChineseName() {
		String[] str = { "��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��", "��", "л", "��", "��", "��", "ˮ", "�", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "³", "Τ", "��", "��", "��", "��", "��", "��", "��", "��", "Ԭ", "��", "ۺ",
				"��", "ʷ", "��", "��", "��", "�", "Ѧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"ʱ", "��", "Ƥ", "��", "��", "��", "��", "��", "Ԫ", "��", "��", "��", "ƽ", "��", "��", "��", "��", "��", "Ҧ", "��", "տ",
				"��", "��", "ë", "��", "��", "��", "��", "��", "�", "��", "��", "��", "��", "̸", "��", "é", "��", "��", "��", "��", "��",
				"��", "ף", "��", "��", "��", "��", "��", "��", "ϯ", "��", "��", "ǿ", "��", "·", "¦", "Σ", "��", "ͯ", "��", "��", "÷",
				"ʢ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "֧", "��", "��", "��",
				"¬", "Ī", "��", "��", "��", "��", "��", "��", "Ӧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"ʯ", "��", "��", "ť", "��", "��", "��", "��", "��", "��", "½", "��", "��", "��", "��", "�", "��", "��", "�L", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɽ", "��", "��",
				"��", "�", "��", "ȫ", "ۭ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "б", "��", "��", "��", "��",
				"��", "��", "��", "ղ", "��", "��", "Ҷ", "��", "˾", "��", "۬", "��", "��", "��", "ӡ", "��", "��", "��", "��", "ۢ", "��",
				"��", "��", "��", "��", "��", "׿", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "˫", "��", "ݷ", "��", "��",
				"̷", "��", "��", "��", "��", "��", "��", "��", "Ƚ", "��", "۪", "Ӻ", "�S", "�", "ɣ", "��", "�", "ţ", "��", "ͨ", "��",
				"��", "��", "��", "ۣ", "��", "��", "ũ", "��", "��", "ׯ", "��", "��", "��", "��", "��", "Ľ", "��", "��", "ϰ", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "»", "��", "��", "ŷ", "�", "��", "��", "ε", "Խ", "��", "¡", "ʦ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɳ", "ؿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "Ȩ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "۳", "Ϳ", "��", "��", "˧",
				"��", "��", "��", "��", "��", "��", "��", "Ĳ", "��", "٦", "��", "��", "ī", "��", "��", "��", "��", "��", "��", "١",
				"��ٹ", "˾��", "�Ϲ�", "ŷ��", "�ĺ�", "���", "����", "����", "����", "�ʸ�", "ξ��", "����", "�̨", "��ұ", "����", "���", "����",
				"����", "̫��", "����", "����", "����", "��ԯ", "���", "����", "����", "����", "Ľ��", "����", "����", "˾ͽ", "˾��", "آ��", "˾��",
				"��", "��", "�ӳ�", "���", "��ľ", "����", "����", "���", "����", "����", "����", "�ذ�", "�й�", "�׸�", "����", "�θ�", "����",
				"����", "����", "����", "��", "��", "����", "΢��", "����", "����", "����", "����", "�Ϲ�" };

		String firstName = str[RandomUtil.random(0, str.length - 1)];
		String lastName = randomChineseString(RandomUtil.random(1, 2));

		return firstName + lastName;
	}

	// У���Ƿ����ֻ���
	public static boolean isPhoneNumber(String str) {
		// �����Ϊ��������ֻ����ж�
		if (hasText(str)) {
			// �ֻ��ŵĹ���
			String regex = "1[3|4|5|6|7|8|9]\\d{9}";
			// ���ݹ���ƥ��
			return str.matches(regex);
		}
		return false;
	}

	// У���Ƿ����ֻ���
	public static boolean judgeTelephoneIsOk(String str) {
		// �����Ϊ��������ֻ����ж�
		if (hasText(str)) {
			// �ֻ��ŵĹ���
			String regex = "1[3|4|5|6|7|8|9]\\d{9}";
			// ���ݹ���ƥ��
			return str.matches(regex);
		}
		return false;
	}

	// �Ƿ�������
	public static boolean isEmail(String str) {

		String regex = "[A-z0-9_]+\\@[A-z0-9]+\\.[A-z]+";

		if (hasText(str)) {
			return str.matches(regex);
		}
		return false;

	}

	// �ж��Ƿ�����ֵ
	public static boolean isNumber(String str) {
		String regex = "^(-)?[0-9]+(.[0-9]+)?$";
		return str.matches(regex);
	}

	// �ɳ������ڻ������

	public static int getAge(Date birthDay) throws Exception {

		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth)
					age--;
			} else {
				age--;
			}
		}
		return age;
	}

	/*
	 * �������ܣ������������ַ�����ȡһ��ֵ�����ں�����url��ַ����ȡIDֵ��
	 * �����ڡ�http://news.cnstock.com/news,yw-201908-4413224.htm���ѡ�4413224����ȡ������
	 */
	public static String getLastNumber(String url) {

		// String regex ="(\\d+)";
		String regex = "[0-9]+(?=[^0-9]*$)";
		// �������
		Pattern c = Pattern.compile(regex);
		// ƥ��
		Matcher m = c.matcher(url);
		if (m.find()) {
			return m.group();
		}
		return null;

	}
}
