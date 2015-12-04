<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Module</title>
</head>
<body>
	<form action="/bbs2.0/ModuleServlet?method=add" method="post">
		<table align="center" width="400">
			<tr>
				<td align="center" colspan="2">
					<h2>Add Module</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<!-- <td><input type="hidden" name="module_id" value=""></td> -->
			</tr>
			<tr>
				<td align="right">模块名:</td>
				<td><input type="text" name="module_name"></td>
			</tr>
			<tr>
				<td align="right">描述:</td>
				<td><textarea name="description" cols="26" rows="5"></textarea></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="添加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>