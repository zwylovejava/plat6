package net.northking.cloudplatform.domain.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CltProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CltProjectExample() {
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

        public Criteria andProIdIsNull() {
            addCriterion("PRO_ID is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("PRO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(String value) {
            addCriterion("PRO_ID =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(String value) {
            addCriterion("PRO_ID <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(String value) {
            addCriterion("PRO_ID >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRO_ID >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(String value) {
            addCriterion("PRO_ID <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(String value) {
            addCriterion("PRO_ID <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLike(String value) {
            addCriterion("PRO_ID like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotLike(String value) {
            addCriterion("PRO_ID not like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<String> values) {
            addCriterion("PRO_ID in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<String> values) {
            addCriterion("PRO_ID not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(String value1, String value2) {
            addCriterion("PRO_ID between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(String value1, String value2) {
            addCriterion("PRO_ID not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("PRO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("PRO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("PRO_NAME =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("PRO_NAME <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("PRO_NAME >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRO_NAME >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("PRO_NAME <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("PRO_NAME <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("PRO_NAME like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("PRO_NAME not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("PRO_NAME in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("PRO_NAME not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("PRO_NAME between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("PRO_NAME not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andTestManagerIsNull() {
            addCriterion("TEST_MANAGER is null");
            return (Criteria) this;
        }

        public Criteria andTestManagerIsNotNull() {
            addCriterion("TEST_MANAGER is not null");
            return (Criteria) this;
        }

        public Criteria andTestManagerEqualTo(String value) {
            addCriterion("TEST_MANAGER =", value, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerNotEqualTo(String value) {
            addCriterion("TEST_MANAGER <>", value, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerGreaterThan(String value) {
            addCriterion("TEST_MANAGER >", value, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_MANAGER >=", value, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerLessThan(String value) {
            addCriterion("TEST_MANAGER <", value, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerLessThanOrEqualTo(String value) {
            addCriterion("TEST_MANAGER <=", value, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerLike(String value) {
            addCriterion("TEST_MANAGER like", value, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerNotLike(String value) {
            addCriterion("TEST_MANAGER not like", value, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerIn(List<String> values) {
            addCriterion("TEST_MANAGER in", values, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerNotIn(List<String> values) {
            addCriterion("TEST_MANAGER not in", values, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerBetween(String value1, String value2) {
            addCriterion("TEST_MANAGER between", value1, value2, "testManager");
            return (Criteria) this;
        }

        public Criteria andTestManagerNotBetween(String value1, String value2) {
            addCriterion("TEST_MANAGER not between", value1, value2, "testManager");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNull() {
            addCriterion("PRO_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNotNull() {
            addCriterion("PRO_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeEqualTo(String value) {
            addCriterion("PRO_TYPE =", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotEqualTo(String value) {
            addCriterion("PRO_TYPE <>", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThan(String value) {
            addCriterion("PRO_TYPE >", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRO_TYPE >=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThan(String value) {
            addCriterion("PRO_TYPE <", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThanOrEqualTo(String value) {
            addCriterion("PRO_TYPE <=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLike(String value) {
            addCriterion("PRO_TYPE like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotLike(String value) {
            addCriterion("PRO_TYPE not like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeIn(List<String> values) {
            addCriterion("PRO_TYPE in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotIn(List<String> values) {
            addCriterion("PRO_TYPE not in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeBetween(String value1, String value2) {
            addCriterion("PRO_TYPE between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotBetween(String value1, String value2) {
            addCriterion("PRO_TYPE not between", value1, value2, "proType");
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

        public Criteria andTestPlanStartTimeIsNull() {
            addCriterion("TEST_PLAN_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeIsNotNull() {
            addCriterion("TEST_PLAN_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME =", value, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME <>", value, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME >", value, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME >=", value, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME <", value, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME <=", value, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME in", values, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME not in", values, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME between", value1, value2, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TEST_PLAN_START_TIME not between", value1, value2, "testPlanStartTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeIsNull() {
            addCriterion("TEST_PLAN_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeIsNotNull() {
            addCriterion("TEST_PLAN_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME =", value, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME <>", value, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME >", value, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME >=", value, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME <", value, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME <=", value, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME in", values, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME not in", values, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME between", value1, value2, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andTestPlanEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TEST_PLAN_END_TIME not between", value1, value2, "testPlanEndTime");
            return (Criteria) this;
        }

        public Criteria andProDescIsNull() {
            addCriterion("PRO_DESC is null");
            return (Criteria) this;
        }

        public Criteria andProDescIsNotNull() {
            addCriterion("PRO_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andProDescEqualTo(String value) {
            addCriterion("PRO_DESC =", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescNotEqualTo(String value) {
            addCriterion("PRO_DESC <>", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescGreaterThan(String value) {
            addCriterion("PRO_DESC >", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescGreaterThanOrEqualTo(String value) {
            addCriterion("PRO_DESC >=", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescLessThan(String value) {
            addCriterion("PRO_DESC <", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescLessThanOrEqualTo(String value) {
            addCriterion("PRO_DESC <=", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescLike(String value) {
            addCriterion("PRO_DESC like", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescNotLike(String value) {
            addCriterion("PRO_DESC not like", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescIn(List<String> values) {
            addCriterion("PRO_DESC in", values, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescNotIn(List<String> values) {
            addCriterion("PRO_DESC not in", values, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescBetween(String value1, String value2) {
            addCriterion("PRO_DESC between", value1, value2, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescNotBetween(String value1, String value2) {
            addCriterion("PRO_DESC not between", value1, value2, "proDesc");
            return (Criteria) this;
        }

        public Criteria andTestEnviIsNull() {
            addCriterion("TEST_ENVI is null");
            return (Criteria) this;
        }

        public Criteria andTestEnviIsNotNull() {
            addCriterion("TEST_ENVI is not null");
            return (Criteria) this;
        }

        public Criteria andTestEnviEqualTo(String value) {
            addCriterion("TEST_ENVI =", value, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviNotEqualTo(String value) {
            addCriterion("TEST_ENVI <>", value, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviGreaterThan(String value) {
            addCriterion("TEST_ENVI >", value, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_ENVI >=", value, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviLessThan(String value) {
            addCriterion("TEST_ENVI <", value, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviLessThanOrEqualTo(String value) {
            addCriterion("TEST_ENVI <=", value, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviLike(String value) {
            addCriterion("TEST_ENVI like", value, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviNotLike(String value) {
            addCriterion("TEST_ENVI not like", value, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviIn(List<String> values) {
            addCriterion("TEST_ENVI in", values, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviNotIn(List<String> values) {
            addCriterion("TEST_ENVI not in", values, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviBetween(String value1, String value2) {
            addCriterion("TEST_ENVI between", value1, value2, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andTestEnviNotBetween(String value1, String value2) {
            addCriterion("TEST_ENVI not between", value1, value2, "testEnvi");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrIsNull() {
            addCriterion("SYS_LINK_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrIsNotNull() {
            addCriterion("SYS_LINK_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrEqualTo(String value) {
            addCriterion("SYS_LINK_ADDR =", value, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrNotEqualTo(String value) {
            addCriterion("SYS_LINK_ADDR <>", value, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrGreaterThan(String value) {
            addCriterion("SYS_LINK_ADDR >", value, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_LINK_ADDR >=", value, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrLessThan(String value) {
            addCriterion("SYS_LINK_ADDR <", value, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrLessThanOrEqualTo(String value) {
            addCriterion("SYS_LINK_ADDR <=", value, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrLike(String value) {
            addCriterion("SYS_LINK_ADDR like", value, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrNotLike(String value) {
            addCriterion("SYS_LINK_ADDR not like", value, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrIn(List<String> values) {
            addCriterion("SYS_LINK_ADDR in", values, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrNotIn(List<String> values) {
            addCriterion("SYS_LINK_ADDR not in", values, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrBetween(String value1, String value2) {
            addCriterion("SYS_LINK_ADDR between", value1, value2, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andSysLinkAddrNotBetween(String value1, String value2) {
            addCriterion("SYS_LINK_ADDR not between", value1, value2, "sysLinkAddr");
            return (Criteria) this;
        }

        public Criteria andNeedAttachIsNull() {
            addCriterion("NEED_ATTACH is null");
            return (Criteria) this;
        }

        public Criteria andNeedAttachIsNotNull() {
            addCriterion("NEED_ATTACH is not null");
            return (Criteria) this;
        }

        public Criteria andNeedAttachEqualTo(String value) {
            addCriterion("NEED_ATTACH =", value, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachNotEqualTo(String value) {
            addCriterion("NEED_ATTACH <>", value, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachGreaterThan(String value) {
            addCriterion("NEED_ATTACH >", value, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachGreaterThanOrEqualTo(String value) {
            addCriterion("NEED_ATTACH >=", value, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachLessThan(String value) {
            addCriterion("NEED_ATTACH <", value, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachLessThanOrEqualTo(String value) {
            addCriterion("NEED_ATTACH <=", value, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachLike(String value) {
            addCriterion("NEED_ATTACH like", value, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachNotLike(String value) {
            addCriterion("NEED_ATTACH not like", value, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachIn(List<String> values) {
            addCriterion("NEED_ATTACH in", values, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachNotIn(List<String> values) {
            addCriterion("NEED_ATTACH not in", values, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachBetween(String value1, String value2) {
            addCriterion("NEED_ATTACH between", value1, value2, "needAttach");
            return (Criteria) this;
        }

        public Criteria andNeedAttachNotBetween(String value1, String value2) {
            addCriterion("NEED_ATTACH not between", value1, value2, "needAttach");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATE_USER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATE_USER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_DATE not between", value1, value2, "updateDate");
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