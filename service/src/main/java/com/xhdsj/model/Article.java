package com.xhdsj.model;

import com.xhdsj.model.sup.Scode;

import java.util.Date;

/**
 * 功能描述: 文章类
 *
 * @auther: njw
 * @date: 2018/4/19
 */

public class Article extends Scode {

    private Integer id;

    private String title;

    private String content;

    private Date createTime;

    private Date publishTime;

    private Short deleteFlag;

    private String crawlingUrl;

    private Short crawlingId;

    private Date crawlingTime;

    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCrawlingUrl() {
        return crawlingUrl;
    }

    public void setCrawlingUrl(String crawlingUrl) {
        this.crawlingUrl = crawlingUrl == null ? null : crawlingUrl.trim();
    }

    public Short getCrawlingId() {
        return crawlingId;
    }

    public void setCrawlingId(Short crawlingId) {
        this.crawlingId = crawlingId;
    }

    public Date getCrawlingTime() {
        return crawlingTime;
    }

    public void setCrawlingTime(Date crawlingTime) {
        this.crawlingTime = crawlingTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }



}