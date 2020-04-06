package hecai.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hecai.entity.User;

public class CookieUtils {
		private static String CookieName = "UserCookie";
	
		//登录成功后添加Cookie
		public static void addCookie(HttpServletResponse response,User user) {
			//将user参数信息变成字符串存入cookie
			String encode;
			try {
				//为Cookie设置编码，以免出现读取异常
				encode = URLEncoder.encode(user.getUserId()+"-"+user.getUserName()+"-"+user.getUserType(), "UTF-8");
				Cookie ck = new Cookie(CookieName,encode);
				ck.setMaxAge(30 * 60);
				ck.setPath("/");//默认是当前路径
				response.addCookie(ck);
			}catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		//在登录前查询本地是否有cookie的存在
		public static Object checkCookie(HttpServletRequest request) {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(CookieName)) {
					//查询到后重新设置时间
					if(cookie.getValue() == null) {
						return null;
					}
					//将从cookie中获取的信息变成User对象返回
					String[] userInfo = cookie.getValue().split("-");
					User user = new User(Integer.parseInt(userInfo[0]),userInfo[1],userInfo[2]);
					return user;
				}
			}
			return null;
		}
		
		//用户点击退出后删除cookie
		public static void deleteCookie(HttpServletRequest request,HttpServletResponse response) {
			Cookie ck = new Cookie(CookieName,null);
			ck.setMaxAge(0);
			ck.setPath("/");//默认是当前路径
			response.addCookie(ck);
		}
}
