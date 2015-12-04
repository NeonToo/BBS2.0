<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子搜索结果</title>
<script type="text/javascript">
	function checkTheme3() {
		with (document.all) {
			if (theme.value == "") {
				alert("输入不能为空！");
				return false;
			} else {
				document.forms['searchTheme3'].submit();
			}
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
			<form action="/bbs2.0/ThemeServlet?method=searchTheme" method="post"
				name="searchTheme3">
				<span style="position: relative; top: 13px; left: 15px; font-size: 23px;">搜索结果</span>
				<input type="text" name="theme"
					style="position: relative; top: 13px; left: 50px; font-size: 23px;">
				<input type="button" value="搜索" onclick="return checkTheme3()"
					style="position: relative; top: 9px; left: 50px; height: 38px; font-size: 20px;">
			</form>
			<form>
				<input type="button" value="发帖"  onclick="location.href='/bbs2.0/ThemeServlet?method=getAllModules'"
					style="position: absolute; top: 9px; left: 970px; height: 38px; font-size: 20px;">
			</form>
		</div>
		<table style="width: 1090px; font-size: 18px; color: #2f25dd;"
			cellspacing="0">
			<tr
				style="width: 1090px; background-color: #e8e8e8; height: 35px; color: black;">
				<td style="width: 674px;">标题</td>
				<td style="width: 170px;">作者</td>
				<td style="width: 60px;">点击</td>
				<td style="width: 60px;">回复</td>
				<td style="">回复时间</td>
			</tr>
			<c:choose>
				<c:when test="${themes.size() > 0 }">
					<c:forEach items="${themes}" var="theme" varStatus="status">
						<tr style="width: 1090px; height: 40px;">
							<td style="width: 674px;"><span style="margin: 0 0 0 20px;"></span>
								<a href="/bbs/ThemeAction?theme_id=${theme.id }&method=visit">${theme.theme }</a>
							</td>
							<td style="width: 170px">
								<a href="userDetail.jsp?user_id=${theme.user.user_id }">${theme.user.user_id }</a>
							</td>
							<td style="width: 60px; font-size: 14px; color: black;">${visitCount.get(theme) }</td>
							<td style="width: 60px; font-size: 14px; color: black;">${replyCount.get(theme) }</td>
							<td style="font-size: 14px; color: black;">${lastReply.get(theme).create_time }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr style="width: 1090px; height: 40px;">
						<td>无搜索结果</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>