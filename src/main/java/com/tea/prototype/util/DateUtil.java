package com.tea.prototype.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	
	private static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	private static final String DATE_FORMAT_MMDDYYYY = "MM/dd/yyyy";

	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * Format date to FDA date format.
	 * 
	 * @param date
	 * @return searchDateFormat
	 */
	public static String toSearchDateFormat(Date date) {
		
		String searchDateFormat = null;
		
		if (date != null) {
			// Convert to YYYYMMDD format
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
		    searchDateFormat = sdf.format(date);
			
		    LOGGER.debug("searchDateFormat " + searchDateFormat);
		}
	    
		return searchDateFormat;
	}

	/**
	 * Format date string MM/dd/yyyy to FDA date string format yyyyMMdd.
	 * 
	 * @param date
	 * @return searchDateFormat
	 */
	public static String toSearchDateFormat(String dateMMDDYYYY) {
		
		String searchDateFormat = null;
		
		if (StringUtils.isNotBlank(dateMMDDYYYY)) {
			// Convert to YYYYMMDD format
			Date date = DateUtil.stringToDateObject(dateMMDDYYYY);
			searchDateFormat = DateUtil.toSearchDateFormat(date);
		}
	    
		return searchDateFormat;
	}

	public static Date stringToDateObject(String dateMMDDYYYY) {
		
		Date date = null;
		
		if (StringUtils.isNotBlank(dateMMDDYYYY)) {
			
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_MMDDYYYY);
			
			try {
				date = sdf.parse(dateMMDDYYYY);
			} 
			catch (ParseException e) {
				LOGGER.error("Error occurred while parsing date format", e);
			}
		}
		
		return date;
	}
}
