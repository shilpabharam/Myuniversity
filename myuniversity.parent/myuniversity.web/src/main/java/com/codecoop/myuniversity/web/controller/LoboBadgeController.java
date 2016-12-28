package com.codecoop.myuniversity.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codecoop.myuniversity.core.dto.LoboBadgeDto;
import com.codecoop.myuniversity.core.service.LoboBadgeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/loboBadge")
public class LoboBadgeController {

	@Autowired
	LoboBadgeService loboBadgeService;
	/*
	 * creating or updating lobo badges.
	 */
	@RequestMapping(value = "/createOrUpdateLoboBadges", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String createLoboBadges(
			@RequestBody List<LoboBadgeDto> logoBadges) {
		return loboBadgeService.saveLoboBadges(logoBadges);
	}

	/*
	 * getting updated lobo badges.
	 */
	@RequestMapping(value = "/getLoboBadges", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getAllLoboBadges() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(loboBadgeService.getAllLoboBadges());
	}
}
