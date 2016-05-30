package com.sysu.moviepro.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(String name, String password, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		User result = userService.getUserByName(name);
		if (result.getId() != 0) {
			if (result.getPassword().equals(password)) {
				logger.info("��¼�ɹ�");
				modelMap.put("code", 1);
				modelMap.put("message", name);
				HttpSession session = request.getSession(true);
				session.setAttribute("user", result);
				//Cookie cookie = new Cookie("username", name);
				//cookie.setPath(request.getContextPath());
				//response.addCookie(cookie);
				//response.addHeader("Cache-Control", "no-cache");
			} else {
				logger.info("�������");
				modelMap.put("code", 0);
				modelMap.put("message", "�������");
			}
		} else {
			logger.info("�û���������");
			modelMap.put("code", 0);
			modelMap.put("message", "�û���������");
		}
		return modelMap;
	}
}
