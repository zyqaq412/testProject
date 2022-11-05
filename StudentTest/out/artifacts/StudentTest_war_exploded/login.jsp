<%--
  Created by IntelliJ IDEA.
  User: GSQY
  Date: 2022/5/25
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%----%>
<html>
<head>
    <title>登录界面</title>
    <style>
        #frame_{
            width: 500px;
            height: 400px;
            /*margin: 220px auto;*/
            margin-left: 480px;
            margin-top: 130px;
            /*background-color: azure;
            border-color: black ;*/
        }
        #inner_{
            margin-left: 60px;
            /*margin-top: 150px;*/
            padding-top: 50PX;

        }
    </style>

    <script>

    </script>

</head>
<body background="aa.jpg">
<div id="frame_">
    <div id="inner_">
        <h2 style="margin-left: 35px">学生信息管理系统</h2><br><br>
        学号：&nbsp<input type="text" id="u_id"><br><br>
        密码：&nbsp<input type="password" id="u_pwd"><br><br>
        <button  style="margin-left: 50px" id="btn01">重置</button><button style="margin-left: 60px" id="btn02">登录</button><br>
        <span id="error">${error}</span>
        <script>
            /*编写js代码对学号与密码进行验证*/
            let btn001 = document.getElementById("btn02");//获取按钮对象
            btn001.onclick=function (){
                //alert("1")
                //获取id查看是否为空
                let id_str = document.getElementById("u_id").value;
                if(id_str==''){
                    document.getElementById("error").innerHTML="账户不能为空!"
                  return;
                }
                //alert("2")
                let pwd_str=document.getElementById("u_pwd").value;
                if(pwd_str==''){
                    document.getElementById("error").innerHTML="密码不能为空!"
                    return;
                }
                    //alert("3")
                    //访问服务器,并传递数据
                    window.location.href = "login?u_id="+id_str+"&u_pwd="+pwd_str;

            }
        </script>
    </div>
</div>

</body>
</html>
