package tp.kits3.livedinner.vo;

import java.sql.Timestamp;

public class Post {

    private Integer pid;

    private String title;

    private String byname;

    private Timestamp regdate;

    private String content;

    private Boolean visible;

    private Integer tagid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getByname() {
        return byname;
    }

    public void setByname(String byname) {
        this.byname = byname;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    // Post 모델 복사
    public void CopyData(Post param)
    {
        this.pid = param.getPid();
        this.title = param.getTitle();
        this.byname = param.getByname();
        this.regdate = param.getRegdate();
        this.content = param.getContent();
        this.visible = param.getVisible();
        this.tagid = param.getTagid();
    }
}