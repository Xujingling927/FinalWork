package dao;

import model.Student;

import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 学生操作类<br>
 *     <p>
 *         对学生对象进行操作
 *     </p>
 * @see BaseDao
 */
public class StudentDao {
    /**
     * 数据库连接实例
     */
    private final BaseDao baseDao;
    /**
     * 学生操作实例
     */
    private static StudentDao instance;
    /**
     * 学生表名
     */
    public static final String TABLENAME = "T_Student";


    public StudentDao() {
        baseDao = BaseDao.getInstance();
    }

    /**
     * 获取学生操作实例对象
     */
    public static StudentDao getInstance(){
        if (instance == null){
            instance = new StudentDao();
        }
        return instance;
    }

    /**
     * 用于查询该学号学生是已经存在
     * @param id 学号
     * @return boolean 是否存在
     */
    public boolean isExist(String id){
        String sql = "SELECT * FROM "+TABLENAME+" WHERE id = ?";
        boolean flag = true;
        try{
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ps.setString(1,id);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();

            if (!resultSet.next()) {
                flag = false;
            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return flag;
    }

    /**
     * 将学生信息插入数据库中
     * @param student 插入的学生
     */
    public void insert(Student student){
        String sql = "INSERT INTO "+TABLENAME+"(id,name,school,password) VALUE (?,?,?,?)";
        try{
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ps.setString(1,student.getStuId());
            ps.setString(2,student.getStuName());
            ps.setString(3,student.getStuSchool());
            ps.setString(4,student.getStuPassword());
            ps.execute();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 登陆验证方法
     * @param id 学号
     * @param password 密码
     * @return boolean 校验结果
     */
    public boolean login(String id,String password){
        String sql = "SELECT password FROM "+TABLENAME+" WHERE id = ?";
        try{
            PreparedStatement ps = baseDao.getConnection().prepareStatement(sql);
            ps.setString(1,id);
            ps.execute();
            ResultSet set = ps.getResultSet();
            if (isExist(id)){
                while (set.next()) {
                    String str = set.getString("password");
                    if (password.equals(str)) {
                        return true;
                    }
                }
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 根据学号获取学生姓名
     * @param id 学号
     * @return String - 学生姓名
     */
    public String getName(String id){
        String sql = "SELECT name FROM "+TABLENAME+" WHERE id =?";
        String name = null;
        try {
            PreparedStatement preparedStatement = baseDao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                name = set.getString("name");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return name;
    }

    /**
     * 根据学号返回学生学校信息
     * @param id 学号
     * @return 学校名称
     */
    public String getSchool(String id){
        String sql = "SELECT school FROM "+TABLENAME+" WHERE id =?";
        String school = null;
        try {
            PreparedStatement preparedStatement = baseDao.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                school = set.getString("school");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return school;
    }
}
