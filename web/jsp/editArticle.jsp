<%--
  Created by IntelliJ IDEA.
  User: xujingling
  Date: 2020/12/15
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="model.Article" %>
<%@ page import="dao.ArticleDao" %>
<%@ page import="dao.StudentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章列表</title>
</head>
<%
    ArticleDao articleDao = ArticleDao.getInstance();
    StudentDao studentDao = StudentDao.getInstance();
    String artId = request.getParameter("artId");
    Article article = articleDao.getArticleByArtId(artId);
    String artStuId = article.getStuId();
    String stuId = "";
    Cookie[] cookie = request.getCookies();
    for (Cookie cookie1:cookie){
        if (cookie1.getName().equals("id")){
            stuId = cookie1.getValue();
        }
    }
%>
<body style="background-image: url(../img/BackGround.JPG);
    background-size: cover;">
<div style="margin: 0 247px 0 247px;width: 600px;">
    <h2 style="text-align: center">《<%=article.getArtTitle()%>》</h2>
    <h4 style="text-align: right">作者：<%=studentDao.getName(artStuId)%></h4>
    <p style="text-align: right;">学校：<%=studentDao.getSchool(artStuId)%></p>
    <p style="text-align: right">发布时间：<%=article.getArtTime()%></p>
<%
    if (stuId.equals(artStuId)){ %>
    <form method="post" action="${pageContext.request.contextPath}/deleteArticle">
        <input value="<%=artId%>" name="artId" hidden="hidden">
        <input type="submit" value="删除文章" name="artId">
    </form>
    <form method="post" action="${pageContext.request.contextPath}/editArticle" >
        <input value="<%=artId%>" name="artId" hidden="hidden">
        <textarea name="artContent" style="margin-right: 50px; width: 600px; height: 800px;"><%=article.getArtContent()%>
        </textarea>
        <br>
        <div style="width: 100%; height: 50px; text-align: center;">
            <input style="width: 190px;height: 40px;margin: 10px;" type="submit" value="提交">
        </div>

    </form>
<%
    }
    else {
%>
<p style="width: 600px" >
    <%=article.getArtContent()%>
</p>
<%
    }
%>
</div>


</body>
</html>
