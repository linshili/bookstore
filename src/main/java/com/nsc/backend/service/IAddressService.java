package com.nsc.backend.service;

import java.util.List;

import com.nsc.backend.entity.Address;
import com.nsc.backend.entity.AddressExample;

//地址管理接口
public interface IAddressService {
	//接受微信授权地址，并且如果能够接受到的话，设为默认地址
	
	Integer saveWeiAdd(Address add);
	//获取用户的所有收货地址
	List<Address> findAllAddress(Integer userId);
	//更新address信息
	void updateAddress(Address add);
	//加载用户的默认地址
	Address findDefaultAdd(Integer integer);
	//通过add的id查找address
	Address findAddressById(Integer addId);
	//通过addr的id和用户的userId查找address
	Address findAddressByIdAndUserId(Integer userId,Integer addId);
	
	/**
	 * 根据地址实例条件查找地址记录
	 * @param example
	 * @return 地址实例数组
	 */
	public List<Address> findAddressesByExample(AddressExample example );
	
}
