package com.codecoop.myuniversity.web.controller;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codecoop.myuniversity.core.dto.AllSocialBadgeDto;
import com.codecoop.myuniversity.core.dto.DepartmentsDto;
import com.codecoop.myuniversity.core.dto.SkillBadgeDto;
import com.codecoop.myuniversity.core.dto.SocialBadgePointsDto;
import com.codecoop.myuniversity.core.dto.SocialBadgesDto;
import com.codecoop.myuniversity.core.service.BadgeService;
import com.codecoop.myuniversity.web.bean.UserBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/badge")
public class BadgeController {
	@Autowired
	BadgeService badgeService;
	/*
	 * creation of social badge.
	 */
	@RequestMapping(value = "/createSocialBadge", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String createSocialBadge(
			@RequestBody AllSocialBadgeDto socialBadgeDto) {
		System.out.println("in controller");
		System.out.println(socialBadgeDto.toString());
		String status = badgeService.createSocialBadges(socialBadgeDto);
		return status;
	}

	/*
	 * updating social badge
	 */
	@RequestMapping(value = "/updateSocialBadge", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String updateSocialBadge(
			@RequestBody AllSocialBadgeDto socialBadgeDto) {
		System.out.println(socialBadgeDto.toString());
		String status = badgeService.updateSocialBadges(socialBadgeDto);
		return status;
	}

	/*
	 * deleting social badge.
	 */
	@RequestMapping(value = "/deleteSocialBadge", method = RequestMethod.DELETE, headers = "Accept=application/xml, application/json")
	public @ResponseBody String deleteSocialBadge(@RequestBody Long badgeId) {
		String status = badgeService.deleteSocialBadge(badgeId);
		return status;
	}

	/*
	 * creation of skill badge.
	 */
	@RequestMapping(value = "/createSkillBadge", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String createSkillBadge(
			@RequestBody List<SkillBadgeDto> skillBadgeDto) {
		System.out.println(skillBadgeDto.toString());
		String status = badgeService.createSkillBadge(skillBadgeDto);
		return status;
	}

	/*
	 * creating social badge points data.
	 */
	@RequestMapping(value = "/createSocialBadgePoints", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String createSocialBadgePoints(
			@RequestBody List<SocialBadgePointsDto> socialBadgePointsDto) {
		String status = badgeService
				.createSocialBadgePoints(socialBadgePointsDto);
		return status;
	}

	/*
	 * getting skill badge data.
	 */
	@RequestMapping(value = "/getSkillBadgeData", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getAllSkillBadgePoints(
			@RequestBody SkillBadgeDto skillBadgeDto)
			throws IllegalAccessException, InvocationTargetException,
			JsonProcessingException {
		Long universityId = skillBadgeDto.getUniversityId();
		List<SkillBadgeDto> badgeDto = badgeService
				.getAllSkillBadgePoints(universityId);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(badgeDto);

	}

	/*
	 * getting social badge points
	 */
	@RequestMapping(value = "/getSocialBadgePoints", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getSocialBadgePoints(
			@RequestBody SocialBadgePointsDto socialBadgePointsDto)
			throws IllegalAccessException, InvocationTargetException,
			JsonProcessingException {
		Long universityId = socialBadgePointsDto.getUniversityId();
		List<SocialBadgePointsDto> badgeDto = badgeService
				.getSocialBadgePoints(universityId);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(badgeDto);

	}

	/*
	 * getting social badge data.
	 */
	@RequestMapping(value = "/getSocialBadgeData", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getSocialBadgeData()
			throws IllegalAccessException, InvocationTargetException,
			JsonProcessingException {
		List<SocialBadgesDto> badgeDto = badgeService.getSocialBadges();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(badgeDto);
	}

	/*
	 * getting all departments.
	 */
	@RequestMapping(value = "/getAlldepartment", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getAlldepartment()
			throws IllegalAccessException, InvocationTargetException,
			JsonProcessingException {
		List<DepartmentsDto> deptDto = badgeService.getAllDeparments();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(deptDto);
	}

	/*
	 * creation of department.
	 */
	@RequestMapping(value = "/createDepartment", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String createDepartment(
			@RequestBody DepartmentsDto deptDto) {
		String status = badgeService.createDepartment(deptDto);
		return status;
	}

	/*
	 * getting skill wise badge score points.
	 */
	@RequestMapping(value = "/skillScore", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getPointsByScore(@RequestBody UserBean user)
			throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(badgeService.getSkillsPoints(user
				.getUserId()));
	}

	/*
	 * getting category wise score.
	 */
	@RequestMapping(value = "/categoryScore", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getPointsByCategory(@RequestBody UserBean user)
			throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(badgeService.getCategoryPoints(user
				.getUserId()));
	}

	@RequestMapping(value = "/getEventsSocailBadgeForUser", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getEventsSocialBadgesPointsForUser(
			@RequestBody UserBean user) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(badgeService
				.getEventsSocialBadgesPointsForUser(user.getUserId()));
	}
}
