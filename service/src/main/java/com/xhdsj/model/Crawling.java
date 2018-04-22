package com.xhdsj.model;

public class Crawling {
    private Integer id;

    private Short deleteFlag;

    private String url;

    private String crawlingName;

    private Short crawlingFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getCrawlingName() {
        return crawlingName;
    }

    public void setCrawlingName(String crawlingName) {
        this.crawlingName = crawlingName;
    }

    public Short getCrawlingFlag() {
        return crawlingFlag;
    }

    public void setCrawlingFlag(Short crawlingFlag) {
        this.crawlingFlag = crawlingFlag;
    }
}