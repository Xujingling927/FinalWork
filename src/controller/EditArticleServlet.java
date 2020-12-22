package controller;

import dao.ArticleDao;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编辑文章Servlet
 */
@WebServlet(name = "EditArticle",urlPatterns = "/editArticle")
public class EditArticleServlet extends HttpServlet {
    ArticleDao articleDao;
    StudentDao studentDao;
    @Override
    public void init() throws ServletException {
        articleDao = ArticleDao.getInstance();
        studentDao = StudentDao.getInstance();

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artContent = req.getParameter("artContent");
        String artId = req.getParameter("artId");
        System.out.println(artId);
        articleDao.editArticleContent(artId,artContent);

        resp.sendRedirect(req.getContextPath()+"/jsp/listArticle.jsp");
    }


}
