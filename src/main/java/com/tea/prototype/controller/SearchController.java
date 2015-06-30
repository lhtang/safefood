package com.tea.prototype.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tea.prototype.bean.SearchCriteriaBean;
import com.tea.prototype.service.SearchService;

/**
 * SearchController handles loading of search page and process search submit.
 * 
 * @author TEA Development Team
 * @version 1.0
 * @since   2015-06-30 
 */
@Controller
public class SearchController {

	private final Logger logger = LoggerFactory
			.getLogger(SearchController.class);

	@Autowired
	private SearchService searchService;

	/**
	 * This method loads the search page.
	 * 
	 * @param model
	 * @return search page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadSearchCriteriaForm(Model model) {

		logger.debug("Entering loadSearchCriteriaForm");

		model.addAttribute("searchCriteriaBean", new SearchCriteriaBean());

		return "search";
	}

	/**
	 * This method processes the search submit.
	 * 
	 * @param searchCriteriaBean
	 * @param model
	 * @return search results
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String handleSearchSubmit(
			@ModelAttribute SearchCriteriaBean searchCriteriaBean, Model model) {

		logger.debug("Entering handleSearchSubmit");
		logger.debug("Date From " + searchCriteriaBean.getReportDateFrom());
		logger.debug("Date To " + searchCriteriaBean.getReportDateTo());
		logger.debug("classification " + searchCriteriaBean.getClassification());

		// Convert search criteria to FDA format
		String formattedSearchParms = searchService.toSearchParms(searchCriteriaBean);

		model.addAttribute("searchParms", formattedSearchParms);
		model.addAttribute("searchCriteriaBean", searchCriteriaBean);

		return "results";
	}

}
