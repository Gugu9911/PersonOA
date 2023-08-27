<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/4/24
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/echarts.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
    <div id="container" style="height: 100%"></div>
    <script type="text/javascript">

        $(function () {
            $.post("gugu/EChartsServlet?method=deptChart",function (result) {
                //
                var dom = document.getElementById("container");
                var myChart = echarts.init(dom);
                var app = {};

                var option;

                option = {
                    title:{
                        text:'部门人数统计',
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        top: '5%',
                        left: 'center'
                    },
                    series: [
                        {
                            name: 'Access From',
                            type: 'pie',
                            radius: ['40%', '70%'],
                            avoidLabelOverlap: false,
                            itemStyle: {
                                borderRadius: 10,
                                borderColor: '#fff',
                                borderWidth: 2
                            },
                            label: {
                                show: false,
                                position: 'center'
                            },
                            emphasis: {
                                label: {
                                    show: true,
                                    fontSize: '40',
                                    fontWeight: 'bold'
                                }
                            },
                            labelLine: {
                                show: false
                            },
                            data: result[0]
                        }
                    ]
                };

                if (option && typeof option === 'object') {
                    myChart.setOption(option);
                }


            },"json")
        })


    </script>

</body>
</html>
