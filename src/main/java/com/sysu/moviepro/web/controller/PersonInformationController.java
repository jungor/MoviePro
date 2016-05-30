package com.sysu.moviepro.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.moviepro.business.dto.UserDTO;
import com.sysu.moviepro.business.entity.User;
import com.sysu.moviepro.business.service.UserService;

@Controller
public class PersonInformationController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonInformationController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getInfo", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getPersonInformation(HttpSession session) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			modelMap.put("code", 1);
			User result = userService.getUser(user.getId());
			UserDTO userinfo = new UserDTO(result);
			modelMap.put("userinfo", userinfo);
		} else {
			modelMap.put("code", 0);
			modelMap.put("message", "当前用户未登录");
		}
		return modelMap;
	}
	
	@RequestMapping(value="/setInfo", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> setPersonInformation(@ModelAttribute UserDTO userDTO, HttpSession session) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		User user = (User) session.getAttribute("user");
		// 不支持修改用户名
		if (user != null) {
			logger.info(userDTO.toString());
			User newUser = userService.getUser(user.getId());
			newUser.setPassword(userDTO.getPassword());
			newUser.setEmail(userDTO.getEmail());
			newUser.setSex(userDTO.getSex());
			newUser.setTelephone(userDTO.getTelephone());
			newUser.setDescription(userDTO.getDescription());
			userService.updateUser(newUser);
			session.setAttribute("user", newUser);
			modelMap.put("code", 1);
		} else {
			modelMap.put("code", 0);
		}
		return modelMap;
	}
}
