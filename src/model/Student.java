package model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 学生实体类
 */
public class Student {
    /**
     * 学号
     */
    private String stuId;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 学生学校
     */
    private String stuSchool;
    /**
     * 学生密码
     */
    private String stuPassword;

    /**
     *学生构造函数
     * @param stuId 学生ID
     * @param stuName 学生姓名
     * @param stuSchool 学生学校
     */
    public Student(String stuId, String stuName, String stuSchool) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSchool = stuSchool;
    }

    public Student() {
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSchool() {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool) {
        this.stuSchool = stuSchool;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }
}
