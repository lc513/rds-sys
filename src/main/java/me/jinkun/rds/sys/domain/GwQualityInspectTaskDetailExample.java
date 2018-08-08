package me.jinkun.rds.sys.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GwQualityInspectTaskDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GwQualityInspectTaskDetailExample() {
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

        public Criteria andQitIdIsNull() {
            addCriterion("qit_id is null");
            return (Criteria) this;
        }

        public Criteria andQitIdIsNotNull() {
            addCriterion("qit_id is not null");
            return (Criteria) this;
        }

        public Criteria andQitIdEqualTo(Long value) {
            addCriterion("qit_id =", value, "qitId");
            return (Criteria) this;
        }

        public Criteria andQitIdNotEqualTo(Long value) {
            addCriterion("qit_id <>", value, "qitId");
            return (Criteria) this;
        }

        public Criteria andQitIdGreaterThan(Long value) {
            addCriterion("qit_id >", value, "qitId");
            return (Criteria) this;
        }

        public Criteria andQitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("qit_id >=", value, "qitId");
            return (Criteria) this;
        }

        public Criteria andQitIdLessThan(Long value) {
            addCriterion("qit_id <", value, "qitId");
            return (Criteria) this;
        }

        public Criteria andQitIdLessThanOrEqualTo(Long value) {
            addCriterion("qit_id <=", value, "qitId");
            return (Criteria) this;
        }

        public Criteria andQitIdIn(List<Long> values) {
            addCriterion("qit_id in", values, "qitId");
            return (Criteria) this;
        }

        public Criteria andQitIdNotIn(List<Long> values) {
            addCriterion("qit_id not in", values, "qitId");
            return (Criteria) this;
        }

        public Criteria andQitIdBetween(Long value1, Long value2) {
            addCriterion("qit_id between", value1, value2, "qitId");
            return (Criteria) this;
        }

        public Criteria andQitIdNotBetween(Long value1, Long value2) {
            addCriterion("qit_id not between", value1, value2, "qitId");
            return (Criteria) this;
        }

        public Criteria andCheckProjectIsNull() {
            addCriterion("check_project is null");
            return (Criteria) this;
        }

        public Criteria andCheckProjectIsNotNull() {
            addCriterion("check_project is not null");
            return (Criteria) this;
        }

        public Criteria andCheckProjectEqualTo(String value) {
            addCriterion("check_project =", value, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectNotEqualTo(String value) {
            addCriterion("check_project <>", value, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectGreaterThan(String value) {
            addCriterion("check_project >", value, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectGreaterThanOrEqualTo(String value) {
            addCriterion("check_project >=", value, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectLessThan(String value) {
            addCriterion("check_project <", value, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectLessThanOrEqualTo(String value) {
            addCriterion("check_project <=", value, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectLike(String value) {
            addCriterion("check_project like", value, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectNotLike(String value) {
            addCriterion("check_project not like", value, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectIn(List<String> values) {
            addCriterion("check_project in", values, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectNotIn(List<String> values) {
            addCriterion("check_project not in", values, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectBetween(String value1, String value2) {
            addCriterion("check_project between", value1, value2, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckProjectNotBetween(String value1, String value2) {
            addCriterion("check_project not between", value1, value2, "checkProject");
            return (Criteria) this;
        }

        public Criteria andCheckPointIsNull() {
            addCriterion("check_point is null");
            return (Criteria) this;
        }

        public Criteria andCheckPointIsNotNull() {
            addCriterion("check_point is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPointEqualTo(String value) {
            addCriterion("check_point =", value, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointNotEqualTo(String value) {
            addCriterion("check_point <>", value, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointGreaterThan(String value) {
            addCriterion("check_point >", value, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointGreaterThanOrEqualTo(String value) {
            addCriterion("check_point >=", value, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointLessThan(String value) {
            addCriterion("check_point <", value, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointLessThanOrEqualTo(String value) {
            addCriterion("check_point <=", value, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointLike(String value) {
            addCriterion("check_point like", value, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointNotLike(String value) {
            addCriterion("check_point not like", value, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointIn(List<String> values) {
            addCriterion("check_point in", values, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointNotIn(List<String> values) {
            addCriterion("check_point not in", values, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointBetween(String value1, String value2) {
            addCriterion("check_point between", value1, value2, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andCheckPointNotBetween(String value1, String value2) {
            addCriterion("check_point not between", value1, value2, "checkPoint");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(String value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(String value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(String value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(String value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(String value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLike(String value) {
            addCriterion("frequency like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotLike(String value) {
            addCriterion("frequency not like", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<String> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<String> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(String value1, String value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(String value1, String value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andQualifiedIsNull() {
            addCriterion("qualified is null");
            return (Criteria) this;
        }

        public Criteria andQualifiedIsNotNull() {
            addCriterion("qualified is not null");
            return (Criteria) this;
        }

        public Criteria andQualifiedEqualTo(Boolean value) {
            addCriterion("qualified =", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotEqualTo(Boolean value) {
            addCriterion("qualified <>", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedGreaterThan(Boolean value) {
            addCriterion("qualified >", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("qualified >=", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedLessThan(Boolean value) {
            addCriterion("qualified <", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedLessThanOrEqualTo(Boolean value) {
            addCriterion("qualified <=", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedIn(List<Boolean> values) {
            addCriterion("qualified in", values, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotIn(List<Boolean> values) {
            addCriterion("qualified not in", values, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedBetween(Boolean value1, Boolean value2) {
            addCriterion("qualified between", value1, value2, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("qualified not between", value1, value2, "qualified");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckUserIsNull() {
            addCriterion("check_user is null");
            return (Criteria) this;
        }

        public Criteria andCheckUserIsNotNull() {
            addCriterion("check_user is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUserEqualTo(Long value) {
            addCriterion("check_user =", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotEqualTo(Long value) {
            addCriterion("check_user <>", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThan(Long value) {
            addCriterion("check_user >", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThanOrEqualTo(Long value) {
            addCriterion("check_user >=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThan(Long value) {
            addCriterion("check_user <", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThanOrEqualTo(Long value) {
            addCriterion("check_user <=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserIn(List<Long> values) {
            addCriterion("check_user in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotIn(List<Long> values) {
            addCriterion("check_user not in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserBetween(Long value1, Long value2) {
            addCriterion("check_user between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotBetween(Long value1, Long value2) {
            addCriterion("check_user not between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIsNull() {
            addCriterion("is_checked is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIsNotNull() {
            addCriterion("is_checked is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckedEqualTo(Boolean value) {
            addCriterion("is_checked =", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotEqualTo(Boolean value) {
            addCriterion("is_checked <>", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedGreaterThan(Boolean value) {
            addCriterion("is_checked >", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_checked >=", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedLessThan(Boolean value) {
            addCriterion("is_checked <", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_checked <=", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIn(List<Boolean> values) {
            addCriterion("is_checked in", values, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotIn(List<Boolean> values) {
            addCriterion("is_checked not in", values, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_checked between", value1, value2, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_checked not between", value1, value2, "isChecked");
            return (Criteria) this;
        }

        public Criteria andTaskStimeIsNull() {
            addCriterion("task_stime is null");
            return (Criteria) this;
        }

        public Criteria andTaskStimeIsNotNull() {
            addCriterion("task_stime is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStimeEqualTo(Date value) {
            addCriterion("task_stime =", value, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskStimeNotEqualTo(Date value) {
            addCriterion("task_stime <>", value, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskStimeGreaterThan(Date value) {
            addCriterion("task_stime >", value, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskStimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_stime >=", value, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskStimeLessThan(Date value) {
            addCriterion("task_stime <", value, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskStimeLessThanOrEqualTo(Date value) {
            addCriterion("task_stime <=", value, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskStimeIn(List<Date> values) {
            addCriterion("task_stime in", values, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskStimeNotIn(List<Date> values) {
            addCriterion("task_stime not in", values, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskStimeBetween(Date value1, Date value2) {
            addCriterion("task_stime between", value1, value2, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskStimeNotBetween(Date value1, Date value2) {
            addCriterion("task_stime not between", value1, value2, "taskStime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeIsNull() {
            addCriterion("task_etime is null");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeIsNotNull() {
            addCriterion("task_etime is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeEqualTo(Date value) {
            addCriterion("task_etime =", value, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeNotEqualTo(Date value) {
            addCriterion("task_etime <>", value, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeGreaterThan(Date value) {
            addCriterion("task_etime >", value, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_etime >=", value, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeLessThan(Date value) {
            addCriterion("task_etime <", value, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeLessThanOrEqualTo(Date value) {
            addCriterion("task_etime <=", value, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeIn(List<Date> values) {
            addCriterion("task_etime in", values, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeNotIn(List<Date> values) {
            addCriterion("task_etime not in", values, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeBetween(Date value1, Date value2) {
            addCriterion("task_etime between", value1, value2, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andTaskEtimeNotBetween(Date value1, Date value2) {
            addCriterion("task_etime not between", value1, value2, "taskEtime");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andEnclosureIsNull() {
            addCriterion("enclosure is null");
            return (Criteria) this;
        }

        public Criteria andEnclosureIsNotNull() {
            addCriterion("enclosure is not null");
            return (Criteria) this;
        }

        public Criteria andEnclosureEqualTo(String value) {
            addCriterion("enclosure =", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotEqualTo(String value) {
            addCriterion("enclosure <>", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureGreaterThan(String value) {
            addCriterion("enclosure >", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureGreaterThanOrEqualTo(String value) {
            addCriterion("enclosure >=", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureLessThan(String value) {
            addCriterion("enclosure <", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureLessThanOrEqualTo(String value) {
            addCriterion("enclosure <=", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureLike(String value) {
            addCriterion("enclosure like", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotLike(String value) {
            addCriterion("enclosure not like", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureIn(List<String> values) {
            addCriterion("enclosure in", values, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotIn(List<String> values) {
            addCriterion("enclosure not in", values, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureBetween(String value1, String value2) {
            addCriterion("enclosure between", value1, value2, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotBetween(String value1, String value2) {
            addCriterion("enclosure not between", value1, value2, "enclosure");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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