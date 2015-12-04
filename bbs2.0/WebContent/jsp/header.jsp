<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bbs.util.Constant"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
<script type="text/javascript">
	function search() {
		with (document.all) {
			if (theme.value == "") {
				alert("输入不能为空！");
				return false;
			} else {
				document.forms['searchTheme'].submit();
			}
		}
	}
</script>
<style type="text/css">
.quanbu {
	position: relative;
	margin: 0 auto;
	width: 1140px;
	height: 1000px;
}
</style>
<STYLE TYPE="text/css">
<!--
BODY {
	background-color: #ccffcc;
}

a {
	color: #444444;
}

a:hover {
	color: red;
	font-weight: bolder;
}
-->
</STYLE>
</head>
<body>
	<div
		style="position: fixed; top: 0px; left: 0px; width: 100%; height: 100px; background-color: white; z-index: 99;">
		<img src="/bbs2.0/img/index/logo.png" style="margin: 0; float: left;">
		<div style="margin: 20px auto; width: 660px;">
			<form action="/bbs2.0/ThemeServlet?method=searchTheme" method="post" name="searchTheme">
				<input type="text" name="theme" 
					style="width: 480px; font-size: 40px; float: left;"> 
				<input type="button" value="搜索" onclick="return search()"
					style="width: 60px; height: 50px; font-size: 20px; float: left; margin: 0 0 0 10px;">
			</form>
		</div>
		<div
			style="width: 300px; font-size: 17px; margin: 0 30px 0 0; float: right;">
			<%
				if (session.getAttribute(Constant.USERID_MARK) != null) {
					if (session.getAttribute(Constant.USERID_MARK).equals("admin")) {
			%>
			<a href="/bbs2.0//jsp/userDetail.jsp"> <%=session.getAttribute(Constant.USER_NAME_MARK)
							.toString()%></a> 
			<a href="/bbs2.0/jsp/manager.jsp">后台管理</a>
			<a href="/bbs2.0/UserServlet?method=logout">退出</a>
			<%
				} else {
			%>
			<a href="/bbs2.0/jsp/userDetail.jsp"> <%=session.getAttribute(Constant.USER_NAME_MARK)
							.toString()%>
			</a> <a href="/bbs2.0/UserServlet?method=logout">退出</a>
			<%
				}
				} else {
			%>
			<a href="/bbs2.0/jsp/login.jsp">登录</a>
			<%
				}
			%>
		</div>
		<div
			style="width: 35px; font-size: 17px; margin: 0 30px 0 0; float: right;">
			<a href="/bbs2.0/jsp/register.jsp">注册</a>
		</div>
	</div>
	<div class="quanbu">
		<img src="/bbs2.0/img/index/biaotilan.png"
			style="position: absolute; top: 130px;">
		<div
			style="position: absolute; top: 145px; left: 50px; font-size: 40px; color: white;">
			<a href="/bbs2.0/InitServlet">首页</a>
		</div>
		<div
			style="position: absolute; top: 145px; left: 230px; font-size: 40px; color: white;">
			<a href="/bbs2.0/ModuleServlet?method=getAll">模块</a>
		</div>
		<div
			style="position: absolute; top: 145px; left: 410px; font-size: 40px; color: white;">
			<a href="/bbs2.0/ThemeServlet?method=getAll">帖子</a>
		</div>
		<div
			style="position: absolute; top: 145px; left: 600px; font-size: 40px; color: white;">
			<a href="/bbs2.0/ThemeServlet?method=getHot">热帖</a>
		</div>
		<div
			style="position: absolute; top: 145px; left: 790px; font-size: 40px; color: white;">
			<a href="/bbs2.0/ThemeServlet?method=getAllModules">发帖</a>
		</div>
		<div
			style="position: absolute; top: 145px; left: 980px; font-size: 40px; color: white;">
			<a href="/bbs2.0/InitServlet">首页</a>
		</div>
</body>
</html>