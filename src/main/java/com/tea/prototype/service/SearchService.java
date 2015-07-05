package com.tea.prototype.service;

import java.util.Date;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tea.prototype.bean.SearchCriteriaBean;
import com.tea.prototype.util.DateUtil;

/**
 * SearchService contains business logic to handle search parameters.
 * 
 * @author TEA Development Team
 * @version 1.0
 * @since   2015-06-30 
 */
@Service
public class SearchService {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchService.class);

	/**
	 * Convert words to FDA search format.
	 * 
	 * @param words
	 * @return search parameter
	 */
	public String toSearchFormat(String words) {
		
		if (StringUtils.isEmpty(words)) {
			return null;
		}

		StringTokenizer st = new StringTokenizer(words, " ");
		StringBuffer searchToken = new StringBuffer();
		
		while (st.hasMoreTokens()) {
			String word = st.nextToken().trim();
			searchToken.append(word).append("+");	
		}
		
		searchToken.deleteCharAt(searchToken.length() - 1);
		
		logger.debug("searchFormat " + searchToken.toString());
		
		return searchToken.toString();
	}
	
	/**
	 * Convert all search criteria to FDA search format.
	 * 
	 * @param searchCriteria
	 * @return search parameters
	 */
	public String toSearchParms(SearchCriteriaBean searchCriteria) {
		
		String reportDateFromStr = searchCriteria.getReportDateFromStr();
		String reportDateToStr = searchCriteria.getReportDateToStr();
		String classification = searchCriteria.getClassification();
		String recallingFirm = searchCriteria.getRecallingFirm();
		String city = searchCriteria.getCity();
		String state = searchCriteria.getState();
		String productDescription = searchCriteria.getProductDescription();
		
		/*
		 * FDA search parms format 
		 * search=report_date:[20040101+TO+20131231]
		 */
		StringBuffer searchParms = new StringBuffer();
		searchParms.append("search=");
		
		if (StringUtils.isNotBlank(reportDateFromStr) && StringUtils.isNotBlank(reportDateToStr)) {
			String dateFrom = DateUtil.toSearchDateFormat(reportDateFromStr);
			String dateTo = DateUtil.toSearchDateFormat(reportDateToStr);
			searchParms.append("report_date:[").append(dateFrom).append("+TO+").append(dateTo).append("]");
		}
		
		if (!StringUtils.isEmpty(classification)) {
			String classificationSearchFormat = toSearchFormat(classification);
			searchParms.append("classification:\"").append(classificationSearchFormat).append("\"");
		}

		if (!StringUtils.isEmpty(recallingFirm)) {
			String recallingFirmSearchFormat = toSearchFormat(recallingFirm);
			searchParms.append("recalling_firm:\"").append(recallingFirmSearchFormat).append("\"");
		}

		if (!StringUtils.isEmpty(city)) {
			String citySearchFormat = toSearchFormat(city);
			searchParms.append("city:\"").append(citySearchFormat).append("\"");
		}

		if (!StringUtils.isEmpty(state)) {
			String stateSearchFormat = toSearchFormat(state);
			searchParms.append("state:\"").append(stateSearchFormat).append("\"");
		}

		if (!StringUtils.isEmpty(productDescription)) {
			String productDescriptionSearchFormat = toSearchFormat(productDescription);
			searchParms.append("product_description:\"").append(productDescriptionSearchFormat).append("\"");
		}
		
		logger.debug("searchParms " + searchParms.toString());
		
		return searchParms.toString();
	}

}