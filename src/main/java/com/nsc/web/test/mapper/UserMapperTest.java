package com.nsc.web.test.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nsc.backend.entity.User;
import com.nsc.backend.entity.UserExample;
import com.nsc.backend.entity.UserExample.Criteria;
import com.nsc.backend.mapper.ChangeMapper;
import com.nsc.backend.mapper.UserMapper;
import com.nsc.web.util.UUIDGenerator;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:application-context.xml", "classpath:config/*.xml" })
//@WebAppConfiguration
public class UserMapperTest {
	
	@Resource
	private UserMapper userMapper;
	
	/**
	 * 测试选择性插入User
	 */
	@Test
	public void testInsertUserSele() {
		
		User user = null;
		try {
			UserExample userExample = new UserExample();
			Criteria criteria = userExample.createCriteria();
			criteria.andUser_unionIdEqualTo("oEQJo5L1jca2Ctp0fr4zwbg_Ghis");

			
			List<User> userList = userMapper.selectUserByExample(userExample);
			if(userList.size() == 0) {
				//保存用户到数据库
				user = new User();
				user.setUnionId(UUIDGenerator.getUUID());
				user.setUserOpenId("o_1QS0WoXqiTeHge-MzBJ1CnPOLs");
				int num = userMapper.insertUserSelective(user);
				System.out.println("info--insert-wxUser-Yes"+num);
				return;
			}
			if(userList.size() == 1) {
				System.out.println("info--query--Yes");
				System.out.println(userList.toString());
				return;
			}
			System.out.println("Error");
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
		
		
	}
}
