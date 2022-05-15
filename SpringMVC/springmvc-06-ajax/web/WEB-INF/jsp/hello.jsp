<%--
  Created by IntelliJ IDEA.
  User: louquanwei
  Date: 2021/11/14
  Time: 9:47 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>iframe测试体验页面无刷新</title>
</head>


<script>

    function go() {

        var url=document.getElementById("url");

        document.getElementById("iframe").src=url;

    }


</script>


<body>


<div>

    <p>请输出网址</p>

    <p>
        <input type="text" id="url" value="https:www.baidu.com">
        <input type="button" value="提交" onclick="go">

    </p>

    </p>

</div>

<div>

    <iframe id="iframe" style="width: 100%;height: 500px">
    </iframe>

</div>


</body>
</html>
