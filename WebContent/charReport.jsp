<script>

$(document).ready(function(){
	getMonthRpt();
});


function getMonthRpt(){
	$('#canvas').hide();
	
	jQuery.ajax({
	    url: mainUrl + "/saleRecord/monthSaleRecord.do",
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


function searchSuccess(resultData){
	
	if(resultData.length > 0){
		
		var barChartData = {
		        labels: resultData[0].dateList,
		        datasets: 
		        [{
		            label: resultData[0].pName,
		            backgroundColor: window.chartColors.red,
		            yAxisID: "y-axis-0",
		            data: resultData[0].totalList
		        }, 
		        {
		        	label: resultData[1].pName,
		            backgroundColor: window.chartColors.green,
		            yAxisID: "y-axis-1",
		            data: resultData[1].totalList
		        }, 
		        {
		        	label: resultData[2].pName,
		            backgroundColor: window.chartColors.orange,
		            yAxisID: "y-axis-2",
		            data: resultData[2].totalList
		        }, 
		        {
		        	label: resultData[3].pName,
		            backgroundColor: window.chartColors.blue,
		            yAxisID: "y-axis-3",
		            data: resultData[3].totalList
		        }, 
		        {
		        	label: resultData[4].pName,
		            backgroundColor: window.chartColors.purple,
		            yAxisID: "y-axis-4",
		            data: resultData[4].totalList
		        }
		        ]

		    };
		
		
		var ctx = document.getElementById("canvas").getContext("2d");
	    window.myBar = new Chart(ctx, {
	        type: 'bar',
	        data: barChartData,
	        options: {
	            responsive: true,
	            title:{
	                display:true,
	                text:"Year Month Sale Report Chart"
	            },
	            tooltips: {
	                mode: 'index',
	                intersect: true
	            },
	            scales: {
	                yAxes: [
	                {
	                    type: "linear", 
	                    display: true,
	                    position: "left",
	                    id: "y-axis-0",
	                }, 
	                {
	                    type: "linear", 
	                    display: false,
	                    id: "y-axis-1",
	                 }, 
                    {
	                    type: "linear", 
	                    display: false,
	                    id: "y-axis-2",
                    },
                    {
	                    type: "linear", 
	                    display: false,
	                    id: "y-axis-3",
                    },
                    {
	                    type: "linear", 
	                    display: false,
	                    id: "y-axis-4",
                    }
                	],
	            }
	        }
	    });
		
		//顯示table
		$('#canvas').show();
		
	}else{
		searchError();
	}
}


function searchError(){
	var message = "no data";
	alert(message);
}

</script>

    <div style="width: 75%">
        <canvas id="canvas"></canvas>
    </div>

    
    