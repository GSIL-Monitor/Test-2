package com.linkcircle.entity;

import java.util.ArrayList;
import java.util.List;

public class CtdDisplayNumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CtdDisplayNumExample() {
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

        public Criteria andDisplaynumIsNull() {
            addCriterion("displaynum is null");
            return (Criteria) this;
        }

        public Criteria andDisplaynumIsNotNull() {
            addCriterion("displaynum is not null");
            return (Criteria) this;
        }

        public Criteria andDisplaynumEqualTo(String value) {
            addCriterion("displaynum =", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumNotEqualTo(String value) {
            addCriterion("displaynum <>", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumGreaterThan(String value) {
            addCriterion("displaynum >", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumGreaterThanOrEqualTo(String value) {
            addCriterion("displaynum >=", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumLessThan(String value) {
            addCriterion("displaynum <", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumLessThanOrEqualTo(String value) {
            addCriterion("displaynum <=", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumLike(String value) {
            addCriterion("displaynum like", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumNotLike(String value) {
            addCriterion("displaynum not like", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumIn(List<String> values) {
            addCriterion("displaynum in", values, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumNotIn(List<String> values) {
            addCriterion("displaynum not in", values, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumBetween(String value1, String value2) {
            addCriterion("displaynum between", value1, value2, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumNotBetween(String value1, String value2) {
            addCriterion("displaynum not between", value1, value2, "displaynum");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNull() {
            addCriterion("areaCode is null");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNotNull() {
            addCriterion("areaCode is not null");
            return (Criteria) this;
        }

        public Criteria andAreacodeEqualTo(String value) {
            addCriterion("areaCode =", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotEqualTo(String value) {
            addCriterion("areaCode <>", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThan(String value) {
            addCriterion("areaCode >", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThanOrEqualTo(String value) {
            addCriterion("areaCode >=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThan(String value) {
            addCriterion("areaCode <", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThanOrEqualTo(String value) {
            addCriterion("areaCode <=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLike(String value) {
            addCriterion("areaCode like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotLike(String value) {
            addCriterion("areaCode not like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeIn(List<String> values) {
            addCriterion("areaCode in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotIn(List<String> values) {
            addCriterion("areaCode not in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeBetween(String value1, String value2) {
            addCriterion("areaCode between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotBetween(String value1, String value2) {
            addCriterion("areaCode not between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updateTime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updateTime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andVccidIsNull() {
            addCriterion("vccid is null");
            return (Criteria) this;
        }

        public Criteria andVccidIsNotNull() {
            addCriterion("vccid is not null");
            return (Criteria) this;
        }

        public Criteria andVccidEqualTo(String value) {
            addCriterion("vccid =", value, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidNotEqualTo(String value) {
            addCriterion("vccid <>", value, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidGreaterThan(String value) {
            addCriterion("vccid >", value, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidGreaterThanOrEqualTo(String value) {
            addCriterion("vccid >=", value, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidLessThan(String value) {
            addCriterion("vccid <", value, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidLessThanOrEqualTo(String value) {
            addCriterion("vccid <=", value, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidLike(String value) {
            addCriterion("vccid like", value, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidNotLike(String value) {
            addCriterion("vccid not like", value, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidIn(List<String> values) {
            addCriterion("vccid in", values, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidNotIn(List<String> values) {
            addCriterion("vccid not in", values, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidBetween(String value1, String value2) {
            addCriterion("vccid between", value1, value2, "vccid");
            return (Criteria) this;
        }

        public Criteria andVccidNotBetween(String value1, String value2) {
            addCriterion("vccid not between", value1, value2, "vccid");
            return (Criteria) this;
        }

        public Criteria andServicekeyIsNull() {
            addCriterion("servicekey is null");
            return (Criteria) this;
        }

        public Criteria andServicekeyIsNotNull() {
            addCriterion("servicekey is not null");
            return (Criteria) this;
        }

        public Criteria andServicekeyEqualTo(String value) {
            addCriterion("servicekey =", value, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyNotEqualTo(String value) {
            addCriterion("servicekey <>", value, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyGreaterThan(String value) {
            addCriterion("servicekey >", value, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyGreaterThanOrEqualTo(String value) {
            addCriterion("servicekey >=", value, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyLessThan(String value) {
            addCriterion("servicekey <", value, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyLessThanOrEqualTo(String value) {
            addCriterion("servicekey <=", value, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyLike(String value) {
            addCriterion("servicekey like", value, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyNotLike(String value) {
            addCriterion("servicekey not like", value, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyIn(List<String> values) {
            addCriterion("servicekey in", values, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyNotIn(List<String> values) {
            addCriterion("servicekey not in", values, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyBetween(String value1, String value2) {
            addCriterion("servicekey between", value1, value2, "servicekey");
            return (Criteria) this;
        }

        public Criteria andServicekeyNotBetween(String value1, String value2) {
            addCriterion("servicekey not between", value1, value2, "servicekey");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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