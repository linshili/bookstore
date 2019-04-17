package com.nsc.backend.service;

import com.nsc.backend.entity.User;

//操作用户的接口
public interface IUserService {
	//根据用户id查找出用户
	User findUserByopenId(String openId);
	//将用户的openId保存到数据库
	void saveUsers(User user);
	
	/**
	 * 根据全局唯一标识unionId查询用户
	 * @param unionId 全局唯一标识unionId
	 * @return userId
	 */
	User findUserByUnionId(String unionId);
	
	/**
	 * 根据全局唯一标识unionId查询用户
	 * @param unionId
	 * @return userId
	 */
	Integer findUserIdByUniondId(String unionId);
	
	/**
	 * 根据传入的用户保存到数据库
	 * @param users
	 * @return true/false(成功/失败)
	 */
	boolean saveUser(User...users);
	
}
