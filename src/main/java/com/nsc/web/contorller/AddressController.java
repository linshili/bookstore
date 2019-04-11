package com.nsc.web.contorller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.nsc.backend.entity.Address;
import com.nsc.backend.entity.User;
import com.nsc.backend.service.IAddressService;
import com.nsc.backend.service.IUserService;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.backstate.BackState;
import com.nsc.web.util.backstate.OpState;

//管理用户收货地址
@Controller
@RequestMapping("address")
public class AddressController {

	private final String classname = "AddressController";
	
	@Autowired
	private IAddressService addressServiceImpl;
	@Autowired
	private IUserService userServiceImpl;

	// 接受微信授权地址，并且如果能够接受到的话，设为默认地址
	@RequestMapping("saveWeiAdd") // Y-get
	@ResponseBody
	public Boolean addWeiAdd(String unionId, String userName, String postalCode, String provinceName, String cityName,
			String countyName, String detailInfo, String nationalCode, String telNumber) {

		//User user = userServiceImpl.findUserByopenId(unionId);
		try {
			User user = userServiceImpl.findUserByUnionId(unionId);
			System.out.println("user======================" + user);
			Address add = new Address();
			add.setAddUserName(userName);
			add.setAddPostalCode(postalCode);
			add.setAddProvince(provinceName);
			add.setAddCity(cityName);
			add.setAddCounty(countyName);
			add.setAddDetailInfo(detailInfo);
			add.setAddNationalCode(nationalCode);
			add.setAddTele(telNumber);
			add.setAddDefault(true);
			add.setUser(user);
			System.out.println("add=====================" + add);
			boolean isOk =  addressServiceImpl.saveWeiAdd(add);
			if(isOk == true) {
				return OpState.OK;
			}
			
			return OpState.ERROR;
		}catch(Exception e) {
			LogUtil.out(classname, "addWeiAdd", "保存微信地址异常"+e.toString());
			return OpState.ERROR;
		}
		

	}

	// 接受微信授权地址，并且如果能够接受到的话，设为默认地址
	@RequestMapping("addAddress") // Y-post
	@ResponseBody
	public Boolean addAddress(@RequestBody String para) {
		BackState bs = null;
		System.out.println("para============" + para);
		JSONObject json = JSONObject.parseObject(para);
		String unionId = (String) json.get("unionId");
		String userName = (String) json.get("userName");
		String postalCode = (String) json.get("postalCode");
		String provinceName = (String) json.get("provinceName");
		String cityName = (String) json.get("cityName");
		String countyName = (String) json.get("countyName");
		String detailInfo = (String) json.get("detailInfo");
		String nationalCode = (String) json.get("nationalCode");
		String telNumber = (String) json.get("telNumber");

		//User user = userServiceImpl.findUserByopenId(openId);
		User user = userServiceImpl.findUserByUnionId(unionId);
		Address add = new Address();
		add.setAddUserName(userName);
		add.setAddPostalCode(postalCode);
		add.setAddProvince(provinceName);
		add.setAddCity(cityName);
		add.setAddCounty(countyName);
		add.setAddDetailInfo(detailInfo);
		add.setAddNationalCode(nationalCode);
		add.setAddTele(telNumber);
		add.setAddDefault(true);
		add.setUser(user);

		// 保存之前，先将其他的地址设置为0
		List<Address> list = addressServiceImpl.findAllAddress(user.getUserId());
		if (list != null) {
			Iterator<Address> it = list.iterator();
			while (it.hasNext()) {
				Address add1 = it.next();
				if (add1.getAddDefault()) {
					add1.setAddDefault(false);
					addressServiceImpl.updateAddress(add1);
				}
			}
		}
		boolean isOK = addressServiceImpl.saveWeiAdd(add);
		if(isOK == true) {
			LogUtil.out(classname, "addAddress", "保存地址到数据库失败");
			// 返回状态码
			return OpState.OK;
		}
		return OpState.ERROR;
	}

	// 展示用户的所有收货地址
	@RequestMapping("showAddress") // Y-post
	@ResponseBody
	public List<Address> showAddress(@RequestBody String unionId) {
		List<Address> list = new ArrayList<>();
		try {
			System.out.println("Start--" + unionId + "--End");
			JSONObject json = JSONObject.parseObject(unionId);
			System.out.println("json=" + json);
			String id = (String) json.get("unionId");
			System.out.println("id=" + id);
			//User userByopenId = userServiceImpl.findUserByopenId(id);
			User userByUnionId = userServiceImpl.findUserByUnionId(id);
			list = addressServiceImpl.findAllAddress(userByUnionId.getUserId());
			System.out.println("showAddress success");
		}catch(Exception e) {
			LogUtil.out(classname, "showAddress", "查询所有地址异常"+e.toString());
		}
		return list;
		
	}

