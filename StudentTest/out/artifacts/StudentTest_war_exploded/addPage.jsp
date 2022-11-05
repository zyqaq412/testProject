<%--
  Created by IntelliJ IDEA.
  User: GSQY
  Date: 2022/5/30
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加界面</title>
</head>
<style>
    #a{
        width: 70%;
        height: 400px;
        margin-top: 50px;
        margin-left: 240px;
        position: absolute;

    }
    #b{
        margin-left: 10px;
        margin-top: 10px;
        position: absolute;
    }
    input{
        margin-left: 70px;
        margin-top: 15px;
        font-size: 30px;
        color: black;
        font-family: 楷体;
    }
    button{
        background-color: azure;
        width: 100px;
        height: 25px;
        font-size: 20px;
        font-family: 楷体;
    }
    span{
        margin-left: 100px;
        color: red;
    }
</style>
<script>
    function gohome(v){

        window.location.href = "goMainPage?v="+v;

    }
    function addUp(){
        //alert("1")
        let a1 = document.getElementById("a1").value;
        let a2 = document.getElementById("a2").value;
        let a3 = document.getElementById("a3").value;
        let a4 = document.getElementById("a4").value;
        let a5 = document.getElementById("a5").value;
        let a6 = document.getElementById("a6").value;
        window.location.href = "addUp?adminId=${adminU}&a1="+a1+"&a2="+a2+"&a3="+a3+"&a4="+a4+"&a5="+a5+"&a6="+a6;
    }
</script>
<body background ="aa.jpg">
<div id="a">
    <div style="font-size: 40px;margin-top: 40px;margin-left: 70px">学生添加</div>
    <span>管理员:&nbsp;${adminU}</span><br>
    <div id="b">
        学号:<input style="margin-left: 10px" id="a1"  type="text">&nbsp;
        &nbsp;姓名:<input style="margin-left: 10px" id="a2"  type="text"><br>
        <br>
        密码:<input style="margin-left: 10px" id="a3"  type="text">&nbsp;
        &nbsp;电话:<input style="margin-left: 10px" id="a4"  type="text"><br>
        <br>
        地址:<input style="margin-left: 10px" id="a5"  type="text">&nbsp;
        &nbsp;权限:<input style="margin-left: 10px" id="a6"  type="text"><br>
        <br>
        &nbsp;&nbsp;&nbsp;<button style="margin-left: 200px" onclick="gohome(${adminU})">回主界面</button>
        <button style="margin-left: 250px" onclick="addUp(${adminU})">确认添加</button>
    </div>
</div>
</body>
</html>
