package com.sysu.moviepro.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.moviepro.business.entity.User;
import com.sysu.moviepro.business.service.UserService;

@Controller
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createUser(String name, String password, HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		// 此处的user的合法性应该已经由前端保证,后台只负责验证重复性
		boolean exist = userService.isUserExist(name);
		if (!exist) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			userService.createUser(user);
			modelMap.put("code", 1);  // 1代表创建成功
			modelMap.put("message", name);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			return modelMap;
		} else {
			modelMap.put("code", 0);  // 0代表创建失败
			modelMap.put("message", "用户名已存在");
			return modelMap;
		}
	}
}
