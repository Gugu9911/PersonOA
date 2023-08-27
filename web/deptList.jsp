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
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});

function remove2(id) {

    $("#sub").click(function () {
        window.location.href="gugu/DeptServlet?method=deptRemove&deptno="+id;
    })
    }
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">部门管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
      
   <div class="formtitle1"><span>部门列表</span></div>
   
    <table class="tablelist" >
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>部门名称</th>
        <th>办公地点</th>
        <th>操作</th>
        </tr>
        </thead>
        
        <tbody>
        <c:forEach items="${requestScope.pg.list}" var="dept">
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>${dept.deptno}</td>
                <td>${dept.deptname}</td>
                <td>${dept.location}</td>
                <td><a href="gugu/DeptServlet?method=deptFindOne&deptno=${dept.deptno}" class="tablelink">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:void(0)" class="tablelink click" onclick="remove2(${dept.deptno})"> 删除</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
<%--    分页查询--%>
        <div class="pagin">
            <div class="message">共<i class="blue">${requestScope.pg.totalCount}</i>条记录，当前显示第&nbsp;<i class="blue">${requestScope.pg.index} </i>页</div>
            <ul class="paginList">
                <li class="paginItem"><a href="gugu/DeptServlet?method=deptFindAll&index=${requestScope.pg.index-1}"><span class="pagepre"></span></a></li>
                <c:forEach items="${requestScope.pg.numbers}" var="num">
                    <c:if test="${requestScope.pg.index == num}">
                        <li class="paginItem current"><a href="gugu/DeptServlet?method=deptFindAll&index=${num}">${num}</a></li>
                    </c:if>
                    <c:if test="${requestScope.pg.index != num}">
                        <li class="paginItem"><a href="gugu/DeptServlet?method=deptFindAll&index=${num}">${num}</a></li>
                    </c:if>
                </c:forEach>
                <li class="paginItem"><a href="gugu/DeptServlet?method=deptFindAll&index=${requestScope.pg.index+1}"><span class="pagenxt"></span></a></li>
            </ul>
        </div>
    
       
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" id="sub"/>&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
