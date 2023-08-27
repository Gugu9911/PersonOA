<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#1c77ac;
background-image:url(images/light.png);
background-repeat:no-repeat;
background-position:center top;
overflow:hidden;">



    <div id="mainBody">

    </div>  

    <div class="logintop">
    <span>欢迎访问人事管理系统</span>
    </div>
    
    <div class="loginbody">
        <div class="loginbox  loginbox2">
            <form action="gugu/EmployeeServlet?method=empLogin" method="post">
                <ul>
                    <li><input name="empid" type="text" class="loginuser" value="用户名" onclick="JavaScript:this.value=''"/>${requestScope.msg}</li>
                    <li><input name="pwd" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
                    <li><input name="" type="submit" class="loginbtn" value="登录"  /></li>
                </ul>
            </form>
        </div>
    </div>
</body>

</html>
