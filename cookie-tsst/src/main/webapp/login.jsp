<%--
  Created by IntelliJ IDEA.
  User: zxwyhzy
  Date: 2022/11/13
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>





<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %><!--不忽略el表达式-->
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>login</title>
  <link href="css/login.css" rel="stylesheet">
</head>

<body>

<div id="loginDiv">
  <form action="${pageContext.request.contextPath}/login" method="post" id="form">
    <h1 id="loginMsg">LOGIN IN</h1>
    <div id="errorMsg">${login_msg}</div>
    <p>Username:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>

    <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
    <p>Remember:<input id="remember" name="remember" type="checkbox" value="1"></p>
    <div id="subDiv">
      <input type="submit" class="button" value="login up">
      <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
      <a href="register.jsp">没有账号？点击注册</a>
    </div>
  </form>
</div>

</body>
</html>
