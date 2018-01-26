package net.northking.cloudplatform.domain.testexecute;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CltTestCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CltTestCaseExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNull() {
            addCriterion("LAST_MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            addCriterion("LAST_MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            addCriterion("LAST_MODIFY_TIME >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            addCriterion("LAST_MODIFY_TIME <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFY_TIME <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            addCriterion("LAST_MODIFY_TIME in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            addCriterion("LAST_MODIFY_TIME not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFY_TIME between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFY_TIME not between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifierIsNull() {
            addCriterion("LAST_MODIFIER is null");
            return (Criteria) this;
        }

        public Criteria andLastModifierIsNotNull() {
            addCriterion("LAST_MODIFIER is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifierEqualTo(String value) {
            addCriterion("LAST_MODIFIER =", value, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierNotEqualTo(String value) {
            addCriterion("LAST_MODIFIER <>", value, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierGreaterThan(String value) {
            addCriterion("LAST_MODIFIER >", value, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFIER >=", value, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierLessThan(String value) {
            addCriterion("LAST_MODIFIER <", value, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierLessThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFIER <=", value, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierLike(String value) {
            addCriterion("LAST_MODIFIER like", value, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierNotLike(String value) {
            addCriterion("LAST_MODIFIER not like", value, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierIn(List<String> values) {
            addCriterion("LAST_MODIFIER in", values, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierNotIn(List<String> values) {
            addCriterion("LAST_MODIFIER not in", values, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierBetween(String value1, String value2) {
            addCriterion("LAST_MODIFIER between", value1, value2, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLastModifierNotBetween(String value1, String value2) {
            addCriterion("LAST_MODIFIER not between", value1, value2, "lastModifier");
            return (Criteria) this;
        }

        public Criteria andLogicDelIsNull() {
            addCriterion("LOGIC_DEL is null");
            return (Criteria) this;
        }

        public Criteria andLogicDelIsNotNull() {
            addCriterion("LOGIC_DEL is not null");
            return (Criteria) this;
        }

        public Criteria andLogicDelEqualTo(String value) {
            addCriterion("LOGIC_DEL =", value, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelNotEqualTo(String value) {
            addCriterion("LOGIC_DEL <>", value, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelGreaterThan(String value) {
            addCriterion("LOGIC_DEL >", value, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIC_DEL >=", value, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelLessThan(String value) {
            addCriterion("LOGIC_DEL <", value, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelLessThanOrEqualTo(String value) {
            addCriterion("LOGIC_DEL <=", value, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelLike(String value) {
            addCriterion("LOGIC_DEL like", value, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelNotLike(String value) {
            addCriterion("LOGIC_DEL not like", value, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelIn(List<String> values) {
            addCriterion("LOGIC_DEL in", values, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelNotIn(List<String> values) {
            addCriterion("LOGIC_DEL not in", values, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelBetween(String value1, String value2) {
            addCriterion("LOGIC_DEL between", value1, value2, "logicDel");
            return (Criteria) this;
        }

        public Criteria andLogicDelNotBetween(String value1, String value2) {
            addCriterion("LOGIC_DEL not between", value1, value2, "logicDel");
            return (Criteria) this;
        }

        public Criteria andDemIdIsNull() {
            addCriterion("DEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andDemIdIsNotNull() {
            addCriterion("DEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDemIdEqualTo(String value) {
            addCriterion("DEM_ID =", value, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdNotEqualTo(String value) {
            addCriterion("DEM_ID <>", value, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdGreaterThan(String value) {
            addCriterion("DEM_ID >", value, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEM_ID >=", value, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdLessThan(String value) {
            addCriterion("DEM_ID <", value, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdLessThanOrEqualTo(String value) {
            addCriterion("DEM_ID <=", value, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdLike(String value) {
            addCriterion("DEM_ID like", value, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdNotLike(String value) {
            addCriterion("DEM_ID not like", value, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdIn(List<String> values) {
            addCriterion("DEM_ID in", values, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdNotIn(List<String> values) {
            addCriterion("DEM_ID not in", values, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdBetween(String value1, String value2) {
            addCriterion("DEM_ID between", value1, value2, "demId");
            return (Criteria) this;
        }

        public Criteria andDemIdNotBetween(String value1, String value2) {
            addCriterion("DEM_ID not between", value1, value2, "demId");
            return (Criteria) this;
        }

        public Criteria andProjIdIsNull() {
            addCriterion("PROJ_ID is null");
            return (Criteria) this;
        }

        public Criteria andProjIdIsNotNull() {
            addCriterion("PROJ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProjIdEqualTo(String value) {
            addCriterion("PROJ_ID =", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdNotEqualTo(String value) {
            addCriterion("PROJ_ID <>", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdGreaterThan(String value) {
            addCriterion("PROJ_ID >", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROJ_ID >=", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdLessThan(String value) {
            addCriterion("PROJ_ID <", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdLessThanOrEqualTo(String value) {
            addCriterion("PROJ_ID <=", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdLike(String value) {
            addCriterion("PROJ_ID like", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdNotLike(String value) {
            addCriterion("PROJ_ID not like", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdIn(List<String> values) {
            addCriterion("PROJ_ID in", values, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdNotIn(List<String> values) {
            addCriterion("PROJ_ID not in", values, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdBetween(String value1, String value2) {
            addCriterion("PROJ_ID between", value1, value2, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdNotBetween(String value1, String value2) {
            addCriterion("PROJ_ID not between", value1, value2, "projId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("TASK_ID =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("TASK_ID >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("TASK_ID <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("TASK_ID like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("TASK_ID not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("TASK_ID in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andModuleIsNull() {
            addCriterion("MODULE is null");
            return (Criteria) this;
        }

        public Criteria andModuleIsNotNull() {
            addCriterion("MODULE is not null");
            return (Criteria) this;
        }

        public Criteria andModuleEqualTo(String value) {
            addCriterion("MODULE =", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotEqualTo(String value) {
            addCriterion("MODULE <>", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThan(String value) {
            addCriterion("MODULE >", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE >=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThan(String value) {
            addCriterion("MODULE <", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThanOrEqualTo(String value) {
            addCriterion("MODULE <=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLike(String value) {
            addCriterion("MODULE like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotLike(String value) {
            addCriterion("MODULE not like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleIn(List<String> values) {
            addCriterion("MODULE in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotIn(List<String> values) {
            addCriterion("MODULE not in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleBetween(String value1, String value2) {
            addCriterion("MODULE between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotBetween(String value1, String value2) {
            addCriterion("MODULE not between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andFuncIsNull() {
            addCriterion("FUNC is null");
            return (Criteria) this;
        }

        public Criteria andFuncIsNotNull() {
            addCriterion("FUNC is not null");
            return (Criteria) this;
        }

        public Criteria andFuncEqualTo(String value) {
            addCriterion("FUNC =", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncNotEqualTo(String value) {
            addCriterion("FUNC <>", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncGreaterThan(String value) {
            addCriterion("FUNC >", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC >=", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncLessThan(String value) {
            addCriterion("FUNC <", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncLessThanOrEqualTo(String value) {
            addCriterion("FUNC <=", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncLike(String value) {
            addCriterion("FUNC like", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncNotLike(String value) {
            addCriterion("FUNC not like", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncIn(List<String> values) {
            addCriterion("FUNC in", values, "func");
            return (Criteria) this;
        }

        public Criteria andFuncNotIn(List<String> values) {
            addCriterion("FUNC not in", values, "func");
            return (Criteria) this;
        }

        public Criteria andFuncBetween(String value1, String value2) {
            addCriterion("FUNC between", value1, value2, "func");
            return (Criteria) this;
        }

        public Criteria andFuncNotBetween(String value1, String value2) {
            addCriterion("FUNC not between", value1, value2, "func");
            return (Criteria) this;
        }

        public Criteria andSubFuncIsNull() {
            addCriterion("SUB_FUNC is null");
            return (Criteria) this;
        }

        public Criteria andSubFuncIsNotNull() {
            addCriterion("SUB_FUNC is not null");
            return (Criteria) this;
        }

        public Criteria andSubFuncEqualTo(String value) {
            addCriterion("SUB_FUNC =", value, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncNotEqualTo(String value) {
            addCriterion("SUB_FUNC <>", value, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncGreaterThan(String value) {
            addCriterion("SUB_FUNC >", value, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_FUNC >=", value, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncLessThan(String value) {
            addCriterion("SUB_FUNC <", value, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncLessThanOrEqualTo(String value) {
            addCriterion("SUB_FUNC <=", value, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncLike(String value) {
            addCriterion("SUB_FUNC like", value, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncNotLike(String value) {
            addCriterion("SUB_FUNC not like", value, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncIn(List<String> values) {
            addCriterion("SUB_FUNC in", values, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncNotIn(List<String> values) {
            addCriterion("SUB_FUNC not in", values, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncBetween(String value1, String value2) {
            addCriterion("SUB_FUNC between", value1, value2, "subFunc");
            return (Criteria) this;
        }

        public Criteria andSubFuncNotBetween(String value1, String value2) {
            addCriterion("SUB_FUNC not between", value1, value2, "subFunc");
            return (Criteria) this;
        }

        public Criteria andTestItemIsNull() {
            addCriterion("TEST_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andTestItemIsNotNull() {
            addCriterion("TEST_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andTestItemEqualTo(String value) {
            addCriterion("TEST_ITEM =", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotEqualTo(String value) {
            addCriterion("TEST_ITEM <>", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemGreaterThan(String value) {
            addCriterion("TEST_ITEM >", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_ITEM >=", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLessThan(String value) {
            addCriterion("TEST_ITEM <", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLessThanOrEqualTo(String value) {
            addCriterion("TEST_ITEM <=", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLike(String value) {
            addCriterion("TEST_ITEM like", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotLike(String value) {
            addCriterion("TEST_ITEM not like", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemIn(List<String> values) {
            addCriterion("TEST_ITEM in", values, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotIn(List<String> values) {
            addCriterion("TEST_ITEM not in", values, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemBetween(String value1, String value2) {
            addCriterion("TEST_ITEM between", value1, value2, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotBetween(String value1, String value2) {
            addCriterion("TEST_ITEM not between", value1, value2, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestPointIsNull() {
            addCriterion("TEST_POINT is null");
            return (Criteria) this;
        }

        public Criteria andTestPointIsNotNull() {
            addCriterion("TEST_POINT is not null");
            return (Criteria) this;
        }

        public Criteria andTestPointEqualTo(String value) {
            addCriterion("TEST_POINT =", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointNotEqualTo(String value) {
            addCriterion("TEST_POINT <>", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointGreaterThan(String value) {
            addCriterion("TEST_POINT >", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_POINT >=", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointLessThan(String value) {
            addCriterion("TEST_POINT <", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointLessThanOrEqualTo(String value) {
            addCriterion("TEST_POINT <=", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointLike(String value) {
            addCriterion("TEST_POINT like", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointNotLike(String value) {
            addCriterion("TEST_POINT not like", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointIn(List<String> values) {
            addCriterion("TEST_POINT in", values, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointNotIn(List<String> values) {
            addCriterion("TEST_POINT not in", values, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointBetween(String value1, String value2) {
            addCriterion("TEST_POINT between", value1, value2, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointNotBetween(String value1, String value2) {
            addCriterion("TEST_POINT not between", value1, value2, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestTypeIsNull() {
            addCriterion("TEST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTestTypeIsNotNull() {
            addCriterion("TEST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTestTypeEqualTo(String value) {
            addCriterion("TEST_TYPE =", value, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeNotEqualTo(String value) {
            addCriterion("TEST_TYPE <>", value, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeGreaterThan(String value) {
            addCriterion("TEST_TYPE >", value, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_TYPE >=", value, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeLessThan(String value) {
            addCriterion("TEST_TYPE <", value, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeLessThanOrEqualTo(String value) {
            addCriterion("TEST_TYPE <=", value, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeLike(String value) {
            addCriterion("TEST_TYPE like", value, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeNotLike(String value) {
            addCriterion("TEST_TYPE not like", value, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeIn(List<String> values) {
            addCriterion("TEST_TYPE in", values, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeNotIn(List<String> values) {
            addCriterion("TEST_TYPE not in", values, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeBetween(String value1, String value2) {
            addCriterion("TEST_TYPE between", value1, value2, "testType");
            return (Criteria) this;
        }

        public Criteria andTestTypeNotBetween(String value1, String value2) {
            addCriterion("TEST_TYPE not between", value1, value2, "testType");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("PRIORITY =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("PRIORITY <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("PRIORITY >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRIORITY >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("PRIORITY <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("PRIORITY <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("PRIORITY in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("PRIORITY not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("PRIORITY between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("PRIORITY not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andRoundIsNull() {
            addCriterion("ROUND is null");
            return (Criteria) this;
        }

        public Criteria andRoundIsNotNull() {
            addCriterion("ROUND is not null");
            return (Criteria) this;
        }

        public Criteria andRoundEqualTo(String value) {
            addCriterion("ROUND =", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotEqualTo(String value) {
            addCriterion("ROUND <>", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThan(String value) {
            addCriterion("ROUND >", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundGreaterThanOrEqualTo(String value) {
            addCriterion("ROUND >=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThan(String value) {
            addCriterion("ROUND <", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLessThanOrEqualTo(String value) {
            addCriterion("ROUND <=", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundLike(String value) {
            addCriterion("ROUND like", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotLike(String value) {
            addCriterion("ROUND not like", value, "round");
            return (Criteria) this;
        }

        public Criteria andRoundIn(List<String> values) {
            addCriterion("ROUND in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotIn(List<String> values) {
            addCriterion("ROUND not in", values, "round");
            return (Criteria) this;
        }

        public Criteria andRoundBetween(String value1, String value2) {
            addCriterion("ROUND between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andRoundNotBetween(String value1, String value2) {
            addCriterion("ROUND not between", value1, value2, "round");
            return (Criteria) this;
        }

        public Criteria andPlanDateIsNull() {
            addCriterion("PLAN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPlanDateIsNotNull() {
            addCriterion("PLAN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDateEqualTo(Date value) {
            addCriterionForJDBCDate("PLAN_DATE =", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PLAN_DATE <>", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateGreaterThan(Date value) {
            addCriterionForJDBCDate("PLAN_DATE >", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PLAN_DATE >=", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateLessThan(Date value) {
            addCriterionForJDBCDate("PLAN_DATE <", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PLAN_DATE <=", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateIn(List<Date> values) {
            addCriterionForJDBCDate("PLAN_DATE in", values, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PLAN_DATE not in", values, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PLAN_DATE between", value1, value2, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PLAN_DATE not between", value1, value2, "planDate");
            return (Criteria) this;
        }

        public Criteria andUseRobotIsNull() {
            addCriterion("USE_ROBOT is null");
            return (Criteria) this;
        }

        public Criteria andUseRobotIsNotNull() {
            addCriterion("USE_ROBOT is not null");
            return (Criteria) this;
        }

        public Criteria andUseRobotEqualTo(String value) {
            addCriterion("USE_ROBOT =", value, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotNotEqualTo(String value) {
            addCriterion("USE_ROBOT <>", value, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotGreaterThan(String value) {
            addCriterion("USE_ROBOT >", value, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotGreaterThanOrEqualTo(String value) {
            addCriterion("USE_ROBOT >=", value, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotLessThan(String value) {
            addCriterion("USE_ROBOT <", value, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotLessThanOrEqualTo(String value) {
            addCriterion("USE_ROBOT <=", value, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotLike(String value) {
            addCriterion("USE_ROBOT like", value, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotNotLike(String value) {
            addCriterion("USE_ROBOT not like", value, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotIn(List<String> values) {
            addCriterion("USE_ROBOT in", values, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotNotIn(List<String> values) {
            addCriterion("USE_ROBOT not in", values, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotBetween(String value1, String value2) {
            addCriterion("USE_ROBOT between", value1, value2, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUseRobotNotBetween(String value1, String value2) {
            addCriterion("USE_ROBOT not between", value1, value2, "useRobot");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1IsNull() {
            addCriterion("USER_DEFINED_IDX1 is null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1IsNotNull() {
            addCriterion("USER_DEFINED_IDX1 is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1EqualTo(String value) {
            addCriterion("USER_DEFINED_IDX1 =", value, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1NotEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX1 <>", value, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1GreaterThan(String value) {
            addCriterion("USER_DEFINED_IDX1 >", value, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1GreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX1 >=", value, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1LessThan(String value) {
            addCriterion("USER_DEFINED_IDX1 <", value, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1LessThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX1 <=", value, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1Like(String value) {
            addCriterion("USER_DEFINED_IDX1 like", value, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1NotLike(String value) {
            addCriterion("USER_DEFINED_IDX1 not like", value, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1In(List<String> values) {
            addCriterion("USER_DEFINED_IDX1 in", values, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1NotIn(List<String> values) {
            addCriterion("USER_DEFINED_IDX1 not in", values, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1Between(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX1 between", value1, value2, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx1NotBetween(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX1 not between", value1, value2, "userDefinedIdx1");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2IsNull() {
            addCriterion("USER_DEFINED_IDX2 is null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2IsNotNull() {
            addCriterion("USER_DEFINED_IDX2 is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2EqualTo(String value) {
            addCriterion("USER_DEFINED_IDX2 =", value, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2NotEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX2 <>", value, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2GreaterThan(String value) {
            addCriterion("USER_DEFINED_IDX2 >", value, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2GreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX2 >=", value, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2LessThan(String value) {
            addCriterion("USER_DEFINED_IDX2 <", value, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2LessThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX2 <=", value, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2Like(String value) {
            addCriterion("USER_DEFINED_IDX2 like", value, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2NotLike(String value) {
            addCriterion("USER_DEFINED_IDX2 not like", value, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2In(List<String> values) {
            addCriterion("USER_DEFINED_IDX2 in", values, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2NotIn(List<String> values) {
            addCriterion("USER_DEFINED_IDX2 not in", values, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2Between(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX2 between", value1, value2, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx2NotBetween(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX2 not between", value1, value2, "userDefinedIdx2");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3IsNull() {
            addCriterion("USER_DEFINED_IDX3 is null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3IsNotNull() {
            addCriterion("USER_DEFINED_IDX3 is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3EqualTo(String value) {
            addCriterion("USER_DEFINED_IDX3 =", value, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3NotEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX3 <>", value, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3GreaterThan(String value) {
            addCriterion("USER_DEFINED_IDX3 >", value, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3GreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX3 >=", value, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3LessThan(String value) {
            addCriterion("USER_DEFINED_IDX3 <", value, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3LessThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX3 <=", value, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3Like(String value) {
            addCriterion("USER_DEFINED_IDX3 like", value, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3NotLike(String value) {
            addCriterion("USER_DEFINED_IDX3 not like", value, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3In(List<String> values) {
            addCriterion("USER_DEFINED_IDX3 in", values, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3NotIn(List<String> values) {
            addCriterion("USER_DEFINED_IDX3 not in", values, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3Between(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX3 between", value1, value2, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx3NotBetween(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX3 not between", value1, value2, "userDefinedIdx3");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4IsNull() {
            addCriterion("USER_DEFINED_IDX4 is null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4IsNotNull() {
            addCriterion("USER_DEFINED_IDX4 is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4EqualTo(String value) {
            addCriterion("USER_DEFINED_IDX4 =", value, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4NotEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX4 <>", value, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4GreaterThan(String value) {
            addCriterion("USER_DEFINED_IDX4 >", value, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4GreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX4 >=", value, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4LessThan(String value) {
            addCriterion("USER_DEFINED_IDX4 <", value, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4LessThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX4 <=", value, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4Like(String value) {
            addCriterion("USER_DEFINED_IDX4 like", value, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4NotLike(String value) {
            addCriterion("USER_DEFINED_IDX4 not like", value, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4In(List<String> values) {
            addCriterion("USER_DEFINED_IDX4 in", values, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4NotIn(List<String> values) {
            addCriterion("USER_DEFINED_IDX4 not in", values, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4Between(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX4 between", value1, value2, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx4NotBetween(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX4 not between", value1, value2, "userDefinedIdx4");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5IsNull() {
            addCriterion("USER_DEFINED_IDX5 is null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5IsNotNull() {
            addCriterion("USER_DEFINED_IDX5 is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5EqualTo(String value) {
            addCriterion("USER_DEFINED_IDX5 =", value, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5NotEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX5 <>", value, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5GreaterThan(String value) {
            addCriterion("USER_DEFINED_IDX5 >", value, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5GreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX5 >=", value, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5LessThan(String value) {
            addCriterion("USER_DEFINED_IDX5 <", value, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5LessThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX5 <=", value, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5Like(String value) {
            addCriterion("USER_DEFINED_IDX5 like", value, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5NotLike(String value) {
            addCriterion("USER_DEFINED_IDX5 not like", value, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5In(List<String> values) {
            addCriterion("USER_DEFINED_IDX5 in", values, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5NotIn(List<String> values) {
            addCriterion("USER_DEFINED_IDX5 not in", values, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5Between(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX5 between", value1, value2, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx5NotBetween(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX5 not between", value1, value2, "userDefinedIdx5");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6IsNull() {
            addCriterion("USER_DEFINED_IDX6 is null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6IsNotNull() {
            addCriterion("USER_DEFINED_IDX6 is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6EqualTo(String value) {
            addCriterion("USER_DEFINED_IDX6 =", value, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6NotEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX6 <>", value, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6GreaterThan(String value) {
            addCriterion("USER_DEFINED_IDX6 >", value, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6GreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX6 >=", value, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6LessThan(String value) {
            addCriterion("USER_DEFINED_IDX6 <", value, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6LessThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX6 <=", value, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6Like(String value) {
            addCriterion("USER_DEFINED_IDX6 like", value, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6NotLike(String value) {
            addCriterion("USER_DEFINED_IDX6 not like", value, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6In(List<String> values) {
            addCriterion("USER_DEFINED_IDX6 in", values, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6NotIn(List<String> values) {
            addCriterion("USER_DEFINED_IDX6 not in", values, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6Between(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX6 between", value1, value2, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx6NotBetween(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX6 not between", value1, value2, "userDefinedIdx6");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7IsNull() {
            addCriterion("USER_DEFINED_IDX7 is null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7IsNotNull() {
            addCriterion("USER_DEFINED_IDX7 is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7EqualTo(String value) {
            addCriterion("USER_DEFINED_IDX7 =", value, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7NotEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX7 <>", value, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7GreaterThan(String value) {
            addCriterion("USER_DEFINED_IDX7 >", value, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7GreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX7 >=", value, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7LessThan(String value) {
            addCriterion("USER_DEFINED_IDX7 <", value, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7LessThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX7 <=", value, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7Like(String value) {
            addCriterion("USER_DEFINED_IDX7 like", value, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7NotLike(String value) {
            addCriterion("USER_DEFINED_IDX7 not like", value, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7In(List<String> values) {
            addCriterion("USER_DEFINED_IDX7 in", values, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7NotIn(List<String> values) {
            addCriterion("USER_DEFINED_IDX7 not in", values, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7Between(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX7 between", value1, value2, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx7NotBetween(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX7 not between", value1, value2, "userDefinedIdx7");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8IsNull() {
            addCriterion("USER_DEFINED_IDX8 is null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8IsNotNull() {
            addCriterion("USER_DEFINED_IDX8 is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8EqualTo(String value) {
            addCriterion("USER_DEFINED_IDX8 =", value, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8NotEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX8 <>", value, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8GreaterThan(String value) {
            addCriterion("USER_DEFINED_IDX8 >", value, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8GreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX8 >=", value, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8LessThan(String value) {
            addCriterion("USER_DEFINED_IDX8 <", value, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8LessThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX8 <=", value, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8Like(String value) {
            addCriterion("USER_DEFINED_IDX8 like", value, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8NotLike(String value) {
            addCriterion("USER_DEFINED_IDX8 not like", value, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8In(List<String> values) {
            addCriterion("USER_DEFINED_IDX8 in", values, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8NotIn(List<String> values) {
            addCriterion("USER_DEFINED_IDX8 not in", values, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8Between(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX8 between", value1, value2, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx8NotBetween(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX8 not between", value1, value2, "userDefinedIdx8");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9IsNull() {
            addCriterion("USER_DEFINED_IDX9 is null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9IsNotNull() {
            addCriterion("USER_DEFINED_IDX9 is not null");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9EqualTo(String value) {
            addCriterion("USER_DEFINED_IDX9 =", value, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9NotEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX9 <>", value, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9GreaterThan(String value) {
            addCriterion("USER_DEFINED_IDX9 >", value, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9GreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX9 >=", value, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9LessThan(String value) {
            addCriterion("USER_DEFINED_IDX9 <", value, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9LessThanOrEqualTo(String value) {
            addCriterion("USER_DEFINED_IDX9 <=", value, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9Like(String value) {
            addCriterion("USER_DEFINED_IDX9 like", value, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9NotLike(String value) {
            addCriterion("USER_DEFINED_IDX9 not like", value, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9In(List<String> values) {
            addCriterion("USER_DEFINED_IDX9 in", values, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9NotIn(List<String> values) {
            addCriterion("USER_DEFINED_IDX9 not in", values, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9Between(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX9 between", value1, value2, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andUserDefinedIdx9NotBetween(String value1, String value2) {
            addCriterion("USER_DEFINED_IDX9 not between", value1, value2, "userDefinedIdx9");
            return (Criteria) this;
        }

        public Criteria andAlgomIsNull() {
            addCriterion("ALGOM is null");
            return (Criteria) this;
        }

        public Criteria andAlgomIsNotNull() {
            addCriterion("ALGOM is not null");
            return (Criteria) this;
        }

        public Criteria andAlgomEqualTo(String value) {
            addCriterion("ALGOM =", value, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomNotEqualTo(String value) {
            addCriterion("ALGOM <>", value, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomGreaterThan(String value) {
            addCriterion("ALGOM >", value, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomGreaterThanOrEqualTo(String value) {
            addCriterion("ALGOM >=", value, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomLessThan(String value) {
            addCriterion("ALGOM <", value, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomLessThanOrEqualTo(String value) {
            addCriterion("ALGOM <=", value, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomLike(String value) {
            addCriterion("ALGOM like", value, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomNotLike(String value) {
            addCriterion("ALGOM not like", value, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomIn(List<String> values) {
            addCriterion("ALGOM in", values, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomNotIn(List<String> values) {
            addCriterion("ALGOM not in", values, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomBetween(String value1, String value2) {
            addCriterion("ALGOM between", value1, value2, "algom");
            return (Criteria) this;
        }

        public Criteria andAlgomNotBetween(String value1, String value2) {
            addCriterion("ALGOM not between", value1, value2, "algom");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("STEP is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("STEP is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(String value) {
            addCriterion("STEP =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(String value) {
            addCriterion("STEP <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(String value) {
            addCriterion("STEP >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(String value) {
            addCriterion("STEP >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(String value) {
            addCriterion("STEP <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(String value) {
            addCriterion("STEP <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLike(String value) {
            addCriterion("STEP like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotLike(String value) {
            addCriterion("STEP not like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<String> values) {
            addCriterion("STEP in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<String> values) {
            addCriterion("STEP not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(String value1, String value2) {
            addCriterion("STEP between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(String value1, String value2) {
            addCriterion("STEP not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andPreResultIsNull() {
            addCriterion("PRE_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andPreResultIsNotNull() {
            addCriterion("PRE_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andPreResultEqualTo(String value) {
            addCriterion("PRE_RESULT =", value, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultNotEqualTo(String value) {
            addCriterion("PRE_RESULT <>", value, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultGreaterThan(String value) {
            addCriterion("PRE_RESULT >", value, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultGreaterThanOrEqualTo(String value) {
            addCriterion("PRE_RESULT >=", value, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultLessThan(String value) {
            addCriterion("PRE_RESULT <", value, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultLessThanOrEqualTo(String value) {
            addCriterion("PRE_RESULT <=", value, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultLike(String value) {
            addCriterion("PRE_RESULT like", value, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultNotLike(String value) {
            addCriterion("PRE_RESULT not like", value, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultIn(List<String> values) {
            addCriterion("PRE_RESULT in", values, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultNotIn(List<String> values) {
            addCriterion("PRE_RESULT not in", values, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultBetween(String value1, String value2) {
            addCriterion("PRE_RESULT between", value1, value2, "preResult");
            return (Criteria) this;
        }

        public Criteria andPreResultNotBetween(String value1, String value2) {
            addCriterion("PRE_RESULT not between", value1, value2, "preResult");
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