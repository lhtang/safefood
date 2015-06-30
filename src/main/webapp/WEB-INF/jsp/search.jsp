<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="UTF-8">
<title>SafeFood - Search</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/lib/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/lib/themes/icon.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/app.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/lib/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/lib/jquery.easyui.min.js"></script>
</head>
<body>

	<div style="margin: 20px 0;"></div>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout"
		style="width: 100%; height: 550px; background: #666;">
		<div data-options="region:'north'"
			style="height: 83px; vertical-align: middle">
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
		</div>
		<div data-options="region:'south',split:true" style="height: 75px;">
			<div style="color: #666; font-size: 14px; text-align: center">
				<p>
					This application has been developed by Technology Engineering
					Associates, LLC (TEA) in response to GSA Agile Development RFQ.</br> For
					more information about TEA, please our company website at <a
						href="http://www.tea-llc.com" target="_blank">http://www.tea-llc.com</a>.
				</p>
			</div>
		</div>
		<div data-options="region:'east',split:true" title="More Info"
			style="width: 200px; padding: 10px;">
			<div style="font-size: 14px; text-align: left">
				<p>For additional information on search fields, please visit the
					openFDA web site at</p>

				<p>
					<a href="https://open.fda.gov/food/enforcement/reference/"
						target="_blank" class="easyui-link">https://open.fda.gov/food/enforcement/reference</a>.
				</p>
			</div>
		</div>
		<div
			data-options="region:'center',title:'Search',iconCls:'icon-search'"
			style="height: 750px;" align="center">

			<div
				style="color: #666; font-size: 18px; font-weight: bold; text-align: center">
				<p>Enter your search criteria and click submit.</p>
			</div>

			<div style="padding: 10px 60px 20px 60px; alignment: center">
				<form:form id="searchForm" action="search"
					modelAttribute="searchCriteriaBean" method="post">

					<table cellpadding="5">
						<tr>
							<td>Report Date From:</td>
							<td><form:input class="easyui-datebox" path="reportDateFrom"
									type="text" id="reportDateFrom" name="reportDateFrom"
									data-options="required:true" /> &nbsp;To&nbsp; <form:input
									class="easyui-datebox" path="reportDateTo" type="text"
									id="reportDateTo" name="reportDateTo"
									data-options="required:true" /></td>
						</tr>
						<tr>
							<td>Recall Classification:</td>
							<td><form:select class="easyui-combobox"
									path="classification" id="classification" name="classification"
									style="width:150px">
									<option value=""></option>
									<option value="Class I">Class I</option>
									<option value="Class II">Class II</option>
									<option value="Class III">Class III</option>
								</form:select></td>
						</tr>
						<tr>
							<td>Recalling Firm:</td>
							<td><form:input class="easyui-inputbox" path="recallingFirm"
									type="text" id="recallingFirm" style="width:150px" /></td>
						</tr>
						<tr>
							<td>Product Description:</td>
							<td><form:input class="easyui-inputbox"
									path="productDescription" type="text" id="productDescription"
									style="width:150px" /></td>
						</tr>
						<tr>
							<td>City:</td>
							<td><form:input class="easyui-inputbox" path="city"
									type="text" id="city" style="width:150px" /></td>
						</tr>
						<tr>
							<td>State:</td>
							<td><form:select class="easyui-combobox" path="state"
									id="state" name="state" style="width:150px">
									<option value=""></option>
									<option value="AK">Alaska</option>
									<option value="AL">Alabama</option>
									<option value="AR">Arkansas</option>
									<option value="AZ">Arizona</option>
									<option value="CA">California</option>
									<option value="CO">Colorado</option>
									<option value="CT">Connecticut</option>
									<option value="DC">Washington DC</option>
									<option value="DE">Delaware</option>
									<option value="FL">Florida</option>
									<option value="GA">Georgia</option>
									<option value="HI">Hawaii</option>
									<option value="IA">Iowa</option>
									<option value="ID">Idaho</option>
									<option value="IL">Illinois</option>
									<option value="IN">Indiana</option>
									<option value="KS">Kansas</option>
									<option value="KY">Kentucky</option>
									<option value="LA">Louisiana</option>
									<option value="MA">Massachusetts</option>
									<option value="MD">Maryland</option>
									<option value="ME">Maine</option>
									<option value="MI">Michigan</option>
									<option value="MN">Minnesota</option>
									<option value="MO">Missouri</option>
									<option value="MS">Mississippi</option>
									<option value="MT">Montana</option>
									<option value="NC">North Carolina</option>
									<option value="ND">North Dakota</option>
									<option value="NE">Nebraska</option>
									<option value="NH">New Hampshire</option>
									<option value="NJ">New Jersey</option>
									<option value="NM">New Mexico</option>
									<option value="NV">Nevada</option>
									<option value="NY">New York</option>
									<option value="OH">Ohio</option>
									<option value="OK">Oklahoma</option>
									<option value="OR">Oregon</option>
									<option value="PA">Pennsylvania</option>
									<option value="RI">Rhode Island</option>
									<option value="SC">South Carolina</option>
									<option value="SD">South Dakota</option>
									<option value="TN">Tennessee</option>
									<option value="TX">Texas</option>
									<option value="UT">Utah</option>
									<option value="VA">Virginia</option>
									<option value="VT">Vermont</option>
									<option value="WA">Washington</option>
									<option value="WI">Wisconsin</option>
									<option value="WV">West Virginia</option>
									<option value="WY">Wyoming</option>
								</form:select></td>
						</tr>
					</table>

					<div style="text-align: center; padding: 5px">
						</br>
						</br> <input type="submit" class="easyui-button" value="Submit" />
				</form:form>
				&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" class="easyui-button"
					value="Clear" onclick="clearForm(); return false;" />
			</div>

		</div>
	</div>

	<script>
		function clearForm(){
			$('#searchForm').form('clear');
		}
	</script>
</body>
</html>