package com.nsc.web.contorller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.nsc.backend.entity.Address;
import com.nsc.backend.entity.AddressExample;
import com.nsc.backend.entity.AddressExample.Criteria;
import com.nsc.backend.entity.Book;
import com.nsc.backend.entity.OrderBase;
import com.nsc.backend.entity.OrderGoods;
import com.nsc.backend.entity.OrderSub;
import com.nsc.backend.entity.OrderSubGoods;
import com.nsc.backend.entity.OrderSup;
import com.nsc.backend.entity.OrderSupStatus;
import com.nsc.backend.entity.Store;
import com.nsc.backend.entity.User;
import com.nsc.backend.service.IAddressService;
import com.nsc.backend.service.IBookService;
import com.nsc.backend.service.ICartService;
import com.nsc.backend.service.IOrderBaseService;
import com.nsc.backend.service.IOrderGoodsService;
import com.nsc.backend.service.IStoreService;
import com.nsc.backend.service.IUserService;
import com.nsc.web.util.DateTimeGenerator;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.OrderUtil;
import com.nsc.web.util.ROrderGoods;
import com.nsc.web.util.backstate.BackState;
import com.nsc.web.util.backstate.OpState;
import com.nsc.web.util.weixin.PayUtil;
import com.nsc.web.vo.Json;

@Controller
@RequestMapping("OrderGoods")
public class OrderGoodsController {
	
	public final static String classname = "OrderGoodsController";
	
	@Autowired
	IBookService bookServiceImpl;
	@Autowired
	IUserService userServiceImpl;
	@Autowired
	IAddressService addressServiceImpl;
	@Autowired
	IOrderGoodsService orderGoodsServiceImpl;
	@Autowired
	IOrderBaseService orderBaseServiceImpl;
	@Autowired
	IStoreService storeserviceImpl;
	@Autowired
	ICartService cartserviceImpl;
	/** 保存主订单
	 *  @param order_totalAcount 支付总金额
	 *  @param tradeTable_method 支付方式
	 *  @param openId  
	 */
	/** 保存子订单
	 *  @param orderGoods_count	商品数量
	 *  @param orderGoods_IsGift	是否赠品
	 *  @param orderGoods_IsDiscounts	是否电商平台折扣
	 *  @param orderGoods_isStoreDiscount	是否店铺优惠
	 *  @param orderGoods_DiscounAmount	订单优惠金额
	 *  @param orderGoods_TotalPrice	商品总价
	 *  @param orderFreightList	订单运费
	 *  @param orderReightRiskList	订单运费险
	 *  @param book_id	商品id	
	 *  @param openId  
	 *  @param addId  用户选择的地址
	 *  @param note	备注
	 * @throws java.text.ParseException 
	 */

	@RequestMapping("/addToOrderGoods")
	@ResponseBody
	//@RequestBody String orderparam,@RequestBody String goodsparam
	public List<Object> addToOrderGoods(@RequestBody String paramgoods,HttpServletRequest request)  {
		
		String jp ="{\"openId\":\"oEQJo5KSAQWbkD2D7rMxZZHtVI78\",\"addId\":\"83\","
				+"\"goodslist\":[{\"bookId\":\"1\",\"count\":\"3\",\"invoice\":\"1\",\"totalprice\":\"200\"},"
				              +"{\"bookId\":\"2\",\"count\":\"2\",\"invoice\":\"0\",\"totalprice\":\"60\"},"
		                     +"{\"bookId\":\"3\",\"count\":\"1\",\"invoice\":\"0\",\"totalprice\":\"34\"}],"
		          +"\"order_totalAcount\":\"365\"}";
				
		System.out.println("paramgoods="+paramgoods);
		JSONObject json = JSONObject.parseObject(paramgoods);
		System.out.println("===="+paramgoods);
		String openId = json.getString("openId");
		
		Integer addId = json.getInteger("addId");
		Integer totalAcount = json.getInteger("order_totalAcount");
		
		List<Object> states = new ArrayList<Object>();//存放返回给前台的数据放在states里
		
		
		BackState state =new BackState();//存放主订单信息
		User user = userServiceImpl.findUserByopenId(openId);//获取用户信息
		Address address = addressServiceImpl.findAddressById(addId);//获取用户收获地址
		
		String s ="=======================主订单===========================";
		//订单编号
		String order_number =OrderUtil.getOrderNum(0);
		//订单生成时间
		Date order_time = null;
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat();
			String formate = sdf.format(date);
			order_time = sdf.parse(formate);
		} catch (ParseException e) {
			System.out.println("当前日期初始化 错误");
			e.printStackTrace();
		}
		
