<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<base href="<%=request.getContextPath()+"/"%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="js/jquery.js"></script>

		<script type="text/javascript">
			$(function(){	
				//导航切换
				$(".menuson .header").click(function(){
					var $parent = $(this).parent();
					$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
					
					$parent.addClass("active");
					if(!!$(this).next('.sub-menus').size()){
						if($parent.hasClass("open")){
							$parent.removeClass("open").find('.sub-menus').hide();
						}else{
							$parent.addClass("open").find('.sub-menus').show();	
						}
						
						
					}
				});
				
				// 三级菜单点击
				$('.sub-menus li').click(function(e) {
			        $(".sub-menus li.active").removeClass("active")
					$(this).addClass("active");
			    });
				
				$('.title').click(function(){
					var $ul = $(this).next('ul');
					$('dd').find('.menuson').slideUp();
					if($ul.is(':visible')){
						$(this).next('.menuson').slideUp();
					}else{
						$(this).next('.menuson').slideDown();
					}
				});
			})
		</script>

	</head>

	<body style="background:#f0f9fd;">
		<div class="lefttop"><span></span>导航菜单</div>


		<c:if test="${sessionScope.employee.empType==1}">
			<dl class="leftmenu">

				<dd>
					<div class="title"><span><img src="images/leftico02.png" /></span>考勤管理</div>
					<ul class="menuson">
						<li><cite></cite><a href="dutyAdd.html" target="rightFrame">签到签退</a><i></i></li>
						<li><cite></cite><a href="gugu/DutyServlet?method=dutyFindSome" target="rightFrame">我的考勤</a><i></i></li>
					</ul>
				</dd>
				<dd>
					<div class="title"><span><img src="images/leftico03.png" /></span>请假管理</div>
					<ul class="menuson">
						<li><cite></cite><a href="expenseAdd.html" target="rightFrame">请假申请</a><i></i></li>
						<li><cite></cite><a href="gugu/ExpenseServlet?method=expenseFindSome" target="rightFrame">我的请假</a><i></i></li>
					</ul>
				</dd>

				<dd>
					<div class="title"><span><img src="images/leftico03.png" /></span>个人平台</div>
					<ul class="menuson">
						<li><cite></cite><a href="gugu/EmployeeServlet?method=empFindOne3" target="rightFrame">我的信息</a><i></i></li>
					</ul>
				</dd>
			</dl>
		</c:if>

		<c:if test="${sessionScope.employee.empType==2}">
			<dl class="leftmenu">
				<dd>
					<div class="title"><span><img src="images/leftico03.png" /></span>部门管理</div>
					<ul class="menuson">
						<li><cite></cite><a href="deptAdd.jsp" target="rightFrame">添加部门</a><i></i></li>
						<li><cite></cite><a href="gugu/DeptServlet?method=deptFindAll" target="rightFrame">部门管理</a><i></i></li>
					</ul>
				</dd>
				<dd>
					<div class="title"><span><img src="images/leftico04.png" /></span>岗位管理</div>
					<ul class="menuson">
						<li><cite></cite><a href="positionAdd.jsp" target="rightFrame">添加岗位</a><i></i></li>
						<li><cite></cite><a href="gugu/PositionServlet?method=posiFindAll" target="rightFrame">岗位管理</a><i></i></li>
					</ul>
				</dd>
				<dd>
					<div class="title"><span><img src="images/leftico01.png" /></span>员工管理</div>
					<ul class="menuson">
						<li><cite></cite><a href="empAdd.html" target="rightFrame">添加员工</a><i></i></li>
						<li><cite></cite><a href="empList.html" target="rightFrame">员工管理</a><i></i></li>
					</ul>
				</dd>
				<dd>
					<div class="title"><span><img src="images/leftico02.png" /></span>考勤管理</div>
					<ul class="menuson">
						<li><cite></cite><a href="dutyAdd.html" target="rightFrame">签到签退</a><i></i></li>
						<li><cite></cite><a href="dutyList.html" target="rightFrame">考勤管理</a><i></i></li>
						<li><cite></cite><a href="gugu/DutyServlet?method=dutyFindSome" target="rightFrame">我的考勤</a><i></i></li>
					</ul>
				</dd>
				<dd>
					<div class="title"><span><img src="images/leftico03.png" /></span>请假管理</div>
					<ul class="menuson">
						<li><cite></cite><a href="expenseAdd.html" target="rightFrame">请假申请</a><i></i></li>
						<li><cite></cite><a href="toAudit.html" target="rightFrame">待审请假申请</a><i></i></li>
						<li><cite></cite><a href="gugu/ExpenseServlet?method=expenseFindSome" target="rightFrame">我的请假</a><i></i></li>
						<li><cite></cite><a href="gugu/AuditingServlet?method=auditFindMore" target="rightFrame">我的审批记录</a><i></i></li>
					</ul>
				</dd>
				<dd>
					<div class="title"><span><img src="images/leftico04.png" /></span>图表管理</div>
					<ul class="menuson">
						<li><cite></cite><a href="DeptChart.jsp" target="rightFrame">部门人数统计</a><i></i></li>
						<li><cite></cite><a href="PositionChart.jsp" target="rightFrame">岗位人数统计</a><i></i></li>
					</ul>
				</dd>

				<dd>
					<div class="title"><span><img src="images/leftico03.png" /></span>个人平台</div>
					<ul class="menuson">
						<li><cite></cite><a href="gugu/EmployeeServlet?method=empFindOne3" target="rightFrame">我的信息</a><i></i></li>
					</ul>
				</dd>
			</dl>
		</c:if>


	</body>

</html>