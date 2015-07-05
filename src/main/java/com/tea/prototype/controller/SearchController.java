package com.tea.prototype.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tea.prototype.bean.SearchCriteriaBean;
import com.tea.prototype.constant.WebPage;
import com.tea.prototype.service.DeviceTypeService;
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
	
	@Autowired
	private DeviceTypeService deviceTypeService;
	
	@Autowired 
	private HttpServletRequest request;
	
	/**
	 * Initializes controller to convert empty strings to null on submit
	 * @param binder
	 */
	@InitBinder       
	public void initBinder(WebDataBinder binder) {  
	      binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));  
	  }

	/**
	 * This method loads the search page.
	 * 
	 * @param model
	 * @return search page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadSearchCriteriaForm(Model model) {
		
		String pageName = null;

		logger.debug("Entering loadSearchCriteriaForm");
		model.addAttribute("searchCriteriaBean", new SearchCriteriaBean());
		String deviceName = deviceTypeService.getDeviceName(request);
		
		if (deviceTypeService.isPersonalComputer(deviceName)) {
			pageName = WebPage.SEARCH_PAGE_FOR_PC;
		}
		else if (deviceTypeService.isMobileDevice(deviceName)) {
			pageName = WebPage.SEARCH_PAGE_FOR_MOBILE;
		}
		else if (deviceTypeService.isTablet(deviceName)) {
			pageName = WebPage.SEARCH_PAGE_FOR_TABLET;
		}
		else  {
			pageName = WebPage.SEARCH_PAGE_FOR_OTHER;
		}
		
		return pageName;
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
		
		String pageName = null;

		logger.debug("Entering handleSearchSubmit");
		logger.debug(request.getParameterMap().toString());

		// Convert search criteria to FDA format
		String formattedSearchParms = searchService.toSearchParms(searchCriteriaBean);

		// UI client uses searchParms to invoke RESTful service
		model.addAttribute("searchParms", formattedSearchParms);
		
		model.addAttribute("searchCriteriaBean", searchCriteriaBean);
		String deviceName = deviceTypeService.getDeviceName(request);
		
		if (deviceTypeService.isPersonalComputer(deviceName)) {
			pageName = WebPage.RESULTS_PAGE_FOR_PC;
		}
		else if (deviceTypeService.isMobileDevice(deviceName)) {
			pageName = WebPage.RESULTS_PAGE_FOR_MOBILE;
		}
		else if (deviceTypeService.isTablet(deviceName)) {
			pageName = WebPage.RESULTS_PAGE_FOR_TABLET;
		}
		else  {
			pageName = WebPage.RESULTS_PAGE_FOR_OTHER;
		}

		return pageName;
	}

}