		OrderBase orderbase = new OrderBase();
		try {
			
			orderbase.setOrderNumber(order_number);
			orderbase.setOrderTime(order_time);
			orderbase.setOrderTotalacount(totalAcount);
			orderbase.setUser(user);
			orderbase.setTradetableMethod(1);
			orderbase.setAddress(address);
			
			System.out.println(orderbase.toString());
			orderBaseServiceImpl.saveOrderbase(orderbase);
			state.setStateName("HTTP Status 200");
			state.setOrderNumber("主订单:"+order_number);
		
		}catch(Exception e) {
			state.setStateName("主订单生成异常！");
			System.out.println("主订单生成异常！");
		}
		
		//若主订单生成异常，则则重新生成，
		int n=0;
		while(orderbase.getOrderId()==null&&n<5) {
			orderbase.setOrderNumber(OrderUtil.getOrderNum(0));
			orderBaseServiceImpl.saveOrderbase(orderbase);
			System.out.println("订单一重新生成！");
			state.setStateName("HTTP Status 200");
			state.setOrderNumber("主订单:"+order_number);
			n++;
		}
		states.add(state);
		s="=============================================================";
		
		
		s="========================子订单=====================================";
		
		String js1 = "{goodslist:[{bookId:1,count:3,invoice:1,totalprice:200},{},{}]}";
		
		JSONArray goodslist = json.getJSONArray("goodslist");
		
