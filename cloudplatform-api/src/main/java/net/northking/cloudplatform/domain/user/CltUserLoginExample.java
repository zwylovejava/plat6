package net.northking.cloudplatform.domain.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CltUserLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CltUserLoginExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("USER_TYPE =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("USER_TYPE <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("USER_TYPE >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TYPE >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("USER_TYPE <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("USER_TYPE <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("USER_TYPE like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("USER_TYPE not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("USER_TYPE in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("USER_TYPE not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("USER_TYPE between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("USER_TYPE not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andLoginNoIsNull() {
            addCriterion("LOGIN_NO is null");
            return (Criteria) this;
        }

        public Criteria andLoginNoIsNotNull() {
            addCriterion("LOGIN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNoEqualTo(String value) {
            addCriterion("LOGIN_NO =", value, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoNotEqualTo(String value) {
            addCriterion("LOGIN_NO <>", value, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoGreaterThan(String value) {
            addCriterion("LOGIN_NO >", value, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_NO >=", value, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoLessThan(String value) {
            addCriterion("LOGIN_NO <", value, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_NO <=", value, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoLike(String value) {
            addCriterion("LOGIN_NO like", value, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoNotLike(String value) {
            addCriterion("LOGIN_NO not like", value, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoIn(List<String> values) {
            addCriterion("LOGIN_NO in", values, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoNotIn(List<String> values) {
            addCriterion("LOGIN_NO not in", values, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoBetween(String value1, String value2) {
            addCriterion("LOGIN_NO between", value1, value2, "loginNo");
            return (Criteria) this;
        }

        public Criteria andLoginNoNotBetween(String value1, String value2) {
            addCriterion("LOGIN_NO not between", value1, value2, "loginNo");
            return (Criteria) this;
        }

        public Criteria andUserChnNameIsNull() {
            addCriterion("USER_CHN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserChnNameIsNotNull() {
            addCriterion("USER_CHN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserChnNameEqualTo(String value) {
            addCriterion("USER_CHN_NAME =", value, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameNotEqualTo(String value) {
            addCriterion("USER_CHN_NAME <>", value, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameGreaterThan(String value) {
            addCriterion("USER_CHN_NAME >", value, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_CHN_NAME >=", value, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameLessThan(String value) {
            addCriterion("USER_CHN_NAME <", value, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameLessThanOrEqualTo(String value) {
            addCriterion("USER_CHN_NAME <=", value, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameLike(String value) {
            addCriterion("USER_CHN_NAME like", value, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameNotLike(String value) {
            addCriterion("USER_CHN_NAME not like", value, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameIn(List<String> values) {
            addCriterion("USER_CHN_NAME in", values, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameNotIn(List<String> values) {
            addCriterion("USER_CHN_NAME not in", values, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameBetween(String value1, String value2) {
            addCriterion("USER_CHN_NAME between", value1, value2, "userChnName");
            return (Criteria) this;
        }

        public Criteria andUserChnNameNotBetween(String value1, String value2) {
            addCriterion("USER_CHN_NAME not between", value1, value2, "userChnName");
            return (Criteria) this;
        }

        public Criteria andLoginPwdIsNull() {
            addCriterion("LOGIN_PWD is null");
            return (Criteria) this;
        }

        public Criteria andLoginPwdIsNotNull() {
            addCriterion("LOGIN_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPwdEqualTo(String value) {
            addCriterion("LOGIN_PWD =", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdNotEqualTo(String value) {
            addCriterion("LOGIN_PWD <>", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdGreaterThan(String value) {
            addCriterion("LOGIN_PWD >", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_PWD >=", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdLessThan(String value) {
            addCriterion("LOGIN_PWD <", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_PWD <=", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdLike(String value) {
            addCriterion("LOGIN_PWD like", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdNotLike(String value) {
            addCriterion("LOGIN_PWD not like", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdIn(List<String> values) {
            addCriterion("LOGIN_PWD in", values, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdNotIn(List<String> values) {
            addCriterion("LOGIN_PWD not in", values, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdBetween(String value1, String value2) {
            addCriterion("LOGIN_PWD between", value1, value2, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_PWD not between", value1, value2, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andPwdStatusIsNull() {
            addCriterion("PWD_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPwdStatusIsNotNull() {
            addCriterion("PWD_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPwdStatusEqualTo(String value) {
            addCriterion("PWD_STATUS =", value, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusNotEqualTo(String value) {
            addCriterion("PWD_STATUS <>", value, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusGreaterThan(String value) {
            addCriterion("PWD_STATUS >", value, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PWD_STATUS >=", value, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusLessThan(String value) {
            addCriterion("PWD_STATUS <", value, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusLessThanOrEqualTo(String value) {
            addCriterion("PWD_STATUS <=", value, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusLike(String value) {
            addCriterion("PWD_STATUS like", value, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusNotLike(String value) {
            addCriterion("PWD_STATUS not like", value, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusIn(List<String> values) {
            addCriterion("PWD_STATUS in", values, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusNotIn(List<String> values) {
            addCriterion("PWD_STATUS not in", values, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusBetween(String value1, String value2) {
            addCriterion("PWD_STATUS between", value1, value2, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdStatusNotBetween(String value1, String value2) {
            addCriterion("PWD_STATUS not between", value1, value2, "pwdStatus");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumIsNull() {
            addCriterion("PWD_ERR_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumIsNotNull() {
            addCriterion("PWD_ERR_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumEqualTo(Integer value) {
            addCriterion("PWD_ERR_NUM =", value, "pwdErrNum");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumNotEqualTo(Integer value) {
            addCriterion("PWD_ERR_NUM <>", value, "pwdErrNum");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumGreaterThan(Integer value) {
            addCriterion("PWD_ERR_NUM >", value, "pwdErrNum");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PWD_ERR_NUM >=", value, "pwdErrNum");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumLessThan(Integer value) {
            addCriterion("PWD_ERR_NUM <", value, "pwdErrNum");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumLessThanOrEqualTo(Integer value) {
            addCriterion("PWD_ERR_NUM <=", value, "pwdErrNum");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumIn(List<Integer> values) {
            addCriterion("PWD_ERR_NUM in", values, "pwdErrNum");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumNotIn(List<Integer> values) {
            addCriterion("PWD_ERR_NUM not in", values, "pwdErrNum");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumBetween(Integer value1, Integer value2) {
            addCriterion("PWD_ERR_NUM between", value1, value2, "pwdErrNum");
            return (Criteria) this;
        }

        public Criteria andPwdErrNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PWD_ERR_NUM not between", value1, value2, "pwdErrNum");
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

        public Criteria andIsSuperIsNull() {
            addCriterion("IS_SUPER is null");
            return (Criteria) this;
        }

        public Criteria andIsSuperIsNotNull() {
            addCriterion("IS_SUPER is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuperEqualTo(String value) {
            addCriterion("IS_SUPER =", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperNotEqualTo(String value) {
            addCriterion("IS_SUPER <>", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperGreaterThan(String value) {
            addCriterion("IS_SUPER >", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SUPER >=", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperLessThan(String value) {
            addCriterion("IS_SUPER <", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperLessThanOrEqualTo(String value) {
            addCriterion("IS_SUPER <=", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperLike(String value) {
            addCriterion("IS_SUPER like", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperNotLike(String value) {
            addCriterion("IS_SUPER not like", value, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperIn(List<String> values) {
            addCriterion("IS_SUPER in", values, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperNotIn(List<String> values) {
            addCriterion("IS_SUPER not in", values, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperBetween(String value1, String value2) {
            addCriterion("IS_SUPER between", value1, value2, "isSuper");
            return (Criteria) this;
        }

        public Criteria andIsSuperNotBetween(String value1, String value2) {
            addCriterion("IS_SUPER not between", value1, value2, "isSuper");
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