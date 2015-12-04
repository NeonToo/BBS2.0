<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="bbs.util.Constant"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>

	<div
		style="width: 1090px; height: 1000px; position: relative; top: 220px; left: 20px;">
		<div style="width: 1090px; text-align: center;">
			<span style="font-size: 40px; background-color: #fad237">${theme.theme }</span>
		</div>
		<div style="width: 1090px; text-align: center; margin: 15px 0 0 0;">
			<span style="font-size: 18px; color: #a9c3a9">楼主:<span
				style="color: #40bdf4"><a href="">${theme.user.user_id }</a></span>&nbsp
				<span>时间:&nbsp${theme.create_time }&nbsp点击量：${visit}&nbsp回复量：${replies.size() }</span>
			</span>
			<c:if test="${theme.user.user_id eq 'session.getAttribute(Constant.USERID_MARK)' }">
				<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=lock">【锁定】</a>
				<a href="/bbs2.0/ThemeServlet?id=${theme.id }&method=cancellock">【解除锁定】</a>
			</c:if>
		</div>
		<c:forEach items="${replies }" var="reply" varStatus="status">
			<div
				style="width: 1090px; margin: 5px 0 0 0; background-color: #FFFFFF; font-size: 25px;">
				<table style="width: 1090px;">
					<tr style="float: left">
						<td><a href="">${reply.user.user_id }</a>
							<p>&nbsp${reply.content }</p></td>
					</tr>
					<tr style="float: right; margin-top: 80px">
						<td>${status.index+1 }楼<br />发布于：${reply.create_time }
						</td>
					</tr>
				</table>
			</div>
		</c:forEach>
		<c:choose>
			<c:when test="${theme.is_lock == 0 }">
				<div style="width: 1090px; margin: 15px; font-size: 24px;">发表评论</div>
				<form action="/bbs2.0/ResponseServlet?theme_id=${theme.id }&method=add" method="post">
					<textarea rows="8" cols="152" name="content"></textarea>
					<input type="submit" value="回复" style="font-size: 30px; position: relative; left: 1010px;top: 10px">
				</form>
			</c:when>
			<c:otherwise>
				<div style="width: 1090px; margin: 15px; font-size: 24px;">当前帖子已被锁定，不能发表评论！</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>