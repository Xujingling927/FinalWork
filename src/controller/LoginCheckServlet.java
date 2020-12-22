package controller;

import dao.BaseDao;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;

/**
 * 登陆操作Servlet
 */
@WebServlet(name = "loginCheck",urlPatterns = "/loginCheck")
public class LoginCheckServlet extends HttpServlet {
    private StudentDao dao;
    @Override
    public void init() throws ServletException {
        dao = StudentDao.getInstance();
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("stuId");
        String password = req.getParameter("password");
        if (dao.login(id,password)){
            Cookie cookie = new Cookie("id",id);
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);
            resp.sendRedirect("/jsp/listArticle.jsp");
        }
        else {
            resp.sendRedirect("/jsp/login.jsp");
        }
    }


}
