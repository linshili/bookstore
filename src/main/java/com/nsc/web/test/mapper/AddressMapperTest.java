package com.nsc.web.test.mapper;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nsc.backend.entity.Address;
import com.nsc.backend.mapper.AddressMapper;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:application-context.xml", "classpath:config/*.xml" })
//@WebAppConfiguration
public class AddressMapperTest {

	@Resource
	private AddressMapper addressMapper;
	
	@Test
	public void testGetAddressById() {
		
		Address addr = addressMapper.findAddressByIdAndUserId(null, 93);
		System.out.println(addr.toString());
		
	}
}
