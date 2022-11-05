<%--
  Created by IntelliJ IDEA.
  User: GSQY
  Date: 2022/5/30
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩修改</title>
</head>
<style>
    #a{
        width: 70%;
        height: 600px;
        margin-top: 50px;
        margin-left: 240px;
        position: absolute;
    }
    #b{
        margin-left: 100px;
        margin-top: 50px;
        position: absolute;
    }
    input{
        margin-left: 70px;
        margin-top: 15px;
        font-size: 10px;
        color: red;
        font-family: 楷体;
    }
    button{
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
    function modifyUp(){
        //alert("1")
        let a1 = document.getElementById("a1").value;
        let a2 = document.getElementById("a2").value;
        let a3 = document.getElementById("a3").value;
        let a4 = document.getElementById("a4").value;
        window.location.href = "modifyUp?adminId=${adminU}&stuId=${studentId}&a1="+a1+"&a2="+a2+"&a3="+a3+"&a4="+a4;
    }
</script>
<body background="aa.jpg">
    <div id="a">
        <div style="font-size: 40px;margin-top: 40px;margin-left: 70px">成绩修改界面</div>
        <span>管理员:&nbsp;${adminU}</span><br>
        <span>学生:&nbsp;${studentId}</span>
        <div id="b">
            云计算系统搭建<input id="a1" style="margin-left: 10px" type="text">
            java语言基础<input id="a2" style="margin-left: 30px" type="text"><br>
            <br>
            系统运维<input id="a3" style="margin-left: 60px" type="text">
            python语言基础<input id="a4" style="margin-left: 0px" type="text"><br>
            <br>
            <button style="margin-left: 100px"  onclick="gohome(${adminU})">回主界面</button>
            <button style="margin-left: 90px"  onclick="modifyUp(${adminU})">确认修改</button>
        </div>
    </div>
</body>
</html>
