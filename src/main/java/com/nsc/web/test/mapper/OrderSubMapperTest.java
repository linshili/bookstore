package com.nsc.web.test.mapper;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONArray;
import com.nsc.backend.entity.OrderSubGoods;
import com.nsc.backend.mapper.OrderSubMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml", "classpath:config/*.xml" })
@WebAppConfiguration
public class OrderSubMapperTest {

	@Resource
	OrderSubMapper orderSubMapper;
	
	
	/**
	 * 获取未支付订单
	 */
	@Test
	public void testGetNoPay() {
		
		String unionId = "oEQJo5L1jca2Ctp0fr4zwbg_Ghis";
		
		List<OrderSubGoods> orderSubGoodses = orderSubMapper.selectOrderPendingPay(unionId,0);
		String jsonArr = JSONArray.toJSONString(orderSubGoodses);
		
		System.out.println(orderSubGoodses.size());
		
		
		
	}

}
