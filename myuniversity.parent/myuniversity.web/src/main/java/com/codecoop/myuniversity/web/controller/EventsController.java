package com.codecoop.myuniversity.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codecoop.myuniversity.core.dto.AllEventsDtoAngNew;
import com.codecoop.myuniversity.core.dto.EventDetailDto;
import com.codecoop.myuniversity.core.dto.EventTypeDto;
import com.codecoop.myuniversity.core.dto.FilterScreenDto;
import com.codecoop.myuniversity.core.dto.TotalEventDtoMob;
import com.codecoop.myuniversity.core.dto.UpdateEventDto;
import com.codecoop.myuniversity.core.service.AdvertisementsService;
import com.codecoop.myuniversity.core.service.EventsService;
import com.codecoop.myuniversity.web.bean.EnrollEventBean;
import com.codecoop.myuniversity.web.bean.EventBean;
import com.codecoop.myuniversity.web.bean.EventBeanResponse;
import com.codecoop.myuniversity.web.bean.EventDetailBean;
import com.codecoop.myuniversity.web.bean.EventRequestBean;
import com.codecoop.myuniversity.web.bean.FilterEventsBean;
import com.codecoop.myuniversity.web.bean.UniversityBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/events")
public class EventsController {

	@Autowired
	EventsService eventsService;

	@Autowired
	private AdvertisementsService advertisementsService;

