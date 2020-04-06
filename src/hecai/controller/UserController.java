package hecai.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 用于用户的登录操作
 * @author 24357
 */
import org.springframework.web.servlet.ModelAndView;

import hecai.entity.ResultType;
import hecai.entity.User;
import hecai.service.IUserService;
import hecai.util.CookieUtils;
@RequestMapping("user")
@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	IUserService userService;
	
	
	@RequestMapping("/getall")
	public ModelAndView getAllUsers() {
		List<User> list = userService.getAllUsers();
		for (User user : list) {
			System.out.println(user.getUserId()+" " + user.getUserName());
		}
		return new ModelAndView("result");
	}
	
	
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public ResultType login(HttpServletResponse response,User user) {
		User exist = userService.isExist(user);
		System.out.println(exist);
		//如果用户不存在
		if(exist == null) {
			return ResultType.fail();
		}else {
			//如果存在
			//将查询到的用户放入cookie中
			CookieUtils.addCookie(response, exist);
			return ResultType.ok();
		}
	}
	
	//在登录之前检查本地是否存在Cookie
	@RequestMapping(value="checklogin",method=RequestMethod.POST)
	@ResponseBody
	public ResultType checkLogin(HttpServletRequest request) {
		Object user = CookieUtils.checkCookie(request);
		if(user != null) {
			user = (User)user;
			return ResultType.build(200,user);
		}
		return ResultType.fail();
	}
	
	
	@RequestMapping(value="outlogin",method=RequestMethod.POST)
	@ResponseBody
	public ResultType outLogin(HttpServletRequest request,HttpServletResponse response) {
		CookieUtils.deleteCookie(request, response);
		return ResultType.ok();
	}
	
	 
	
	@RequestMapping(value="/isexist", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> isExist(@ModelAttribute User user) {
		
		return null;
//		System.out.println(user.getUserName() + "  " + user.getUserPwd());
//		//通过从前端传入的用户信息查询到后
//		User exist = userService.isExist(user);
//		//判断是否存在该用户
//		if(exist == null) {
//			return new ModelAndView("");
//		}else {
//			//将查询到的全部存入Cookie中
//			
//		}
//		System.out.println("id:  "+exist.getUserId());
//		return new ModelAndView("result");
	}
	
	
	
}
