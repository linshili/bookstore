package com.nsc.backend.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.nsc.backend.entity.OrderSub;
import com.nsc.backend.entity.OrderSubExample;
import com.nsc.backend.entity.OrderSubGoods;

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
    
    /**
     * 根据用户unionId查找用户订单
     * @param unionId 用户唯一unionId
     * @return 子订单实例数组
     */
    List<OrderSubGoods> selectOrderAll(String unionId);
    
    List<OrderSubGoods> selectOrderPendingPay(@Param("unionId") String unionId,@Param("index") Integer index);
    
}