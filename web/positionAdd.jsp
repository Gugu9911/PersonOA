<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">添加岗位</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>

        <form action="gugu/PositionServlet?method=posiSave" method="post">
            <ul class="forminfo">
                <li><label>岗位编号</label><input name="posid" type="text" class="dfinput" />${requestScope.msg}职位编号唯一</li>
                <li><label>岗位名称</label><input name="pname" type="text" class="dfinput" /></li>
                <li><label>岗位描述</label><input name="pdesc" type="text" class="dfinput" /></li>
                <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
            </ul>
        </form>

    </div>


</body>

</html>
