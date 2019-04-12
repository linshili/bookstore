package com.nsc.backend.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartExample() {
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

        public Criteria andCart_idIsNull() {
            addCriterion("cart_id is null");
            return (Criteria) this;
        }

        public Criteria andCart_idIsNotNull() {
            addCriterion("cart_id is not null");
            return (Criteria) this;
        }

        public Criteria andCart_idEqualTo(Integer value) {
            addCriterion("cart_id =", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCart_idNotEqualTo(Integer value) {
            addCriterion("cart_id <>", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCart_idGreaterThan(Integer value) {
            addCriterion("cart_id >", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCart_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_id >=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCart_idLessThan(Integer value) {
            addCriterion("cart_id <", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCart_idLessThanOrEqualTo(Integer value) {
            addCriterion("cart_id <=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCart_idIn(List<Integer> values) {
            addCriterion("cart_id in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCart_idNotIn(List<Integer> values) {
            addCriterion("cart_id not in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCart_idBetween(Integer value1, Integer value2) {
            addCriterion("cart_id between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCart_idNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_id not between", value1, value2, "cartId");
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
            addCriterion("user_id =", value, "user_id");
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

        public Criteria andUser_unionIdIsNull() {
            addCriterion("user_unionId is null");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdIsNotNull() {
            addCriterion("user_unionId is not null");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdEqualTo(String value) {
            addCriterion("user_unionId =", value, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotEqualTo(String value) {
            addCriterion("user_unionId <>", value, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdGreaterThan(String value) {
            addCriterion("user_unionId >", value, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_unionId >=", value, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdLessThan(String value) {
            addCriterion("user_unionId <", value, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdLessThanOrEqualTo(String value) {
            addCriterion("user_unionId <=", value, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdLike(String value) {
            addCriterion("user_unionId like", value, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotLike(String value) {
            addCriterion("user_unionId not like", value, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdIn(List<String> values) {
            addCriterion("user_unionId in", values, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotIn(List<String> values) {
            addCriterion("user_unionId not in", values, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdBetween(String value1, String value2) {
            addCriterion("user_unionId between", value1, value2, "userUnionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotBetween(String value1, String value2) {
            addCriterion("user_unionId not between", value1, value2, "userUnionId");
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
            addCriterion("user_openId <>", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdGreaterThan(String value) {
            addCriterion("user_openId >", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_openId >=", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdLessThan(String value) {
            addCriterion("user_openId <", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdLessThanOrEqualTo(String value) {
            addCriterion("user_openId <=", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdLike(String value) {
            addCriterion("user_openId like", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdNotLike(String value) {
            addCriterion("user_openId not like", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdIn(List<String> values) {
            addCriterion("user_openId in", values, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdNotIn(List<String> values) {
            addCriterion("user_openId not in", values, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdBetween(String value1, String value2) {
            addCriterion("user_openId between", value1, value2, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUser_openIdNotBetween(String value1, String value2) {
            addCriterion("user_openId not between", value1, value2, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andBook_idIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBook_idIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBook_idEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBook_idNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBook_idGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBook_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBook_idLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBook_idLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBook_idIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBook_idNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBook_idBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBook_idNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeIsNull() {
            addCriterion("cart_joinCartTime is null");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeIsNotNull() {
            addCriterion("cart_joinCartTime is not null");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeEqualTo(Date value) {
            addCriterion("cart_joinCartTime =", value, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeNotEqualTo(Date value) {
            addCriterion("cart_joinCartTime <>", value, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeGreaterThan(Date value) {
            addCriterion("cart_joinCartTime >", value, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cart_joinCartTime >=", value, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeLessThan(Date value) {
            addCriterion("cart_joinCartTime <", value, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeLessThanOrEqualTo(Date value) {
            addCriterion("cart_joinCartTime <=", value, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeIn(List<Date> values) {
            addCriterion("cart_joinCartTime in", values, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeNotIn(List<Date> values) {
            addCriterion("cart_joinCartTime not in", values, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeBetween(Date value1, Date value2) {
            addCriterion("cart_joinCartTime between", value1, value2, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_joinCartTimeNotBetween(Date value1, Date value2) {
            addCriterion("cart_joinCartTime not between", value1, value2, "cartJoinCartTime");
            return (Criteria) this;
        }

        public Criteria andCart_sumIsNull() {
            addCriterion("cart_sum is null");
            return (Criteria) this;
        }

        public Criteria andCart_sumIsNotNull() {
            addCriterion("cart_sum is not null");
            return (Criteria) this;
        }

        public Criteria andCart_sumEqualTo(Double value) {
            addCriterion("cart_sum =", value, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_sumNotEqualTo(Double value) {
            addCriterion("cart_sum <>", value, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_sumGreaterThan(Double value) {
            addCriterion("cart_sum >", value, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_sumGreaterThanOrEqualTo(Double value) {
            addCriterion("cart_sum >=", value, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_sumLessThan(Double value) {
            addCriterion("cart_sum <", value, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_sumLessThanOrEqualTo(Double value) {
            addCriterion("cart_sum <=", value, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_sumIn(List<Double> values) {
            addCriterion("cart_sum in", values, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_sumNotIn(List<Double> values) {
            addCriterion("cart_sum not in", values, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_sumBetween(Double value1, Double value2) {
            addCriterion("cart_sum between", value1, value2, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_sumNotBetween(Double value1, Double value2) {
            addCriterion("cart_sum not between", value1, value2, "cartSum");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceIsNull() {
            addCriterion("cart_unitPrice is null");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceIsNotNull() {
            addCriterion("cart_unitPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceEqualTo(Double value) {
            addCriterion("cart_unitPrice =", value, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceNotEqualTo(Double value) {
            addCriterion("cart_unitPrice <>", value, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceGreaterThan(Double value) {
            addCriterion("cart_unitPrice >", value, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("cart_unitPrice >=", value, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceLessThan(Double value) {
            addCriterion("cart_unitPrice <", value, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceLessThanOrEqualTo(Double value) {
            addCriterion("cart_unitPrice <=", value, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceIn(List<Double> values) {
            addCriterion("cart_unitPrice in", values, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceNotIn(List<Double> values) {
            addCriterion("cart_unitPrice not in", values, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceBetween(Double value1, Double value2) {
            addCriterion("cart_unitPrice between", value1, value2, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_unitPriceNotBetween(Double value1, Double value2) {
            addCriterion("cart_unitPrice not between", value1, value2, "cartUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCart_countIsNull() {
            addCriterion("cart_count is null");
            return (Criteria) this;
        }

        public Criteria andCart_countIsNotNull() {
            addCriterion("cart_count is not null");
            return (Criteria) this;
        }

        public Criteria andCart_countEqualTo(Integer value) {
            addCriterion("cart_count =", value, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_countNotEqualTo(Integer value) {
            addCriterion("cart_count <>", value, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_countGreaterThan(Integer value) {
            addCriterion("cart_count >", value, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_count >=", value, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_countLessThan(Integer value) {
            addCriterion("cart_count <", value, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_countLessThanOrEqualTo(Integer value) {
            addCriterion("cart_count <=", value, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_countIn(List<Integer> values) {
            addCriterion("cart_count in", values, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_countNotIn(List<Integer> values) {
            addCriterion("cart_count not in", values, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_countBetween(Integer value1, Integer value2) {
            addCriterion("cart_count between", value1, value2, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_countNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_count not between", value1, value2, "cartCount");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedIsNull() {
            addCriterion("cart_IsDeleted is null");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedIsNotNull() {
            addCriterion("cart_IsDeleted is not null");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedEqualTo(Byte value) {
            addCriterion("cart_IsDeleted =", value, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedNotEqualTo(Byte value) {
            addCriterion("cart_IsDeleted <>", value, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedGreaterThan(Byte value) {
            addCriterion("cart_IsDeleted >", value, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("cart_IsDeleted >=", value, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedLessThan(Byte value) {
            addCriterion("cart_IsDeleted <", value, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("cart_IsDeleted <=", value, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedIn(List<Byte> values) {
            addCriterion("cart_IsDeleted in", values, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedNotIn(List<Byte> values) {
            addCriterion("cart_IsDeleted not in", values, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("cart_IsDeleted between", value1, value2, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_IsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("cart_IsDeleted not between", value1, value2, "cartIsDeleted");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckIsNull() {
            addCriterion("cart_isCheck is null");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckIsNotNull() {
            addCriterion("cart_isCheck is not null");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckEqualTo(Byte value) {
            addCriterion("cart_isCheck =", value, "cartIsCheck");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckNotEqualTo(Byte value) {
            addCriterion("cart_isCheck <>", value, "cartIsCheck");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckGreaterThan(Byte value) {
            addCriterion("cart_isCheck >", value, "cartIsCheck");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckGreaterThanOrEqualTo(Byte value) {
            addCriterion("cart_isCheck >=", value, "cartIsCheck");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckLessThan(Byte value) {
            addCriterion("cart_isCheck <", value, "cartIsCheck");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckLessThanOrEqualTo(Byte value) {
            addCriterion("cart_isCheck <=", value, "cartIsCheck");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckIn(List<Byte> values) {
            addCriterion("cart_isCheck in", values, "cartIsCheck");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckNotIn(List<Byte> values) {
            addCriterion("cart_isCheck not in", values, "cartIsCheck");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckBetween(Byte value1, Byte value2) {
            addCriterion("cart_isCheck between", value1, value2, "cartIsCheck");
            return (Criteria) this;
        }

        public Criteria andCart_isCheckNotBetween(Byte value1, Byte value2) {
            addCriterion("cart_isCheck not between", value1, value2, "cartIsCheck");
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