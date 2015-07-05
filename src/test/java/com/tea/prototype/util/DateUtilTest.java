package com.tea.prototype.util;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DateUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToSearchDateFormat() {
		Calendar cal = Calendar.getInstance();
		cal.set(1990, 0, 1);
		
		String dateStr = DateUtil.toSearchDateFormat(cal.getTime());
		
		assertEquals(dateStr, "19900101");
	}

	@Test
	public void testToSearchDateFormatString() {
		
		String dateFormat = DateUtil.toSearchDateFormat("01/01/1990");
		
		assertEquals(dateFormat, "19900101");
	}

	@Test
	public void testStringToDateObject() {
		Date date = DateUtil.stringToDateObject("01/01/1990");
		
		assertNotNull(date);
	}
}
