<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<base href="<%=request.getContextPath()+"/"%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>

		<script type="text/javascript">
			$(document).ready(function() {
				$(".click").click(function() {
					$(".tip").fadeIn(200);
				});
				$(".tiptop a").click(function() {
					$(".tip").fadeOut(200);
				});
				$(".sure").click(function() {
					$(".tip").fadeOut(100);
				});
				$(".cancel").click(function() {
					$(".tip").fadeOut(100);
				});
			});
		</script>

	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">查看审核记录</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>审核记录</span></div>

			<table class="tablelist">
				<thead>
					<tr>
<%--						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>--%>
						<th>审核人<i class="sort"><img src="images/px.gif" /></i></th>
						<th>审核结果</th>
						<th>审核意见</th>
						<th>审核时间</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${requestScope.auditingList2}" var="audit2">
					<tr>
<%--						<td>
							<input name="" type="checkbox" value="" />
						</td>--%>
						<td>${audit2.realName}</td>
						<td>
							<c:if test="${audit2.result==0}">未审核</c:if>
							<c:if test="${audit2.result==2}">审核通过</c:if>
							<c:if test="${audit2.result==3}">审核拒绝</c:if>
							<c:if test="${audit2.result==4}">审核打回</c:if>
						</td>
						<td>${audit2.auditDesc}</td>
						<td><fmt:formatDate value="${audit2.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
				</c:forEach>


				</tbody>
			</table>

		</div>
		<input name="" type="button" class="btn" value="返回" onclick="window.history.go(-1)"/>
		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>
		
	</body>

</html>