		for(int i=0;i<goodslist.size();i++) {
			OrderGoods ordergoods =new OrderGoods();
			BackState state1 = new BackState();
			JSONObject jsonobject = goodslist.getJSONObject(i);
			Integer bookId = jsonobject.getInteger("bookId");
			Integer count = jsonobject.getInteger("count");
			Integer invoice = jsonobject.getInteger("invoice");
			Integer totalprice = jsonobject.getInteger("totalprice");
			Integer storeId = bookServiceImpl.findStoreIdBybookId(bookId);
			Book book = bookServiceImpl.findBookById(bookId);
			Store store = storeserviceImpl.findStoreByStoreId(storeId);
			try {
				ordergoods.setOrderBase(orderbase);
				ordergoods.setOrderNumber(orderbase.getOrderNumber());
				ordergoods.setOrdergoodsNumber(OrderUtil.getOrderNum(storeId));
				ordergoods.setOrderState(0);//订单支付状态初始值为0
				ordergoods.setOrdergoodsCount(count);
				ordergoods.setInvoice(invoice);
				ordergoods.setOrdergoodsIsreturngoods(0);//是否已退货
				ordergoods.setOrdergoodsTotalprice(totalprice);
				ordergoods.setBook(book);
				ordergoods.setStore(store);
				ordergoods.setOrderreturnStatus(0);//是否退货
				ordergoods.setOrderreturnReason("无");
				System.out.println("插入数据库之前："+ordergoods.toString());
				
				orderGoodsServiceImpl.saveOrderGoods(ordergoods);
				
				n=0;
				//若主订单生成异常，则则重新生成，
				while(ordergoods.getOrdergoodsId()==null&&n<5) {
					ordergoods.setOrdergoodsNumber(OrderUtil.getOrderNum(storeId));
					orderGoodsServiceImpl.saveOrderGoods(ordergoods);
					System.out.println("订单一重新生成！");
					state.setStateName("HTTP Status 200");
					state.setOrderNumber("子订单:"+bookId+"-"+ordergoods.getOrdergoodsNumber());
					n++;
				}
				System.out.println("插入数据库之后："+ordergoods.toString());
				
				state1.setStateName("HTTP Status 200");
				state1.setOrderNumber("子订单:"+bookId+"-"+ordergoods.getOrdergoodsNumber());
				
				//购物是否选中，物理删除购物车
				cartserviceImpl.changeStatus(openId,bookId);
				
			}catch(Exception e) {
				state1.setStateName("子订单生成异常！");
				System.out.println("子订单生成异常！");
			}
			states.add(state1);
			
		}
		s="=============================================================";
		
		
		s="=======================调用统一下单接口，发起支付=============================";
		Json payjson = new Json();
		WeixinController w = new WeixinController();
		System.out.println("+++++++++WeixinController+++++++++");
		//payjson=w.wxPay(openId, orderbase.getOrderNumber(), totalAcount, request);
		payjson = null;
		System.out.println("调用统一下单接口返回值payjson===="+payjson.toString());
		states.add(payjson);
		s="=============================================================";
		
		
		//输出所有返回值
		for(Object j:states) {
			System.out.println(j.toString());
		}
		return states;
	}

	
	/**
	 * 根据用户的openId，将此用户所有订单的信息返回到前台
	 * @param openId
	 * @return
	 */
	@RequestMapping(value= "showOrderGoods",method= RequestMethod.POST)
	public @ResponseBody List<ROrderGoods> showOrderGoods(@RequestBody String openId){
		//根据用户id将此用户的购物信息，查找出来
		System.out.println("this is showOrderGoods："+openId);
		JSONObject json = JSONObject.parseObject(openId);
		openId = json.getString("openId");
		System.out.println("openId="+openId);
		User user = userServiceImpl.findUserByopenId(openId);
		System.out.println("USER"+user);
		List<OrderBase> listb=null;
		try {
			listb = orderBaseServiceImpl.findOrderBaseByOpenId(user.getUserId());
			System.out.println("listb="+listb);
		} catch (Exception e) {
            System.out.println("无此人信息！");
		}

    	
    	List<OrderGoods> list =null;
    	List<ROrderGoods> listr=null;
    	try {
    		list= orderGoodsServiceImpl.showOrderGoods(listb);
    		listr = new ArrayList<ROrderGoods>();
        	System.out.println("list=="+list.size());
        	System.out.println("listb=="+listb.size());
        	for(int i=0;i<list.size();i++) {
        		for(int j=0;j<listb.size();j++) {
        			if(list.get(i).getOrderBase().getOrderId()==listb.get(j).getOrderId()) {
    		    		ROrderGoods rordergoods = new ROrderGoods();
    		    		rordergoods.setOrdergoodsId(list.get(i).getOrdergoodsId());
    		    		rordergoods.setOrderNumber(list.get(i).getOrderNumber());
    		    		rordergoods.setOrdergoodsNumber(list.get(i).getOrdergoodsNumber());
    		    		rordergoods.setOrderState(list.get(i).getOrderState());
    		    		rordergoods.setOrdergoodsCount(list.get(i).getOrdergoodsCount());
    		    		rordergoods.setInvoice(list.get(i).getInvoice());
    		    		rordergoods.setOrdergoodsIsreturngoods(list.get(i).getOrdergoodsIsreturngoods());
    		    		rordergoods.setOrdergoodsTotalprice(list.get(i).getOrdergoodsTotalprice());
    		    		rordergoods.setOrderreturnStatus(list.get(i).getOrderreturnStatus());
    		    		rordergoods.setOrderreturnReason(list.get(i).getOrderreturnReason());
    		    		rordergoods.setOrderTime(listb.get(j).getOrderTime());
    		    		rordergoods.setTradetableNumber(listb.get(j).getTradetableNumber());
    		    		rordergoods.setOrderPaytime(listb.get(j).getOrderPaytime());
    		    		rordergoods.setAddress(listb.get(j).getAddress());
    		    		rordergoods.setBook(list.get(i).getBook());
    		    		rordergoods.setStore(list.get(i).getStore());
    		    		listr.add(rordergoods);
    		    		Collections.sort(listr, new Comparator<ROrderGoods>() {
    		                @Override
    		                public int compare(ROrderGoods o1, ROrderGoods o2) {
    		                    //降序
    		                	int n;
    		                		n=o2.getOrderTime().compareTo(o1.getOrderTime());
    		                		
    		                    return n;
    		                }
    		            });
    		      
    		        	for(ROrderGoods r:listr) {
    		        		System.out.println(r.toString());
    		        		
    		        	}
    		    		
        			}
    	    		
        		}
        	}
		} catch (Exception e) {
             System.out.println("此人的购物车信息为空！");
		}finally{
			return listr ;
			}
    	
	}
	
	/**
	 * 根据用户的unionId，将此用户所有未支付订单的信息返回到前台
	 * @param unionId
	 * @return 
	 */
	@RequestMapping("/getPending")
	@ResponseBody 
	public Object getPending(@RequestBody String info){
		
		JSONObject jsonObj = JSON.parseObject(info);
		String unionId = (String)jsonObj.get("unionId");
		Integer index = (Integer)jsonObj.get("index");
		
		List<OrderSubGoods> orderSubGoods = null;
		try {
			orderSubGoods = orderGoodsServiceImpl.getPendingPay(unionId, index);
			return orderSubGoods;
		}catch(Exception e) {
			
			LogUtil.out(classname, "getPending--", "exception--"+e.toString());
			return OpState.ERROR;
		}
		
	}
	
	@RequestMapping(value= "commitSubOrderByWx",method= RequestMethod.POST)
	@ResponseBody
	public Object commitSubOrderByWx(@RequestBody String subOrderInfo) {
		
		try {
			JSONObject jsonObj = JSONObject.parseObject(subOrderInfo);
			System.out.println(jsonObj);
			//1.获取用户唯一Id
			String unionId = jsonObj.getString("unionId");
			//2.获取微信用户的openId，用作微信支付接口的参数
			String openId = jsonObj.getString("openId");
			BigDecimal moneySum = jsonObj.getBigDecimal("moneySum");
			//3.获取收货地址
			JSONObject addrJson = jsonObj.getJSONObject("addr");
			Address address = JSON.parseObject(addrJson.toJSONString(), new TypeReference<Address>() {});
			Integer addrId = address.getAddId();
			//4.获取商品
			JSONArray list = jsonObj.getJSONArray("orderGoods");
			OrderSub orderSub = JSON.parseObject(list.toJSONString(), new TypeReference< OrderSub >(){} );
			
			if( addrId == null) {
				//5.保存用户的收货通讯地址
				Integer id = addressServiceImpl.saveWeiAdd(address);
				if(id == null) {
					LogUtil.out(classname, "coommitSubOrder", "保存地址失败-->boolean isOk = addressServiceImpl.saveWeiAdd(address);");
					return OpState.ERROR;
				}
			}
			String subOrderNum = orderSub.getOrdergoodsNumber();
			Integer supOrderId = orderBaseServiceImpl.getSupOrderId( subOrderNum );
			if( supOrderId == null ) {
				//根据子订单生成新的主订单(即将生成的主订单将会和子订单的编号一致)
				OrderSup orderSup = new OrderSup();
				orderSup.setOrderTime(DateTimeGenerator.getDateTime());
				orderSup.setOrderNumber( subOrderNum );
				orderSup.setOrderTotalAcount(moneySum);
				orderSup.setAddId(addrId);
				orderSup.setOrderIsvalid(OrderSupStatus.InAva.getCode());
				orderSup.setOrderIspay(OrderSupStatus.NoPay.getCode());
				Integer userId = userServiceImpl.findUserIdByUniondId(unionId);
				if(userId != null ) {
					orderSup.setUserId(userId);
				}else {
					LogUtil.out(classname, "coommitSubOrder", "没有找到匹配的用户--");
					return OpState.ERROR;
				}
				
				supOrderId = orderBaseServiceImpl.saveSupOrderToGetId(orderSup);
				if(supOrderId == null) {
					LogUtil.out(classname, "coommitSubOrder", "保存主订单失败--");
					return OpState.ERROR;
				}
				//更新子订单的关联主订单Id
				boolean isOk = orderGoodsServiceImpl.updateSubOrderForOId(supOrderId, subOrderNum);
			
				if(isOk != true) {
					LogUtil.out(classname, "coommitSubOrder", "更新子订单中主订单Id失败--");
					return OpState.ERROR;
				}
			}
			//6.调用微信支付接口,发起微信支付统一下单
			Json result = PayUtil.wxPay(openId, orderSub.getOrdergoodsNumber(), moneySum);
			if(result.isSuccess()==false) {
				return OpState.ERROR;
			}
			return result;
			
		}catch(Exception e) {
			LogUtil.out(classname, "commitSubOrder", "exception-->"+e.toString());
		}
		
		return OpState.ERROR;
	}
	
	/**
	 * 逻辑删除子订单
	 * 
	 * @param ordergoodsnumber
	 * @return
	 */
	@RequestMapping("updateOGoodsState")
	public BackState updateOGoodsState(String ordergoodsnumber,Integer state) {
		
		orderGoodsServiceImpl.updateOGoodsState(ordergoodsnumber,state);
		BackState backState = new BackState();
		backState.setStateName("HTTP State 200");
		return backState;
	}
	
}
