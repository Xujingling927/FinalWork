package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  数据库连接类<br>
 *      <p>
 *          建立与数据库的连接
 *      </p>
 */
public class BaseDao{
    /**
     * mysql jdbc驱动程序
     */
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * mysql 地址
     */
    public static final String URL = "jdbc:mysql://localhost:3306/" +
            "mydatabase?characterEncoding=utf-8&" +
            "useSSL=false&" +
            "allowPublicKeyRetrieval=true";
    /**
     * 数据库用户名
     */
    public static final String USERNAME = "xujingling";
    /**
     * 数据库密码
     */
    public static final String PASSWORD = "123456";
    /**
     * 实例
     */
    private static BaseDao instance;
    /**
     * 数据库连接
     */
    private Connection connection;

    /**
     * 无参构造函数
     */
    public BaseDao() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if (connection != null){
                System.out.println("数据库连接成功");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found");
            e.printStackTrace();
        }catch (SQLException e){
            System.out.println("SQL Connect Failed");
            e.printStackTrace();
        }
    }

    /**
     * 获取BaseDao实例
     */
    public static BaseDao getInstance() {
        if (instance == null){
            instance= new BaseDao();
            return instance;
        }
        return instance;
    }
    /**
     * 获取数据库连接
     */
    public Connection getConnection() {
        return connection;
    }

}
