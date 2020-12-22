<%--
  Created by IntelliJ IDEA.
  User: xujingling
  Date: 2020/12/15
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传论文</title>
</head>
<body style="background-image: url(../img/BackGround.JPG);
    background-size: cover;">

<div style="text-align: center; margin-top: 100px">
    <h2>文章提交界面</h2>
    <form method="post" action="${pageContext.request.contextPath}/addArticle" enctype="multipart/form-data">
        论文题目：<input style="margin: 10px;width: 180px" type="text" name="artTitle"><br>
        <input style="margin: 10px" type="file" name="artFile" accept=".doc"><br>
        <input style=" margin:10px;width: 250px;border-radius: 17px;" type="submit" value="提交">
    </form>
</div>

</body>
</html>
