<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sunRent.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html xmlns:spry="http://ns.adobe.com/spry">
<head>

<link href="css/pinkTable.css" rel="stylesheet" type="text/css">
<jsp:include page="pages/basicPage.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first practice</title>
</head>

<body>

<br>
Login Page
<br>

<form class="form-inline" action="LoginServlet" method="post">
			
	<f:bundle basename="messages">
	<label for="rg-from"><f:message key="account"></f:message></label>
	<div class="form-group">
	  <input type="text" id="account" name="account" value="haha" class="form-control">
	</div>
	
	<label for="rg-from"><f:message key="password"></f:message></label>
	<div class="form-group">
	  <input type="password" id="password" name="password" value="123" class="form-control">
	</div>
	</f:bundle>
	
	<!--practice restful post-->
	<button type="submit" value="login" class="btn btn-primary fr" id="login">
		登入
	</button>

</form>

	
	
	
</body>
</html>