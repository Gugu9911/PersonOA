<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/4/21
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>ECharts</title>
    <!-- 引入刚刚下载的 ECharts 文件 -->
    <script src="js/echarts.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
   $(function () {
        $.post("gugu/EChartsServlet?method=positionChart",function (result) {

            //[],[]数组数据传递
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '不同岗位的人数统计'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    left:'center',
                    data: ['所在岗位的人数']
                },
                xAxis: {
                    data: result[0]
                },
                yAxis: {},
                series: [
                    {
                        name: '所在岗位的人数',
                        type: 'bar',
                        data: result[1]
                    }
                ]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);

        },"json")
   })

</script>
</body>
</html>