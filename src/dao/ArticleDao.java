package dao;

import model.Article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 文章操作类<br>
 * <p>
 *     对文章信息进行数据库操作
 * </p>
 *
 * @see BaseDao
 */
public class ArticleDao {
    /**
     * 数据库连接实例
     */
    private final BaseDao baseDao;
    /**
     * 文章数据操作实例
     */
    private static ArticleDao instance;
    /**
     * 文章表名
     */
    public static final String TABLENAME = "T_Student_Article";

    /**
     * 获取文章操作实例
     * @return 文章操作实例对象
     */
    public static ArticleDao getInstance(){
        if (instance == null){
            instance = new ArticleDao();
        }
        return instance;
    }

    public ArticleDao() {
        baseDao = BaseDao.getInstance();
    }

    /**
     * 将文章插入数据库
     * @param article 文章对象
     */
    public void insert(Article article){
        String sql = "INSERT INTO "+TABLENAME+" (stuId,title,content,time) VALUE (?,?,?,?)";
        try {
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ps.setString(1,article.getStuId());
            ps.setString(2,article.getArtTitle());
            ps.setString(3,article.getArtContent());
            ps.setString(4,article.getArtTime());
            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 通过学号获取文章列表
     * @param stuId 学号
     * @return 文章集合
     */
    public List<Article> getStudentArticleByStuId(String stuId){
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLENAME + " WHERE stuId = ?";
        try {
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ps.setString(1,stuId);
            ResultSet set = ps.executeQuery();
            while (set.next()){
                Article article = new Article();
                article.setStuId(set.getString("stuId"));
                article.setArtTime(set.getString("time"));
                article.setArtContent(set.getString("content"));
                article.setArtId(set.getString("id"));
                article.setArtTitle(set.getString("title"));
                articles.add(article);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return articles;
    }

    /**
     * 获取数据库中所有文章
     * @return 文章集合
     */
    public List<Article> getAllArticle(){
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLENAME;
        try {
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ResultSet set = ps.executeQuery();
            while (set.next()){
                Article article = new Article();
                article.setStuId(set.getString("stuId"));
                article.setArtTime(set.getString("time"));
                article.setArtContent(set.getString("content"));
                article.setArtId(set.getString("id"));
                article.setArtTitle(set.getString("title"));
                articles.add(article);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return articles;
    }

    /**
     * 搜索标题中含有关键词的文章
     * @param keyword 关键词
     * @return 文章集合
     */
    public List<Article> getArticleByKeyword(String keyword){
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM "+TABLENAME+" WHERE title LIKE '%"+keyword+"%';";
        try {
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ResultSet set = ps.executeQuery();
            while (set.next()){
                Article article = new Article();
                article.setStuId(set.getString("stuId"));
                article.setArtTime(set.getString("time"));
                article.setArtContent(set.getString("content"));
                article.setArtId(set.getString("id"));
                article.setArtTitle(set.getString("title"));
                articles.add(article);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return articles;
    }

    /**
     * 获取单篇文章
     * @param artId 文章编号
     * @return 文章对象
     */
    public Article getArticleByArtId(String artId){
        String sql = "SELECT * FROM "+TABLENAME+" WHERE id = ?";
        Article article = null;
        try {
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ps.setString(1,artId);
            ResultSet set = ps.executeQuery();
            while (set.next()){
                 article = new Article(
                        artId,
                        set.getString("stuId"),
                        set.getString("title"),
                        set.getString("content"),
                        set.getString("time")

                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return article;
    }

    /**
     * 根据文章id删除文章
     * @param artId 文章ID
     */
    public void deleteArticle(String artId){
        String sql = "DELETE FROM "+TABLENAME+" WHERE id = ?;";
        try {
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ps.setString(1,artId);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 修改文章内容
     * @param artId 文章编号
     * @param content 新内容
     */
    public void editArticleContent(String artId,String content){
        String sql = "UPDATE "+TABLENAME+" SET content = ? WHERE id = ?;";
        try {
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ps.setString(1,content);
            ps.setString(2,artId);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
