<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sunRent.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html xmlns:spry="http://ns.adobe.com/spry">
<head>

<script type="text/javascript">

var projectName = $("#mainUrl").val();

function btnFirst(){
	window.location.replace(projectName+"pages/feature/productInfo.jsp");
}

function btnSecond(){
	window.location.replace(projectName+"pages/feature/productInfo.jsp");
}

</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<body>

<f:bundle basename="messages">
			 
	<button type="button" class="btn btn-default btn-block" onclick="btnFirst()">
		<f:message key="btn_first"></f:message>
	</button> 
	<button type="button" class="btn btn-default btn-block" onclick="btnSecond()">
		按鈕二
	</button> 
	<button type="button" class="btn btn-default btn-block">
		Default
	</button>
	
</f:bundle>
</body>
</html>