package com.nsc.web.contorller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nsc.backend.entity.Book;
import com.nsc.backend.entity.Cart;
import com.nsc.backend.entity.User;
import com.nsc.backend.service.IBookService;
import com.nsc.backend.service.ICartService;
import com.nsc.backend.service.IUserService;
import com.nsc.web.util.DateTimeGenerator;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.backstate.BackState;
import com.nsc.web.util.backstate.OpState;

/**
 * 商品加入购物车controller
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	
	private final String classname = "CartController";
	
	@Autowired
	private ICartService cartServiceImpl;
	@Autowired
	private IUserService userServiceImpl;
	@Autowired
	private IBookService bookServiceImpl;
	
	@RequestMapping("test")
	public void test(){
		System.out.println("这是测试方法的");
	}
	
	/**
	 * 保存用户购物车记录
	 * @param info {unionId:"",bookId:"",unitPrice:"",count:""}
	 * @return true/false(成功/失败)
	 */
	@RequestMapping("addToCartList")//N
	@ResponseBody
	public Boolean addToCartList( @RequestBody String info) {
		
		JSONObject jsonObj = JSONObject.parseObject(info);
		String unionId = jsonObj.getString("unionId");
		Integer bookId = (Integer)jsonObj.getInteger("bookId");
		Double unitPrice = (Double)jsonObj.getDouble("unitPrice");
		Integer count = (Integer)jsonObj.getInteger("count");
		try {
			//1.-判断是否已经存在记录
			//2.--是( booId + isDeleted == false ):更新记录
			//3.--否: 直接作为新纪录保存
			
			Cart cart = cartServiceImpl.getCartByBIdAndUId(bookId,unionId);
			Cart newCartItem = null;
			Date dateNow = DateTimeGenerator.getDateTime();
			if(cart==null){
				newCartItem = new Cart();
				newCartItem.setBookId(bookId);
				newCartItem.setUserUnionId(unionId);
				newCartItem.setCartCount(count);
				newCartItem.setCartUnitPrice(unitPrice);
				newCartItem.setCartJoinCartTime(dateNow);
				newCartItem.setCartModCartTime(dateNow);
				newCartItem.setCartSum(unitPrice*count);
				//保存newCartItem到数据库(insert)
				cartServiceImpl.saveCartItem(newCartItem);
				
			}else {
				newCartItem = new Cart();
				//重要============
				cart.setCartCount(cart.getCartCount()+count);
				cart.setCartSum(cart.getCartCount() *cart.getCartUnitPrice().doubleValue());
				cart.setCartModCartTime(dateNow);
				//重要============
				//保存更新后的cart到数据库(update)
				cartServiceImpl.updateCartItem(cart);
				
			}
			return OpState.OK;
			
		}catch(Exception e) {
			LogUtil.out(classname, "addToCartList", "添加用户的购物车数据异常"+e.toString());
			return OpState.ERROR;
		}
	}
	
	/**
	 * 添加购物车信息，如果已经包含则更新购物车的信息(弃)
	 * @param unionId
	 * @param bookId
	 * @param unitPrice
	 * @param count
	 */
	@RequestMapping("addToCart")//N
	@ResponseBody
	public Boolean addToCart(String unionId,Integer bookId,Double unitPrice,Integer count,String temp){
	
		try {
			//将用户的购物车信息保存到数据库
			//1.判断购物车是否有此商品
			Cart cart = cartServiceImpl.getCartByBIdAndUId(bookId,unionId);
			
			Cart addCart = new Cart();
			if(cart==null){
				Book book = new Book();
				//User user = new User();
				//查找用户和book,为cart添加外键
				User user = userServiceImpl.findUserByUnionId(unionId);
				//Book book = bookServiceImpl.findBookById(bookId);
				//user.setUserOpenId(openId);
				book.setBookId(bookId);
				//设置当前时间，保存购物车
				Date parse = null;
//				try {
//					Date date = new Date();
//					SimpleDateFormat sdf = new SimpleDateFormat();
//					String formate = sdf.format(date);
//					parse = sdf.parse(formate);
//				} catch (ParseException e) {
//					System.out.println("当前日期初始化错误");
//					e.printStackTrace();
//				}
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat();
				String formate = sdf.format(date);
				parse = sdf.parse(formate);
				addCart.setCartJoinCartTime(parse);
				addCart.setBook(book);
				addCart.setUser(user);
				addCart.setCartUnitPrice(unitPrice);
				addCart.setCartCount(count);
				Double sum = unitPrice.doubleValue()*count;
				addCart.setCartSum(sum);
				//保存订单信息到数据库
				cartServiceImpl.saveCart(addCart);
				System.out.println(addCart.getCartId()+"=========================");
				
				//为小程序返回，操作状态
				BackState bs = new BackState();
				bs.setStateName("HTTP State 200");//HTTP Status 404
			}else{
				Date parse = null;
				try {
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat();
					String formate = sdf.format(date);
					parse = sdf.parse(formate);
				} catch (ParseException e) {
					System.out.println("当前日期初始化错误");
					e.printStackTrace();
				}

				cart.setCartJoinCartTime(parse);
				
				//重要============
				cart.setCartCount(cart.getCartCount()+count);
				cart.setCartSum(cart.getCartCount() *cart.getCartUnitPrice().doubleValue());
				//重要============
				
				
				//将更新的购物车信息，在数据库进行更新
			    cartServiceImpl.updateCart(cart);
			    //为小程序返回，操作状态
				BackState bs = new BackState();
				bs.setStateId(Math.random());
				bs.setStateName("HTTP State 200");
				}
		}catch(Exception e) {
			LogUtil.out(classname, "addToCart", "异常--"+e.toString());
			return OpState.ERROR;
		}
		return false;
		
	}
	
	/**
	 * 保存用户缓存购物车记录(弃)
	 * @param para 
	 * @return
	 */
	@RequestMapping("cacheToCart")
	@ResponseBody
	public BackState cacheToCart(@RequestBody String para ){
		//测试json
		String testList = "{\"cartList\":[{\"bookId\":24,\"unitPrice\":52,\"count\":10},"
				+ "{\"bookId\":25,\"unitPrice\":38,\"count\":10},"
				+ "{\"bookId\":26,\"unitPrice\":39,\"count\":10}]}";
		String one = "{\"openId\":\"o_1QS0WoXqiTeHge-MzBJ1CnPOL0\",\"cartList\":[{\"bookId\":39,\"unitPrice\":2.3,\"count\":10}]}";
		JSONObject json = JSONObject.parseObject(para);
		JSONArray arr = (JSONArray) json.get("cartList");
		String openId = (String) json.get("openId");
		
		//查找用户和book,为cart添加外键
		User user = userServiceImpl.findUserByopenId(openId);
		//生成jsonArray解析为list
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<arr.size();i++){
			JSONObject jsonObject = arr.getJSONObject(i);
			Integer bookId = jsonObject.getInteger("bookId");
			Double unitPrice = jsonObject.getDouble("unitPrice");
			Integer count = jsonObject.getInteger("count");
			//判断购物车是否有此商品
			Cart cart = cartServiceImpl.getCartByBookId(bookId,openId);
			if(cart==null){
				Cart addCart = new Cart();
				Book book = new Book();
				book.setBookId(bookId);
				//设置当前时间，保存购物车
				Date parse = null;
				try {
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat();
					String formate = sdf.format(date);
					parse = sdf.parse(formate);
				} catch (ParseException e) {
					System.out.println("当前日期初始化错误");
					e.printStackTrace();
				}
				addCart.setCartJoinCartTime(parse);
				addCart.setBook(book);
				addCart.setUser(user);
				addCart.setCartUnitPrice(unitPrice);
				addCart.setCartCount(count);
				addCart.setCartSum(unitPrice*count);
				//保存订单信息到数据库
				cartServiceImpl.saveCart(addCart);
				System.out.println(addCart.getCartId()+"=========================");
				
			}else{
				Date parse = null;
				try {
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat();
					String formate = sdf.format(date);
					parse = sdf.parse(formate);
				} catch (ParseException e) {
					System.out.println("当前日期初始化错误");
					e.printStackTrace();
				}
				cart.setCartJoinCartTime(parse);
				cart.setCartCount(cart.getCartCount()+count);
				cart.setCartSum(cart.getCartCount()*cart.getCartUnitPrice());
				//将更新的购物车信息，在数据库进行更新
			    cartServiceImpl.updateCart(cart);
			}
		}
		//为小程序返回，操作状态
		BackState bs = new BackState();
		bs.setStateName("HTTP State 200");//HTTP Status 404
		return bs ;
	}
	
	/**
	 * 删除购物车信息，根据cartId,并且将删除之后的信息，查询并且返回去
	 */
	@RequestMapping("deleteCart")
	@ResponseBody
	public Boolean deleteBooks(@RequestBody String para){
		//测试数据json串
		try {
			/*String paralist ="{\"unionId\":\"o_1QS0WoXqiTeHge-MzBJ1CnPOL0\","
					+ "\"cartList\":[{\"cartId\":17},{\"cartId\":18},{\"cartId\":19}]}";*/
			JSONObject json = JSONObject.parseObject(para);
			JSONArray arr = (JSONArray) json.get("cartList");
			String unionId = (String) json.get("unionId");
			//生成jsonArray解析为list
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<arr.size();i++){
				JSONObject jsonObject = arr.getJSONObject(i);
				list.add(jsonObject.getInteger("cartId"));
			}
			//将list传向持久层，删除购物车信息
			boolean isOk = cartServiceImpl.deleteCart(list);
			if(isOk == true) {
				return OpState.OK;
			}
			return OpState.ERROR;
		}catch(Exception e) {
			LogUtil.out(classname, "deleteBooks", "exception-->"+e.toString());
			return OpState.ERROR;
		}
		
	}
	
	
	/**
	 *	根据cartId和count修改，购物车中书籍中数量 
	 * @param cartId
	 * @param count
	 */
	@RequestMapping("updateBookCount")
	@ResponseBody
	public Boolean updateBookCount(Integer cartId,Integer count){
		//修改数据中cart的count,先查找出cart，进行更新
		System.out.println("cartId="+cartId+"   count="+count);
		try {
			Cart cart = cartServiceImpl.findCartByCartId(cartId);
			cart.setCartCount(count);
			cart.setCartSum( (double)count*cart.getCartUnitPrice());
			cart.setCartModCartTime(DateTimeGenerator.getDateTime());
			boolean isOK = cartServiceImpl.updateBookCount(cart);
			if(isOK == true) {
				return OpState.OK;				
			}else {
				return OpState.ERROR;
			}
		}catch(Exception e){
			LogUtil.out(classname, "updateBookCount", "exception-->"+e.toString());
			return OpState.ERROR;
		}

	}
	
	
	@RequestMapping("isCheck")
	@ResponseBody
	public void isCheck(String cartparam) {
		
		String param_1 ="{\"cartList\":[{\"cartId\":01},{\"cartId\":01},{\"cartId\":03}]}";
		JSONObject json = JSONObject.parseObject(cartparam);
		JSONArray arrcart = (JSONArray) json.get("cartList");
		List<Integer> cartlist = new ArrayList<Integer>();
		for(int i=0;i<arrcart.size();i++){
			JSONObject jsonObject = arrcart.getJSONObject(i);
			cartlist.add(jsonObject.getInteger("cartId"));
		}
		
		cartlist.add(62);
		cartlist.add(64);
		cartlist.add(67);
		
		cartServiceImpl.isCheck(cartlist);
		
	}
	
	@RequestMapping("isDelete")
	@ResponseBody
	public void isDelete( String cartparam) {
		
		String param_1 ="{\"cartList\":[{\"cartId\":01},{\"cartId\":01},{\"cartId\":03}]}";
		JSONObject json = JSONObject.parseObject(cartparam);
		JSONArray arrcart = (JSONArray) json.get("cartList");
		List<Integer> cartlist = new ArrayList<Integer>();
		for(int i=0;i<arrcart.size();i++){
			JSONObject jsonObject = arrcart.getJSONObject(i);
			cartlist.add(jsonObject.getInteger("cartId"));
		}
		
		cartlist.add(62);
		cartlist.add(65);
		cartlist.add(66);
		
		cartServiceImpl.updateIsDelete(cartlist);
		
	}
	
	@RequestMapping("/addOrDele")
	@ResponseBody
	public BackState addOrDele(@RequestBody String cartparam){
		
		String param__1="{\"cartList\":[{cartId:71,count:3},{cartId:72,count:67},{cartId:73,count:5}]}";
		JSONObject json=JSONObject.parseObject(param__1);
		JSONArray array=(JSONArray)json.get("cartList");
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		List<Map<String,String>> list=new ArrayList<>();
		for(int i=0;i<array.size();i++){
			JSONObject json1=array.getJSONObject(i);
			String carId=json1.getString("cartId");
			Integer count=json1.getInteger("count");
			map.put(carId, count);

			System.out.println(map.toString());
			/*list.add(map);*/
		}
		BackState bs=new BackState();
		bs=cartServiceImpl.updCount(map);
		return bs;
	}
	
	/**
	 * 根据用户的unionId，将此用户加入到购物车的信息返回到前台
	 * @param unionId
	 * @return
	 */
	@RequestMapping(value= "showCart",method= RequestMethod.POST)
	@ResponseBody
	public List<Cart> showCart(@RequestBody String unionId){
		
		JSONObject json = JSONObject.parseObject(unionId);
		List<Cart> carts = cartServiceImpl.showCart(json.getString("unionId"));
		LogUtil.out(classname, "showCart", "查找用户购物车数据成功 共计--"+ carts.size() +"条");
		
		return carts ;
	}
	
}
