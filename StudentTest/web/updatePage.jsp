<%--
  Created by IntelliJ IDEA.
  User: GSQY
  Date: 2022/5/31
  Time: 16:17
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
        margin-left: 0px;
        margin-top: 0px;
    }
    input{
        margin-left: 70px;
        margin-top: 15px;
        font-size: 30px;
        color: red;
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
    function updateUp(){

        let a1 = document.getElementById("a1").value;
        let a2 = document.getElementById("a2").value;
        let a3 = document.getElementById("a3").value;
        let a4 = document.getElementById("a4").value;
        window.location.href = "updateUp?stuId=${studentId}&a1="+a1+"&a2="+a2+"&a3="+a3+"&a4="+a4;
    }
</script>
<body background="aa.jpg">
<div  id="a">
    <div style="font-size: 40px;margin-top: 40px;margin-left: 70px">信息修改界面</div>
    <span>学生:&nbsp;${studentId}</span>
        <div id="b">
            姓名:<input style="margin-left: 10px" id="a1"  type="text">
            密码:<input style="margin-left: 10px" id="a2"  type="text"><br>
            <br>
            电话:<input style="margin-left: 10px" id="a3"  type="text">
            地址:<input style="margin-left: 10px" id="a4"  type="text"><br><br><br>
            <button style="margin-left: 200px" onclick="gohome(${studentId})">回主界面</button>
            <button style="margin-left: 250px" onclick="updateUp(${studentId})">确认修改</button>
        </div>
    </div>
</div>
</body>
</html>
