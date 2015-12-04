<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div
		style="width: 1090px; height: 580px; position: relative; top: 220px; left: 20px; background-color: #f8f8f8">
		<div
			style="position: relative; top: 10px; left: 15px; font-size: 25px;">发帖</div>
		<form action="/bbs2.0/ThemeServlet?method=add" method="post">
			<div style="position: relative; top: 30px; left: 15px; font-size: 18px;">
				标题:<input type="text" style="margin: 0 0 0 20px; font-size: 18px; width: 700px;" name="theme"> 
					<select style="margin: 0 0 0 20px; font-size: 18px;" name="module_name">
						<option selected="selected">选择分类</option>
						<c:forEach items="${modules}" var="module">
							<option>${module.module_name }</option>
						</c:forEach>
					</select>
			</div>
			<div style="position: relative; top: 60px; left: 15px; font-size: 18px; width: 800px">
				内容:
				<textarea rows="8" cols="100" name="content"></textarea>
			</div>
			<div style="margin: 80px 0 0 15px; color: #a2aaa2">请注意文明用词，共同维护网络和谐</div>
			<input type="submit" value="发表" style="font-size: 20px; margin: 0 0 0 700px;">
		</form>
	</div>
	</div>
</body>
</html>