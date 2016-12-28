package com.codecoop.myuniversity.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/populateValues", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody String generateTemplateData(
			HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}
