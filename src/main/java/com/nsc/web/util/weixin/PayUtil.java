package com.nsc.web.util.weixin;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.codec.digest.DigestUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONObject;
import com.nsc.web.util.LogUtil;
import com.nsc.web.util.StringUtils;
import com.nsc.web.util.weixin.config.WxPayConfig;
import com.nsc.web.vo.Json;

public class PayUtil {

	public static final String classname = "PayUtil";
	private static Logger logger = LoggerFactory.getLogger(PayUtil.class);
	private static final String appid = "wxe166a8932b206268"; // 微信小程序appid
	private static final String secret = "a4f75c728f0ab90fe4ae41f55201d484"; // 微信小程序密钥
	private static final String grant_type = "authorization_code";

	/**
	 * 签名字符串
	 * @param text需要签名的字符串
	 * @param key 密钥
	 * @param input_charset编码格式
	 * @return 签名结果
	 */
	public static String sign(String text, String key, String input_charset) {
		text = text + "&key=" + key;
		return DigestUtils.md5Hex(getContentBytes(text, input_charset));
	}

	/**
	 * 签名字符串
	 * 
	 * @param text需要签名的字符串
	 * @param sign
	 *            签名结果
	 * @param key密钥
	 * @param input_charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static boolean verify(String text, String sign, String key, String input_charset) {
		// text = text + key;
		text = text + "&key=" + key;
		String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
		mysign = mysign.toUpperCase();
		System.err.println("mysign===" + mysign);
		System.err.println("sign===" + sign);
		if (mysign.equals(sign)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param content
	 * @param charset
	 * @return
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
		}
	}

	/**
	 * 生成6位或10位随机数 param codeLength(多少位)
	 * 
	 * @return
	 */
	public static String createCode(int codeLength) {
		String code = "";
		for (int i = 0; i < codeLength; i++) {
			code += (int) (Math.random() * 9);
		}
		return code;
	}

