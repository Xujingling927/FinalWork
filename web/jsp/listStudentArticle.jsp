<%@ page import="dao.StudentDao" %>
<%@ page import="dao.ArticleDao" %>
<%@ page import="model.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xujingling
  Date: 2020/12/15
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../css/stylesheet.css" rel="stylesheet" type="text/css">
    <title>Title</title>
</head>
<head>
    <title>图片列表</title>
</head>
<body style="background-image: url(../img/BackGround.JPG);
    background-size: cover;">
<br/><br/>
<%
    StudentDao studentDao = StudentDao.getInstance();
    List<Article> list = (List<Article>) request.getAttribute("list");
%>
<div style="text-align: center;padding: 50px 50px 50px 50px">
    <h2><%=studentDao.getName(list.get(0).getStuId())%>的所有文章</h2>
    <table class="pure-table">
        <thead>
        <tr>
            <td>序号</td>
            <td style="min-width: 200px">文章标题</td>
            <td>发表时间</td>
            <td>作者</td>
            <td>学校</td>
        </tr>
        </thead>
        <tbody>
        <%
            int count = 1;
            for (Article article:list){
        %>
        <tr>
            <td><%=count%></td>
            <td><a href="editArticle.jsp?artId=<%=article.getArtId()%>"><%=article.getArtTitle()%></a></td>
            <td><%=article.getArtTime()%></td>
            <td><%=studentDao.getName(article.getStuId())%></td>
            <td><%=studentDao.getSchool(article.getStuId())%></td>
        </tr>
        <%
                count++;
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>