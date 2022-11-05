<%--
  Created by IntelliJ IDEA.
  User: GSQY
  Date: 2022/5/25
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<%----%>
<html>


<head>
    <title>学生信息管理系统</title>
    <style>
        #head_{
            height: 100px;
            width: 100%;

        }
        #personFile{
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }
        #search{
            height: 70px;
            width: 100%;

        }
        #inner_s{
            /*width: 200px;
            height: 40px;
            padding-right: 70%;
            padding-top: 50%;*/
            width: 40%;
            padding-top:25px;
            padding-left: 45%;
        }
        #table{
            margin-left: 25%;
            margin-top: 30px;
            background-color: azure;
        }
        td{
            text-align: center;
            height: 20px;
            width: 150px;
            border: black 1px solid;
            padding:1px;

        }

    </style>

    <script>
        function search(){
            let v = document.getElementById("fileId").value;
            window.location.href = "mainServlet?v="+v+"&id=${user.getU_id()}";//将登录账号传到服务器

        }
        function show(){
            //alert(v)
            window.location.href = "show?v=${user.getU_id()}";

        }
        function update(){
            //alert(v)
            window.location.href = "update?v=${user.getU_id()}";

        }
        function cancellation(){
            window.location.href = "cancellation";
        }
    </script>
</head>
<body background="bb.jpg">

<div id="head_">

    <div id="personFile">
        名字:<span style="color: red">${user.getU_name()}</span><br>
        学号:<span style="color: red">${user.getU_id()}</span>
    </div>
    <button  style="font-size: 18px; height: 28px;" onclick="cancellation()">注销</button>
</div>


<div id="search">
    <div id="inner_s">
        <input type="text" style="font-size: 20px; height: 26px;width: 190px" id="fileId">&nbsp;&nbsp;
        <button  style="font-size: 18px; height: 28px;" onclick="search()">查询</button>
        <button  style="font-size: 18px; height: 28px;" onclick="show(${item.getU_id()})">查看成绩</button>&nbsp;<button  style="font-size: 18px; height: 28px;" onclick="update()">修改信息</button>

    </div>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr >
            <td>学生学号</td>
            <td>学生名字</td>
            <td>学生电话</td>
            <td>学生住址</td>
        </tr>

        <c:forEach items="${arr}" var="item">
            <tr>
                <td>${item.getU_id()}</td>
                <td>${item.getU_name()}</td>
                <td>${item.getU_phone()}</td>
                <td>${item.getAddress()}</td>

            </tr>
        </c:forEach>



    </table>
</div>

<div>


</div>

</body>
</html>


