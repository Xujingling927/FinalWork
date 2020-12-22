<%--
  Created by IntelliJ IDEA.
  User: xujingling
  Date: 2020/12/15
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Student" %>
<%@ page import="model.Article" %>
<%@ page import="dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.ArticleDao" %>
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
    ArticleDao articleDao = ArticleDao.getInstance();
    List<Article> list = new ArrayList<>();
    String id = null;
    Cookie[] cookie = request.getCookies();
    for (Cookie cookie1:cookie){
        if (cookie1.getName().equals("id")){
            id = cookie1.getValue();
        }
    }
    if (id==null){
        out.print("<h2 style='text-align:center'><a href='/jsp/login.jsp'>登陆失败，点击此处返回登陆页面</a></h2>");
    }else {
        out.print("<h2 style='text-align:center'>欢迎登陆！你好"+ studentDao.getName(id)+"</>");
        list = articleDao.getAllArticle();
    }



%>
<div style="text-align: center;padding: 50px 50px 50px 50px">
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
            <td><a href="${pageContext.request.contextPath}/StudentArticle?stuId=<%=article.getStuId()%>"><%=studentDao.getName(article.getStuId())%></a></td>
            <td><%=studentDao.getSchool(article.getStuId())%></td>
        </tr>
        <%
                count++;
            }
        %>
        </tbody>
    </table>
    <button onclick="window.location.href = '${pageContext.request.contextPath}/jsp/addArticle.jsp'"> 上传文章</button>
    <button onclick="clearCookie()"> 退出登陆</button>
    <script>

        function clearCookie() {
            const keys = "id";
            document.cookie = keys + '=0;expires=' + new Date(0).toUTCString();
            window.alert("退出登录");
            window.location.href="login.jsp";
        }

    </script>
</div>
</body>
</html>