<%--
  Created by IntelliJ IDEA.
  User: xujingling
  Date: 2020/12/15
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >
<head>
    <title>登陆</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="login">
    <h1>欢迎使用本系统</h1>
    <form method="post" action="${pageContext.request.contextPath}/loginCheck">
        <input type="text" name="stuId" placeholder="学号" required="required" />
        <input type="password" name="password" placeholder="密码" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">登陆</button>
    </form>
    <a href="${pageContext.request.contextPath}/jsp/register.jsp" style="color: white;text-decoration: none">还没有账号？点此注册</a>
</div>
</body>

</html>