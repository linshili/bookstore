package com.nsc.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsc.backend.entity.User;
import com.nsc.backend.entity.UserExample;
import com.nsc.backend.entity.UserExample.Criteria;
import com.nsc.backend.mapper.UserMapper;
import com.nsc.backend.service.IUserService;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.UUIDGenerator;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	private final String className = "IUserService";
	
	@Autowired
	private UserMapper userMapper;

	// 根据openId查找出用户
	public User findUserByopenId(String openId) {
		User user = userMapper.findUserByopenId(openId);
		return user;
	}

	// 将用户的openId保存到数据库
	public void saveUsers(User user) {
		userMapper.saveUser(user);
	}

	@Override
	public User findUserByUnionId(String unionId) {

		try {
			UserExample userExample = new UserExample();
			Criteria criteria = userExample.createCriteria();
			criteria.andUser_unionIdEqualTo(unionId);
			List<User> userList = userMapper.selectUserByExample(userExample);

			if (userList.size() == 1) {
				return userList.get(0);
			}
			if(userList.size() == 0) {				
				LogUtil.out(this.className, "findUserByUnionId", "查询结果为空");
				return null;
			}
			LogUtil.out(this.className, "findUserByUnionId", "查询条件有误");
			return null;
		} catch (Exception e) {
			LogUtil.out(this.className, "findUserByUnionId",e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveUser(User... users) {

		if(users == null) {
			return true;
		}
		try {
			for(int i = 0, len = users.length; i < len; i++) {
				int num = userMapper.insertUserSelective(users[i]);
			}
			return true;
		}catch(Exception e) {
			LogUtil.out(this.className, "saveUser", e.getMessage());
			return false;
		}
	}

	@Override
	public Integer findUserIdByUniondId(String unionId) {
		
		Integer userId = userMapper.findUserByUnionId(unionId);
		if(userId != null) {
			return userId;
		}
		
		return null;
	}

}
