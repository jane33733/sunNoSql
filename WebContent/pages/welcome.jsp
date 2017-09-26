<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sunRent.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html xmlns:spry="http://ns.adobe.com/spry">
<head>


<jsp:include page="basicPage.jsp"></jsp:include>
<script src="<c:url value="/js/pages/index.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first practice</title>
</head>


<body>

<jsp:include page="top.jsp"></jsp:include>
			
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			 
			<jsp:include page="left.jsp"></jsp:include>

		</div>
		<div class="col-md-10">
			<h3>
				h3. Lorem ipsum dolor sit amet.
			</h3>
			<div class="carousel slide" id="carousel-988926">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-988926">
					</li>
					<li data-slide-to="1" data-target="#carousel-988926">
					</li>
					<li data-slide-to="2" data-target="#carousel-988926">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="Carousel Bootstrap First" src="http://lorempixel.com/output/sports-q-c-1600-500-1.jpg" />
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="Carousel Bootstrap Second" src="http://lorempixel.com/output/sports-q-c-1600-500-2.jpg" />
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="Carousel Bootstrap Third" src="http://lorempixel.com/output/sports-q-c-1600-500-3.jpg" />
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-988926" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-988926" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
			<div class="tabbable" id="tabs-476863">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#panel-577214" data-toggle="tab">Section 1</a>
					</li>
					<li>
						<a href="#panel-279431" data-toggle="tab">Section 2</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-577214">
						<p>
							<ul>
								<li>
									Lorem ipsum dolor sit amet
								</li>
								<li>
									Consectetur adipiscing elit
								</li>
								<li>
									Integer molestie lorem at massa
								</li>
								<li>
									Facilisis in pretium nisl aliquet
								</li>
								<li>
									Nulla volutpat aliquam velit
								</li>
								<li>
									Faucibus porta lacus fringilla vel
								</li>
								<li>
									Aenean sit amet erat nunc
								</li>
								<li>
									Eget porttitor lorem
								</li>
							</ul>
						</p>
					</div>
					<div class="tab-pane" id="panel-279431">
						<p>
							Howdy, I'm in Section 2.
						</p>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</div>
		
    	
	
</body>
</html>