<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Module Manage</title>
<script type="text/javascript">
	function checkModule3() {
		with (document.all) {
			if (module_name.value == "") {
				alert("模块名不能为空！");
				return false;
			} else {
				document.forms['searchModule3'].submit();
			}
		}
	}
	function resetAll() {
		with (document.all) {
			module_name.value = "";
		}
	}
</script>
</head>
<body>
	<jsp:include page="manager.jsp" flush="true"></jsp:include>
	<br />
	<div align="center">
		<form action="/bbs2.0/ModuleServlet?method=search" method="post"
			name="searchModule3">
			模块名： <input type="text" name="module_name"> 
				  <input type="button" value="搜索" onclick="return checkModule3()">
				  <input type="button" value="重置" onclick="resetAll()">
		</form>
		<br />
		<a href="/bbs2.0/jsp/addModule.jsp">增加模块</a>
		<br/><br/>
		<table width="500" border="1" align="center">
		<tr>
			<td>序号</td>
			<td>模块名</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${modules}" var="module" varStatus="status">
			<tr>
				<td>${status.index+1 }</td>
				<td><a href="/bbs2.0/ModuleServlet?name=${module.module_name}&method=goto">${module.module_name}</a></td>
				<td>${module.description }</td>
				<td><a href="/bbs2.0/ModuleServlet?name=${module.module_name}&method=get">修改</a>
					<a href="/bbs2.0/ModuleServlet?id=${module.id}&method=delete">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>