package com.nsc.backend.entity;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAdd_idIsNull() {
            addCriterion("add_id is null");
            return (Criteria) this;
        }

        public Criteria andAdd_idIsNotNull() {
            addCriterion("add_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_idEqualTo(Integer value) {
            addCriterion("add_id =", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_idNotEqualTo(Integer value) {
            addCriterion("add_id <>", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_idGreaterThan(Integer value) {
            addCriterion("add_id >", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_id >=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_idLessThan(Integer value) {
            addCriterion("add_id <", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_idLessThanOrEqualTo(Integer value) {
            addCriterion("add_id <=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_idIn(List<Integer> values) {
            addCriterion("add_id in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_idNotIn(List<Integer> values) {
            addCriterion("add_id not in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_idBetween(Integer value1, Integer value2) {
            addCriterion("add_id between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_idNotBetween(Integer value1, Integer value2) {
            addCriterion("add_id not between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameIsNull() {
            addCriterion("add_userName is null");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameIsNotNull() {
            addCriterion("add_userName is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameEqualTo(String value) {
            addCriterion("add_userName =", value, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameNotEqualTo(String value) {
            addCriterion("add_userName <>", value, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameGreaterThan(String value) {
            addCriterion("add_userName >", value, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameGreaterThanOrEqualTo(String value) {
            addCriterion("add_userName >=", value, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameLessThan(String value) {
            addCriterion("add_userName <", value, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameLessThanOrEqualTo(String value) {
            addCriterion("add_userName <=", value, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameLike(String value) {
            addCriterion("add_userName like", value, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameNotLike(String value) {
            addCriterion("add_userName not like", value, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameIn(List<String> values) {
            addCriterion("add_userName in", values, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameNotIn(List<String> values) {
            addCriterion("add_userName not in", values, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameBetween(String value1, String value2) {
            addCriterion("add_userName between", value1, value2, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_userNameNotBetween(String value1, String value2) {
            addCriterion("add_userName not between", value1, value2, "addUserName");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeIsNull() {
            addCriterion("add_postalCode is null");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeIsNotNull() {
            addCriterion("add_postalCode is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeEqualTo(String value) {
            addCriterion("add_postalCode =", value, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeNotEqualTo(String value) {
            addCriterion("add_postalCode <>", value, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeGreaterThan(String value) {
            addCriterion("add_postalCode >", value, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("add_postalCode >=", value, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeLessThan(String value) {
            addCriterion("add_postalCode <", value, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeLessThanOrEqualTo(String value) {
            addCriterion("add_postalCode <=", value, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeLike(String value) {
            addCriterion("add_postalCode like", value, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeNotLike(String value) {
            addCriterion("add_postalCode not like", value, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeIn(List<String> values) {
            addCriterion("add_postalCode in", values, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeNotIn(List<String> values) {
            addCriterion("add_postalCode not in", values, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeBetween(String value1, String value2) {
            addCriterion("add_postalCode between", value1, value2, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_postalCodeNotBetween(String value1, String value2) {
            addCriterion("add_postalCode not between", value1, value2, "addPostalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_countyIsNull() {
            addCriterion("add_county is null");
            return (Criteria) this;
        }

        public Criteria andAdd_countyIsNotNull() {
            addCriterion("add_county is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_countyEqualTo(String value) {
            addCriterion("add_county =", value, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyNotEqualTo(String value) {
            addCriterion("add_county <>", value, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyGreaterThan(String value) {
            addCriterion("add_county >", value, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyGreaterThanOrEqualTo(String value) {
            addCriterion("add_county >=", value, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyLessThan(String value) {
            addCriterion("add_county <", value, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyLessThanOrEqualTo(String value) {
            addCriterion("add_county <=", value, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyLike(String value) {
            addCriterion("add_county like", value, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyNotLike(String value) {
            addCriterion("add_county not like", value, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyIn(List<String> values) {
            addCriterion("add_county in", values, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyNotIn(List<String> values) {
            addCriterion("add_county not in", values, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyBetween(String value1, String value2) {
            addCriterion("add_county between", value1, value2, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_countyNotBetween(String value1, String value2) {
            addCriterion("add_county not between", value1, value2, "addCounty");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceIsNull() {
            addCriterion("add_province is null");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceIsNotNull() {
            addCriterion("add_province is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceEqualTo(String value) {
            addCriterion("add_province =", value, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceNotEqualTo(String value) {
            addCriterion("add_province <>", value, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceGreaterThan(String value) {
            addCriterion("add_province >", value, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceGreaterThanOrEqualTo(String value) {
            addCriterion("add_province >=", value, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceLessThan(String value) {
            addCriterion("add_province <", value, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceLessThanOrEqualTo(String value) {
            addCriterion("add_province <=", value, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceLike(String value) {
            addCriterion("add_province like", value, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceNotLike(String value) {
            addCriterion("add_province not like", value, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceIn(List<String> values) {
            addCriterion("add_province in", values, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceNotIn(List<String> values) {
            addCriterion("add_province not in", values, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceBetween(String value1, String value2) {
            addCriterion("add_province between", value1, value2, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_provinceNotBetween(String value1, String value2) {
            addCriterion("add_province not between", value1, value2, "addProvince");
            return (Criteria) this;
        }

        public Criteria andAdd_cityIsNull() {
            addCriterion("add_city is null");
            return (Criteria) this;
        }

        public Criteria andAdd_cityIsNotNull() {
            addCriterion("add_city is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_cityEqualTo(String value) {
            addCriterion("add_city =", value, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityNotEqualTo(String value) {
            addCriterion("add_city <>", value, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityGreaterThan(String value) {
            addCriterion("add_city >", value, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityGreaterThanOrEqualTo(String value) {
            addCriterion("add_city >=", value, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityLessThan(String value) {
            addCriterion("add_city <", value, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityLessThanOrEqualTo(String value) {
            addCriterion("add_city <=", value, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityLike(String value) {
            addCriterion("add_city like", value, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityNotLike(String value) {
            addCriterion("add_city not like", value, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityIn(List<String> values) {
            addCriterion("add_city in", values, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityNotIn(List<String> values) {
            addCriterion("add_city not in", values, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityBetween(String value1, String value2) {
            addCriterion("add_city between", value1, value2, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_cityNotBetween(String value1, String value2) {
            addCriterion("add_city not between", value1, value2, "addCity");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoIsNull() {
            addCriterion("add_detailInfo is null");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoIsNotNull() {
            addCriterion("add_detailInfo is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoEqualTo(String value) {
            addCriterion("add_detailInfo =", value, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoNotEqualTo(String value) {
            addCriterion("add_detailInfo <>", value, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoGreaterThan(String value) {
            addCriterion("add_detailInfo >", value, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoGreaterThanOrEqualTo(String value) {
            addCriterion("add_detailInfo >=", value, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoLessThan(String value) {
            addCriterion("add_detailInfo <", value, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoLessThanOrEqualTo(String value) {
            addCriterion("add_detailInfo <=", value, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoLike(String value) {
            addCriterion("add_detailInfo like", value, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoNotLike(String value) {
            addCriterion("add_detailInfo not like", value, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoIn(List<String> values) {
            addCriterion("add_detailInfo in", values, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoNotIn(List<String> values) {
            addCriterion("add_detailInfo not in", values, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoBetween(String value1, String value2) {
            addCriterion("add_detailInfo between", value1, value2, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_detailInfoNotBetween(String value1, String value2) {
            addCriterion("add_detailInfo not between", value1, value2, "addDetailInfo");
            return (Criteria) this;
        }

        public Criteria andAdd_teleIsNull() {
            addCriterion("add_tele is null");
            return (Criteria) this;
        }

        public Criteria andAdd_teleIsNotNull() {
            addCriterion("add_tele is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_teleEqualTo(String value) {
            addCriterion("add_tele =", value, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleNotEqualTo(String value) {
            addCriterion("add_tele <>", value, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleGreaterThan(String value) {
            addCriterion("add_tele >", value, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleGreaterThanOrEqualTo(String value) {
            addCriterion("add_tele >=", value, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleLessThan(String value) {
            addCriterion("add_tele <", value, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleLessThanOrEqualTo(String value) {
            addCriterion("add_tele <=", value, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleLike(String value) {
            addCriterion("add_tele like", value, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleNotLike(String value) {
            addCriterion("add_tele not like", value, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleIn(List<String> values) {
            addCriterion("add_tele in", values, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleNotIn(List<String> values) {
            addCriterion("add_tele not in", values, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleBetween(String value1, String value2) {
            addCriterion("add_tele between", value1, value2, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_teleNotBetween(String value1, String value2) {
            addCriterion("add_tele not between", value1, value2, "addTele");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeIsNull() {
            addCriterion("add_nationalCode is null");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeIsNotNull() {
            addCriterion("add_nationalCode is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeEqualTo(String value) {
            addCriterion("add_nationalCode =", value, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeNotEqualTo(String value) {
            addCriterion("add_nationalCode <>", value, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeGreaterThan(String value) {
            addCriterion("add_nationalCode >", value, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("add_nationalCode >=", value, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeLessThan(String value) {
            addCriterion("add_nationalCode <", value, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeLessThanOrEqualTo(String value) {
            addCriterion("add_nationalCode <=", value, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeLike(String value) {
            addCriterion("add_nationalCode like", value, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeNotLike(String value) {
            addCriterion("add_nationalCode not like", value, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeIn(List<String> values) {
            addCriterion("add_nationalCode in", values, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeNotIn(List<String> values) {
            addCriterion("add_nationalCode not in", values, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeBetween(String value1, String value2) {
            addCriterion("add_nationalCode between", value1, value2, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_nationalCodeNotBetween(String value1, String value2) {
            addCriterion("add_nationalCode not between", value1, value2, "addNationalCode");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultIsNull() {
            addCriterion("add_default is null");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultIsNotNull() {
            addCriterion("add_default is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultEqualTo(Byte value) {
            addCriterion("add_default =", value, "addDefault");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultNotEqualTo(Byte value) {
            addCriterion("add_default <>", value, "addDefault");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultGreaterThan(Byte value) {
            addCriterion("add_default >", value, "addDefault");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultGreaterThanOrEqualTo(Byte value) {
            addCriterion("add_default >=", value, "addDefault");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultLessThan(Byte value) {
            addCriterion("add_default <", value, "addDefault");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultLessThanOrEqualTo(Byte value) {
            addCriterion("add_default <=", value, "addDefault");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultIn(List<Byte> values) {
            addCriterion("add_default in", values, "addDefault");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultNotIn(List<Byte> values) {
            addCriterion("add_default not in", values, "addDefault");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultBetween(Byte value1, Byte value2) {
            addCriterion("add_default between", value1, value2, "addDefault");
            return (Criteria) this;
        }

        public Criteria andAdd_defaultNotBetween(Byte value1, Byte value2) {
            addCriterion("add_default not between", value1, value2, "addDefault");
            return (Criteria) this;
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
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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