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
				<li><a href="#">请假管理</a></li>
				<li><a href="#">我的审批记录</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>我的审批记录</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>申请人<i class="sort"><img src="images/px.gif" /></i></th>
						<th>请假总天数</th>
						<th>申请递交时间</th>
						<th>审核时间</th>
						<th>总备注信息</th>
						<th>查看具体动向</th>
						<th>审核结果</th>
						<th>审核建议</th>
					</tr>
				</thead>

				<tbody>
				<c:forEach items="${requestScope.auditingList}" var="audit">
					<tr>

						<td>${audit.realName}</td>
						<td>${audit.totalAmount}</td>
						<td><fmt:formatDate value="${audit.expTime}" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${audit.time}" pattern="yyyy-MM-dd"/></td>
						<td>${audit.expDesc}</td>
						<td><a href="gugu/ExpenseItemServlet?method=expenseItemFindAll&expid=${audit.expId}" class="tablelink">查看具体日期和动向</a></td>
						<td> <c:if test="${audit.result==0}">未审核</c:if>
							<c:if test="${audit.result==2}">审核通过</c:if>
							<c:if test="${audit.result==3}">审核拒绝</c:if>
							<c:if test="${audit.result==4}">审核打回</c:if>
						</td>
						<td>${audit.auditDesc}</td>
					</tr>
				</c:forEach>

				</tbody>
			</table>

		</div>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</body>

</html>