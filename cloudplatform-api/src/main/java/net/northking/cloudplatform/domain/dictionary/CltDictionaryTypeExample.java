package net.northking.cloudplatform.domain.dictionary;

import java.util.ArrayList;
import java.util.List;

public class CltDictionaryTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CltDictionaryTypeExample() {
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

        public Criteria andTypeIdIsNull() {
            addCriterion("TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("TYPE_ID =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("TYPE_ID <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("TYPE_ID >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_ID >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("TYPE_ID <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("TYPE_ID <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("TYPE_ID like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("TYPE_ID not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("TYPE_ID in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("TYPE_ID not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("TYPE_ID between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("TYPE_ID not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNull() {
            addCriterion("TYPE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNotNull() {
            addCriterion("TYPE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeEqualTo(String value) {
            addCriterion("TYPE_CODE =", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotEqualTo(String value) {
            addCriterion("TYPE_CODE <>", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThan(String value) {
            addCriterion("TYPE_CODE >", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_CODE >=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThan(String value) {
            addCriterion("TYPE_CODE <", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("TYPE_CODE <=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLike(String value) {
            addCriterion("TYPE_CODE like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotLike(String value) {
            addCriterion("TYPE_CODE not like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIn(List<String> values) {
            addCriterion("TYPE_CODE in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotIn(List<String> values) {
            addCriterion("TYPE_CODE not in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeBetween(String value1, String value2) {
            addCriterion("TYPE_CODE between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotBetween(String value1, String value2) {
            addCriterion("TYPE_CODE not between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("TYPE_NAME =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("TYPE_NAME <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("TYPE_NAME >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_NAME >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("TYPE_NAME <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("TYPE_NAME <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("TYPE_NAME like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("TYPE_NAME not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("TYPE_NAME in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("TYPE_NAME not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("TYPE_NAME between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("TYPE_NAME not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeScopeIsNull() {
            addCriterion("TYPE_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeScopeIsNotNull() {
            addCriterion("TYPE_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeScopeEqualTo(String value) {
            addCriterion("TYPE_SCOPE =", value, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeNotEqualTo(String value) {
            addCriterion("TYPE_SCOPE <>", value, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeGreaterThan(String value) {
            addCriterion("TYPE_SCOPE >", value, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_SCOPE >=", value, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeLessThan(String value) {
            addCriterion("TYPE_SCOPE <", value, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeLessThanOrEqualTo(String value) {
            addCriterion("TYPE_SCOPE <=", value, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeLike(String value) {
            addCriterion("TYPE_SCOPE like", value, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeNotLike(String value) {
            addCriterion("TYPE_SCOPE not like", value, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeIn(List<String> values) {
            addCriterion("TYPE_SCOPE in", values, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeNotIn(List<String> values) {
            addCriterion("TYPE_SCOPE not in", values, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeBetween(String value1, String value2) {
            addCriterion("TYPE_SCOPE between", value1, value2, "typeScope");
            return (Criteria) this;
        }

        public Criteria andTypeScopeNotBetween(String value1, String value2) {
            addCriterion("TYPE_SCOPE not between", value1, value2, "typeScope");
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