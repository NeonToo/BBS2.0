<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	function bcancel() {
		window.location = "/bbs2.0/jsp/moduleManage.jsp";
	}
</script>
<body>
	<form action="/bbs2.0/ModuleServlet?method=modify" method="post">
		<table align="center" width="400">
			<tr>
				<td align="center" colspan="2">
					<h2>Modify Module</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">模块名:</td>
				<td>
					<select name="name">
						<c:forEach items="${modules}" var="m">
							<option>${m.module_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">描述:</td>
				<td><textarea rows="10" cols="30" name="description">${module.description }</textarea></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				<input type="submit" class="postBtn" value="保存"> 
				<input type="button" class="cancelBtn" value="取消" onclick="bcancel();"></td>
			</tr>
		</table>
	</form>
</body>
</html>