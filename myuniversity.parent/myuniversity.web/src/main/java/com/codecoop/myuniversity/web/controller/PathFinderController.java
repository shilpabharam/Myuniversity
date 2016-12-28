package com.codecoop.myuniversity.web.controller;

import java.lang.reflect.InvocationTargetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codecoop.myuniversity.core.dto.AllPathFinderDto;
import com.codecoop.myuniversity.core.dto.PathFinderDto;
import com.codecoop.myuniversity.core.service.PathFinderService;
import com.codecoop.myuniversity.web.bean.PaginationBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/resource")
public class PathFinderController {

	@Autowired
	PathFinderService resourceService;
	/*
	 * Creation of path finder.
	 */
	@RequestMapping(value = "/createResource", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String createResource(
			@RequestBody PathFinderDto reourceDto) {
		String status = resourceService.createResource(reourceDto);
		return status;
	}
	/*
	 * updating path finder.
	 */
	@RequestMapping(value = "/updateResource", method = RequestMethod.PUT, headers = "Accept=application/xml, application/json")
	public @ResponseBody String updateResource(
			@RequestBody PathFinderDto reourceDto) {
		String status = resourceService.updateResource(reourceDto);
		return status;
	}
	/*
	 * Deleting path finder.
	 */
	@RequestMapping(value = "/deleteResource", method = RequestMethod.DELETE, headers = "Accept=application/xml, application/json")
	public @ResponseBody String deleteResource(
			@RequestBody PathFinderDto reourceDto) {
		String status = resourceService.deleteResource(reourceDto.getId());
		return status;
	}
	/*
	 * Getting path finder.
	 */
	@RequestMapping(value = "/getResource", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getResource(@RequestBody PathFinderDto reourceDto) {
		String response = "";
		ObjectMapper mapper = null;
		try {
			PathFinderDto resource = resourceService.getResource(reourceDto
					.getId());
			System.out.println(resource.toString());
			if (resource != null) {
				mapper = new ObjectMapper();
				try {
					response = mapper.writeValueAsString(resource);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					response = "Error while getting resource";
				}
			} 
		} catch (IllegalAccessException e) {
			response = "Error while getting resource";
		} catch (InvocationTargetException e) {
			response = "Error while getting resource";
		}

		return response;
	}
	/*
	 * getting all path finder.
	 */
	@RequestMapping(value = "/getAllResources", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getAllResource(@RequestBody PaginationBean page) {
		String response = "";
		try {
			AllPathFinderDto resources = resourceService.getAllResource(
					page.getPageNumber(),
					page.getNoOfRecords());
			ObjectMapper mapper = new ObjectMapper();
			try {
				response = mapper.writeValueAsString(resources);
			} catch (JsonProcessingException e) {
				response = "Error while getting resource";
			}
		} catch (IllegalAccessException e) {
			response = "Error while getting resource";
		} catch (InvocationTargetException e) {
			response = "Error while getting resource";
		}
		return response;
	}

}
