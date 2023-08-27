<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<base href="<%=request.getContextPath()+"/"%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>审核报销单</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript">
			function submitForm(){
				window.close();
				
			}


			$(function () {
				$("#sub").click(function () {
					$.post("gugu/AuditingServlet?method=auditSave",$("#fm").serialize(),function (result) {

						if (result>0){
							window.close();

							window.opener.location.reload();
						}else {
							alert("审核失败");
						}
					})
				})
			})
			
		</script>
	</head>

	<body>

		<div class="formtitle"><span>审核请假信息</span></div>
		<form action="#" id="fm">
			<ul class="forminfo">
				<li>
					<label>请假ID</label>
					<input name="expId" type="text" class="dfinput" value="<%=request.getParameter("expid")%>"/>
				<li>
				<li>
					<label>请假天数</label>
					<input name="day" type="text" class="dfinput" value="<%=request.getParameter("day")%>"/>
				<li>
					<label>审核结果</label>
					<input name="result" type="radio" value="2"/>通过
					<input name="result" type="radio" value="3"/>拒绝
					<input name="result" type="radio" value="4"/>打回
				</li>
				<li>
					<label>审核意见</label>
					<input name="auditDesc" type="text" class="dfinput" />
				</li>
				<li>
					<label>&nbsp;</label>
					<input name="" id="sub" type="button" class="btn" value="确认保存" />
				</li>
			</ul>
		</form>
	</body>

</html>