var $dataCount = 0;
var productTable;
var character;
var productList = [];


function checkLogin(){
	
	
	var loginInfo = {
			account: $("#account").val(),
			password: $("#password").val()
	    };
	
	
	jQuery.ajax({
		url: "login/validate.do",
		data: JSON.stringify(loginInfo),
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
	$("#userName").hide();
	
	if(resultData.length > 0){
		
		$("#userName").html(resultData.userName);
		
		//名字
		$("#userName").show();
		
	}else{
		searchError()
	}
}


function searchError(){
	//$('#no_result').show();
	$("#welcome").hide();
}









