<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<li><a href="#">查看具体请假去向</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>具体请假信息</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>请假申请编号<i class="sort"><img src="images/px.gif" /></i></th>
						<th>请假类型</th>
						<th>请假天数</th>
						<th>请假日期及去向</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.expenseItemlist}" var="expenseItem">
						<tr>
							<td>
								<input name="" type="checkbox" value="" />
							</td>
							<td>${expenseItem.expId}</td>
							<td>${expenseItem.type}</td>
							<td>${expenseItem.amount}</td>
							<td>${expenseItem.itemDesc}</td>
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