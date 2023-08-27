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
				<li><a href="#">我的请假</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>我的请假</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>编号</th>
						<th>请假总天数</th>
						<th>申请递交时间</th>
						<th>请假备注</th>
						<th>查看具体请假动向</th>
						<th>状态</th>
						<th>审核备注</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${requestScope.expenseList}" var="expense">
					<tr>
						<td>${expense.expId}</td>
						<td>${expense.totalAmount}</td>
						<td><fmt:formatDate value="${expense.expTime}" pattern="yyyy-MM-dd"/> </td>
						<td>${expense.expDesc}</td>
						<td><a href="gugu/ExpenseItemServlet?method=expenseItemFindAll&expid=${expense.expId}"
							   class="tablelink"> 查看具体请假去向</a></td>
						<td><c:if test="${expense.status==0}">未审核</c:if>
							<c:if test="${expense.status==2}">审核通过</c:if>
							<c:if test="${expense.status==3}">审核拒绝</c:if>
							<c:if test="${expense.status==4}">审核打回</c:if>
						</td>
						<td><a href="gugu/AuditingServlet?method=auditFindOne&expid=${expense.expId}" class="tablelink"> 查看审批状况</a></td>
<%--						<td>${expense.auditDesc}</td>--%>
					</tr>

				</c:forEach>

				</tbody>
			</table>
<%--
 			<div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>--%>
    
		</div>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</body>

</html>