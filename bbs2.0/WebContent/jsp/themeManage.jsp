<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>themeManage</title>
</head>
<body>
	<jsp:include page="manager.jsp" flush="true"></jsp:include>
	<br />
	<div align="center">
		<form action="/bbs2.0/ThemeServlet?method=search" method="post">
			模块名： <input type="text" name="module_name"> 
			创建人： <input type="text" name="user_id"> 
			主题： <input type="text" name="theme"> 
			    <input type="submit" value="搜索" /> 
			    <input type="submit" value="重置" />
		</form>
		<br />
		<button type="button" onclick="location.href='/bbs2.0/ThemeServlet?method=getAllModules'">增加</button>
	</div>
	<br />
	<br />
	<div>
		<table width="550px" border="1" align="center">
			<tr>
				<td>序号</td>
				<td>所属模块</td>
				<td>主题</td>
				<td>创建人</td>
				<td>是否置顶</td>
				<td>是否锁定</td>
				<td>是否热门</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${themes }" var="theme" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>
						<a href="/bbs2.0/ModuleServlet?name=${theme.module.module_name}&method=goto">${theme.module.module_name }</a>
					</td>
					<td><a href="/bbs2.0/ThemeServlet?theme_id=${theme.id }&method=visit">${theme.theme }</a></td>
					<td><a href="userDetail.jsp?user_id=${theme.user.user_id }">${theme.user.user_id }</a></td>
					<td>${theme.is_up }</td>
					<td>${theme.is_lock }</td>
					<td>${theme.hot }</td>
					<td>
						<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=get">修改</a> 
						<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=top">置顶</a> 
						<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=canceltop">取消置顶</a>
						<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=lock">锁定</a>
						<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=cancellock">解除锁定</a>
						<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=hot">设置热门</a>
						<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=cancelhot">解除热门</a>
						<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=delete">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>