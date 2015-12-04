<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<style type="text/css">
.jiudiancengshu {
	position: relative;
	top: 10px;
	left: 5px;
	width: 25px;
	height: 25px;
	border: 1px solid #AAAAAA;
	background-color: #2577e3;
	color: white;
	text-align: center;
	font-size: 20px;
}
</style>
<link rel='stylesheet' id='camera-css' href='<%=request.getContextPath() %>/css/camera.css'
	type='text/css' media='all'>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

a {
	color: #09f;
}

a:hover {
	text-decoration: none;
}

#back_to_camera {
	background: rgba(255, 255, 255, .9);
	clear: both;
	display: block;
	height: 40px;
	line-height: 40px;
	padding: 20px;
	position: relative;
	z-index: 1;
}

.fluid_container {
	bottom: 0;
	height: 100%;
	left: 0;
	position: fixed;
	right: 0;
	top: 0;
	z-index: 0;
}

#camera_wrap_4 {
	bottom: 0;
	height: 100%;
	left: 0;
	margin-bottom: 0 !important;
	position: fixed;
	right: 0;
	top: 0;
}

.camera_bar {
	z-index: 2;
}

.camera_thumbs {
	margin-top: -100px;
	position: relative;
	z-index: 1;
}

.camera_thumbs_cont {
	border-radius: 0;
	-moz-border-radius: 0;
	-webkit-border-radius: 0;
}

.camera_overlayer {
	opacity: .1;
}
</style>

<script type='text/javascript' src='<%=request.getContextPath() %>/js/jquery.min.js'></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/js/jquery.mobile.customized.min.js'></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/js/jquery.easing.1.3.js'></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/js/camera.min.js'></script>

<script>
	jQuery(function() {
		jQuery('#camera_wrap_4').camera({
			height : 'auto',
			loader : 'bar',
			pagination : false,
			thumbnails : true,
			hover : false,
			opacityOnGrid : false,
			imagesPath : '<%=request.getContextPath() %>/img'
		});
	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div style="width: 522px; height: 322px; position: absolute; top: 190px; -moz-transform: scale(0.8917, 0.7917);
	 -webkit-transform: scale(0.8917, 0.7917); -o-transform: scale(0.8917, 0.7917);">
		<div class="fluid_container" style="">
			<div class="camera_wrap camera_emboss pattern_1" id="camera_wrap_4">
				<div data-thumb="<%=request.getContextPath() %>/img/slides/thumbs/bridge.jpg"
					data-src="<%=request.getContextPath() %>/img/slides/bridge.jpg">
					<!-- 前者小图，后者大图 -->
				</div>
				<div data-thumb="<%=request.getContextPath() %>/img/slides/thumbs/leaf.jpg"
					data-src="<%=request.getContextPath() %>/img/slides/leaf.jpg"></div>
				<div data-thumb="<%=request.getContextPath() %>/img/slides/thumbs/road.jpg"
					data-src="<%=request.getContextPath() %>/img/slides/road.jpg"></div>
				<div data-thumb="<%=request.getContextPath() %>/img/slides/thumbs/sea.jpg"
					data-src="<%=request.getContextPath() %>/img/slides/sea.jpg"></div>
				<div data-thumb="<%=request.getContextPath() %>/img/slides/thumbs/shelter.jpg"
					data-src="<%=request.getContextPath() %>/img/slides/shelter.jpg"></div>
				<div data-thumb="<%=request.getContextPath() %>/img/slides/thumbs/tree.jpg"
					data-src="<%=request.getContextPath() %>/img/slides/tree.jpg"></div>
			</div>
			<!-- #camera_wrap_3 -->
		</div>
		<!-- .fluid_container -->
	</div>

	<img src="<%=request.getContextPath() %>/img/index/retieguanzhu.png"
		style="position: absolute; top: 215px; left: 530px;">

	<div style="position: absolute; top: 285px; left: 550px; width: 570px;">
		<c:forEach items="${themes}" var="theme" varStatus="status">
			<!-- 重复以下这个div -->
			<div style="border-top: 2px solid #c7dcea; border-left: 2px solid #c7dcea; border-right: 2px solid #c7dcea; width: 470px; height: 60px; background-color: #F7F9fd;">
				<div class="jiudiancengshu">
					<span style="position: relative; top: 10px;"></span>
				</div>
				<span style="position: relative; top: -12px; left: 40px; color: #3c62a6; font-size: 20px; width: 330px;
				 display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; float: left">
					<a href="/bbs2.0/ThemeServlet?theme_id=${theme.id }&method=visit">${theme.theme }</a>
				</span> 
				<span style="position: relative; top: -20px; left: 40px; color: #95c0e6; font-size: 15px; width: 100px; float: left">
					${lastReply.get(theme).create_time }<br />${replyCount.get(theme) }/${visitCount.get(theme) }
				</span>
			</div>
		</c:forEach>
	</div>

	<img src="<%=request.getContextPath() %>/img/index/shishiredian.png"
		style="position: absolute; top: 580px; left: 30px; width: 470px;">
	<div
		style="position: absolute; top: 640px; left: 30px; width: 470px; height: 60px; font-size: 23px;">
		<div style="margin: 5px 0 0 5px;">上海:重要交通枢纽严禁用打车软件载客</div>
		<div style="margin: 5px 0 0 5px;">上海:重要交通枢纽严禁用打车软件载客</div>
		<div style="margin: 5px 0 0 5px;">上海:重要交通枢纽严禁用打车软件载客</div>
	</div>
	</div>
</body>
</html>