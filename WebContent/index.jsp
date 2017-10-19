<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>
<head>

<link href="css/pinkTable.css" rel="stylesheet" type="text/css">
<script src="js/pages/product.js"></script>
<jsp:include page="pages/basicPage.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NoSQL DB practice</title>
</head>

<body>



<div class="container-fluid">
	<div class="row-fluid">
		<div class="span4">
			
			<!--Sidebar content-->
			
			<br>
			Version 14:00
			<br>
			
			<!--practice restful get-->
			<button type="button" class="btn btn-primary fr" id="searchProduct" onclick="getAllProduct()">
				顯示所有產品
			</button>
			
			<br>
			---------
			<br>
			

			
			
		</div>
		
		<br><br>
		
    	<div class="span8">
			<!--Body content-->
			
			
			<!--查無資料-->
			<p id="no_result" style="display: none;">
				no data
			</p>
			
			<table id="product_table" class="pinkTable table-hover table" style="display: none;">
			<!--以下為固定標頭-->
			<thead>
				<tr>
				<f:bundle basename="messages">
					<!--產品編號--> 
					<th><f:message key="productId"></f:message></th>
					<!--產品名稱--> 
					<th><f:message key="productName"></f:message></th>
					<!--價格--> 
					<th><f:message key="productPrice"></f:message></th>
					<!--時間--> 
					<th><f:message key="createTime"></f:message></th>
					<!--查看-->
					<th><f:message key="detail"></f:message></th>
		        </f:bundle>
				</tr>
			</thead>
			
			<tbody id="product_tbody">
			<!--顯示資料庫資料-->
			</tbody>
				
			</table>
			
			
    	</div>
	</div>
</div>
	
	
	
</body>
</html>