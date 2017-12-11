<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>
<head>

<link href="css/pinkTable.css" rel="stylesheet" type="text/css">
<jsp:include page="pages/basicPage.jsp"></jsp:include>
<script src="js/pages/product.js"></script>
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
			
			<br>
			Version 14:00
			<br>
			
			<button type="button" class="btn btn-primary fr" id="searchProduct" onclick="getAllProduct()">
				顯示所有產品
			</button>
			
			<br>
			<hr/>
			<br>
			
	    	<!-- 交易紀錄 -->
			<form class="form-inline">
				<button type="button" class="btn btn-primary fr" id="deleteBtn" onclick="deleteSale()">
					刪除交易紀錄
				</button>
			
				<button type="button" class="btn btn-primary fr" id="insertBtn" onclick="insert200ThousandSale()">
					新增20萬筆交易紀錄
				</button>
			</form>


		<br>
		<hr/>
		<br>

		
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
						<th>產品編號</th>
						<th>產品名稱</th>
						<th>價格</th>
						<th>時間</th>
						<th></th>
					</tr>
				</thead>
				
				<tbody id="product_tbody">
				<!--顯示資料庫資料-->
				</tbody>
					
				</table>
				<!-- Content end -->
	
	
			</div>
			
			
		</div>
		
	</div>
</div>


	
	
	
</body>
</html>