	private static boolean isValidChar(char ch) {
		if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
			return true;
		if ((ch >= 0x4e00 && ch <= 0x7fff) || (ch >= 0x8000 && ch <= 0x952f))
			return true;// 简体中文汉字编码
		return false;
	}

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {
		Map<String, String> result = new HashMap<String, String>();
		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
					|| key.equalsIgnoreCase("sign_type")) {
				continue;
			}
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		System.err.println("参数=参数值”的模式用“&”字符拼接成字符串\n" + prestr);
		return prestr;
	}

	/**
	 * 
	 * @param requestUrl请求地址
	 * @param requestMethod请求方法
	 * @param outputStr参数
	 */
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
		// 创建SSLContext
		StringBuffer buffer = null;
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			// 往服务器端写内容
			if (null != outputStr) {
				OutputStream os = conn.getOutputStream();
				os.write(outputStr.getBytes("utf-8"));
				os.close();
			}
			// 读取服务器端返回的内容
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			buffer = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * 
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Map doXMLParse(String strxml) throws Exception {
		if (null == strxml || "".equals(strxml)) {
			return null;
		}

		Map m = new HashMap();
		InputStream in = String2Inputstream(strxml);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List children = e.getChildren();
			if (children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = getChildrenText(children);
			}

			m.put(k, v);
		}

		// 关闭流
		in.close();

		return m;
	}

	/**
	 * 获取子结点的xml
	 * 
	 * @param children
	 * @return String
	 */
	public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if (!children.isEmpty()) {
			Iterator it = children.iterator();
			while (it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if (!list.isEmpty()) {
					sb.append(getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}

		return sb.toString();
	}

	public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}

	/**
	 * 调用微信支付统一下单(商户在小程序中先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易后调起支付。 )
	 * 
	 * @param openId
	 *            微信用户openId
	 * @param orderNo
	 *            商户订单编号
	 * @param paymoney
	 *            订单总金额
	 * @return 预支付结果
	 */
	public static Json wxPay(String openId, String orderNo, BigDecimal paymoneySum) {
		String methodname = "wxPay";
		Json json = new Json();
		//微信支付以分为单位，不能带有小数
		Integer paymoney = (paymoneySum.multiply(BigDecimal.valueOf(100))).intValue();
		
		
		try {
			LogUtil.out(classname, methodname, "" + paymoney + openId + orderNo);

			// 生成的随机字符串
			String nonce_str = StringUtils.getRandomStringByLength(32);
			// 商品名称
			String body = "图书";
			// 获取本机的ip地址
			// String spbill_create_ip = IpUtils.getIpAddr(request);
			InetAddress address = InetAddress.getLocalHost();// 获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
			String spbill_create_ip = address.getHostAddress();// 192.168.0.121
			LogUtil.out(classname, methodname, "获取本机的ip地址=" + spbill_create_ip);

			String money = paymoney.toString();// 支付金额，单位：分，这边需要转成字符串类型，否则后面的签名会失败
			Map<String, String> packageParams = new HashMap<String, String>();
			packageParams.put("appid", WxPayConfig.appid);
			packageParams.put("mch_id", WxPayConfig.mch_id);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("body", body);
			packageParams.put("out_trade_no", orderNo);// 商户订单号
			packageParams.put("total_fee", money);// 支付金额，这边需要转成字符串类型，否则后面的签名会失败
			packageParams.put("spbill_create_ip", spbill_create_ip);
			packageParams.put("notify_url", WxPayConfig.notify_url);
			packageParams.put("trade_type", WxPayConfig.TRADETYPE);
			packageParams.put("openid", openId);

			// 除去数组中的空值和签名参数
			packageParams = PayUtil.paraFilter(packageParams);
			String prestr = PayUtil.createLinkString(packageParams);// 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

			// MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
			String mysign = PayUtil.sign(prestr, WxPayConfig.key, "utf-8").toUpperCase();
			logger.info("=======================预支付中：" + "" + paymoney + openId + orderNo + "=====================");
			logger.info("=======================第一次签名：" + mysign + "=====================");

			// 拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
			String xml = "<xml>" + "<appid><![CDATA[" + WxPayConfig.appid + "]]></appid>" + "<body><![CDATA[" + body
					+ "]]></body>"
					// + "<body>" + body + "</body>"
					+ "<mch_id><![CDATA[" + WxPayConfig.mch_id + "]]></mch_id>" + "<nonce_str><![CDATA[" + nonce_str
					+ "]]></nonce_str>" + "<notify_url><![CDATA[" + WxPayConfig.notify_url + "]]></notify_url>"
					+ "<openid><![CDATA[" + openId + "]]></openid>" + "<out_trade_no><![CDATA[" + orderNo
					+ "]]></out_trade_no>" + "<spbill_create_ip><![CDATA[" + spbill_create_ip + "]]></spbill_create_ip>"
					+ "<total_fee><![CDATA[" + money + "]]></total_fee>" + "<trade_type><![CDATA["
					+ WxPayConfig.TRADETYPE + "]]></trade_type>" + "<sign><![CDATA[" + mysign + "]]></sign>" + "</xml>";

			LogUtil.out(classname, methodname, "调试模式_统一下单接口 请求XML数据：" + xml);
			// System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);

			// 调用统一下单接口，并接受返回的结果
			String result = PayUtil.httpRequest(WxPayConfig.pay_url, "POST", xml);

			LogUtil.out(classname, methodname, "调试模式_统一下单接口 返回XML数据：" + result);
			// System.out.println("调试模式_统一下单接口 返回XML数据：" + result);

			// 将解析结果存储在HashMap中
			Map map = PayUtil.doXMLParse(result);

			String return_code = (String) map.get("return_code");// 返回状态码
			LogUtil.out(classname, methodname, "状态码return_code=" + return_code);
			// System.out.println("return_code="+return_code);

			// 返回给移动端需要的参数
			Map<String, Object> response = new HashMap<String, Object>();
			if (return_code == "SUCCESS" || return_code.equals(return_code)) {
				// 业务结果
				String prepay_id = (String) map.get("prepay_id");// 返回的预付单信息
				response.put("nonceStr", nonce_str);
				response.put("package", "prepay_id=" + prepay_id);
				Long timeStamp = System.currentTimeMillis() / 1000;
				response.put("timeStamp", timeStamp + "");// 这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误

				String stringSignTemp = "appId=" + WxPayConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id="
						+ prepay_id + "&signType=" + WxPayConfig.SIGNTYPE + "&timeStamp=" + timeStamp;
				// 再次签名，这个签名用于小程序端调用wx.requesetPayment方法
				String paySign = PayUtil.sign(stringSignTemp, WxPayConfig.key, "utf-8").toUpperCase();
				LogUtil.out(classname, methodname, "第二次签名：\n" + paySign);
				// System.out.println("第二次签名：\n"+paySign);
				logger.info("=======================第二次签名：" + paySign + "=====================");

				response.put("paySign", paySign);
				// 更新订单信息
				// 业务逻辑代码

			}

			response.put("appid", WxPayConfig.appid);
			json.setSuccess(true);
			json.setData(response);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("调用微信支付统一下单发起失败");
		}
		return json;
	}

}
