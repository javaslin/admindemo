package com.sl.boot.admindemo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PatientExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andPatientNameIsNull() {
            addCriterion("patient_name is null");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNotNull() {
            addCriterion("patient_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatientNameEqualTo(String value) {
            addCriterion("patient_name =", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotEqualTo(String value) {
            addCriterion("patient_name <>", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThan(String value) {
            addCriterion("patient_name >", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThanOrEqualTo(String value) {
            addCriterion("patient_name >=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThan(String value) {
            addCriterion("patient_name <", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThanOrEqualTo(String value) {
            addCriterion("patient_name <=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLike(String value) {
            addCriterion("patient_name like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotLike(String value) {
            addCriterion("patient_name not like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameIn(List<String> values) {
            addCriterion("patient_name in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotIn(List<String> values) {
            addCriterion("patient_name not in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameBetween(String value1, String value2) {
            addCriterion("patient_name between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotBetween(String value1, String value2) {
            addCriterion("patient_name not between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andDiseaseIsNull() {
            addCriterion("disease is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIsNotNull() {
            addCriterion("disease is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseEqualTo(String value) {
            addCriterion("disease =", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotEqualTo(String value) {
            addCriterion("disease <>", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseGreaterThan(String value) {
            addCriterion("disease >", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseGreaterThanOrEqualTo(String value) {
            addCriterion("disease >=", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLessThan(String value) {
            addCriterion("disease <", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLessThanOrEqualTo(String value) {
            addCriterion("disease <=", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseLike(String value) {
            addCriterion("disease like", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotLike(String value) {
            addCriterion("disease not like", value, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseIn(List<String> values) {
            addCriterion("disease in", values, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotIn(List<String> values) {
            addCriterion("disease not in", values, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseBetween(String value1, String value2) {
            addCriterion("disease between", value1, value2, "disease");
            return (Criteria) this;
        }

        public Criteria andDiseaseNotBetween(String value1, String value2) {
            addCriterion("disease not between", value1, value2, "disease");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("age like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("age not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("`method` is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("`method` is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(Integer value) {
            addCriterion("`method` =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(Integer value) {
            addCriterion("`method` <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(Integer value) {
            addCriterion("`method` >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("`method` >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(Integer value) {
            addCriterion("`method` <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(Integer value) {
            addCriterion("`method` <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<Integer> values) {
            addCriterion("`method` in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<Integer> values) {
            addCriterion("`method` not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(Integer value1, Integer value2) {
            addCriterion("`method` between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("`method` not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdIsNull() {
            addCriterion("belong_to_doctor_id is null");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdIsNotNull() {
            addCriterion("belong_to_doctor_id is not null");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdEqualTo(Long value) {
            addCriterion("belong_to_doctor_id =", value, "belongToDoctorId");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdNotEqualTo(Long value) {
            addCriterion("belong_to_doctor_id <>", value, "belongToDoctorId");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdGreaterThan(Long value) {
            addCriterion("belong_to_doctor_id >", value, "belongToDoctorId");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("belong_to_doctor_id >=", value, "belongToDoctorId");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdLessThan(Long value) {
            addCriterion("belong_to_doctor_id <", value, "belongToDoctorId");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdLessThanOrEqualTo(Long value) {
            addCriterion("belong_to_doctor_id <=", value, "belongToDoctorId");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdIn(List<Long> values) {
            addCriterion("belong_to_doctor_id in", values, "belongToDoctorId");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdNotIn(List<Long> values) {
            addCriterion("belong_to_doctor_id not in", values, "belongToDoctorId");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdBetween(Long value1, Long value2) {
            addCriterion("belong_to_doctor_id between", value1, value2, "belongToDoctorId");
            return (Criteria) this;
        }

        public Criteria andBelongToDoctorIdNotBetween(Long value1, Long value2) {
            addCriterion("belong_to_doctor_id not between", value1, value2, "belongToDoctorId");
            return (Criteria) this;
        }
    }

    /**
     *
     */
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