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

<%--    员工信息修改--%>
	<script type="text/javascript">
		$(function () {
			$("#sub").click(function () {
				var val = $("form").serialize();
				$.post("gugu/EmployeeServlet?method=empChange",val,function (result) {
					if (result>0){
						window.location.href="empList.html";
					}else {
						alert("修改失败");
					}
				},"json")
			})
		})
	</script>

	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">人事管理</a></li>
				<li><a href="#">修改员工信息</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>

		<form>

			<ul class="forminfo">
				<li>
					<label>用户名</label>
					<input name="empId" id="empid" type="text" class="dfinput" value="${requestScope.employee.empId}" readonly/><i>唯一用户名</i></li>
				<li>
                <li>
                    <label>密码</label>
                    <input name="password" type="text" class="dfinput" value="${requestScope.employee.password}" /></li>
                <li>
					<li>
						<label>真实姓名</label>
						<input name="realName" type="text" class="dfinput" value="${requestScope.employee.realName}"/><i></i></li>
					<li>
						<label>性别</label>

						<cite>
						<input name="sex" type="radio" value="1"  <c:if test="${requestScope.employee.sex==1}">checked</c:if>/>男&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="sex" type="radio" value="0"  <c:if test="${requestScope.employee.sex==0}">checked</c:if>/>女
						</cite>
						
					</li>
					<li>
						<label>出生日期</label>

						<input name="birthDate" type="text" class="dfinput"
							   value="<fmt:formatDate value="${requestScope.employee.birthDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"/></li>
					<li>
					<li>
						<label>入职时间</label>
						<input name="hireDate" type="text" class="dfinput"
							   value="<fmt:formatDate value="${requestScope.employee.hireDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"/>
					</li>
					
					<li>
						<label>离职时间</label>
						<input name="leaveDate" type="text" class="dfinput"
							   value="<fmt:formatDate value="${requestScope.employee.leaveDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"/>
						<i>1900-01-01为默认值</i>
					</li>
					<li>
						<label>是否在职</label><cite>
						<input name="onDuty" type="radio" value="1" <c:if test="${requestScope.employee.onDuty==1}">checked</c:if>/>是&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="onDuty" type="radio" value="0" <c:if test="${requestScope.employee.onDuty==2}">checked</c:if>/>否</cite>
					</li>
					<li>
						<label>员工类型</label><cite>
						<input name="empType" type="radio" value="1" <c:if test="${requestScope.employee.empType==1}">checked</c:if>/>基层员工&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="empType" type="radio" value="2" <c:if test="${requestScope.employee.empType==2}">checked</c:if>/>上级领导</cite>
					</li>
					<li>
						<label>所属部门<b>*</b></label>
						<div class="vocation">
							<select class="select1" name="deptno">
								<option>--请选择新的部门--</option>
								<c:forEach items="${requestScope.deptList}" var="dept">
									<option value="${dept.deptno}" <c:if test="${dept.deptno==requestScope.employee.deptno}">selected</c:if>>${dept.deptname}</option>
								</c:forEach>
							</select>
						</div>
					</li>

					<li>
						<label>所在岗位<b>*</b></label>
						<div class="vocation">
							<select class="select1" name="posid">
								<option>--请选择新的岗位--</option>
								<c:forEach items="${requestScope.posList}" var="position">
									<option value="${position.posid}" <c:if test="${position.posid==requestScope.employee.posid}">selected</c:if>>${position.pname}</option>
								</c:forEach>
							</select>
						</div>
					</li>

					<li>
						<label>直接上级<b>*</b></label>						
						<div class="vocation">
							<select class="select1" name="empId">
								<option>--请选择新的上级领导--</option>
								<c:forEach items="${requestScope.mgrList}" var="employee">
									<option value="${employee.empId}" <c:if test="${employee.empId==requestScope.employee.mgrid}">selected</c:if>>${employee.realName}</option>
								</c:forEach>
							</select>							
						</div>
					</li>
					<li>
						<label>联系方式</label>
						<input name="phone" type="text" class="dfinput" value="${requestScope.employee.phone}" />
					</li>
					<li>
						<label>QQ号</label>
						<input name="qq" type="text" class="dfinput" value="${requestScope.employee.qq}" />
					</li>
					<li>
						<label>紧急联系人信息</label>
						<textarea name="emerContactPerson" cols="" rows="" class="dfinput">${requestScope.employee.emerContactPerson}</textarea>
					</li>
					<li>
						<label>身份证号</label>
						<input name="idCard" type="text" class="dfinput" value="${requestScope.employee.idCard}" />
					</li>
					<li>
						<label>&nbsp;</label>
						<input name="" type="button" class="btn" value="确认修改" id="sub"/>
					</li>
			</ul>

		</form>

		</div>

	</body>

</html>