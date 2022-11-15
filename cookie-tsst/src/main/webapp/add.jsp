<%--
  Created by IntelliJ IDEA.
  User: zxwyhzy
  Date: 2022/11/15
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %><!--不忽略el表达式-->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AddServlet">
  品牌名称 <input type="text" name="brandName"><br>
  企业名称 <input type="text" name="companyName"><br>
  排序&nbsp;    <input type="text" name="ordered"><br>
  品牌介绍  <input type="text" name="description"><br>
  状态&nbsp;<input type="text" name="status"><br>
  <input type="submit" value="确定">
</form>
</body>
</html>
