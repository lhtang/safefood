<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>SafeFood - Search Results</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/lib/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/lib/themes/icon.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/lib/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/lib/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/custom/results.js"></script>
</head>

<body>
	<table width="100%">
		<tr>
			<td width="100"><img
				src="<%=request.getContextPath()%>/resources/images/tree.jpg"
				alt="Tree" height="75" width="75" /></td>
			<td>
				<div style="color: #666; font-size: 22px; font-weight: bold;">SafeFood - Food
					Recall Enforcement Reports</div>
			</td>
		</tr>
	</table>

	<div style="margin: 20px 0;"></div>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 560px;">

		<div id="p" data-options="region:'west'" title="Search Criteria"
			style="width: 20%; padding: 10px">
			<p>
				<a href="/safefood" class="easyui-linkbutton"">Change</a>
			</p>
			<p style="color: #666; font-size: 14px;">
				<b>Your Search Options are:</b>
			</p>

			<c:if test="${not empty searchCriteriaBean.reportDateFromStr}">
				<p>
					<b>Report Date From:</b>
				</p>
				<p>${searchCriteriaBean.reportDateFromStr}</p>
			</c:if>

			<c:if test="${not empty searchCriteriaBean.reportDateToStr}">
				<p>
					<b>Report Date To:</b>
				</p>
				<p>${searchCriteriaBean.reportDateToStr}</p>
			</c:if>

			<c:if test="${not empty searchCriteriaBean.classification}">
				<p>
					<b>Classification:</b>
				</p>
				<p>${searchCriteriaBean.classification}</p>
			</c:if>

			<c:if test="${not empty searchCriteriaBean.recallingFirm}">
				<p>
					<b>Recalling Firm:</b>
				</p>
				<p>${searchCriteriaBean.recallingFirm}</p>
			</c:if>

			<c:if test="${not empty searchCriteriaBean.productDescription}">
				<p>
					<b>Product Description:</b>
				</p>
				<p>${searchCriteriaBean.productDescription}</p>
			</c:if>

			<c:if test="${not empty searchCriteriaBean.city}">
				<p>
					<b>City:</b>
				</p>
				<p>${searchCriteriaBean.city}</p>
			</c:if>

			<c:if test="${not empty searchCriteriaBean.state}">
				<p>
					<b>State:</b>
				</p>
				<p>${searchCriteriaBean.state}</p>
			</c:if>
		</div>

		<div data-options="region:'center'" title="Search Results">
			<!--********************* Pagination ***********************************-->
			<div id="paging" style="background: #efefef; border: 1px solid #ccc;"></div>

			<!--********************* Results *************************************-->
			<div id="results"></div>
		</div>
	</div>

	<script type="text/javascript">
		// Display pagination and initial set of results
		var searchParms = '${searchParms}';
		resultsRenderer.init(searchParms);
	</script>
</body>
</html>