package com.xhdsj.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    private Integer startRow;
    private Integer pageSize;
    private String mytext;

    public String getMytext() {
        return mytext;
    }

    public void setMytext(String mytext) {
        this.mytext = mytext;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", "%"+value+"%", "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Short value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Short value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Short value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Short value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Short value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Short> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Short> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Short value1, Short value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Short value1, Short value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlIsNull() {
            addCriterion("crawling_url is null");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlIsNotNull() {
            addCriterion("crawling_url is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlEqualTo(String value) {
            addCriterion("crawling_url =", value, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlNotEqualTo(String value) {
            addCriterion("crawling_url <>", value, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlGreaterThan(String value) {
            addCriterion("crawling_url >", value, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlGreaterThanOrEqualTo(String value) {
            addCriterion("crawling_url >=", value, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlLessThan(String value) {
            addCriterion("crawling_url <", value, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlLessThanOrEqualTo(String value) {
            addCriterion("crawling_url <=", value, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlLike(String value) {
            addCriterion("crawling_url like", value, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlNotLike(String value) {
            addCriterion("crawling_url not like", value, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlIn(List<String> values) {
            addCriterion("crawling_url in", values, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlNotIn(List<String> values) {
            addCriterion("crawling_url not in", values, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlBetween(String value1, String value2) {
            addCriterion("crawling_url between", value1, value2, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingUrlNotBetween(String value1, String value2) {
            addCriterion("crawling_url not between", value1, value2, "crawlingUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdIsNull() {
            addCriterion("crawling_id is null");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdIsNotNull() {
            addCriterion("crawling_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdEqualTo(Short value) {
            addCriterion("crawling_id =", value, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdNotEqualTo(Short value) {
            addCriterion("crawling_id <>", value, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdGreaterThan(Short value) {
            addCriterion("crawling_id >", value, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdGreaterThanOrEqualTo(Short value) {
            addCriterion("crawling_id >=", value, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdLessThan(Short value) {
            addCriterion("crawling_id <", value, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdLessThanOrEqualTo(Short value) {
            addCriterion("crawling_id <=", value, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdIn(List<Short> values) {
            addCriterion("crawling_id in", values, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdNotIn(List<Short> values) {
            addCriterion("crawling_id not in", values, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdBetween(Short value1, Short value2) {
            addCriterion("crawling_id between", value1, value2, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingIdNotBetween(Short value1, Short value2) {
            addCriterion("crawling_id not between", value1, value2, "crawlingId");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeIsNull() {
            addCriterion("crawling_time is null");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeIsNotNull() {
            addCriterion("crawling_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeEqualTo(Date value) {
            addCriterion("crawling_time =", value, "crawlingTime");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeNotEqualTo(Date value) {
            addCriterion("crawling_time <>", value, "crawlingTime");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeGreaterThan(Date value) {
            addCriterion("crawling_time >", value, "crawlingTime");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("crawling_time >=", value, "crawlingTime");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeLessThan(Date value) {
            addCriterion("crawling_time <", value, "crawlingTime");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeLessThanOrEqualTo(Date value) {
            addCriterion("crawling_time <=", value, "crawlingTime");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeIn(List<Date> values) {
            addCriterion("crawling_time in", values, "crawlingTime");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeNotIn(List<Date> values) {
            addCriterion("crawling_time not in", values, "crawlingTime");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeBetween(Date value1, Date value2) {
            addCriterion("crawling_time between", value1, value2, "crawlingTime");
            return (Criteria) this;
        }

        public Criteria andCrawlingTimeNotBetween(Date value1, Date value2) {
            addCriterion("crawling_time not between", value1, value2, "crawlingTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}