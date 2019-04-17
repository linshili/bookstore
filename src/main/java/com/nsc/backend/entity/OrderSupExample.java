package com.nsc.backend.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderSupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderSupExample() {
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

        public Criteria andOrder_idIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrder_numberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrder_numberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_numberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_numberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_timeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_timeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_timeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeIsNull() {
            addCriterion("order_payTime is null");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeIsNotNull() {
            addCriterion("order_payTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeEqualTo(Date value) {
            addCriterion("order_payTime =", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeNotEqualTo(Date value) {
            addCriterion("order_payTime <>", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeGreaterThan(Date value) {
            addCriterion("order_payTime >", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_payTime >=", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeLessThan(Date value) {
            addCriterion("order_payTime <", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_payTime <=", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeIn(List<Date> values) {
            addCriterion("order_payTime in", values, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeNotIn(List<Date> values) {
            addCriterion("order_payTime not in", values, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeBetween(Date value1, Date value2) {
            addCriterion("order_payTime between", value1, value2, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_payTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_payTime not between", value1, value2, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeIsNull() {
            addCriterion("order_endTime is null");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeIsNotNull() {
            addCriterion("order_endTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeEqualTo(Date value) {
            addCriterion("order_endTime =", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeNotEqualTo(Date value) {
            addCriterion("order_endTime <>", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeGreaterThan(Date value) {
            addCriterion("order_endTime >", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_endTime >=", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeLessThan(Date value) {
            addCriterion("order_endTime <", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_endTime <=", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeIn(List<Date> values) {
            addCriterion("order_endTime in", values, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeNotIn(List<Date> values) {
            addCriterion("order_endTime not in", values, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeBetween(Date value1, Date value2) {
            addCriterion("order_endTime between", value1, value2, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_endTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_endTime not between", value1, value2, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountIsNull() {
            addCriterion("order_totalAcount is null");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountIsNotNull() {
            addCriterion("order_totalAcount is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountEqualTo(BigDecimal value) {
            addCriterion("order_totalAcount =", value, "orderTotalAcount");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountNotEqualTo(BigDecimal value) {
            addCriterion("order_totalAcount <>", value, "orderTotalAcount");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountGreaterThan(BigDecimal value) {
            addCriterion("order_totalAcount >", value, "orderTotalAcount");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_totalAcount >=", value, "orderTotalAcount");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountLessThan(BigDecimal value) {
            addCriterion("order_totalAcount <", value, "orderTotalAcount");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_totalAcount <=", value, "orderTotalAcount");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountIn(List<BigDecimal> values) {
            addCriterion("order_totalAcount in", values, "orderTotalAcount");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountNotIn(List<BigDecimal> values) {
            addCriterion("order_totalAcount not in", values, "orderTotalAcount");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_totalAcount between", value1, value2, "orderTotalAcount");
            return (Criteria) this;
        }

        public Criteria andOrder_totalAcountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_totalAcount not between", value1, value2, "orderTotalAcount");
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

        public Criteria andTradeTable_methodIsNull() {
            addCriterion("tradeTable_method is null");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodIsNotNull() {
            addCriterion("tradeTable_method is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodEqualTo(Integer value) {
            addCriterion("tradeTable_method =", value, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodNotEqualTo(Integer value) {
            addCriterion("tradeTable_method <>", value, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodGreaterThan(Integer value) {
            addCriterion("tradeTable_method >", value, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodGreaterThanOrEqualTo(Integer value) {
            addCriterion("tradeTable_method >=", value, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodLessThan(Integer value) {
            addCriterion("tradeTable_method <", value, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodLessThanOrEqualTo(Integer value) {
            addCriterion("tradeTable_method <=", value, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodIn(List<Integer> values) {
            addCriterion("tradeTable_method in", values, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodNotIn(List<Integer> values) {
            addCriterion("tradeTable_method not in", values, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodBetween(Integer value1, Integer value2) {
            addCriterion("tradeTable_method between", value1, value2, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_methodNotBetween(Integer value1, Integer value2) {
            addCriterion("tradeTable_method not between", value1, value2, "tradeTableMethod");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberIsNull() {
            addCriterion("tradeTable_number is null");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberIsNotNull() {
            addCriterion("tradeTable_number is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberEqualTo(String value) {
            addCriterion("tradeTable_number =", value, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberNotEqualTo(String value) {
            addCriterion("tradeTable_number <>", value, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberGreaterThan(String value) {
            addCriterion("tradeTable_number >", value, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberGreaterThanOrEqualTo(String value) {
            addCriterion("tradeTable_number >=", value, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberLessThan(String value) {
            addCriterion("tradeTable_number <", value, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberLessThanOrEqualTo(String value) {
            addCriterion("tradeTable_number <=", value, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberLike(String value) {
            addCriterion("tradeTable_number like", value, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberNotLike(String value) {
            addCriterion("tradeTable_number not like", value, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberIn(List<String> values) {
            addCriterion("tradeTable_number in", values, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberNotIn(List<String> values) {
            addCriterion("tradeTable_number not in", values, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberBetween(String value1, String value2) {
            addCriterion("tradeTable_number between", value1, value2, "tradeTableNumber");
            return (Criteria) this;
        }

        public Criteria andTradeTable_numberNotBetween(String value1, String value2) {
            addCriterion("tradeTable_number not between", value1, value2, "tradeTableNumber");
            return (Criteria) this;
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

        public Criteria andOrder_ispayIsNull() {
            addCriterion("order_ispay is null");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayIsNotNull() {
            addCriterion("order_ispay is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayEqualTo(Integer value) {
            addCriterion("order_ispay =", value, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayNotEqualTo(Integer value) {
            addCriterion("order_ispay <>", value, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayGreaterThan(Integer value) {
            addCriterion("order_ispay >", value, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_ispay >=", value, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayLessThan(Integer value) {
            addCriterion("order_ispay <", value, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayLessThanOrEqualTo(Integer value) {
            addCriterion("order_ispay <=", value, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayIn(List<Integer> values) {
            addCriterion("order_ispay in", values, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayNotIn(List<Integer> values) {
            addCriterion("order_ispay not in", values, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayBetween(Integer value1, Integer value2) {
            addCriterion("order_ispay between", value1, value2, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_ispayNotBetween(Integer value1, Integer value2) {
            addCriterion("order_ispay not between", value1, value2, "orderIspay");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalIsNull() {
            addCriterion("order_isequal is null");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalIsNotNull() {
            addCriterion("order_isequal is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalEqualTo(Integer value) {
            addCriterion("order_isequal =", value, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalNotEqualTo(Integer value) {
            addCriterion("order_isequal <>", value, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalGreaterThan(Integer value) {
            addCriterion("order_isequal >", value, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_isequal >=", value, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalLessThan(Integer value) {
            addCriterion("order_isequal <", value, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalLessThanOrEqualTo(Integer value) {
            addCriterion("order_isequal <=", value, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalIn(List<Integer> values) {
            addCriterion("order_isequal in", values, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalNotIn(List<Integer> values) {
            addCriterion("order_isequal not in", values, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalBetween(Integer value1, Integer value2) {
            addCriterion("order_isequal between", value1, value2, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isequalNotBetween(Integer value1, Integer value2) {
            addCriterion("order_isequal not between", value1, value2, "orderIsequal");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidIsNull() {
            addCriterion("order_isvalid is null");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidIsNotNull() {
            addCriterion("order_isvalid is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidEqualTo(Integer value) {
            addCriterion("order_isvalid =", value, "orderIsvalid");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidNotEqualTo(Integer value) {
            addCriterion("order_isvalid <>", value, "orderIsvalid");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidGreaterThan(Integer value) {
            addCriterion("order_isvalid >", value, "orderIsvalid");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_isvalid >=", value, "orderIsvalid");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidLessThan(Integer value) {
            addCriterion("order_isvalid <", value, "orderIsvalid");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidLessThanOrEqualTo(Integer value) {
            addCriterion("order_isvalid <=", value, "orderIsvalid");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidIn(List<Integer> values) {
            addCriterion("order_isvalid in", values, "orderIsvalid");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidNotIn(List<Integer> values) {
            addCriterion("order_isvalid not in", values, "orderIsvalid");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidBetween(Integer value1, Integer value2) {
            addCriterion("order_isvalid between", value1, value2, "orderIsvalid");
            return (Criteria) this;
        }

        public Criteria andOrder_isvalidNotBetween(Integer value1, Integer value2) {
            addCriterion("order_isvalid not between", value1, value2, "orderIsvalid");
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