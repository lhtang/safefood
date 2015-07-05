<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>SafeFood - Search</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/lib/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/lib/themes/mobile.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/lib/themes/icon.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/lib/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/lib/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/lib/jquery.easyui.mobile.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/custom/validation.js"></script>
</head>
<body>
	<div class="easyui-navpanel" style="position: relative; padding: 20px">

		<header>
			<div class="m-toolbar">
				<div class="m-title">SafeFood - Search</div>
				<div class="m-right">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="$('#searchForm').submit();" style="width: 60px">Search</a>
				</div>
			</div>
		</header>
		<form:form id="searchForm" action="search"
			modelAttribute="searchCriteriaBean" method="post">
			<div>
				<label>Report Date From</label>
				<form:input class="easyui-datebox" type="text" id="reportDateFrom"
					path="reportDateFromStr" prompt="Report Date From"
					data-options="panelWidth:220,panelHeight:240,iconWidth:30"
					style="width:100%" validType="validDate"/>
			</div>
			<div>
				<label>Report Date To</label>
				<form:input class="easyui-datebox" id="reportDateTo"
					path="reportDateToStr" prompt="Report Date To" type="text"
					data-options="panelWidth:220,panelHeight:240,iconWidth:30"
					style="width:100%" validType="validDate"/>
			</div>
			<div>
				<label>Recall Classification</label>
				<form:select class="easyui-combobox" id="classification"
					path="classification" prompt="Recall Classification"
					style="width:100%">
					<option value=""></option>
					<option value="Class I">Class I</option>
					<option value="Class II">Class II</option>
					<option value="Class III">Class III</option>
				</form:select>
			</div>
			<div>
				<label>Recalling Firm</label>
				<form:input class="easyui-textbox" id="recallingFirm"
					path="recallingFirm" type="text" prompt="Recalling Firm"
					style="width:100%" />
			</div>
			<div>
				<label>Product Description</label>
				<form:input class="easyui-textbox" id="productDescription"
					path="productDescription" type="text" prompt="Product Description"
					style="width:100%" />
			</div>
			<div>
				<label>City</label>
				<form:input class="easyui-textbox" id="city" path="city" type="text"
					prompt="City" style="width:100%" />
			</div>
			<div>
				<label>State</label>
				<form:select class="easyui-combobox" id="state" path="state"
					prompt="State" style="width: 100%">
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
				</form:select>

			</div>
		</form:form>
	</div>

	<style scoped>
form label {
	display: block;
	margin: 10px 0 5px 0;
}
</style>
</body>
</html>