package com.nsc.backend.mapper;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.nsc.backend.entity.OrderSup;
import com.nsc.backend.entity.OrderSupExample;


public interface OrderSupMapper {
    long countByExample(OrderSupExample example);

    int deleteByExample(OrderSupExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderSup record);

    int insertSelective(OrderSup record);

    List<OrderSup> selectByExample(OrderSupExample example);

    OrderSup selectByPrimaryKey(Integer orderId);
    
    /**
     * 查询主订单Id
     * @param orderNum
     * @return 主订单Id
     */
    Integer selectByNum(@Param("orderNum") String orderNum);
    
    /**
     * 查询主订单总金额
     * @param orderNum 主订单编号
     * @return 主订单金额
     */
    BigDecimal getTotalAcount(@Param("orderNum") String orderNum);
    
    int updateOrderBasePayTime(@Param("orderNum") String orderNumber, @Param("payTime") String payTime, @Param("tMerchantnumber") String tMerchantnumber, @Param("orderNote") String orderNote);

    int updateByExampleSelective(@Param("record") OrderSup record, @Param("example") OrderSupExample example);

    int updateByExample(@Param("record") OrderSup record, @Param("example") OrderSupExample example);

    int updateByPrimaryKeySelective(OrderSup record);

    int updateByPrimaryKey(OrderSup record);
    
    int setorderIsequal(@Param("orderNum") String orderNum);
}