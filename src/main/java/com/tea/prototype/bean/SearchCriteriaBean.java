package com.tea.prototype.bean;

import java.util.Date;

/**
* The search criteria bean contains get and set methods
* to hold user search options.
*
* @author  TEA Development Team
* @version 1.0
* @since   2015-06-30 
*/
public class SearchCriteriaBean {

	private Date reportDateFrom;
	private String reportDateFromStr;
	private Date reportDateTo;
	private String reportDateToStr;
	private String classification;
	private String recallingFirm;
	private String city;
	private String state;
	private String productDescription;

	/**
	 * Get the report start date.
	 * 
	 * @return date
	 */
	public Date getReportDateFrom() {
		return reportDateFrom;
	}

	/**
	 * Set the report start date
	 * 
	 * @param reportDateFrom
	 */
	public void setReportDateFrom(Date reportDateFrom) {
		this.reportDateFrom = reportDateFrom;
	}

	/**
	 * Get the report end date.
	 * 
	 * @return date
	 */
	public Date getReportDateTo() {
		return reportDateTo;
	}

	/**
	 * Set the report end date.
	 * 
	 * @param reportDateTo
	 */
	public void setReportDateTo(Date reportDateTo) {
		this.reportDateTo = reportDateTo;
	}

	/**
	 * Get the recall classification.
	 * 
	 * @return classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * Set the recall classification.
	 * 
	 * @param classification
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
	 * Get the recalling firm.
	 * 
	 * @return recallingFirm
	 */
	public String getRecallingFirm() {
		return recallingFirm;
	}

	/**
	 * Set the recalling firm.
	 * 
	 * @param recallingFirm
	 */
	public void setRecallingFirm(String recallingFirm) {
		this.recallingFirm = recallingFirm;
	}
 
	/**
	 * Get the city.
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city.
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the state.
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the state.
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Get the product description.
	 * 
	 * @return productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Set the product description.
	 * 
	 * @param productDescription
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * Get the report start date in string format
	 * 
	 * @return reportDateFromStr
	 */
	public String getReportDateFromStr() {
		return reportDateFromStr;
	}

	/**
	 * Set the report start date in string format 
	 * 
	 * @param reportDateFromStr
	 */
	public void setReportDateFromStr(String reportDateFromStr) {
		this.reportDateFromStr = reportDateFromStr;
	}

	/**
	 * Get the report end date in string format
	 * 
	 * @return reportDateToStr
	 */
	public String getReportDateToStr() {
		return reportDateToStr;
	}

	/**
	 * Set the report end date in string format
	 * 
	 * @param reportDateToStr
	 */
	public void setReportDateToStr(String reportDateToStr) {
		this.reportDateToStr = reportDateToStr;
	}
}
