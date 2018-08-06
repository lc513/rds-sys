package me.jinkun.rds.sys.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysJournalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysJournalExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Long value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Long value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Long value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Long value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Long value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Long value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Long> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Long> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Long value1, Long value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Long value1, Long value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Long value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Long value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Long value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Long value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Long value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Long value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Long> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Long> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Long value1, Long value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Long value1, Long value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andJDateIsNull() {
            addCriterion("j_date is null");
            return (Criteria) this;
        }

        public Criteria andJDateIsNotNull() {
            addCriterion("j_date is not null");
            return (Criteria) this;
        }

        public Criteria andJDateEqualTo(Date value) {
            addCriterion("j_date =", value, "jDate");
            return (Criteria) this;
        }

        public Criteria andJDateNotEqualTo(Date value) {
            addCriterion("j_date <>", value, "jDate");
            return (Criteria) this;
        }

        public Criteria andJDateGreaterThan(Date value) {
            addCriterion("j_date >", value, "jDate");
            return (Criteria) this;
        }

        public Criteria andJDateGreaterThanOrEqualTo(Date value) {
            addCriterion("j_date >=", value, "jDate");
            return (Criteria) this;
        }

        public Criteria andJDateLessThan(Date value) {
            addCriterion("j_date <", value, "jDate");
            return (Criteria) this;
        }

        public Criteria andJDateLessThanOrEqualTo(Date value) {
            addCriterion("j_date <=", value, "jDate");
            return (Criteria) this;
        }

        public Criteria andJDateIn(List<Date> values) {
            addCriterion("j_date in", values, "jDate");
            return (Criteria) this;
        }

        public Criteria andJDateNotIn(List<Date> values) {
            addCriterion("j_date not in", values, "jDate");
            return (Criteria) this;
        }

        public Criteria andJDateBetween(Date value1, Date value2) {
            addCriterion("j_date between", value1, value2, "jDate");
            return (Criteria) this;
        }

        public Criteria andJDateNotBetween(Date value1, Date value2) {
            addCriterion("j_date not between", value1, value2, "jDate");
            return (Criteria) this;
        }

        public Criteria andWorkDurationIsNull() {
            addCriterion("work_duration is null");
            return (Criteria) this;
        }

        public Criteria andWorkDurationIsNotNull() {
            addCriterion("work_duration is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDurationEqualTo(Integer value) {
            addCriterion("work_duration =", value, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDurationNotEqualTo(Integer value) {
            addCriterion("work_duration <>", value, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDurationGreaterThan(Integer value) {
            addCriterion("work_duration >", value, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_duration >=", value, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDurationLessThan(Integer value) {
            addCriterion("work_duration <", value, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDurationLessThanOrEqualTo(Integer value) {
            addCriterion("work_duration <=", value, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDurationIn(List<Integer> values) {
            addCriterion("work_duration in", values, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDurationNotIn(List<Integer> values) {
            addCriterion("work_duration not in", values, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDurationBetween(Integer value1, Integer value2) {
            addCriterion("work_duration between", value1, value2, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("work_duration not between", value1, value2, "workDuration");
            return (Criteria) this;
        }

        public Criteria andWorkDescIsNull() {
            addCriterion("work_desc is null");
            return (Criteria) this;
        }

        public Criteria andWorkDescIsNotNull() {
            addCriterion("work_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDescEqualTo(String value) {
            addCriterion("work_desc =", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotEqualTo(String value) {
            addCriterion("work_desc <>", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescGreaterThan(String value) {
            addCriterion("work_desc >", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescGreaterThanOrEqualTo(String value) {
            addCriterion("work_desc >=", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLessThan(String value) {
            addCriterion("work_desc <", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLessThanOrEqualTo(String value) {
            addCriterion("work_desc <=", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescLike(String value) {
            addCriterion("work_desc like", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotLike(String value) {
            addCriterion("work_desc not like", value, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescIn(List<String> values) {
            addCriterion("work_desc in", values, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotIn(List<String> values) {
            addCriterion("work_desc not in", values, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescBetween(String value1, String value2) {
            addCriterion("work_desc between", value1, value2, "workDesc");
            return (Criteria) this;
        }

        public Criteria andWorkDescNotBetween(String value1, String value2) {
            addCriterion("work_desc not between", value1, value2, "workDesc");
            return (Criteria) this;
        }

        public Criteria andOverTimeIsNull() {
            addCriterion("over_time is null");
            return (Criteria) this;
        }

        public Criteria andOverTimeIsNotNull() {
            addCriterion("over_time is not null");
            return (Criteria) this;
        }

        public Criteria andOverTimeEqualTo(Integer value) {
            addCriterion("over_time =", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotEqualTo(Integer value) {
            addCriterion("over_time <>", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeGreaterThan(Integer value) {
            addCriterion("over_time >", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("over_time >=", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeLessThan(Integer value) {
            addCriterion("over_time <", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeLessThanOrEqualTo(Integer value) {
            addCriterion("over_time <=", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeIn(List<Integer> values) {
            addCriterion("over_time in", values, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotIn(List<Integer> values) {
            addCriterion("over_time not in", values, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeBetween(Integer value1, Integer value2) {
            addCriterion("over_time between", value1, value2, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("over_time not between", value1, value2, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverDescIsNull() {
            addCriterion("over_desc is null");
            return (Criteria) this;
        }

        public Criteria andOverDescIsNotNull() {
            addCriterion("over_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOverDescEqualTo(String value) {
            addCriterion("over_desc =", value, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescNotEqualTo(String value) {
            addCriterion("over_desc <>", value, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescGreaterThan(String value) {
            addCriterion("over_desc >", value, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescGreaterThanOrEqualTo(String value) {
            addCriterion("over_desc >=", value, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescLessThan(String value) {
            addCriterion("over_desc <", value, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescLessThanOrEqualTo(String value) {
            addCriterion("over_desc <=", value, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescLike(String value) {
            addCriterion("over_desc like", value, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescNotLike(String value) {
            addCriterion("over_desc not like", value, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescIn(List<String> values) {
            addCriterion("over_desc in", values, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescNotIn(List<String> values) {
            addCriterion("over_desc not in", values, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescBetween(String value1, String value2) {
            addCriterion("over_desc between", value1, value2, "overDesc");
            return (Criteria) this;
        }

        public Criteria andOverDescNotBetween(String value1, String value2) {
            addCriterion("over_desc not between", value1, value2, "overDesc");
            return (Criteria) this;
        }

        public Criteria andExamineIsNull() {
            addCriterion("examine is null");
            return (Criteria) this;
        }

        public Criteria andExamineIsNotNull() {
            addCriterion("examine is not null");
            return (Criteria) this;
        }

        public Criteria andExamineEqualTo(Integer value) {
            addCriterion("examine =", value, "examine");
            return (Criteria) this;
        }

        public Criteria andExamineNotEqualTo(Integer value) {
            addCriterion("examine <>", value, "examine");
            return (Criteria) this;
        }

        public Criteria andExamineGreaterThan(Integer value) {
            addCriterion("examine >", value, "examine");
            return (Criteria) this;
        }

        public Criteria andExamineGreaterThanOrEqualTo(Integer value) {
            addCriterion("examine >=", value, "examine");
            return (Criteria) this;
        }

        public Criteria andExamineLessThan(Integer value) {
            addCriterion("examine <", value, "examine");
            return (Criteria) this;
        }

        public Criteria andExamineLessThanOrEqualTo(Integer value) {
            addCriterion("examine <=", value, "examine");
            return (Criteria) this;
        }

        public Criteria andExamineIn(List<Integer> values) {
            addCriterion("examine in", values, "examine");
            return (Criteria) this;
        }

        public Criteria andExamineNotIn(List<Integer> values) {
            addCriterion("examine not in", values, "examine");
            return (Criteria) this;
        }

        public Criteria andExamineBetween(Integer value1, Integer value2) {
            addCriterion("examine between", value1, value2, "examine");
            return (Criteria) this;
        }

        public Criteria andExamineNotBetween(Integer value1, Integer value2) {
            addCriterion("examine not between", value1, value2, "examine");
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