	@RequestMapping(value = "/getUpcomingEvents", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getAllEventsMob(
			@RequestBody UniversityBean university) throws Exception {
		TotalEventDtoMob events = eventsService.getAllEventsMob(
				university.getUniversityId(), university.getPageNumber(),
				university.getNumberOfRecords());
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(events);
	}

	/*
	 * getting data for generating filter item screen.
	 */
	@RequestMapping(value = "/getFilterItemsData", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getFilterScreenData(HttpSession session)
			throws IllegalAccessException, InvocationTargetException,
			JsonProcessingException {
//		Long universityId = Long.parseLong(session.getAttribute("currentUnivesityId").toString());
		Long universityId = 1L;
		System.out.println("university:"+universityId);
		FilterScreenDto filterScreen = eventsService.getFilterScreen(universityId);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(filterScreen);
	}

	/*
	 * getting all event(filter event)
	 */
	@RequestMapping(value = "/getEvents", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String filterEventsMob(
			@RequestBody FilterEventsBean filterEventBean) throws Exception {
		System.out.println(filterEventBean.toString());
		TotalEventDtoMob events = eventsService.filterEventsMob(
				filterEventBean.getUserId(), filterEventBean.getSearchParam(),
				filterEventBean.getFromDate(), filterEventBean.getToDate(),
				filterEventBean.getSkillIds(), filterEventBean.getTagIds(),
				filterEventBean.getInterestIds(),
				filterEventBean.getFeatured(), filterEventBean.getEnrolled(),
				filterEventBean.getUpcoming(), filterEventBean.getPageNumber(),
				filterEventBean.getNumberOfRecords());
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(events);
	}

	/*
	 * enrolling for the event.
	 */
	@RequestMapping(value = "/enrolledEvent", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String enrolledEvent(
			@RequestBody EnrollEventBean enrollEventBean) throws Exception {
		String status = eventsService.enrollEvent(enrollEventBean.getUserId(),
				enrollEventBean.getEventId());
		return status;
	}

	/*
	 * Unenrolling event.
	 */
	@RequestMapping(value = "/unenrolledEvent", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String unenrolledEvent(
			@RequestBody EnrollEventBean enrollEventBean) throws Exception {
		String status = eventsService.unenrollEvent(
				enrollEventBean.getUserId(), enrollEventBean.getEventId());
		return status;
	}

	/*
	 * creation of event.
	 */
	@RequestMapping(value = "/createEvent", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String createEvent(
			@RequestBody AllEventsDtoAngNew eventdto) {
		System.out.println("in controller");
		System.out.println(eventdto.toString());
		String status = eventsService.createEvent(eventdto);
		return status;
	}

	/*
	 * Updating event data
	 */

	@RequestMapping(value = "/updateEvent", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String updateEvent(@RequestBody UpdateEventDto eventdto) {
		
		System.out.println(eventdto.toString());
		String status = eventsService.updateEvent(eventdto);
		return status;
	}

	/*
	 * getting particular event details.
	 */
	@RequestMapping(value = "/getEventDetails", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getEventDetails(@RequestBody EventBean eventBean)
			throws JsonProcessingException, IllegalAccessException,
			InvocationTargetException {
		System.out.println(eventBean.getEventId());
		EventDetailDto event = eventsService.getEventDetails(eventBean
				.getEventId());
		event.setAdvertisements(advertisementsService.getAdsOnEvent(eventBean.getEventId()));
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(event);
	}

//	/**
//	 * getting particular event details.
//	 */
//	@RequestMapping(value = "/getEventDetailsEdit", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
//	public @ResponseBody String getEventDetailsEdit(
//			@RequestBody EventBean eventBean) throws JsonProcessingException,
//			IllegalAccessException, InvocationTargetException {
//		System.out.println(eventBean.getEventId());
//		EventEditDto event = eventsService.getEventDetailsEdit(eventBean
//				.getEventId());
//		event.setAdvertisements(advertisementsService.getAdsOnEvent(eventBean
//				.getEventId()));
//		ObjectMapper mapper = new ObjectMapper();
//		return mapper.writeValueAsString(event);
//	}

	/*
	 * getting type of event.
	 */
	@RequestMapping(value = "/getEventType", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getEventType() throws JsonProcessingException,
			IllegalAccessException, InvocationTargetException {
		List<EventTypeDto> types = eventsService.getEventTypes();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(types);
	}

	@RequestMapping(value = "/getAllCurrentUniversityEvents", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getAllEventsOfCurrentUniversity(
			HttpSession session, @RequestBody EventRequestBean eventReq)
			throws JsonProcessingException {
		// Long universityId =
		// Long.parseLong(session.getAttribute("currentUnivesityId").toString());
		List<EventDetailBean> eventBeanList = new ArrayList<EventDetailBean>();
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Date fromDate = null, toDate = null;
		// try {
		// fromDate = dateFormat.parse(eventReq.getFromDate());
		// toDate = dateFormat.parse(eventReq.getToDate());
		// System.out.println("dates");
		// System.out.println(fromDate);
		// System.out.println(toDate);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		System.out.println("Start Date:" + eventReq.getFromDate());
		System.out.println("End Date:" + eventReq.getToDate());
		EventBeanResponse eventBeanResponse = new EventBeanResponse();

		for (EventDetailDto event : eventsService
				.getAllEventsOfCurrentUniveristy(eventReq.getUniversityId(),eventReq.getEventName(),
						eventReq.getFromDate(), eventReq.getToDate(),
						eventReq.getStart(), eventReq.getLimit())) {
			EventDetailBean eventBean = new EventDetailBean();
			eventBean.setId(event.getId());
			eventBean.setEventName(event.getEventName());
			eventBean.setEventFromTime(event.getEventFromTime());
			eventBean.setEventToTime(event.getEventToTime());
			eventBean.setEventShortDesc(event.getEventShortDesc());
			eventBean.setEventLongDesc(event.getEventLongDesc());
			eventBean.setEventAddress(event.getEventAddress());
			eventBean.setEventCreatedBy(event.getEventCreatedBy());
			eventBean.setFeatured(event.getFeatured());
			eventBean.setCapacity(event.getCapacity());
			eventBean.setEvenType(event.getEvenType());
			eventBean.setPublished(event.getPublished());
			eventBeanList.add(eventBean);
		}

		eventBeanResponse.setEventBeanList(eventBeanList);
		eventBeanResponse.setTotalCount(eventsService
				.getAllEventsOfCurrentUniveristyCount(
						eventReq.getUniversityId(), eventReq.getEventName(),eventReq.getFromDate(),
						eventReq.getToDate(), eventReq.getStart(),
						eventReq.getLimit()));

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(eventBeanResponse);
	}
}
