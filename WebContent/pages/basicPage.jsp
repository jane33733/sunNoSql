<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ page import="com.sun.util.ValidateUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" media="screen">

<script src="<c:url value='/js/jquery-1.11.2.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/js/queryString.js'/>"></script>
<script src="<c:url value='/js/postJson.js'/>"></script>   

<script>

if($("#validate").val()){
	document.location.replace("\pages\error\loginWrong.jsp");
}

</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basic</title>
</head>


<body>

<input type="hidden" id="mainUrl" value="<c:url value='/'/>"/>

	<!-- 初始化語言(不曉得要怎麼替換) -->
	<f:setLocale value="zh_TW"/>
	<input type="hidden" value="false" id="validate"/>

</body>
</html>