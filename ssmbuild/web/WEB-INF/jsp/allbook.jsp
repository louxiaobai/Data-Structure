<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: louquanwei
  Date: 2021/11/10
  Time: 10:30 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">





</head>
<body>

    <div class="container">
        <div class="row clearfix">
            <div class="clo-md-12  column">
                <h1>
                    <small>书籍列表-------显示所有书籍</small>
                </h1>
            </div>


            <div class="row">

                <div class="col-md-4 column">

                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>

                </div>
                <div class="col-md-4 column"> </div>
                <div class="col-md-4 column">
                    <form action="${pageContext.request.contextPath}/book/querBookByName" method="post" class="form-inline" style="float: right" >

                        <span style="color: red">${error}</span>
                        <input type="text" name="querBookName" class="form-control" placeholder="请输入要查询的数据名字">

                        <input   class="btn btn-primary" type="submit" value="查询">

                    </form>
                </div>

            </div>



        </div>


        <div class="row clearfix">

            <div class="clo-md-12 column">

                <table class="table table-hover table-striped">

                    <thead>

                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th>书籍操作</th>

                    </thead>
                    <tbody>
                            <c:forEach var="book" items="${list}">

                                <tr>
                                    <td>${book.bookID}</td>
                                    <td>${book.bookName}</td>
                                    <td>${book.bookCounts}</td>
                                    <td>${book.detail}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/book/toUpdate?id=${book.bookID}">修改</a>&nbsp | &nbsp
                                        <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>

                                    </td>


                                </tr>

                            </c:forEach>

                    </tbody>


                </table>


            </div>

        </div>

    </div>



</body>
</html>
