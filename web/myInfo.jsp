<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<base href="<%=request.getContextPath()+"/"%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript">
		$(document).ready(function(e) {
		    $(".select1").uedSelect({
				width : 345			  
			});
			
		});
	</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">个人平台</a></li>
				<li><a href="#">我的信息</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>查看个人信息</span></div>

				<ul class="forminfo">
					<li>
						<label>用户名</label>
						<input name="empid" type="text" class="dfinput" value="${requestScope.employeeone3.empId}" readonly/>
					</li>
					<li>
						<label>联系方式</label>
						<input name="phone" type="text" class="dfinput" value="${requestScope.employeeone3.phone}" readonly/>
					</li>
					<li>
						<label>QQ号</label>
						<input name="qq" type="text" class="dfinput" value="${requestScope.employeeone3.qq}"/>
					</li>
					<li>
						<label>紧急联系人信息</label>
						<textarea name="emerContactPerson" cols="" rows="" class="dfinput">${requestScope.employeeone3.emerContactPerson}</textarea>
					</li>

				</ul>


		</div>

	</body>

</html>