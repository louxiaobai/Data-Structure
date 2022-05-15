package com.pojo;

import java.util.Date;

/**
 * @author lqw
 * @date 2021/10/9-8:12 ÏÂÎç
 */
public class Blog {
    private String id;
    private String title;
    private Date createTime;
    private String author;
    private int views;

    public Blog() {
    }

    public Blog(String id, String title, Date createTime, String author, int views) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
        this.author = author;
        this.views = views;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", author='" + author + '\'' +
                ", views=" + views +
                '}';
    }
}