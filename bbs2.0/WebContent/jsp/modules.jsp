<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模块</title>

<script src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function checkModule() {
		with (document.all) {
			if (module_name.value == "") {
				alert("输入不能为空！");
				return false;
			} else {
				document.forms['searchModule'].submit();
			}
		}
	}
</script>
<script type="text/javascript">
	var index = 0;
	for (index = 0; index < 10; index++) {
		if (index % 2 == 0) {
			$("#row" + index).css({
				"background-color" : "white"
			});
		}
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div
		style="width: 1090px; height: 1000px; position: relative; top: 220px; left: 20px;">
		<div
			style="width: 1090px; height: 55px; background-color: #f5e682; margin: 0 0 2px 0;">
			<form action="/bbs2.0/ModuleServlet?method=search" method="post" name="searchModule">
				<span
					style="position: relative; top: 13px; left: 15px; font-size: 23px;">所有模块:</span>
				<input type="text" name="module_name"
					style="position: relative; top: 13px; left: 50px; font-size: 23px;">
				<input type="button" value="搜索" onclick="return checkModule()"
					style="position: relative; top: 9px; left: 50px; height: 38px; font-size: 20px;">
			</form>
			<form>
				<input type="button" value="发帖"
					onclick="location.href='/bbs2.0/ThemeServlet?method=getAllModules'"
					style="position: absolute; top: 9px; left: 970px; height: 38px; font-size: 20px;">
			</form>
		</div>
		<table style="width: 1090px; font-size: 18px; color: #2f25dd;"
			cellspacing="0">
			<tr
				style="width: 1090px; background-color: #e8e8e8; height: 35px; color: black;">
				<td style="width: 100px;">序号</td>
				<td style="width: 674px;">模块名</td>
				<td style="width: 500px;">描述</td>
				<td style="width: 300px;">创建人</td>
			</tr>
			<c:forEach items="${modules}" var="module" varStatus="status">
				<tr style="width: 1090px; height: 40px;" id="row${status.index }">
					<td style="width: 100px; font-size: 14px; color: black;">${status.index+1 }</td>
					<td style="width: 674px;"><span style="margin: 0 0 0 20px;"></span>
					<a href="/bbs2.0/ModuleServlet?name=${module.module_name}&method=goto">${module.module_name}</a></td>
					<td style="width: 500px">${module.description }</td>
					<td style="width: 300px; font-size: 14px; color: black;"><p>admin</p></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>