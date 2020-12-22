<%--
  Created by IntelliJ IDEA.
  User: xujingling
  Date: 2020/12/16
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <title>注册页面</title>
</head>
<body>
<div class="register">
    <h1>注册</h1>
    <form method="post" action="${pageContext.request.contextPath}/addStudent">
        <input type="text" name="stuId" placeholder="学号" required="required" />
        <input type="text" name="stuName" placeholder="姓名" required="required"/>
        <input type="text" name="stuSchool" placeholder="学校" required="required"/>
        <input id="password" type="password" name="password" placeholder="请输入密码" required="required" />
        <input id="password_again" type="password" name="password_again" placeholder="请再次输入密码" required="required" onkeyup="validate()" />
        <div id="password_tip"></div>
        <button type="submit" class="btn btn-primary btn-block btn-large">注册</button>
    </form>
</div>
<!--<script  src="js/index.js"></script>-->
<script>
    function validate() {
        var pwd1 = document.getElementById("password").value;
        var pwd2 = document.getElementById("password_again").value;
        if(pwd1 == pwd2) {
            document.getElementById("password_tip").innerHTML="";
            document.getElementById("password_tip").style = "";
            // document.getElementById("submit").disabled = false;
        }
        else {
            document.getElementById("password_tip").innerHTML="<font color='red'>两次密码不相同</font>";
            document.getElementById("password_tip").style = "margin-bottom: 10px;";
            // document.getElementById("submit").disabled = true;
        }
    }
</script>
</body>

</html>