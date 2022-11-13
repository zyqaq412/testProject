<%--
  Created by IntelliJ IDEA.
  User: zxwyhzy
  Date: 2022/11/12
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %><!--不忽略el表达式-->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>企业列表</title>
</head>
<body>
<a href="/cookie-tsst/add.html">添加</a><br>
<h5>${user.username} 欢迎你！ </h5>
      <table>
        <tr>
          <th>序号</th>
          <th>品牌名称</th>
          <th>企业名称</th>
          <th>排序</th>
          <th>品牌介绍</th>
          <th>状态</th>
          <th>操作</th>
        </tr>
        <c:forEach items="${brands}" var="brand">
        <tr>
          <td>${brand.id}</td>
          <td>${brand.brandName}</td>
          <td>${brand.companyName}</td>
          <td>${brand.ordered}</td>
          <td>${brand.description}</td>
          <c:if test="${brand.status==1}">
            <td>启用</td>
          </c:if>
          <c:if test="${brand.status==0}">
            <td>禁用</td>
          </c:if>
          <td><a href="/cookie-tsst/IsModifyServlet?id=${brand.id}">修改</a>
            <a href="/cookie-tsst/DelServlet?id=${brand.id}">删除</a></td>
          <br>

        </tr>
        </c:forEach>
      </table>
</body>
</html>
