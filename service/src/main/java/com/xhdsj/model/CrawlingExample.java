package com.xhdsj.model;

import java.util.ArrayList;
import java.util.List;

public class CrawlingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrawlingExample() {
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

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameIsNull() {
            addCriterion("crawling_name is null");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameIsNotNull() {
            addCriterion("crawling_name is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameEqualTo(Short value) {
            addCriterion("crawling_name =", value, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameNotEqualTo(Short value) {
            addCriterion("crawling_name <>", value, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameGreaterThan(Short value) {
            addCriterion("crawling_name >", value, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameGreaterThanOrEqualTo(Short value) {
            addCriterion("crawling_name >=", value, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameLessThan(Short value) {
            addCriterion("crawling_name <", value, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameLessThanOrEqualTo(Short value) {
            addCriterion("crawling_name <=", value, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameIn(List<Short> values) {
            addCriterion("crawling_name in", values, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameNotIn(List<Short> values) {
            addCriterion("crawling_name not in", values, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameBetween(Short value1, Short value2) {
            addCriterion("crawling_name between", value1, value2, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingNameNotBetween(Short value1, Short value2) {
            addCriterion("crawling_name not between", value1, value2, "crawlingName");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagIsNull() {
            addCriterion("crawling_flag is null");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagIsNotNull() {
            addCriterion("crawling_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagEqualTo(Short value) {
            addCriterion("crawling_flag =", value, "crawlingFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagNotEqualTo(Short value) {
            addCriterion("crawling_flag <>", value, "crawlingFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagGreaterThan(Short value) {
            addCriterion("crawling_flag >", value, "crawlingFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("crawling_flag >=", value, "crawlingFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagLessThan(Short value) {
            addCriterion("crawling_flag <", value, "crawlingFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagLessThanOrEqualTo(Short value) {
            addCriterion("crawling_flag <=", value, "crawlingFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagIn(List<Short> values) {
            addCriterion("crawling_flag in", values, "crawlingFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagNotIn(List<Short> values) {
            addCriterion("crawling_flag not in", values, "crawlingFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagBetween(Short value1, Short value2) {
            addCriterion("crawling_flag between", value1, value2, "crawlingFlag");
            return (Criteria) this;
        }

        public Criteria andCrawlingFlagNotBetween(Short value1, Short value2) {
            addCriterion("crawling_flag not between", value1, value2, "crawlingFlag");
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