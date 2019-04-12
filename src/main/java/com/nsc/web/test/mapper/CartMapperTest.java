package com.nsc.web.test.mapper;

import java.util.Date;
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
import com.nsc.web.util.DateTimeGenerator;

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
	
	//@Test
	public void testCartGoodsIsExsit() {
		
		CartExample cartExample = new CartExample();
		Criteria criteria = cartExample.createCriteria();
		
		System.out.println("xxx");
		criteria.andUser_unionIdEqualTo("o_1QS0WoXqiTeHge-MzBJ1CnPOL0");
		criteria.andBook_idEqualTo(58);

		List<Cart> cartList = cartMapper.selectByExample(cartExample);
		
		System.out.println(cartList.toString());
		
	}
	
	@Test
	public void testInsetCartItem() {
		
		Cart[] carts = new Cart[3];
		carts[0] = new Cart();
		carts[1] = new Cart();
		carts[2] = new Cart();
		
		Date dt0 = DateTimeGenerator.getDateTime();
		carts[0].setBookId(111);
		carts[0].setUserUnionId("oEQJo5CU3HdrlC_CXK1PWuN6knSo");
		carts[0].setCartUnitPrice(20.0);
		carts[0].setCartCount(10);
		carts[0].setCartSum( 20.0*(double)10 );
		carts[0].setCartJoinCartTime(dt0);
		carts[0].setCartModCartTime(dt0);
		
		Date dt1 = DateTimeGenerator.getDateTime();
		carts[1].setCartId(106);
		carts[1].setBookId(58);
		carts[1].setUserUnionId("oEQJo5L1jca2Ctp0fr4zwbg_Ghis");
		carts[1].setCartUnitPrice(12.0);
		carts[1].setCartCount(10);
		carts[1].setCartSum( 12.0*(double)10 );
		carts[1].setCartJoinCartTime(dt1);
		carts[1].setCartModCartTime(dt1);
		
		Date dt2 = DateTimeGenerator.getDateTime();
		carts[2].setBookId(58);
		carts[2].setUserUnionId("oEQJo5L1jca2Ctp0fr4zwbg_Ghis");
		carts[2].setCartUnitPrice(926.0);
		carts[2].setCartCount(10);
		carts[2].setCartSum( 926.0*(double)10 );
		carts[2].setCartJoinCartTime(dt2);
		carts[2].setCartModCartTime(dt2);
		
		
//		for(int i = 0, len = carts.length; i < len; i++) {
//			cartMapper.insertSelective(carts[i]);
//		}
		
		cartMapper.updateCart(carts[0]);
		cartMapper.updateByPrimaryKeySelective(carts[1]);
	}

}
