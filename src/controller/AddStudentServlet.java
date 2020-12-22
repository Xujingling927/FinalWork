package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.StudentDao;
import model.Student;

/**
 * 添加学生Servlet
 */
@WebServlet(name = "addStudent",urlPatterns = "/addStudent")
public class AddStudentServlet extends HttpServlet {
    private StudentDao dao;

    @Override
    public void init() throws ServletException {
        dao = StudentDao.getInstance();
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("stuId");
        if (dao.isExist(id)){
            System.out.println("错误，该学生已存在");
        }
        else {
            String name = req.getParameter("stuName");
            String school = req.getParameter("stuSchool");
            String password = req.getParameter("password");
            System.out.println(id+name+school+password);
            Student student = new Student(id,name,school);
            student.setStuPassword(password);
            dao.insert(student);
        }

        resp.sendRedirect(req.getContextPath()+"/jsp/login.jsp");

    }
}
