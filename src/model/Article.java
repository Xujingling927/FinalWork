package model;

/**
 * 文章实体类
 */
public class Article {
    /**
     * 文章id
     */
    private int artId;
    /**
     * 作者学号
     */
    private String stuId;
    /**
     * 文章标题
     */
    private String artTitle;
    /**
     * 文章内容
     */
    private String artContent;
    /**
     * 文章上传时间
     */
    private String artTime;

    public Article() {
    }
    /**
     *文章构造函数
     * @param stuId 学生姓名
     * @param artTitle 标题
     * @param artContent 内容
     * @param artTime 发布时间
     */
    public Article(String stuId, String artTitle, String artContent, String artTime) {
        this.stuId = stuId;
        this.artTitle = artTitle;
        this.artContent = artContent;
        this.artTime = artTime;
    }

    /**
     *文章构造函数
     * @param artId 文章id
     * @param stuId 作者学号
     * @param artTitle 文章标题
     * @param artContent 文章内容
     * @param artTime 文章上传时间
     */
    public Article(String artId, String stuId, String artTitle, String artContent, String artTime) {
        setArtId(artId);
        this.stuId = stuId;
        this.artTitle = artTitle;
        this.artContent = artContent;
        this.artTime = artTime;
    }

    public String getArtId() {
        return Integer.toString(artId);
    }

    public void setArtId(String artId) {
        this.artId = Integer.parseInt(artId);
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    public String getArtTime() {
        return artTime;
    }

    public void setArtTime(String artTime) {
        this.artTime = artTime;
    }
}
