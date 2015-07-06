<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta charset="UTF-8">  
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>SafeFood - Search Results</title>  
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/lib/themes/default/easyui.css">  
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/lib/themes/mobile.css">  
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/js/lib/themes/icon.css">  
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/lib/jquery.min.js"></script>  
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/lib/jquery.easyui.min.js"></script> 
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/lib/jquery.easyui.mobile.js"></script> 
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/custom/results.js"></script>
</head>
<body>
    <div class="easyui-navpanel" style="position:relative;padding:20px">
        <header>
            <div class="m-toolbar">
                <div class="m-title">SafeFood - Search Results</div>
                <div class="m-right">
                    <a href="/safefood" class="easyui-linkbutton">Change</a>
                </div>
            </div>
        </header>

        <div data-options="region:'center'" title="Search Results">
			<!--********************* Pagination ***********************************-->
			<div id="paging" style="background: #efefef; border: 1px solid #ccc;"></div>

			<!--********************* Results *************************************-->
			<div id="results"></div>
		</div>
        
    </div>
    <style scoped>
        form label{
            display: block;
            margin: 10px 0 5px 0;
        }
    </style>
    
	<script type="text/javascript">
		// Display pagination and initial set of results
		var searchParms = '${searchParms}';
		resultsRenderer.init(searchParms);	
	</script>

</body>    
</html>