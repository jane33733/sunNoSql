<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>
<head>


<jsp:include page="pages/basicPage.jsp"></jsp:include>

<script type = "text/javascript">


function btnProduct(){
	window.location.replace(mainUrl + "product.jsp");
}

function btnReport(){
	window.location.replace(mainUrl + "report.html");
}

</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<body>

<div class="form-group row" style="padding: 20px;">
	<button type="button" class="btn btn-default btn-block" onclick="btnProduct()">
		Edit Product
	</button>
	
	<button type="button" class="btn btn-default btn-block" onclick="btnReport()">
		Show Report
	</button>
</div>


	
</body>
</html>