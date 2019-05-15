<%--
  Created by IntelliJ IDEA.
  User: HUIZHENG
  Date: 2019/5/12
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <!-- jQuery -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
</head>

<script type="text/javascript">

    /*$(function () {
        $("#userName").blur(function () {
            var userName=$(this).val();
            $.ajax({
                url:"checkUser",
                data:{"userName":userName},
                type:"POST",
                async:true,
                dataType:"text",
                success:function (data) {
                    alert(data)
                    if (data=="true"){
                        $("#userNameError").html("用户可以使用");
                    }else {
                        $("#userNameError").html("用户已被注册");
                    }
                },
                error:function (data) {
                    alert(data);
                }
            });
        });
    });*/

    /*$(function () {
        $("#userName").blur(function () {
            var userName=$("#userName").val();
            $.post("checkUser",{"userName":userName},function (data) {
                if (data=="true"){
                    $("#userNameError").html("用户可以使用");
                }else {
                    $("#userNameError").html("用户已被注册");
                }
            },"text");
        });
    });*/

    function checkUserName() {
        var username = document.getElementById("userName");
        var req = new XMLHttpRequest();
        //创建连接 用post提交方式
        req.open("post","checkUser",true);
        //设置http请求头信息，将Content-Type设置为application/x-www-form-urlencoded
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        // req.setRequestHeader("Content-Type", "application/json charset=utf-8");
        //把请求发送到服务器
        req.send("userName="+username.value);
        //回调函数
        req.onreadystatechange=function(){
            if(req.readyState==4 && req.status==200){
                var  userError = document.getElementById("userNameError");
                if(req.responseText=="true"){
                    userError.innerHTML ="用户名可以使用";
                }else{
                    userError.innerHTML ="用户已被注册";
                }
            }
        }
    }

    /*function checkUserName() {
        var username = document.getElementById("userName");
        var req = new XMLHttpRequest();
        //创建连接 用post提交方式
        req.open("get","checkUser?userName="+username.value,true);
        //把请求发送到服务器
        req.send(null);
        //回调函数
        req.onreadystatechange=function(){
            if(req.readyState==4 && req.status==200){
                var  userError = document.getElementById("userNameError");
                if(req.responseText=="true"){
                    userError.innerHTML ="用户名可以使用";
                }else{
                    userError.innerHTML ="用户已被注册";
                }
            }
        }
    }*/
</script>

<body>
    <%--表单提交--%>
    <form action="register" method="post">
        <label>用户名:</label><input id="userName" name="userName" type="text" placeholder="请输入用户名" onblur="checkUserName();"><label id="userNameError">${message}</label><br>
        <label>密码:</label><input id="userPwd" name="userPwd" type="password" placeholder="请输入密码"><label></label><br>
        <label>确认密码:</label><input id="confirmPwd" name="confirmPwd" type="password" placeholder="请确认密码"><label></label><br>
        <label>邮箱:</label><input id="email" name="email" type="email" placeholder="请输入邮箱"><label></label><br>
        <label>生日:</label><input id="birthday" name="birthday" type="text" placeholder="请输入邮箱"><label></label><br>
        <input type="submit" value="注册"><br>
    </form>
</body>
</html>
