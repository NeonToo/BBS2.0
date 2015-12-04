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
		window.location = "/bbs2.0/ThemeServlet?method=showAll";
	}
</script>
<body>
	<form action="/bbs2.0/ThemeServlet?id=${theme.id }&method=modify" method="post">
		<table align="center" width="400">
			<tr>
				<td align="center" colspan="2">
					<h2>Modify Theme</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">模块名:</td>
				<td>
					<select name="module_name">
						<option selected="selected">${theme.module.module_name }</option>
						<c:forEach items="${modules}" var="m">
							<option>${m.module_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">主题:</td>
				<td><input type="text" name="theme" value="${theme.theme }"></td>
			</tr>
			<tr>
				<td align="right">创建人:</td>
				<td><input type="text" name="user_id" value="${theme.user.user_id }"></td>
			</tr>
			<tr>
				<td align="right">是否置顶:</td>
				<td><input type="text" name="is_up" value="${theme.is_up }"></td>
			</tr>
			<tr>
				<td align="right">是否锁定:</td>
				<td><input type="text" name="is_lock" value="${theme.is_lock }"></td>
			</tr>
			<tr>
				<td align="right">是否热门:</td>
				<td><input type="text" name="is_hot" value="${theme.hot }"></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				<input id="submitInput" type="submit" class="postBtn" value="保存"> 
				<input type="button" class="cancelBtn" value="取消" onclick="bcancel();">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>