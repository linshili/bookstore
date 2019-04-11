package com.nsc.backend.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Desc User扩展(用于Mybatis条件式CRUD)
 * @author sjg
 * @Date 2019年4月11日
 */
public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdIsNull() {
            addCriterion("user_unionId is null");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdIsNotNull() {
            addCriterion("user_unionId is not null");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdEqualTo(String value) {
            addCriterion("user_unionId =", value, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotEqualTo(String value) {
            addCriterion("user_unionId <>", value, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdGreaterThan(String value) {
            addCriterion("user_unionId >", value, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_unionId >=", value, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdLessThan(String value) {
            addCriterion("user_unionId <", value, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdLessThanOrEqualTo(String value) {
            addCriterion("user_unionId <=", value, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdLike(String value) {
            addCriterion("user_unionId like", value, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotLike(String value) {
            addCriterion("user_unionId not like", value, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdIn(List<String> values) {
            addCriterion("user_unionId in", values, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotIn(List<String> values) {
            addCriterion("user_unionId not in", values, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdBetween(String value1, String value2) {
            addCriterion("user_unionId between", value1, value2, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotBetween(String value1, String value2) {
            addCriterion("user_unionId not between", value1, value2, "user_unionId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdIsNull() {
            addCriterion("user_openId is null");
            return (Criteria) this;
        }

        public Criteria andUser_openIdIsNotNull() {
            addCriterion("user_openId is not null");
            return (Criteria) this;
        }

        public Criteria andUser_openIdEqualTo(String value) {
            addCriterion("user_openId =", value, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdNotEqualTo(String value) {
            addCriterion("user_openId <>", value, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdGreaterThan(String value) {
            addCriterion("user_openId >", value, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_openId >=", value, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdLessThan(String value) {
            addCriterion("user_openId <", value, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdLessThanOrEqualTo(String value) {
            addCriterion("user_openId <=", value, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdLike(String value) {
            addCriterion("user_openId like", value, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdNotLike(String value) {
            addCriterion("user_openId not like", value, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdIn(List<String> values) {
            addCriterion("user_openId in", values, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdNotIn(List<String> values) {
            addCriterion("user_openId not in", values, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdBetween(String value1, String value2) {
            addCriterion("user_openId between", value1, value2, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdNotBetween(String value1, String value2) {
            addCriterion("user_openId not between", value1, value2, "user_openId");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameIsNull() {
            addCriterion("user_nickName is null");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameIsNotNull() {
            addCriterion("user_nickName is not null");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameEqualTo(String value) {
            addCriterion("user_nickName =", value, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameNotEqualTo(String value) {
            addCriterion("user_nickName <>", value, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameGreaterThan(String value) {
            addCriterion("user_nickName >", value, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nickName >=", value, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameLessThan(String value) {
            addCriterion("user_nickName <", value, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameLessThanOrEqualTo(String value) {
            addCriterion("user_nickName <=", value, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameLike(String value) {
            addCriterion("user_nickName like", value, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameNotLike(String value) {
            addCriterion("user_nickName not like", value, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameIn(List<String> values) {
            addCriterion("user_nickName in", values, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameNotIn(List<String> values) {
            addCriterion("user_nickName not in", values, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameBetween(String value1, String value2) {
            addCriterion("user_nickName between", value1, value2, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_nickNameNotBetween(String value1, String value2) {
            addCriterion("user_nickName not between", value1, value2, "user_nickName");
            return (Criteria) this;
        }

        public Criteria andUser_genderIsNull() {
            addCriterion("user_gender is null");
            return (Criteria) this;
        }

        public Criteria andUser_genderIsNotNull() {
            addCriterion("user_gender is not null");
            return (Criteria) this;
        }

        public Criteria andUser_genderEqualTo(String value) {
            addCriterion("user_gender =", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderNotEqualTo(String value) {
            addCriterion("user_gender <>", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderGreaterThan(String value) {
            addCriterion("user_gender >", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderGreaterThanOrEqualTo(String value) {
            addCriterion("user_gender >=", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderLessThan(String value) {
            addCriterion("user_gender <", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderLessThanOrEqualTo(String value) {
            addCriterion("user_gender <=", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderLike(String value) {
            addCriterion("user_gender like", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderNotLike(String value) {
            addCriterion("user_gender not like", value, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderIn(List<String> values) {
            addCriterion("user_gender in", values, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderNotIn(List<String> values) {
            addCriterion("user_gender not in", values, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderBetween(String value1, String value2) {
            addCriterion("user_gender between", value1, value2, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_genderNotBetween(String value1, String value2) {
            addCriterion("user_gender not between", value1, value2, "user_gender");
            return (Criteria) this;
        }

        public Criteria andUser_cityIsNull() {
            addCriterion("user_city is null");
            return (Criteria) this;
        }

        public Criteria andUser_cityIsNotNull() {
            addCriterion("user_city is not null");
            return (Criteria) this;
        }

        public Criteria andUser_cityEqualTo(String value) {
            addCriterion("user_city =", value, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityNotEqualTo(String value) {
            addCriterion("user_city <>", value, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityGreaterThan(String value) {
            addCriterion("user_city >", value, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityGreaterThanOrEqualTo(String value) {
            addCriterion("user_city >=", value, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityLessThan(String value) {
            addCriterion("user_city <", value, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityLessThanOrEqualTo(String value) {
            addCriterion("user_city <=", value, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityLike(String value) {
            addCriterion("user_city like", value, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityNotLike(String value) {
            addCriterion("user_city not like", value, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityIn(List<String> values) {
            addCriterion("user_city in", values, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityNotIn(List<String> values) {
            addCriterion("user_city not in", values, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityBetween(String value1, String value2) {
            addCriterion("user_city between", value1, value2, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_cityNotBetween(String value1, String value2) {
            addCriterion("user_city not between", value1, value2, "user_city");
            return (Criteria) this;
        }

        public Criteria andUser_provinceIsNull() {
            addCriterion("user_province is null");
            return (Criteria) this;
        }

        public Criteria andUser_provinceIsNotNull() {
            addCriterion("user_province is not null");
            return (Criteria) this;
        }

        public Criteria andUser_provinceEqualTo(String value) {
            addCriterion("user_province =", value, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceNotEqualTo(String value) {
            addCriterion("user_province <>", value, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceGreaterThan(String value) {
            addCriterion("user_province >", value, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceGreaterThanOrEqualTo(String value) {
            addCriterion("user_province >=", value, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceLessThan(String value) {
            addCriterion("user_province <", value, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceLessThanOrEqualTo(String value) {
            addCriterion("user_province <=", value, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceLike(String value) {
            addCriterion("user_province like", value, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceNotLike(String value) {
            addCriterion("user_province not like", value, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceIn(List<String> values) {
            addCriterion("user_province in", values, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceNotIn(List<String> values) {
            addCriterion("user_province not in", values, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceBetween(String value1, String value2) {
            addCriterion("user_province between", value1, value2, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_provinceNotBetween(String value1, String value2) {
            addCriterion("user_province not between", value1, value2, "user_province");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlIsNull() {
            addCriterion("user_avatarUrl is null");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlIsNotNull() {
            addCriterion("user_avatarUrl is not null");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlEqualTo(String value) {
            addCriterion("user_avatarUrl =", value, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlNotEqualTo(String value) {
            addCriterion("user_avatarUrl <>", value, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlGreaterThan(String value) {
            addCriterion("user_avatarUrl >", value, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlGreaterThanOrEqualTo(String value) {
            addCriterion("user_avatarUrl >=", value, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlLessThan(String value) {
            addCriterion("user_avatarUrl <", value, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlLessThanOrEqualTo(String value) {
            addCriterion("user_avatarUrl <=", value, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlLike(String value) {
            addCriterion("user_avatarUrl like", value, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlNotLike(String value) {
            addCriterion("user_avatarUrl not like", value, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlIn(List<String> values) {
            addCriterion("user_avatarUrl in", values, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlNotIn(List<String> values) {
            addCriterion("user_avatarUrl not in", values, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlBetween(String value1, String value2) {
            addCriterion("user_avatarUrl between", value1, value2, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_avatarUrlNotBetween(String value1, String value2) {
            addCriterion("user_avatarUrl not between", value1, value2, "user_avatarUrl");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneIsNull() {
            addCriterion("user_telephone is null");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneIsNotNull() {
            addCriterion("user_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneEqualTo(String value) {
            addCriterion("user_telephone =", value, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneNotEqualTo(String value) {
            addCriterion("user_telephone <>", value, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneGreaterThan(String value) {
            addCriterion("user_telephone >", value, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_telephone >=", value, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneLessThan(String value) {
            addCriterion("user_telephone <", value, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneLessThanOrEqualTo(String value) {
            addCriterion("user_telephone <=", value, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneLike(String value) {
            addCriterion("user_telephone like", value, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneNotLike(String value) {
            addCriterion("user_telephone not like", value, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneIn(List<String> values) {
            addCriterion("user_telephone in", values, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneNotIn(List<String> values) {
            addCriterion("user_telephone not in", values, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneBetween(String value1, String value2) {
            addCriterion("user_telephone between", value1, value2, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_telephoneNotBetween(String value1, String value2) {
            addCriterion("user_telephone not between", value1, value2, "user_telephone");
            return (Criteria) this;
        }

        public Criteria andUser_regionIsNull() {
            addCriterion("user_region is null");
            return (Criteria) this;
        }

        public Criteria andUser_regionIsNotNull() {
            addCriterion("user_region is not null");
            return (Criteria) this;
        }

        public Criteria andUser_regionEqualTo(String value) {
            addCriterion("user_region =", value, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionNotEqualTo(String value) {
            addCriterion("user_region <>", value, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionGreaterThan(String value) {
            addCriterion("user_region >", value, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionGreaterThanOrEqualTo(String value) {
            addCriterion("user_region >=", value, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionLessThan(String value) {
            addCriterion("user_region <", value, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionLessThanOrEqualTo(String value) {
            addCriterion("user_region <=", value, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionLike(String value) {
            addCriterion("user_region like", value, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionNotLike(String value) {
            addCriterion("user_region not like", value, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionIn(List<String> values) {
            addCriterion("user_region in", values, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionNotIn(List<String> values) {
            addCriterion("user_region not in", values, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionBetween(String value1, String value2) {
            addCriterion("user_region between", value1, value2, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_regionNotBetween(String value1, String value2) {
            addCriterion("user_region not between", value1, value2, "user_region");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeIsNull() {
            addCriterion("user_postalCode is null");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeIsNotNull() {
            addCriterion("user_postalCode is not null");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeEqualTo(String value) {
            addCriterion("user_postalCode =", value, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeNotEqualTo(String value) {
            addCriterion("user_postalCode <>", value, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeGreaterThan(String value) {
            addCriterion("user_postalCode >", value, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_postalCode >=", value, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeLessThan(String value) {
            addCriterion("user_postalCode <", value, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeLessThanOrEqualTo(String value) {
            addCriterion("user_postalCode <=", value, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeLike(String value) {
            addCriterion("user_postalCode like", value, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeNotLike(String value) {
            addCriterion("user_postalCode not like", value, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeIn(List<String> values) {
            addCriterion("user_postalCode in", values, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeNotIn(List<String> values) {
            addCriterion("user_postalCode not in", values, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeBetween(String value1, String value2) {
            addCriterion("user_postalCode between", value1, value2, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_postalCodeNotBetween(String value1, String value2) {
            addCriterion("user_postalCode not between", value1, value2, "user_postalCode");
            return (Criteria) this;
        }

        public Criteria andUser_noteIsNull() {
            addCriterion("user_note is null");
            return (Criteria) this;
        }

        public Criteria andUser_noteIsNotNull() {
            addCriterion("user_note is not null");
            return (Criteria) this;
        }

        public Criteria andUser_noteEqualTo(String value) {
            addCriterion("user_note =", value, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteNotEqualTo(String value) {
            addCriterion("user_note <>", value, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteGreaterThan(String value) {
            addCriterion("user_note >", value, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteGreaterThanOrEqualTo(String value) {
            addCriterion("user_note >=", value, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteLessThan(String value) {
            addCriterion("user_note <", value, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteLessThanOrEqualTo(String value) {
            addCriterion("user_note <=", value, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteLike(String value) {
            addCriterion("user_note like", value, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteNotLike(String value) {
            addCriterion("user_note not like", value, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteIn(List<String> values) {
            addCriterion("user_note in", values, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteNotIn(List<String> values) {
            addCriterion("user_note not in", values, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteBetween(String value1, String value2) {
            addCriterion("user_note between", value1, value2, "user_note");
            return (Criteria) this;
        }

        public Criteria andUser_noteNotBetween(String value1, String value2) {
            addCriterion("user_note not between", value1, value2, "user_note");
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
