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
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
        <li><a href="main.html" target="_parent">
            <img src="images/logo.png" title="系统首页" />
        </a></li>

    </div>
    <div class="topleft">
        <li class="toptitle">企业人事管理系统</li>
    </div>

<%--    <ul class="nav">
    <li><a href="deptAdd.jsp" target="rightFrame" class="selected"><img src="images/icon12.png" title="添加部门" /><h2>添加部门</h2></a></li>
    <li><a href="empAdd.html" target="rightFrame"><img src="images/icon11.png" title="添加员工" /><h2>添加员工</h2></a></li>
    <li><a href="empList.html"  target="rightFrame"><img src="images/icon13.png" title="员工管理" /><h2>员工管理</h2></a></li>
    <li><a href="expenseAdd.html"  target="rightFrame"><img src="images/icon14.png" title="添加报销" /><h2>添加报销</h2></a></li>
    <li><a href="dutyAdd.html" target="rightFrame"><img src="images/icon16.png" title="签到签退" /><h2>签到签退</h2></a></li>
    <li><a href="myInfo.jsp"  target="rightFrame"><img src="images/icon17.png" title="我的信息" /><h2>我的信息</h2></a></li>
    </ul>--%>
            
    <div class="topright">    

        <div class="user">
            <span><a href="myInfo.jsp" target="rightFrame">${sessionScope.employee.realName}</a></span>
        </div>
        <ul>
            <li><a href="gugu/EmployeeServlet?method=empLoginOut" target="_parent">退出</a></li>
        </ul>
    
    </div>

</body>
</html>
