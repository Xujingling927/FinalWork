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
 * 删除文章Servlet
 */
@WebServlet(name = "DeleteArticle",urlPatterns = "/deleteArticle")
public class DeleteArticleServlet extends HttpServlet {
    ArticleDao articleDao;
    StudentDao studentDao;
    @Override
    public void init() throws ServletException {
        articleDao = ArticleDao.getInstance();
        studentDao = StudentDao.getInstance();

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artId = req.getParameter("artId");
        articleDao.deleteArticle(artId);

        resp.sendRedirect(req.getContextPath()+"/jsp/listArticle.jsp");
    }
}
