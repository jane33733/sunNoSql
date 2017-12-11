var $dataCount = 0;
var productTable;
var character;
var productList = [];
var $dynamicTableBlock;
var $dynamicTableSpace;


$(document).ready(function(){

});

function getAllProduct(){
	$('#product_table').hide();
	$('#no_result').hide();
	
	jQuery.ajax({
	    url: mainUrl + "product/getAll.do",
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

function insert200ThousandSale(){
	
	jQuery.ajax({
		url: mainUrl + "saleRecord/insert200ThousandSale.go",
		data: JSON.stringify(productQueryVO),
		dataType: "json",
		type: "GET",
		contentType: 'application/json; charset=utf-8',
		success: function(resultData){
			alert(success);
		} ,
		error : function(jqXHR, textStatus, errorThrown) {
			alert(fail);
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
		tableHtml = $("<tr id ='" + dbData.pId + "'>");
        tableHtml.append("<td>" + dbData.pId + "</td>");
        tableHtml.append("<td>" + dbData.name + "</td>");
        tableHtml.append("<td>" + dbData.price + "</td>");
        tableHtml.append("<td>" + dbData.createTime + "</td>");
        tableHtml.append("<tr/>");
        
        $("#product_tbody").append(tableHtml);
	});
}



function deleteSale(){
	jQuery.ajax({
		url: mainUrl + "saleRecord/deleteSale.go",
		data: JSON.stringify(productQueryVO),
		dataType: "json",
		type: "GET",
		contentType: 'application/json; charset=utf-8',
		success: function(resultData){
			alert(success);
		} ,
		error : function(jqXHR, textStatus, errorThrown) {
			alert(fail);
		},
		timeout: 120000,
	});
}





