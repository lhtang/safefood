var resultsRenderer = {

	baseUrl : 'https://api.fda.gov/food/enforcement.json',
	searchParms : '',
	jsonData : null,
	total : 0,
	pageSize : 10,
	htmlTableRows : '',
	
	init : function(criteria) {
		this.searchParms = criteria; 
		resultsRenderer.fetchData(10,0);
		resultsRenderer.registerPaginationHandler();
	},
	
	registerPaginationHandler : function() {

		// Handle pagination callback function
		$('#paging').pagination({
			onSelectPage:function(pageNumber, pageSize){		

				$(this).pagination('loading');
				
				var skip = (pageNumber - 1) * pageSize;
				var limit = pageSize;
				
				resultsRenderer.fetchData(limit, skip);
				
				$(this).pagination('loaded');
			}
		});
	
	},
	
	fetchData : function (limit, skip) {
		
		var fetchUrl = this.baseUrl;
		var parms = this.searchParms + '&limit=' + limit + '&skip=' + skip;

		// Clear table contents
		resultsRenderer.clear();
		
		jQuery.support.cors = true;
		
		$.ajax({
			type: 'GET',
			url: fetchUrl,
			data: parms,
			dataType: 'json',

			success : function(dataResponse) {
				resultsRenderer.processMeta(dataResponse.meta.results);
				resultsRenderer.processResults(dataResponse.results);
				resultsRenderer.renderPagination(limit);
			},
			error : function(responseData, textStatus, errorThrown) {
				console.log(textStatus, errorThrown);
			}
		});
		
	}, // End of fetchData
	
	clear : function() {
		this.htmlTableRows = '';
		$('#results').empty();
	},
	
	renderPagination : function(pageLimit) {

		// Render pagination options
		$('#paging').pagination({
			total: this.total,
			pageSize: pageLimit
		});
	},

	processMeta : function(metaResults) {	
		this.total = metaResults.total;	
	}, // End of processMeta
	
	processResults : function(results) {
	
		$.each(results, function(index, record) {
			resultsRenderer.render(record);
		});

		// Results table
		finalHtmlTable = resultsRenderer.wrapHtmlTable(this.htmlTableRows); 

		// Display results
		$('#results').html(finalHtmlTable);
		
	}, // End of processResults
	
	render : function(record) {

		resultsRenderer.appendHtmlTableRow('Recall Number', record.report_date);
		resultsRenderer.appendHtmlTableRow('Recall Initiation Date', record.recall_initiation_date);
		resultsRenderer.appendHtmlTableRow('Recall Firm', record.recalling_firm);
		resultsRenderer.appendHtmlTableRow('Recall Number', record.recall_number);
		resultsRenderer.appendHtmlTableRow('Reason for Recall', record.reason_for_recall);
		resultsRenderer.appendHtmlTableRow('Classification', record.classification);
		resultsRenderer.appendHtmlTableRow('Product Type', record.product_type);
		resultsRenderer.appendHtmlTableRow('Product Quantity', record.product_quantity);
		resultsRenderer.appendHtmlTableRow('Product Description', record.product_description);
		resultsRenderer.appendHtmlTableRow('Status', record.status);
		resultsRenderer.appendHtmlTableRow('Distribution Pattern', record.distribution_pattern);
		resultsRenderer.appendHtmlTableRow('Voluntary Mandated', record.voluntary_mandated);
		resultsRenderer.appendHtmlTableRow('Code Information', record.code_info);
		resultsRenderer.appendHtmlTableRow('Initial Firm Notification', record.initial_firm_notification);
		resultsRenderer.appendHtmlTableRow('Event ID', record.event_id);
		resultsRenderer.appendHtmlTableRow('City', record.city);
		resultsRenderer.appendHtmlTableRow('State', record.state);
		resultsRenderer.appendHtmlTableRow('Country', record.country);
		resultsRenderer.appendHtmlTableRowSeparator();
	}, // End of render
	
	appendHtmlTableRow : function(label, value) {
		
		this.htmlTableRows += '<tr>'
		this.htmlTableRows += '<td width="180px" valign="top"><b>'+label+':</b></td>';
		this.htmlTableRows += '<td>'+value+'</td>';
		this.htmlTableRows += '</tr>';
	},

	appendHtmlTableRowSeparator : function() {
		
		this.htmlTableRows += '<tr>'
		this.htmlTableRows += '<td colspan="2"><hr></td>';
		this.htmlTableRows += '</tr>';
	},
	
	wrapHtmlTable : function() {
		return '<table cellpadding="5">' + this.htmlTableRows + '</table>';
	}
};