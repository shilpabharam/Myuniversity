package com.codecoop.myuniversity.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codecoop.myuniversity.core.dto.UserLOGDetailDto;
import com.codecoop.myuniversity.core.service.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/usersDetail")
public class UserDetailController {

	@Autowired
	UsersService usersService;

	/*
	 * getting logged user name.
	 */
	@RequestMapping(value = "/userName", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserNameSimple(HttpServletRequest request) throws JsonProcessingException {
		Principal principal = request.getUserPrincipal();
		HttpSession session = request.getSession();
		UserLOGDetailDto userLog = usersService.getLoggedUser(principal
				.getName());
		session.setAttribute("currentUnivesityId", userLog.getUniversityId());
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(userLog);
	}

	/*
	 * getting logged user Id.
	 */
	@RequestMapping(value = "/userId", method = RequestMethod.GET)
	@ResponseBody
	public Long currentUserIdSimple(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		return usersService.getLoggedUserID(principal.getName());
	}

}
