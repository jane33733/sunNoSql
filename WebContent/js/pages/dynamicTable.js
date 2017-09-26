var $dynamicTableBlock;
var $dynamicTableSpace;


function generateTable(reports){
	  var $table = document.createElement('table');
	  $table.className += "table porduct_table";
	  $dynamicTableSpace.append($table);
	  generateTheadDynamic(reports.dateList, $table);
	  var $tbody = $table.createTBody();
	  reports.reportList.forEach(function (report) {
	    generateTBodyDynamic(report, $tbody)
	  });
	  $dynamicTableBlock.show(); // display table
}

function generateTheadDynamic(dateList, $table){
	  var $thead = $table.createTHead();
	  $thead.className += "table table-bordered";
	  var $tr = $thead.insertRow(0);
	  $tr.insertCell(0);
	  $tr.className += "th_bg_gray";
	  for (var i = 0; i < dateList.length; i++){
	    cell = $tr.insertCell(i + 1);
	    cell.setAttribute("colspan","2");
	    cell.innerHTML = dateList[i].startDate + ' ~ ' + dateList[i].endDate;
	  }
	  var $tr1 = $thead.insertRow(1);
	  $tr1.className += "th_bg_gray";
	  var $statisticalItems = $tr1.insertCell(0);
	  $statisticalItems.innerHTML = $('#statisticalItems').val();
	  for (var i = 0; i < dateList.length; i ++){
	    cell = $tr1.insertCell(i*2 + 1);
	    cell.innerHTML = $('#data').val();
	    cell = $tr1.insertCell(i*2 + 2);
	    cell.innerHTML = $('#growthRate').val();
	  }
}

function generateTBodyDynamic(report, $tbody){
	  var $tr = $tbody.insertRow();
	  var cell;
	  var sourceName;
	  sourceName = '#' + ITEM_SOURCE[report.reportType];
	  cell = $tr.insertCell();
	  cell.innerHTML = $(sourceName).val();
	  for( var i = 0; i < report.reportData.length ; i ++){
	    if (report.reportDisable === true){
	      cell = $tr.insertCell();
	      cell.innerHTML = '-';
	      cell = $tr.insertCell();
	      cell.innerHTML = '-';
	    }else {
	      cell = $tr.insertCell();
	      cell.innerHTML = report.reportData[i].count;
	      cell = $tr.insertCell();
	      cell.innerHTML = report.reportData[i].growRate + '%';
	    }
	  }
}



