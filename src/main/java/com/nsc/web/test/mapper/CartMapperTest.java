package com.nsc.web.test.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nsc.backend.entity.Cart;
import com.nsc.backend.entity.CartExample;
import com.nsc.backend.entity.CartExample.Criteria;
import com.nsc.backend.mapper.CartMapper;

/**
 * 
 * @Desc  购物车Mapper接口测试类
 * @author sjg
 * @Date 2019年4月12日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml", "classpath:config/*.xml" })
@WebAppConfiguration
public class CartMapperTest {
	
	@Resource
	private CartMapper cartMapper;
	
	@Test
	public void testCartGoodsIsExsit() {
		
		CartExample cartExample = new CartExample();
		Criteria criteria = cartExample.createCriteria();
		
		System.out.println("xxx");
		criteria.andUser_unionIdEqualTo("o_1QS0WoXqiTeHge-MzBJ1CnPOL0");
		criteria.andBook_idEqualTo(58);

		List<Cart> cartList = cartMapper.selectByExample(cartExample);
		
		System.out.println(cartList.toString());
		
	}

}
