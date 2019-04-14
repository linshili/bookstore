package com.nsc.backend.mapper;

import java.util.List;

import com.nsc.backend.entity.User;
import com.nsc.backend.entity.UserExample;

/**
 * @Desc  Dao-UserMapper-User用户
 * @author sjg
 * @Date 2019年4月11日
 */
public interface UserMapper {
	
	//根据用户id查找出用户
	User findUserByopenId(String openId);
	//将用户的openId保存到数据库
	void saveUser(User user);
	/**
	 * 根据条件查询用户
	 * @param example
	 * @return
	 */
	List<User> selectUserByExample(UserExample example);
	
	/**
	 * 根据用户UnionId查找用户的id
	 * @param unionId
	 * @return userId
	 */
	Integer findUserByUnionId(String unionId);
	
	/**
	 * 选择性保存User到数据库
	 * @param user 
	 * @return 保存成功的记录数
	 */
	int insertUserSelective(User user);
}
