<%--
  Created by IntelliJ IDEA.
  User: GSQY
  Date: 2022/5/28
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>学生成绩</title>
<style>
    #table{
        margin-left: 30%;
        margin-top: 30px;
    }
</style>
</head>
<body>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr >
            <td>课程</td>
            <td>成绩</td>

        </tr>

        <c:forEach items="${arr}" var="item">
            <tr>
                <td>${item.getA()}</td>
                <td>${item.getB()}</td>

            </tr>
        </c:forEach>



    </table>
</body>
</html>
