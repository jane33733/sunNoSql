<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>
<head>

<jsp:include page="pages/basicPage.jsp"></jsp:include>

<!-- char.js plugin -->
<script src="js/charJs/Chart.bundle.js"></script>
<script src="js/charJs/utils.js"></script>
<style>
canvas {
    -moz-user-select: none;
    -webkit-user-select: none;
    -ms-user-select: none;
}
</style>
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NoSQL DB practice</title>
</head>

<body>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			 
			<jsp:include page="left.jsp"></jsp:include> 
			
		</div>
		<div class="col-md-10">
			
			<!--Sidebar content-->
			
			<jsp:include page="charReport.jsp"></jsp:include> 
			
			<!-- Content end -->
	
		</div>
		
	</div>
</div>


	
	
	
</body>
</html>