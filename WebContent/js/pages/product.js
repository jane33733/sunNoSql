var $dataCount = 0;
var productTable;
var character;
var productList = [];
var $dynamicTableBlock;
var $dynamicTableSpace;

var mainUrl ='/noSql';

$(document).ready(function(){

});

function getAllProduct(){
	$('#product_table').hide();
	$('#no_result').hide();
	
	jQuery.ajax({
	    url: mainUrl + "/product/getAll.do",
	    dataType: "json",
	    type: "GET",
	    contentType: 'application/json; charset=utf-8',
	    success: function(resultData){
	    	searchSuccess(resultData);
	    } ,
	    error : function(jqXHR, textStatus, errorThrown) {
	    	searchError();
	    },
	    timeout: 120000,
	});
}

function getProductByPrice(){
	$('#product_table').hide();
	$('#no_result').hide();
	
	var productQueryVO = {
			productId: 1,
			priceBottom: $("#priceBottom").val(),
			priceTop: $("#priceTop").val()
	    };
	
	jQuery.ajax({
		url: mainUrl + "product/getByPrice.go",
		data: JSON.stringify(productQueryVO),
		dataType: "json",
		type: "POST",
		contentType: 'application/json; charset=utf-8',
		success: function(resultData){
			searchSuccess(resultData);
		} ,
		error : function(jqXHR, textStatus, errorThrown) {
			searchError();
		},
		timeout: 120000,
	});
}



function searchSuccess(resultData){
	
	if(resultData.length > 0){
		
		$("#product_tbody").html("");
		this.dbDataTable(resultData)
		
		//顯示table
		$('#product_table').show();
		$('#no_result').hide();
		
	}else{
		searchError()
	}
}


function searchError(){
	$('#no_result').show();
	$('.book_search').hide();
}

function dbDataTable(resultData){
	var tableHtml;
	var resultList = document.getElementById('product_table');
	resultData.forEach(function(dbData, index){
        tableHtml = $('<tr/>');
		tableHtml.append("<tr id ='" + dbData.pId + "'>");
        tableHtml.append("<td>" + dbData.pId + "</td>");
        tableHtml.append("<td>" + dbData.name + "</td>");
        tableHtml.append("<td>" + dbData.price + "</td>");
        tableHtml.append("<td>" + dbData.createTime + "</td>");
//        tableHtml.append("<td> </td>");
        tableHtml.append("<tr/>");
        
        $("#product_tbody").append(tableHtml);
	});
}



function deleteProduct(){
	$('#product_table').hide();
	$('#no_result').hide();
	
	// easy simple way
	var apiUrl = mainUrl + 'product/deleteProduct.do?';
	var pId = $("#delPid");
//	var selectedVal = $multiSelect.val().join();
//	var calculation = $('input[name="radio_mark"]:checked').val();
//	var dateType = $timeInterval.val();
	
	apiUrl += 'pId=' + pId;
//	+ $dateStart.val() + '&endDate=' + $dateEnd.val() + '&reportType=' + selectedVal;
//	location.href = url;
	
	jQuery.ajax({
		url: apiUrl,
//		data: JSON.stringify(productQueryVO),
//		dataType: "json",
		type: "GET",
		contentType: 'application/json; charset=utf-8',
		success: function(resultData){
			deleteSuccess(resultData);
		} ,
		error : function(jqXHR, textStatus, errorThrown) {
			searchError();
		},
		timeout: 120000,
	});
	
}


function deleteSuccess(resultData){
	
	if(resultData.length > 0){
		
		//隱藏刪除的一列
		$("#product_table ."+ resultData ).hide();
		
	}else{
		searchError()
	}
}



