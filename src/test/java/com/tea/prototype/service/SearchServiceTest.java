package com.tea.prototype.service;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tea.prototype.bean.SearchCriteriaBean;

public class SearchServiceTest {
	
	private SearchService searchService;

	@Before
	public void setUp() throws Exception {
		searchService = new SearchService();
	}

	@Test
	public void testToSearchFormat() {
		
		String formattedParm = searchService.toSearchFormat("This is a test");
		assertEquals(formattedParm, "This+is+a+test");
		
		formattedParm = searchService.toSearchFormat("This is a     test");
		assertEquals(formattedParm, "This+is+a+test");
	}

	@Test
	public void testToSearchParms() {
		
		SearchCriteriaBean criteria = new SearchCriteriaBean();
		criteria.setCity("Rockville");
		criteria.setState("MD");
		criteria.setProductDescription("ice cream");
		
		String formattedParms = searchService.toSearchParms(criteria);
		
		Assert.assertThat(formattedParms, CoreMatchers.containsString("ice+cream"));
		Assert.assertThat(formattedParms, CoreMatchers.containsString("Rockville"));
		Assert.assertThat(formattedParms, CoreMatchers.containsString("MD"));
	}

}
