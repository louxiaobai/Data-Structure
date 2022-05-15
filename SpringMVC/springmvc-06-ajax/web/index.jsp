<%--
  Created by IntelliJ IDEA.
  User: louquanwei
  Date: 2021/11/11
  Time: 9:37 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.4.1.min.js"></script>

  <script>

     function  a() {
          $.post({
             url:"${pageContext.request.contextPath}/a2",
             data:{"name":$("name").val()},
             success:function (data) {
               alert(data);
             }

          });

     }



  </script>

  <body>

<%--  失去焦点的时候，发一个清酒(携带消息)到后台--%>

   用户名:<input type="text" id="username" onblur="a()">

  </body>
</html>
