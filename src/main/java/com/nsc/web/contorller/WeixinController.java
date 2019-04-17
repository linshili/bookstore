package com.nsc.web.contorller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.weixin4j.WeixinException;
import org.weixin4j.WeixinSupport;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsc.backend.service.IOrderBaseService;
import com.nsc.backend.service.IOrderGoodsService;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.weixin.PayUtil;
import com.nsc.web.util.weixin.config.WxPayConfig;
import com.nsc.web.util.weixin.vo.OAuthJsToken;

/**
 * @Date: 2018/4/8
 * @Author: wcf
 */
@RequestMapping("/weixin")
@RestController
public class WeixinController extends WeixinSupport {

	@Autowired
	IOrderBaseService orderBaseServiceImpl;
	@Autowired
	IOrderGoodsService orderGoodsServiceImpl;
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final String appid = "wxe166a8932b206268"; // 微信小程序appid
	private static final String secret = "a4f75c728f0ab90fe4ae41f55201d484"; // 微信小程序密钥
	private static final String grant_type = "authorization_code";
	private static final String classname = "WeixinController";

	/**
	 * 小程序后台登录，向微信平台发送获取access_token请求，并返回openId
	 * 
	 * @param code
	 * @return openid
	 * @throws WeixinException
	 * @throws IOException
	 * @since Weixin4J 1.0.0
	 */
	@RequestMapping("login")
	public Map<String, Object> login(String code, HttpServletRequest request) throws WeixinException, IOException {
		if (code == null || code.equals("")) {
			throw new WeixinException("invalid null, code is null.");
		}

		Map<String, Object> ret = new HashMap<String, Object>();
		// 拼接参数
		String param = "?grant_type=" + grant_type + "&appid=" + appid + "&secret=" + secret + "&js_code=" + code;

		// 创建请求对象
		HttpsClient http = new HttpsClient();
		// 调用获取access_token接口
		Response res = http.get("https://api.weixin.qq.com/sns/jscode2session" + param);
		// 根据请求结果判定，是否验证成功
		JSONObject jsonObj = res.asJSONObject();
		if (jsonObj != null) {
			Object errcode = jsonObj.get("errcode");
			if (errcode != null) {
				// 返回异常信息
				throw new WeixinException(getCause(Integer.parseInt(errcode.toString())));
			}

			ObjectMapper mapper = new ObjectMapper();
			OAuthJsToken oauthJsToken = mapper.readValue(jsonObj.toJSONString(), OAuthJsToken.class);

			logger.info("openid=" + oauthJsToken.getOpenid());
			ret.put("openid", oauthJsToken.getOpenid());
		}
		return ret;
	}

	//@RequestMapping("wxPay")
//	public Json wxPay(@RequestBody String orderInfo, HttpServletRequest request) {
//		// String openId,String orderNo,Integer paymoney,
//		Json json = new Json();
//		try {
//			JSONObject jsonObj = JSONObject.parseObject(orderInfo);
//			String openId = jsonObj.getString("openId");
//			String orderNo = "123456789";
//			Integer paymoney = 50;
//
//			System.out.println("openId=" + openId);
//			System.out.println("orderNo=" + orderNo);
//			// 生成的随机字符串
//			String nonce_str = StringUtils.getRandomStringByLength(32);
//			// 商品名称
//			String body = "测试图书-购买\"名称";
//			// 获取本机的ip地址
//			// String spbill_create_ip = IpUtils.getIpAddr(request);
//			InetAddress address = InetAddress.getLocalHost();// 获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
//			String spbill_create_ip = address.getHostAddress();// 192.168.0.121
//			System.out.println("获取本机的ip地址=" + spbill_create_ip);
//
//			// String orderNo = "123456789";
//			String money = paymoney.toString();// 支付金额，单位：分，这边需要转成字符串类型，否则后面的签名会失败
//			// String money = "1";
//
//			Map<String, String> packageParams = new HashMap<String, String>();
//			packageParams.put("appid", WxPayConfig.appid);
//			packageParams.put("mch_id", WxPayConfig.mch_id);
//			packageParams.put("nonce_str", nonce_str);
//			packageParams.put("body", body);
//			packageParams.put("out_trade_no", orderNo);// 商户订单号
//			packageParams.put("total_fee", money);// 支付金额，这边需要转成字符串类型，否则后面的签名会失败
//			packageParams.put("spbill_create_ip", spbill_create_ip);
//			packageParams.put("notify_url", WxPayConfig.notify_url);
//			packageParams.put("trade_type", WxPayConfig.TRADETYPE);
//			packageParams.put("openid", openId);
//
//			// 除去数组中的空值和签名参数
//			packageParams = PayUtil.paraFilter(packageParams);
//			String prestr = PayUtil.createLinkString(packageParams);// 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
//
//			// MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
//			String mysign = PayUtil.sign(prestr, WxPayConfig.key, "utf-8").toUpperCase();
//			logger.info("=======================第一次签名：" + mysign + "=====================");
//			System.out.println("第一次签名：\n" + mysign);
//
//			// 拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
//			String xml = "<xml>" + "<appid><![CDATA[" + WxPayConfig.appid + "]]></appid>" + "<body><![CDATA[" + body
//					+ "]]></body>"
//					// + "<body>" + body + "</body>"
//					+ "<mch_id><![CDATA[" + WxPayConfig.mch_id + "]]></mch_id>" + "<nonce_str><![CDATA[" + nonce_str
//					+ "]]></nonce_str>" + "<notify_url><![CDATA[" + WxPayConfig.notify_url + "]]></notify_url>"
//					+ "<openid><![CDATA[" + openId + "]]></openid>" + "<out_trade_no><![CDATA[" + orderNo
//					+ "]]></out_trade_no>" + "<spbill_create_ip><![CDATA[" + spbill_create_ip + "]]></spbill_create_ip>"
//					+ "<total_fee><![CDATA[" + money + "]]></total_fee>" + "<trade_type><![CDATA["
//					+ WxPayConfig.TRADETYPE + "]]></trade_type>" + "<sign><![CDATA[" + mysign + "]]></sign>" + "</xml>";
//
//			System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);
//
//			// 调用统一下单接口，并接受返回的结果
//			String result = PayUtil.httpRequest(WxPayConfig.pay_url, "POST", xml);
//
//			System.out.println("调试模式_统一下单接口 返回XML数据：" + result);
//
//			// 将解析结果存储在HashMap中
//			Map map = PayUtil.doXMLParse(result);
//
//			String return_code = (String) map.get("return_code");// 返回状态码
//			System.out.println("return_code=" + return_code);
//
//			// 返回给移动端需要的参数
//			Map<String, Object> response = new HashMap<String, Object>();
//			if (return_code == "SUCCESS" || return_code.equals(return_code)) {
//				// 业务结果
//				String prepay_id = (String) map.get("prepay_id");// 返回的预付单信息
//				response.put("nonceStr", nonce_str);
//				response.put("package", "prepay_id=" + prepay_id);
//				Long timeStamp = System.currentTimeMillis() / 1000;
//				response.put("timeStamp", timeStamp + "");// 这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
//
//				String stringSignTemp = "appId=" + WxPayConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id="
//						+ prepay_id + "&signType=" + WxPayConfig.SIGNTYPE + "&timeStamp=" + timeStamp;
//				// 再次签名，这个签名用于小程序端调用wx.requesetPayment方法
//				String paySign = PayUtil.sign(stringSignTemp, WxPayConfig.key, "utf-8").toUpperCase();
//				System.out.println("第二次签名：\n" + paySign);
//				logger.info("=======================第二次签名：" + paySign + "=====================");
//
//				response.put("paySign", paySign);
//				// 更新订单信息
//				// 业务逻辑代码
//
//			}
//
//			response.put("appid", WxPayConfig.appid);
//
//			json.setSuccess(true);
//			json.setData(response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			json.setSuccess(false);
//			json.setMsg("发起失败");
//		}
//		return json;
//	}

