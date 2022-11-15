<%--
  Created by IntelliJ IDEA.
  User: zxwyhzy
  Date: 2022/11/12
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %><!--不忽略el表达式-->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ModifyServlet">
  <%--id &nbsp;&nbsp;   <input type="text" name="id" value="${brand.id}" disabled="true"><br>--%>
  <%--不能用disabled="true" 虽然文本框不能编辑了但是 数据也参与表单提交了--%>
  id &nbsp;&nbsp;   <input type="text" name="id" value="${brand.id}" readonly="true"><br>
  品牌名称&nbsp;      <input type="text" name="brandName" value="${brand.brandName}"><br>
  企业名称&nbsp;      <input type="text" name="companyName" value="${brand.companyName}"><br>
  排序&nbsp; &nbsp;&nbsp;  <input type="text" name="ordered" value="${brand.ordered}"><br>
  品牌介绍 &nbsp;     <input type="text" name="description" value="${brand.description}"><br>
  状态&nbsp;&nbsp;&nbsp;  <input type="text" name="status" value="${brand.status}"><br>
  <input type="submit" value="确定">
</form>
</body>
</html>