	// 修改用户的默认地址
	@RequestMapping("modifyDeAdd")
	@ResponseBody
	public Boolean modifyDeAdd(@RequestBody Map<String,Object> map) {
		// 返回状态码
		System.out.println("unionId=" + map.get("unionId") + " addId=" + map.get("addId"));
		try {
			String unionId = (String) map.get("unionId");
			Integer addId = (Integer) map.get("addId");
			System.out.println("unionId=" + unionId + " addId=" + addId);
			// 将所有的收货地址查出来，原来默认的为false，新的为true
			//User userByopenId = userServiceImpl.findUserByopenId(openId);
			User userByUnionId = userServiceImpl.findUserByUnionId(unionId);
			System.out.println("userByUnionId=" + userByUnionId);
			List<Address> list = addressServiceImpl.findAllAddress(userByUnionId.getUserId());
			Iterator<Address> it = list.iterator();
			while (it.hasNext()) {
				Address add = it.next();
				if (add.getAddDefault()) {
					add.setAddDefault(false);
					addressServiceImpl.updateAddress(add);
				}
				if (add.getAddId() == addId) {
					add.setAddDefault(true);
					addressServiceImpl.updateAddress(add);
				}
			}
			return OpState.OK;

		}catch(Exception e) {
			return OpState.ERROR;
		}
	}

	// 加载用户的默认地址
	@RequestMapping("showDeAddress") // Y-post
	@ResponseBody
	public void findDeAddress(HttpServletResponse response, @RequestBody String unionId) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		JSONObject json = JSONObject.parseObject(unionId);
		
		try {
			//String id = (String) json.get("openId");
			//User user = userServiceImpl.findUserByopenId(id);
			String id = (String) json.get("uinonId");
			User user = userServiceImpl.findUserByUnionId(id);
			Address address = addressServiceImpl.findDefaultAdd(user.getUserId());
			Map<String,Address> map = new HashMap<>();
			map.put("address", address);
			JSONObject jObj = (JSONObject) JSONObject.toJSON(map);
			response.getWriter().write(jObj.toString());
			LogUtil.out(classname, "findDeAddress", "获取默认地址成功--");
		}catch(Exception e) {
			LogUtil.out(classname, "findDeAddress", "获取默认地址失败--"+e.toString());
			response.getWriter().write("Error");
		}
		
		return;
	}
	
	/**
	 * 修改微信用户的地址
	 * @param response
	 * @param strmap {unionId:"",addId:"" }
	 * @return true/false
	 */
	@RequestMapping("modAddress") // Y-post
	@ResponseBody
	public Boolean modifiedAddress(HttpServletResponse response, @RequestBody String strmap) {
		
		try {
			JSONObject json = JSONObject.parseObject(strmap);
			String unionId = (String) json.get("unionId");
			Integer addId = (Integer) json.get("addId");
			System.out.println("info--modifiedAddress --\n"+addId);
			String userName = (String) json.get("userName");
			String postalCode = (String) json.get("postalCode");
			String provinceName = (String) json.get("provinceName");
			String cityName = (String) json.get("cityName");
			String countyName = (String) json.get("countyName");
			String detailInfo = (String) json.get("detailInfo");
			String nationalCode = (String) json.get("nationalCode");
			String telNumber = (String) json.get("telNumber");
			User userByUnionId = userServiceImpl.findUserByUnionId(unionId);
			System.out.println("userByopenId=" + userByUnionId);

			// 将所有的收货地址查出来，原来默认的为false，新的为true
			Address addr = addressServiceImpl.findAddressByIdAndUserId(addId,userByUnionId.getUserId());
			if(addr != null) {
				addr.setAddUserName(userName);
				addr.setAddPostalCode(postalCode);
				addr.setAddCity(cityName);
				addr.setAddCounty(countyName);
				addr.setAddDetailInfo(detailInfo);
				addr.setAddNationalCode(nationalCode);
				addr.setAddTele(telNumber);
				addressServiceImpl.updateAddress(addr);
			}else {
				return OpState.ERROR;
			}
			return OpState.OK;
		}catch(Exception e) {
			return OpState.ERROR;
		}
	}

}
