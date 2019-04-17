package com.nsc.backend.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nsc.backend.entity.OrderSubExample.Criteria;
import com.nsc.backend.entity.OrderSubExample.Criterion;
import com.nsc.backend.entity.OrderSubExample.GeneratedCriteria;

public class OrderSubGoodsExample {
	
	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderSubGoodsExample() {
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

        public Criteria andUser_unionIdIsNull() {
            addCriterion("user_unionId is null");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdIsNotNull() {
            addCriterion("user_unionId is not null");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdEqualTo(Integer value) {
            addCriterion("user_unionId =", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotEqualTo(Integer value) {
            addCriterion("user_unionId <>", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdGreaterThan(Integer value) {
            addCriterion("user_unionId >", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_unionId >=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdLessThan(Integer value) {
            addCriterion("user_unionId <", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_unionId <=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdIn(List<Integer> values) {
            addCriterion("user_unionId in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotIn(List<Integer> values) {
            addCriterion("user_unionId not in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdBetween(Integer value1, Integer value2) {
            addCriterion("user_unionId between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andUser_unionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_unionId not between", value1, value2, "unionId");
            return (Criteria) this;
        }
        
        public Criteria andOrderGoods_idIsNull() {
            addCriterion("orderGoods_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idIsNotNull() {
            addCriterion("orderGoods_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idEqualTo(Integer value) {
            addCriterion("orderGoods_id =", value, "orderGoodsId");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idNotEqualTo(Integer value) {
            addCriterion("orderGoods_id <>", value, "orderGoodsId");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idGreaterThan(Integer value) {
            addCriterion("orderGoods_id >", value, "orderGoodsId");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderGoods_id >=", value, "orderGoodsId");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idLessThan(Integer value) {
            addCriterion("orderGoods_id <", value, "orderGoodsId");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idLessThanOrEqualTo(Integer value) {
            addCriterion("orderGoods_id <=", value, "orderGoodsId");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idIn(List<Integer> values) {
            addCriterion("orderGoods_id in", values, "orderGoodsId");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idNotIn(List<Integer> values) {
            addCriterion("orderGoods_id not in", values, "orderGoodsId");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idBetween(Integer value1, Integer value2) {
            addCriterion("orderGoods_id between", value1, value2, "orderGoodsId");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_idNotBetween(Integer value1, Integer value2) {
            addCriterion("orderGoods_id not between", value1, value2, "orderGoodsId");
            return (Criteria) this;
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

        public Criteria andOrdergoods_numberIsNull() {
            addCriterion("ordergoods_number is null");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberIsNotNull() {
            addCriterion("ordergoods_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberEqualTo(String value) {
            addCriterion("ordergoods_number =", value, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberNotEqualTo(String value) {
            addCriterion("ordergoods_number <>", value, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberGreaterThan(String value) {
            addCriterion("ordergoods_number >", value, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberGreaterThanOrEqualTo(String value) {
            addCriterion("ordergoods_number >=", value, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberLessThan(String value) {
            addCriterion("ordergoods_number <", value, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberLessThanOrEqualTo(String value) {
            addCriterion("ordergoods_number <=", value, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberLike(String value) {
            addCriterion("ordergoods_number like", value, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberNotLike(String value) {
            addCriterion("ordergoods_number not like", value, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberIn(List<String> values) {
            addCriterion("ordergoods_number in", values, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberNotIn(List<String> values) {
            addCriterion("ordergoods_number not in", values, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberBetween(String value1, String value2) {
            addCriterion("ordergoods_number between", value1, value2, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrdergoods_numberNotBetween(String value1, String value2) {
            addCriterion("ordergoods_number not between", value1, value2, "ordergoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countIsNull() {
            addCriterion("orderGoods_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countIsNotNull() {
            addCriterion("orderGoods_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countEqualTo(Integer value) {
            addCriterion("orderGoods_count =", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countNotEqualTo(Integer value) {
            addCriterion("orderGoods_count <>", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countGreaterThan(Integer value) {
            addCriterion("orderGoods_count >", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderGoods_count >=", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countLessThan(Integer value) {
            addCriterion("orderGoods_count <", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countLessThanOrEqualTo(Integer value) {
            addCriterion("orderGoods_count <=", value, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countIn(List<Integer> values) {
            addCriterion("orderGoods_count in", values, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countNotIn(List<Integer> values) {
            addCriterion("orderGoods_count not in", values, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countBetween(Integer value1, Integer value2) {
            addCriterion("orderGoods_count between", value1, value2, "orderGoodsCount");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_countNotBetween(Integer value1, Integer value2) {
            addCriterion("orderGoods_count not between", value1, value2, "orderGoodsCount");
            return (Criteria) this;
        }
        
        public Criteria andOrderGoods_TotalPriceIsNull() {
            addCriterion("orderGoods_TotalPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceIsNotNull() {
            addCriterion("orderGoods_TotalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceEqualTo(BigDecimal value) {
            addCriterion("orderGoods_TotalPrice =", value, "orderGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("orderGoods_TotalPrice <>", value, "orderGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceGreaterThan(BigDecimal value) {
            addCriterion("orderGoods_TotalPrice >", value, "orderGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("orderGoods_TotalPrice >=", value, "orderGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceLessThan(BigDecimal value) {
            addCriterion("orderGoods_TotalPrice <", value, "orderGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("orderGoods_TotalPrice <=", value, "orderGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceIn(List<BigDecimal> values) {
            addCriterion("orderGoods_TotalPrice in", values, "orderGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("orderGoods_TotalPrice not in", values, "orderGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderGoods_TotalPrice between", value1, value2, "orderGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_TotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderGoods_TotalPrice not between", value1, value2, "orderGoodsTotalPrice");
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

        public Criteria andStore_idIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStore_idIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStore_idEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStore_idNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStore_idGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStore_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStore_idLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStore_idLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStore_idIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStore_idNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStore_idBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStore_idNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }
        

        public Criteria andInvoiceIsNull() {
            addCriterion("invoice is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNotNull() {
            addCriterion("invoice is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEqualTo(Byte value) {
            addCriterion("invoice =", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotEqualTo(Byte value) {
            addCriterion("invoice <>", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThan(Byte value) {
            addCriterion("invoice >", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThanOrEqualTo(Byte value) {
            addCriterion("invoice >=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThan(Byte value) {
            addCriterion("invoice <", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThanOrEqualTo(Byte value) {
            addCriterion("invoice <=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceIn(List<Byte> values) {
            addCriterion("invoice in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotIn(List<Byte> values) {
            addCriterion("invoice not in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceBetween(Byte value1, Byte value2) {
            addCriterion("invoice between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotBetween(Byte value1, Byte value2) {
            addCriterion("invoice not between", value1, value2, "invoice");
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
        
//        public Criteria andOrder_isvalidIsNull() {
//            addCriterion("order_isvalid is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidIsNotNull() {
//            addCriterion("order_isvalid is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidEqualTo(Integer value) {
//            addCriterion("order_isvalid =", value, "orderIsvalid");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidNotEqualTo(Integer value) {
//            addCriterion("order_isvalid <>", value, "orderIsvalid");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidGreaterThan(Integer value) {
//            addCriterion("order_isvalid >", value, "orderIsvalid");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidGreaterThanOrEqualTo(Integer value) {
//            addCriterion("order_isvalid >=", value, "orderIsvalid");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidLessThan(Integer value) {
//            addCriterion("order_isvalid <", value, "orderIsvalid");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidLessThanOrEqualTo(Integer value) {
//            addCriterion("order_isvalid <=", value, "orderIsvalid");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidIn(List<Integer> values) {
//            addCriterion("order_isvalid in", values, "orderIsvalid");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidNotIn(List<Integer> values) {
//            addCriterion("order_isvalid not in", values, "orderIsvalid");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidBetween(Integer value1, Integer value2) {
//            addCriterion("order_isvalid between", value1, value2, "orderIsvalid");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_isvalidNotBetween(Integer value1, Integer value2) {
//            addCriterion("order_isvalid not between", value1, value2, "orderIsvalid");
//            return (Criteria) this;
//        }
//        
//        public Criteria andOrder_stateIsNull() {
//            addCriterion("order_state is null");
//            return (Criteria) this;
//        }
//        
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
        

//        public Criteria andOrder_stateIsNotNull() {
//            addCriterion("order_state is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateEqualTo(Byte value) {
//            addCriterion("order_state =", value, "orderState");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateNotEqualTo(Byte value) {
//            addCriterion("order_state <>", value, "orderState");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateGreaterThan(Byte value) {
//            addCriterion("order_state >", value, "orderState");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateGreaterThanOrEqualTo(Byte value) {
//            addCriterion("order_state >=", value, "orderState");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateLessThan(Byte value) {
//            addCriterion("order_state <", value, "orderState");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateLessThanOrEqualTo(Byte value) {
//            addCriterion("order_state <=", value, "orderState");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateIn(List<Byte> values) {
//            addCriterion("order_state in", values, "orderState");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateNotIn(List<Byte> values) {
//            addCriterion("order_state not in", values, "orderState");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateBetween(Byte value1, Byte value2) {
//            addCriterion("order_state between", value1, value2, "orderState");
//            return (Criteria) this;
//        }
//
//        public Criteria andOrder_stateNotBetween(Byte value1, Byte value2) {
//            addCriterion("order_state not between", value1, value2, "orderState");
//            return (Criteria) this;
//        }
//
//        


        public Criteria andOrderGoods_IsReturnGoodsIsNull() {
            addCriterion("orderGoods_IsReturnGoods is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsIsNotNull() {
            addCriterion("orderGoods_IsReturnGoods is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsEqualTo(Integer value) {
            addCriterion("orderGoods_IsReturnGoods =", value, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsNotEqualTo(Integer value) {
            addCriterion("orderGoods_IsReturnGoods <>", value, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsGreaterThan(Integer value) {
            addCriterion("orderGoods_IsReturnGoods >", value, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderGoods_IsReturnGoods >=", value, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsLessThan(Integer value) {
            addCriterion("orderGoods_IsReturnGoods <", value, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsLessThanOrEqualTo(Integer value) {
            addCriterion("orderGoods_IsReturnGoods <=", value, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsIn(List<Integer> values) {
            addCriterion("orderGoods_IsReturnGoods in", values, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsNotIn(List<Integer> values) {
            addCriterion("orderGoods_IsReturnGoods not in", values, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsBetween(Integer value1, Integer value2) {
            addCriterion("orderGoods_IsReturnGoods between", value1, value2, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        public Criteria andOrderGoods_IsReturnGoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("orderGoods_IsReturnGoods not between", value1, value2, "orderGoodsIsReturnGoods");
            return (Criteria) this;
        }

        

        public Criteria andOrderReturn_statusIsNull() {
            addCriterion("orderReturn_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusIsNotNull() {
            addCriterion("orderReturn_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusEqualTo(Integer value) {
            addCriterion("orderReturn_status =", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusNotEqualTo(Integer value) {
            addCriterion("orderReturn_status <>", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusGreaterThan(Integer value) {
            addCriterion("orderReturn_status >", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderReturn_status >=", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusLessThan(Integer value) {
            addCriterion("orderReturn_status <", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusLessThanOrEqualTo(Integer value) {
            addCriterion("orderReturn_status <=", value, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusIn(List<Integer> values) {
            addCriterion("orderReturn_status in", values, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusNotIn(List<Integer> values) {
            addCriterion("orderReturn_status not in", values, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusBetween(Integer value1, Integer value2) {
            addCriterion("orderReturn_status between", value1, value2, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("orderReturn_status not between", value1, value2, "orderReturnStatus");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonIsNull() {
            addCriterion("orderReturn_Reason is null");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonIsNotNull() {
            addCriterion("orderReturn_Reason is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonEqualTo(String value) {
            addCriterion("orderReturn_Reason =", value, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonNotEqualTo(String value) {
            addCriterion("orderReturn_Reason <>", value, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonGreaterThan(String value) {
            addCriterion("orderReturn_Reason >", value, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonGreaterThanOrEqualTo(String value) {
            addCriterion("orderReturn_Reason >=", value, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonLessThan(String value) {
            addCriterion("orderReturn_Reason <", value, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonLessThanOrEqualTo(String value) {
            addCriterion("orderReturn_Reason <=", value, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonLike(String value) {
            addCriterion("orderReturn_Reason like", value, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonNotLike(String value) {
            addCriterion("orderReturn_Reason not like", value, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonIn(List<String> values) {
            addCriterion("orderReturn_Reason in", values, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonNotIn(List<String> values) {
            addCriterion("orderReturn_Reason not in", values, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonBetween(String value1, String value2) {
            addCriterion("orderReturn_Reason between", value1, value2, "orderReturnReason");
            return (Criteria) this;
        }

        public Criteria andOrderReturn_ReasonNotBetween(String value1, String value2) {
            addCriterion("orderReturn_Reason not between", value1, value2, "orderReturnReason");
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
