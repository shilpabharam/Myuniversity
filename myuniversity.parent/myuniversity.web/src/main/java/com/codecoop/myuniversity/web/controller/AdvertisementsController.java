package com.codecoop.myuniversity.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codecoop.myuniversity.core.dto.AdDto;
import com.codecoop.myuniversity.core.service.AdvertisementsService;
import com.codecoop.myuniversity.web.bean.AdBeanRequest;
import com.codecoop.myuniversity.web.bean.AdBeanResponse;
import com.codecoop.myuniversity.web.bean.AdsBeanResponse;
import com.codecoop.myuniversity.web.bean.GetAdsBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/ads")
public class AdvertisementsController {

	@Autowired
	private AdvertisementsService advertisementsService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String createAd(HttpSession session,
			@RequestBody AdBeanRequest newAd) throws JsonProcessingException {
		// Long universityId =
		// Long.parseLong(session.getAttribute("currentUnivesityId").toString());
		Long universityId = 1L;
		AdDto ad = new AdDto();
		ad.setName(newAd.getName());
		ad.setPublished((!StringUtils.isEmpty(newAd.getPublished()) && newAd
				.getPublished().equalsIgnoreCase("Yes")) ? true : false);
		ad.setWebURL(newAd.getWebURL());
		ad.setDescription(newAd.getDescription());
		ad.setFromDate(newAd.getFromDate());
		ad.setToDate(newAd.getToDate());
		ad.setUniId(universityId);
		return advertisementsService.creteAd(ad);

	}

	@RequestMapping(value = "/show", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String showAds(HttpSession session,
			@RequestBody GetAdsBean request) throws JsonProcessingException {
		// Long universityId =
		// Long.parseLong(session.getAttribute("currentUnivesityId").toString());
		Long universityId = 1L;
		ObjectMapper mapper = new ObjectMapper();
		List<AdsBeanResponse> adsList = new ArrayList<AdsBeanResponse>();
		for (AdDto ad : advertisementsService.getAllAdsOfUniveristy(
				universityId, request.getFromDate(), request.getToDate(),
				request.getStart(), request.getLimit())) {
			AdsBeanResponse responce = new AdsBeanResponse();
			responce.setDescription(ad.getDescription());
			responce.setFromDate(ad.getFromDate());
			responce.setId(ad.getId());
			responce.setIsPublished(ad.isPublished() ? "Yes" : "No");
			responce.setName(ad.getName());
			responce.setToDate(ad.getToDate());
			responce.setUniId(ad.getUniId());
			responce.setWebURL(ad.getWebURL());
			adsList.add(responce);
		}
		AdBeanResponse resp = new AdBeanResponse();
		resp.setAdvertisements(adsList);
		resp.setCount(advertisementsService.getAllAdsOfUniveristy(universityId,
				request.getFromDate(), request.getToDate(), null, null).size());
		return mapper
				.writeValueAsString(CollectionUtils.isEmpty(adsList) ? "No ads available"
						: resp);
	}

	
	@RequestMapping(value = "/filter", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String filterads(HttpSession session,@RequestBody GetAdsBean request) throws JsonProcessingException{
//		Long universityId = Long.parseLong(session.getAttribute("currentUnivesityId").toString());
		Long universityId = 1L;
		ObjectMapper mapper = new ObjectMapper();
		List<AdsBeanResponse> adsList = new ArrayList<AdsBeanResponse>();
		for(AdDto ad:advertisementsService.getAllAdsOfUniveristyPublishOnly(universityId, request.getFromDate(), request.getToDate(), request.getStart(), request.getLimit())){
			AdsBeanResponse responce = new AdsBeanResponse();
			responce.setDescription(ad.getDescription());
			responce.setFromDate(ad.getFromDate());
			responce.setId(ad.getId());
			responce.setIsPublished(ad.isPublished() ? "Yes":"No");
			responce.setName(ad.getName());
			responce.setToDate(ad.getToDate());
			responce.setUniId(ad.getUniId());
			responce.setWebURL(ad.getWebURL());
			adsList.add(responce);
		}
		AdBeanResponse resp = new AdBeanResponse();
		resp.setAdvertisements(adsList);
		resp.setCount(advertisementsService.getAllAdsOfUniveristyPublishOnly(universityId, request.getFromDate(), request.getToDate(),null, null).size());
		return mapper.writeValueAsString(CollectionUtils.isEmpty(adsList)?"No ads available":resp);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String editAds(HttpSession session,
			@RequestBody AdBeanRequest request) {
		// Long universityId =
		// Long.parseLong(session.getAttribute("currentUnivesityId").toString());
		Long universityId = 1L;
		AdDto ad = new AdDto();
		ad.setId(request.getId());
		ad.setName(request.getName());
		ad.setPublished((!StringUtils.isEmpty(request.getPublished()) && request
				.getPublished().equalsIgnoreCase("Yes")) ? true : false);
		ad.setWebURL(request.getWebURL());
		ad.setDescription(request.getDescription());
		ad.setFromDate(request.getFromDate());
		ad.setToDate(request.getToDate());
		ad.setUniId(universityId);
		try {
			return advertisementsService.editAd(ad);
		} catch (Exception e) {
			return "failed";
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody String deleteAds(HttpSession session,
			@RequestParam(required = true) Long adId)
			throws JsonProcessingException {
		return advertisementsService.deleteAd(adId);
	}

	@RequestMapping(value = "/getAdsOnEvent", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getAdsOnEvent(
			@RequestParam(required = true) Long eventId)
			throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		List<AdDto> list = advertisementsService.getAdsOnEvent(eventId);
		return mapper
				.writeValueAsString(CollectionUtils.isEmpty(list) ? "No ads associated with this event"
						: list);
	}

}