	/**
	 * @Description 接收微信支付通知结果，根据返回的结果判断微信支付是否成功
	 * @return
	 * @throws Exception
	 * @throws WeixinException
	 */
	@RequestMapping(value = "/wxNotify")
	public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		// sb为微信返回的xml
		String notityXml = sb.toString();
		String resXml = "";
		LogUtil.out(classname, "wxNotify--支付结果通知--", notityXml);
		// System.out.println("接收到的报文：" + notityXml);

		Map map = PayUtil.doXMLParse(notityXml);
		
		String jsonMap = JSON.toJSONString(map);
		String returnCode = (String) map.get("return_code");
		System.out.println("returnCode" + returnCode);

		if ("SUCCESS".equals(returnCode)) {

			LogUtil.out(classname, "wxNotify--", "SUCCESS.equals(returnCode)--状态码为OK--");

			String order_number = (String) map.get("out_trade_no");
			String time_end = (String) map.get("time_end");
			//微信支付交易号
			String transaction_id = (String) map.get("transaction_id");
			//微信支付总金额(单位：分)
			String total_fee = (String) map.get("total_fee");
			Integer sum = Integer.valueOf(total_fee);
			LogUtil.out(classname, "wxNotify--SUCCESS.equals(returnCode)--", "主订单交易号--"+order_number+"交易结束时间--"+time_end+"微信支付交易号--"+transaction_id+"微信支付总额(/分)--"+sum);

			// OrderBase o = orderBaseServiceImpl.findtotalAcount(order_number);//加了排他锁
			// //查看返回的支付金额是否与系统中(主订单)的金额相同
			// if(!o.getOrderTotalacount().toString().equals(total_fee)) {
			// orderBaseServiceImpl.setorderIsequal(order_number);
			// }
			// //查看订单是否已支付
			// if(o.getOrderIspay()==0) {
			//
			// 保存微信端返回的签名
			String sign = (String) map.get("sign");

			// 去除map中的sign
			map.remove("sign");

			String text = PayUtil.createLinkString(map);
			// 验证签名是否正确
			boolean falg = PayUtil.verify(text, sign, WxPayConfig.key, "utf-8");
			if (falg) {
				LogUtil.out(classname, "wxNotify--签名正确--", resXml);
				
				/** 此处添加自己的业务逻辑代码start **/
				
				String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
				time_end = time_end.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
				
					Boolean isOK = orderBaseServiceImpl.isOkTotalAcount(order_number, sum);
					if (isOK == true) {
						// 主订单信息正确
						orderBaseServiceImpl.setorderIsequal(order_number);
					}
					// 在主订单中填入支付时间与交易号字段的值并且把支付状态改为已支付
					orderBaseServiceImpl.updateOrderBaseByWx(order_number, time_end, transaction_id,jsonMap);
					// 根据主订单把所对应的所有子订单改为已付款状态
					orderGoodsServiceImpl.updateOrderStateToPaid(order_number);
					
					
				/** 此处添加自己的业务逻辑代码end **/
				// 通知微信服务器已经支付成功
				resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
						+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
			} else {
				LogUtil.out(classname, "wxNotify--签名错误--", resXml);
				
			}

			// }

		} else {
			System.out.println("returnCode is fail");
			LogUtil.out(classname, "wxNotify--微信支付返回通知失败--", notityXml);
			resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
					+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
		}
		LogUtil.out(classname, "wxNotify--微信支付回调数据结束--", resXml);

		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		out.write(resXml.getBytes());
		out.flush();
		out.close();
	}
}
