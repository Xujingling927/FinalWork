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
 * 查看学生所有文章Servlet
 */
@WebServlet(name = "StudentArticle",urlPatterns = "/StudentArticle")
public class StudentArticleServlet extends HttpServlet {
    private ArticleDao articleDao;
    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        articleDao = ArticleDao.getInstance();
        studentDao = StudentDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuId = req.getParameter("stuId");
        req.setAttribute("list",articleDao.getStudentArticleByStuId(stuId));
        req.getRequestDispatcher("/jsp/listStudentArticle.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
