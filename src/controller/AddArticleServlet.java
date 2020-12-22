package controller;

import dao.ArticleDao;
import dao.StudentDao;
import model.Article;
import org.apache.poi.hwpf.HWPFDocument;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 添加文章Servlet
 */
@WebServlet(name = "addArticle",urlPatterns = "/addArticle")
@MultipartConfig
public class AddArticleServlet extends HttpServlet {
    private ArticleDao articleDao;
    private StudentDao studentDao;
    @Override
    public void init() throws ServletException {
        articleDao = ArticleDao.getInstance();
        studentDao = StudentDao.getInstance();
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String stuId = null,
                artTitle = null,
                artTime = sdf.format(new Date());
        //从cookie获取用户id
        Cookie[] cookie = req.getCookies();
        for (Cookie cookie1:cookie){
            if (cookie1.getName().equals("id")){
                stuId = cookie1.getValue();
            }
        }
        artTitle = req.getParameter("artTitle");
        Article article = new Article(stuId,artTitle,null,artTime);

        Part part = req.getPart("artFile");
        String fileName = "";
        String savePath = req.getServletContext().getRealPath(req.getContextPath())+"files";
        try {
            String header = part.getHeader("content-disposition");
            fileName = System.currentTimeMillis() + "_" + getFileName(header);
            System.out.println(savePath + File.separator + fileName);
            part.write(savePath + File.separator + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String text = "";

        try {
            InputStream input = new FileInputStream(savePath + File.separator + fileName);
            //读取不同格式word文件
            if ("doc".equals(getPostFix(savePath + File.separator + fileName))){
                HWPFDocument doc = new HWPFDocument(input);
                text = doc.getDocumentText();
                article.setArtContent(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        article.setArtContent(text);
        articleDao.insert(article);

        resp.sendRedirect(req.getContextPath()+"/jsp/listArticle.jsp");

    }
    //获取文件名
    private String getFileName(String header){
        String[] tempArr1 = header.split(";");
        String[] tempArr2 = tempArr1[2].split("=");
        return tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
    }

    //获取文件后缀
    private String getPostFix(String path){
        if (path == null || "".equals(path.trim())){
            return "";
        }

        if (path.contains(".") && path.lastIndexOf(".") != path.length()-1){
            return path.substring(path.lastIndexOf(".") + 1,path.length());
        }
        return "";
    }

}
