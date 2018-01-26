package net.northking.cloudplatform.domain.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CltLoginLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CltLoginLogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(String value) {
            addCriterion("LOG_ID =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(String value) {
            addCriterion("LOG_ID <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(String value) {
            addCriterion("LOG_ID >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_ID >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(String value) {
            addCriterion("LOG_ID <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(String value) {
            addCriterion("LOG_ID <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLike(String value) {
            addCriterion("LOG_ID like", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotLike(String value) {
            addCriterion("LOG_ID not like", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<String> values) {
            addCriterion("LOG_ID in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<String> values) {
            addCriterion("LOG_ID not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(String value1, String value2) {
            addCriterion("LOG_ID between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(String value1, String value2) {
            addCriterion("LOG_ID not between", value1, value2, "logId");
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

        public Criteria andSessionIdIsNull() {
            addCriterion("SESSION_ID is null");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNotNull() {
            addCriterion("SESSION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSessionIdEqualTo(String value) {
            addCriterion("SESSION_ID =", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotEqualTo(String value) {
            addCriterion("SESSION_ID <>", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThan(String value) {
            addCriterion("SESSION_ID >", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThanOrEqualTo(String value) {
            addCriterion("SESSION_ID >=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThan(String value) {
            addCriterion("SESSION_ID <", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThanOrEqualTo(String value) {
            addCriterion("SESSION_ID <=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLike(String value) {
            addCriterion("SESSION_ID like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotLike(String value) {
            addCriterion("SESSION_ID not like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdIn(List<String> values) {
            addCriterion("SESSION_ID in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotIn(List<String> values) {
            addCriterion("SESSION_ID not in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdBetween(String value1, String value2) {
            addCriterion("SESSION_ID between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotBetween(String value1, String value2) {
            addCriterion("SESSION_ID not between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andLoginDateIsNull() {
            addCriterion("LOGIN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLoginDateIsNotNull() {
            addCriterion("LOGIN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLoginDateEqualTo(Date value) {
            addCriterionForJDBCDate("LOGIN_DATE =", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LOGIN_DATE <>", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateGreaterThan(Date value) {
            addCriterionForJDBCDate("LOGIN_DATE >", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LOGIN_DATE >=", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateLessThan(Date value) {
            addCriterionForJDBCDate("LOGIN_DATE <", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LOGIN_DATE <=", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateIn(List<Date> values) {
            addCriterionForJDBCDate("LOGIN_DATE in", values, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LOGIN_DATE not in", values, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LOGIN_DATE between", value1, value2, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LOGIN_DATE not between", value1, value2, "loginDate");
            return (Criteria) this;
        }

        public Criteria andExitDateIsNull() {
            addCriterion("EXIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExitDateIsNotNull() {
            addCriterion("EXIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExitDateEqualTo(Date value) {
            addCriterionForJDBCDate("EXIT_DATE =", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("EXIT_DATE <>", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateGreaterThan(Date value) {
            addCriterionForJDBCDate("EXIT_DATE >", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EXIT_DATE >=", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateLessThan(Date value) {
            addCriterionForJDBCDate("EXIT_DATE <", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EXIT_DATE <=", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateIn(List<Date> values) {
            addCriterionForJDBCDate("EXIT_DATE in", values, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("EXIT_DATE not in", values, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EXIT_DATE between", value1, value2, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EXIT_DATE not between", value1, value2, "exitDate");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("LOGIN_IP =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("LOGIN_IP <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("LOGIN_IP >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("LOGIN_IP <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("LOGIN_IP like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("LOGIN_IP not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("LOGIN_IP in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("LOGIN_IP not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("LOGIN_IP between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("LOGIN_IP not between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andStautsIsNull() {
            addCriterion("STAUTS is null");
            return (Criteria) this;
        }

        public Criteria andStautsIsNotNull() {
            addCriterion("STAUTS is not null");
            return (Criteria) this;
        }

        public Criteria andStautsEqualTo(String value) {
            addCriterion("STAUTS =", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotEqualTo(String value) {
            addCriterion("STAUTS <>", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsGreaterThan(String value) {
            addCriterion("STAUTS >", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsGreaterThanOrEqualTo(String value) {
            addCriterion("STAUTS >=", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsLessThan(String value) {
            addCriterion("STAUTS <", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsLessThanOrEqualTo(String value) {
            addCriterion("STAUTS <=", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsLike(String value) {
            addCriterion("STAUTS like", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotLike(String value) {
            addCriterion("STAUTS not like", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsIn(List<String> values) {
            addCriterion("STAUTS in", values, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotIn(List<String> values) {
            addCriterion("STAUTS not in", values, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsBetween(String value1, String value2) {
            addCriterion("STAUTS between", value1, value2, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotBetween(String value1, String value2) {
            addCriterion("STAUTS not between", value1, value2, "stauts");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumIsNull() {
            addCriterion("PWD_LOGIN_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumIsNotNull() {
            addCriterion("PWD_LOGIN_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumEqualTo(Integer value) {
            addCriterion("PWD_LOGIN_NUM =", value, "pwdLoginNum");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumNotEqualTo(Integer value) {
            addCriterion("PWD_LOGIN_NUM <>", value, "pwdLoginNum");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumGreaterThan(Integer value) {
            addCriterion("PWD_LOGIN_NUM >", value, "pwdLoginNum");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PWD_LOGIN_NUM >=", value, "pwdLoginNum");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumLessThan(Integer value) {
            addCriterion("PWD_LOGIN_NUM <", value, "pwdLoginNum");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumLessThanOrEqualTo(Integer value) {
            addCriterion("PWD_LOGIN_NUM <=", value, "pwdLoginNum");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumIn(List<Integer> values) {
            addCriterion("PWD_LOGIN_NUM in", values, "pwdLoginNum");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumNotIn(List<Integer> values) {
            addCriterion("PWD_LOGIN_NUM not in", values, "pwdLoginNum");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumBetween(Integer value1, Integer value2) {
            addCriterion("PWD_LOGIN_NUM between", value1, value2, "pwdLoginNum");
            return (Criteria) this;
        }

        public Criteria andPwdLoginNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PWD_LOGIN_NUM not between", value1, value2, "pwdLoginNum");
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