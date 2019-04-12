package com.nsc.web.contorller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nsc.backend.entity.User;
import com.nsc.backend.service.IUserService;
import com.nsc.web.util.CommonUtil;
import com.nsc.web.util.LogUtil;

import net.sf.json.JSONObject;

/**
 * 获取微信用户信息
 * 
 * @author Lenovo
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private final String classname = "UserController";

	@Autowired
	private IUserService userServiceImpl;

	// 获取微信用户的信息
	// public void login(HttpServletResponse response,HttpServletRequest
	// request,String appid,String appsecret,String code)
	@RequestMapping("login")
	public void login(HttpServletResponse response, HttpServletRequest request, @RequestBody Map<String, Object> map)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); // 转码
		PrintWriter out = response.getWriter();
		try {

			System.out.println(map.get("appsecret") + "==" + map.get("code"));
			String appid = (String) map.get("appid");
			String appsecret = (String) map.get("appsecret");
			String code = (String) map.get("code");
			String encryptedData = (String) map.get("encryptedData");
			String iv = (String) map.get("iv");

			String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appsecret
					+ "&js_code=" + code + "&grant_type=authorization_code";
			// requestUrl.replaceAll("APPID", appid).replaceAll("SECRET",
			// appsecret).replaceAll("JSCODE", code);
			JSONObject httpsRequest = CommonUtil.httpsRequest(requestUrl, "GET", null);
			String openid = (String) httpsRequest.get("openid");
			String sekey = (String) httpsRequest.get("session_key");
			String unionId = CommonUtil.getUnionId(encryptedData, sekey, iv);
			httpsRequest.accumulate("unionId", unionId);
			String jsonUser = httpsRequest.toString();
			System.out.println("这是用户信息" + openid + "====" + sekey + "====" + unionId);

			// 现根据openid查找下，用户是否已经存在了
//			User userByopenId = userServiceImpl.findUserByopenId(openid);
//			if (userByopenId == null) {
//				User user = new User();
//				user.setUserOpenId(openid);
//				user.setUserNickName("Tom");
//				// 将用户的openId保存到数据库
//				userServiceImpl.saveUser(user);
//			}
			User userByUionId = userServiceImpl.findUserByUnionId(unionId);
			if (userByUionId == null) {
				User user = new User();
				user.setUnionId(unionId);
				user.setUserOpenId(openid);
				// 将新用户保存到数据库
				boolean isOk = userServiceImpl.saveUser(user);
				// String
				// one="{\"session_key\":\"5r9TVfOwFjdXhEj5CeDREA==\",\"expires_in\":7200,\"openid\":\"o_1QS0WoXqiTeHge-MzBJ1CnPOL0\"}";
				if (isOk == true) {
					LogUtil.out(classname, "login", "保存用户到数据库成功");
				} else {
					LogUtil.out(classname, "login", "保存用户到数据库失败");
				}
			}
			out.println(jsonUser);

		} catch (Exception e) {
			LogUtil.out(classname, "login", e.toString());
			out.println("Error");
		}

	}

	/**
	 * 添加用户信息，字段待确定
	 */

}
