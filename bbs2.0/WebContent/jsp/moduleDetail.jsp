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
		style="width: 1090px; height: 1000px; position: relative; top: 220px; left: 20px;">
		<form>
			<table style="width: 1090px; font-size: 18px; color: #2f25dd;">
				<tr style="width: 1090px; background-color: white; height: 35px; color: black;">
					<td><h1>模块:${module.module_name}</h1></td>
				</tr>
				<tr style="width: 1090px; background-color: white; height: 35px; color: black;">
					<td><h1>描述:${module.description }</h1></td>
				</tr>
				<tr style="width: 1090px; background-color: white; height: 35px; color: black;">
					<td><h1>包含主题:</h1></td>
				</tr>
				<c:forEach items="${themes}" var="theme" varStatus="status">
					<tr style="width: 1090px; background-color: white; height: 35px; color: black;">
						<td>
							<h4>${status.index+1 }</h4>&nbsp&nbsp 
							<a href="/bbs2.0/ThemeServlet?theme_id=${theme.id }&method=visit">${theme.theme }</a>
							<div style="text-align:right">
								<p>作者：<a href="">${theme.user.user_id }</a></p>
								发布于：${theme.create_time }
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>