<%--
  Created by IntelliJ IDEA.
  User: louquanwei
  Date: 2021/11/14
  Time: 11:14 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.4.1.min.js"></script>

<script>

    $(function () {

        $("#btn").click(function () {

        //$.post(url,param(可以省略),success)

            $.post("${pageContext.request.contextPath}/a2",function (data) {

                var html="";

                for (let i=0;i<data.length;i++){

                    html+="<tr>"+
                            "<td>"+data[i].name+"</td>"+
                            "<td>"+data[i].age+"</td>"+
                            "<td>"+data[i].sex+"</td>"+
                        +"</tr>"

                }
                $("#content").html(html)

            });

        });
    });
</script>


<body>


<input type="button" value="加载数据" id="btn">

<table>

    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">

<%--    后台数据展示 --%>



    </tbody>


</table>



</body>
</html>
