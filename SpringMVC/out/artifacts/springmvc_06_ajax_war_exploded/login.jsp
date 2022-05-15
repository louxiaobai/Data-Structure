<%--
  Created by IntelliJ IDEA.
  User: louquanwei
  Date: 2021/11/14
  Time: 11:50 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>

<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.4.1.min.js"></script>

<script>

    function a1() {

        $.post({

            url:"${pageContext.request.contextPath}/a3",
            data:{"name":$("#name").val()},
            success:function (data) {

                if (data.toString()=="ok"){

                    $("#userInfo").css("color","green");
                }else{

                    $("#userInfo").css("color","red");
                }

                $("#userInfo").html(data);

            }



        });

    }

    function a2() {

        $.post({
            url:"${pageContext.request.contextPath}/a3",
            data:{"password":$("#name").val()},
            success:function (data) {


                if (data.toString()=="ok"){

                    $("#pwdInfo").css("color","green");
                }else{

                    $("#pwdInfo").css("color","red");
                }

                $("#pwdInfo").html(data);

            }

        });

    }


</script>



<body>
<p>
    用户名:<input type="text" id="name" onblur="a1()">
    <span id="userInfo"></span>
</p>


<p>
    密码:<input type="text" id="password" onblur="a2()">
    <span id="pwdInfo"></span>
</p>

</body>
</html>
