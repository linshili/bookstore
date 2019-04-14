package com.nsc.backend.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.nsc.backend.entity.OrderSub;
import com.nsc.backend.entity.OrderSubExample;

public interface OrderSubMapper {
    long countByExample(OrderSubExample example);

    int deleteByExample(OrderSubExample example);

    int deleteByPrimaryKey(Integer orderGoodsId);

    int insert(OrderSub record);

    int insertSelective(OrderSub record);

    List<OrderSub> selectByExample(OrderSubExample example);

    OrderSub selectByPrimaryKey(Integer orderGoodsId);

    int updateByExampleSelective(@Param("record") OrderSub record, @Param("example") OrderSubExample example);

    int updateByExample(@Param("record") OrderSub record, @Param("example") OrderSubExample example);

    int updateByPrimaryKeySelective(OrderSub record);

    int updateByPrimaryKey(OrderSub record);
    
    
}