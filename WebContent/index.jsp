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
			<hr/>
			<br>
			

			<div class="card bg-light mb-3" style="max-width: 20rem;">
			  <div class="card-header">DELETE Product</div>
			  <div class="card-body">
			    <h4 class="card-title">刪除產品</h4>
			    <p class="card-text">
			    	<!-- 刪除的form -->
					<form class="form-inline">
					
						<label for="rg-from">欲刪除的產品ID</label>
						<div class="form-group">
						  <input type="text" id="delPid" name="rg-from" class="form-control">
						</div>
						
						<!--practice restful GET -->
						<button type="button" class="btn btn-primary fr" id="deleteBtn">
							刪除產品
						</button>
					
					</form>

			  </div>
			</div>
			
			
			
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
			
			
    	</div>
	</div>
</div>
	
	
	
</body>
</html>