package com.codecoop.myuniversity.core.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codecoop.myuniversity.core.dao.AdvertisementsDao;
import com.codecoop.myuniversity.core.dao.EnrollEventDao;
import com.codecoop.myuniversity.core.dao.EventInterestDao;
import com.codecoop.myuniversity.core.dao.EventSkillScheduleDao;
import com.codecoop.myuniversity.core.dao.EventSkillsDao;
import com.codecoop.myuniversity.core.dao.EventSocialBadgeDao;
import com.codecoop.myuniversity.core.dao.EventSponsorDao;
import com.codecoop.myuniversity.core.dao.EventTagsDao;
import com.codecoop.myuniversity.core.dao.EventTypeDao;
import com.codecoop.myuniversity.core.dao.EventsDao;
import com.codecoop.myuniversity.core.dao.InterestDao;
import com.codecoop.myuniversity.core.dao.SkillsCategoryDao;
import com.codecoop.myuniversity.core.dao.SkillsDao;
import com.codecoop.myuniversity.core.dao.SponsorDao;
import com.codecoop.myuniversity.core.dao.TagDao;
import com.codecoop.myuniversity.core.domain.EnrolledEvents;
import com.codecoop.myuniversity.core.domain.EventInterests;
import com.codecoop.myuniversity.core.domain.EventSkillSchedule;
import com.codecoop.myuniversity.core.domain.EventSkills;
import com.codecoop.myuniversity.core.domain.EventSocialBadge;
import com.codecoop.myuniversity.core.domain.EventSponsor;
import com.codecoop.myuniversity.core.domain.EventTags;
import com.codecoop.myuniversity.core.domain.EventType;
import com.codecoop.myuniversity.core.domain.Events;
import com.codecoop.myuniversity.core.domain.Interests;
import com.codecoop.myuniversity.core.domain.SkillCategories;
import com.codecoop.myuniversity.core.domain.Skills;
import com.codecoop.myuniversity.core.domain.Sponsor;
import com.codecoop.myuniversity.core.domain.Tags;
import com.codecoop.myuniversity.core.dto.AdDto;
import com.codecoop.myuniversity.core.dto.AllEventsDto;
import com.codecoop.myuniversity.core.dto.AllEventsDtoAngNew;
import com.codecoop.myuniversity.core.dto.AllEventsDtoMob;
import com.codecoop.myuniversity.core.dto.BadgeDto;
import com.codecoop.myuniversity.core.dto.BadgeDtoUpdate;
import com.codecoop.myuniversity.core.dto.EventDetailDto;
import com.codecoop.myuniversity.core.dto.EventEditDto;
import com.codecoop.myuniversity.core.dto.EventInterestDto;
import com.codecoop.myuniversity.core.dto.EventSocialBadgeDto;
import com.codecoop.myuniversity.core.dto.EventTypeDto;
import com.codecoop.myuniversity.core.dto.EventsDto;
import com.codecoop.myuniversity.core.dto.EventsNewDto;
import com.codecoop.myuniversity.core.dto.FilterScreenDto;
import com.codecoop.myuniversity.core.dto.InterestScreenDto;
import com.codecoop.myuniversity.core.dto.SelectedSkillDtoUpdate;
import com.codecoop.myuniversity.core.dto.SkillBadgeRowDto;
import com.codecoop.myuniversity.core.dto.SkillCategoryDto;
import com.codecoop.myuniversity.core.dto.SkillEventDetailDto;
import com.codecoop.myuniversity.core.dto.SkillScheduleDto;
import com.codecoop.myuniversity.core.dto.SkillScreenDto;
import com.codecoop.myuniversity.core.dto.SkillsDto;
import com.codecoop.myuniversity.core.dto.SkillsMobDto;
import com.codecoop.myuniversity.core.dto.SponsorDto;
import com.codecoop.myuniversity.core.dto.TagDto;
import com.codecoop.myuniversity.core.dto.TagScreenDto;
import com.codecoop.myuniversity.core.dto.TotalEventDtoMob;
import com.codecoop.myuniversity.core.dto.UpdateEventDto;

@Service
public class EventsService {

	@Autowired
	SponsorDao sponsorDao;

	@Autowired
	EventSponsorDao eventSponsorDao;

	@Autowired
	EventsDao eventsDao;

	@Autowired
	TagDao tagDao;

	@Autowired
	EnrollEventDao enrollEventDao;

	@Autowired
	EventTypeDao eventTypeDao;

	@Autowired
	EventInterestDao eventInterestDao;

	@Autowired
	EventTagsDao eventTagsDao;

	@Autowired
	EventSkillsDao eventSkillsDao;

	@Autowired
	SkillsCategoryDao skillCategoryDao;

	@Autowired
	InterestDao interestDao;

	@Autowired
	SkillsDao skillDao;

	@Autowired
	EventSkillScheduleDao eventSkillScheduleDao;

	@Autowired
	EventSocialBadgeDao eventSocialBadgeDao;

	@Autowired
	private AdvertisementsDao advertisementsDao;

	@Transactional
	public TotalEventDtoMob getAllEventsMob(Long universityId, Integer start,
			Integer limit) {

		List<AllEventsDtoMob> allEvents = new ArrayList<AllEventsDtoMob>();
		TotalEventDtoMob totalEvent = new TotalEventDtoMob();

		// getting general information of event
		List<Events> events = eventsDao.getAllEvents(universityId,
				((start - 1) * limit), limit);
		// List<EventsDto> eventsDto = new ArrayList<EventsDto>();
		for (Events event : events) {
			AllEventsDtoMob eventdto = new AllEventsDtoMob();
			eventdto.setId(event.getId());
			eventdto.setEventName(event.getEventName());
			eventdto.setEventAddress(event.getEventAddress());
			eventdto.setEventFromTime(event.getEventFromTime());
			eventdto.setEventToTime(event.getEventToTime());
			eventdto.setEventShortDesc(event.getEventShortDesc());
			eventdto.setEventLongDesc(event.getEventLongDesc());
			eventdto.setEventCreatedBy(event.getEventCreatedBy());
			eventdto.setCapacity(event.getCapacity());
			eventdto.setFeatured(event.getFeatured());
			eventdto.setPublished(event.getPublished());
			// getting event type
			EventType eventType = eventTypeDao.getEventType(event
					.getEventTypeId());

			eventdto.setEvenType(eventType.getEventType());

			List<TagDto> tags = tagDao.getTagsByEvent(event.getId());
			Map<String, Boolean> tagMap = new HashMap<String, Boolean>();

			for (TagDto tag : tags) {
				tagMap.put(tag.getTagName(), tag.getFlag());
			}
			eventdto.setTags(tagMap);

			// getting all the information about the skill of events
			List<SkillsMobDto> skills = tagDao.getSkillsByEventMob(event
					.getId());
			Map<String, Integer> skillsMap = new HashMap<String, Integer>();
			for (SkillsMobDto skillMob : skills) {
				skillsMap.put(skillMob.getCategoryName(),
						skillMob.getTotalSubSkills());
			}
			eventdto.setSkills(skillsMap);

			allEvents.add(eventdto);
		}

		totalEvent.setAllEvents(allEvents);
		totalEvent.setPageNumber(start);
		totalEvent.setTotalEvents(allEvents.size());

		return totalEvent;
	}

	/*
	 * Getting all information about upcoming events
	 */
	@Transactional
	public List<AllEventsDto> getAllEvents(Long universityId, Integer start,
			Integer limit) {

		List<AllEventsDto> allEvents = new ArrayList<AllEventsDto>();

		// getting general information of event
		List<Events> events = eventsDao
				.getAllEvents(universityId, start, limit);
		// List<EventsDto> eventsDto = new ArrayList<EventsDto>();
		for (Events event : events) {
			EventsDto eventdto = new EventsDto();
			eventdto.setId(event.getId());
			eventdto.setEventName(event.getEventName());
			eventdto.setEventAddress(event.getEventAddress());
			eventdto.setEventFromTime(event.getEventFromTime());
			eventdto.setEventToTime(event.getEventToTime());
			eventdto.setEventShortDesc(event.getEventShortDesc());
			eventdto.setEventLongDesc(event.getEventLongDesc());
			eventdto.setEventCreatedBy(event.getEventCreatedBy());
			eventdto.setUniversityId(event.getUniversityId());
			eventdto.setCapacity(event.getCapacity());
			eventdto.setFeatured(event.getFeatured());
			eventdto.setPublished(event.getPublished());
			// getting event type
			EventType eventType = eventTypeDao.getEventType(event
					.getEventTypeId());
			EventTypeDto evenTypeDto = new EventTypeDto();
			evenTypeDto.setId(eventType.getId());
			evenTypeDto.setEventType(eventType.getEventType());

			eventdto.setEvenType(evenTypeDto);

			// getting interest
			List<EventInterestDto> eventInterests = eventInterestDao
					.getEventInterests(event.getId());
			eventdto.setEventInterest(eventInterests);

			// we have event general information
			// getting tags information for the events
			List<TagDto> tags = tagDao.getTagsByEvent(event.getId());

			// getting all the information about the skill of events
			List<SkillsDto> skills = tagDao.getSkillsByEvent(event.getId());

			AllEventsDto alleventdto = new AllEventsDto();
			alleventdto.setGeneral(eventdto);
			alleventdto.setSkills(skills);
			alleventdto.setTags(tags);

			allEvents.add(alleventdto);

		}

		return allEvents;
	}

	/*
	 * update event
	 */
	@Transactional
	public String updateEvent(UpdateEventDto eventDto) {
		String status = "";
		try {

			Events ev = eventsDao.findById(eventDto.getId());

			ev.setId(eventDto.getId());
			ev.setCapacity(eventDto.getCapacity());
			ev.setEventAddress(eventDto.getEventAddress());
			ev.setEventLongDesc(eventDto.getEventLongDesc());
			ev.setEventShortDesc(eventDto.getEventShortDesc());
			ev.setEventName(eventDto.getEventName());
			ev.setEventFromTime(eventDto.getEventFromTime());
			ev.setEventToTime(eventDto.getEventToTime());
			ev.setFeatured(eventDto.getFeatured());
			ev.setKeywords(eventDto.getKeyword());
			ev.setPublished(eventDto.getPublished());
			ev.setEventTypeId(eventDto.getEventTypeId());

			eventsDao.saveOrUpdate(ev);

			// saving skill badge schedule

			for (SelectedSkillDtoUpdate selectedSkill : eventDto
					.getSkillBadgeRowDto()) {
				EventSkills evSkill = eventSkillsDao.findBySkillAndEventId(
						eventDto.getId(), selectedSkill.getSelected_skills());
				if (evSkill == null) {
					evSkill = new EventSkills();
					evSkill.setEventId(eventDto.getId());
					evSkill.setSkillId(selectedSkill.getSelected_skills());
					eventSkillsDao.save(evSkill);

					EventSkillSchedule evSch = new EventSkillSchedule();
					evSch.setEventId(eventDto.getId());
					evSch.setEventSkillId(evSkill.getId());
					evSch.setEventStartTime(new Date(Long
							.parseLong(selectedSkill.getStartDate())));
					evSch.setEventEndTime(new Date(Long.parseLong(selectedSkill
							.getEndDate())));
					eventSkillScheduleDao.save(evSch);

				} else {

					EventSkillSchedule evSch = eventSkillScheduleDao
							.findByEventSkillId(evSkill.getId());

					// String newDateString = df.format(startDate);

					if (evSch == null) {
						evSch = new EventSkillSchedule();
						evSch.setEventId(eventDto.getId());
						evSch.setEventSkillId(evSkill.getId());
						evSch.setEventStartTime(new Date(Long
								.parseLong(selectedSkill.getStartDate())));
						evSch.setEventEndTime(new Date(Long
								.parseLong(selectedSkill.getEndDate())));
						eventSkillScheduleDao.save(evSch);

					} else {
						evSch.setEventStartTime(new Date(Long
								.parseLong(selectedSkill.getStartDate())));
						evSch.setEventEndTime(new Date(Long
								.parseLong(selectedSkill.getEndDate())));
						eventSkillScheduleDao.saveOrUpdate(evSch);
					}

				}

			}
			// delete
			List<EventSkills> evSkills = eventSkillsDao.findByEventId(eventDto
					.getId());
			for (EventSkills evSkillTmp : evSkills) {
				boolean flag = true;
				for (SelectedSkillDtoUpdate selectedSkill : eventDto
						.getSkillBadgeRowDto()) {

					if (selectedSkill.getSelected_skills().equals(
							evSkillTmp.getSkillId())
							&& (evSkillTmp.getEventId()
									.equals(eventDto.getId()))) {
						flag = false;
						break;
					}
				}

				if (flag) {
					EventSkillSchedule evSch = eventSkillScheduleDao
							.findByEventSkillId(evSkillTmp.getId());
					if (evSch != null) {
						eventSkillScheduleDao.delete(evSch);
					}
					eventSkillsDao.delete(evSkillTmp);
				}

			}

			// saving social badge row data

			for (BadgeDtoUpdate badge : eventDto.getBadgeDto()) {
				EventSocialBadge evs = eventSocialBadgeDao
						.findEventIdSocialBadgeId(eventDto.getId(),
								badge.getBadgeId());

				System.out.println("badge id" + badge.getBadgeId());
				if (evs == null) {
					evs = new EventSocialBadge();
					evs.setEventId(eventDto.getId());
					evs.setSocialBadgeId(badge.getBadgeId());
					evs.setDescription(badge.getDescription());
					eventSocialBadgeDao.save(evs);
					System.out.println("adding");
				} else {
					evs.setDescription(badge.getDescription());
					eventSocialBadgeDao.saveOrUpdate(evs);
					System.out.println("updating");
				}
			}

			List<EventSocialBadge> evSocial = eventSocialBadgeDao
					.findEventSocialBadgeId(eventDto.getId());

			for (EventSocialBadge evTemp : evSocial) {
				boolean flag = false;
				for (BadgeDtoUpdate badge : eventDto.getBadgeDto()) {

					System.out.println("Evenet Id 1: " + evTemp.getEventId()
							+ ", Event id2: " + eventDto.getId());
					System.out.println("badge Id 1: "
							+ evTemp.getSocialBadgeId() + ", badge id2: "
							+ badge.getBadgeId());

					if (evTemp.getEventId().equals(eventDto.getId())
							&& evTemp.getSocialBadgeId().equals(
									badge.getBadgeId())) {
						System.out.println("equal");
						flag = true;
						break;
					}
				}
				if (!flag) {
					System.out.println("deleting");
					eventSocialBadgeDao.delete(evTemp);
				}
			}

			// sponsor updation

			List<EventSponsor> esp = eventSponsorDao.findEventSponsor(eventDto
					.getId());
			if (!esp.isEmpty()) {
				for (EventSponsor ep : esp) {
					// Sponsor sponsor = sponsorDao.findById(ep.getSponsorId());
					eventSponsorDao.delete(ep);
					// sponsorDao.delete(sponsor);
				}
			}

			// saving sponsers
			if (eventDto.getSponsor() != null) {
				for (String sponsors : eventDto.getSponsor().split(",")) {
					Sponsor sponser = new Sponsor();
					sponser.setSponsorName(sponsors);
					sponsorDao.save(sponser);

					EventSponsor eventSponsor = new EventSponsor();
					eventSponsor.setEventId(eventDto.getId());
					eventSponsor.setSponsorId(sponser.getId());

					eventSponsorDao.save(eventSponsor);
				}
			}

			// updating interest
			List<Long> interests = eventDto.getInterest();
			for (long interest : interests) {
				System.out.println("hi" + interest);
				EventInterests eInterest = eventInterestDao
						.findByInterestAndEventId(eventDto.getId(), interest);
				if (eInterest == null) {
					eInterest = new EventInterests();
					eInterest.setEventId(eventDto.getId());
					eInterest.setInterestId(interest);
					eventInterestDao.save(eInterest);
				}
			}

			List<EventInterests> eventInterest = eventInterestDao
					.findEventInterests(eventDto.getId());
			for (EventInterests evInterest : eventInterest) {
				boolean interestFlag = false;
				for (long interest : interests) {
					if (evInterest.getInterestId() == interest) {
						interestFlag = true;
						break;
					}
				}
				if (!interestFlag) {
					eventInterestDao.delete(evInterest);
				}
			}
			// updating tags
			List<Long> tags = eventDto.getTags();
			for (long tag : tags) {
				EventTags eTag = eventTagsDao.findByTagAndEventId(
						eventDto.getId(), tag);
				if (eTag == null) {
					eTag = new EventTags();
					eTag.setEventId(eventDto.getId());
					eTag.setTagId(tag);
					eventTagsDao.save(eTag);
				}
			}

			List<EventTags> eventTags = eventTagsDao.findEventTags(eventDto
					.getId());

			for (EventTags tempTag : eventTags) {
				boolean flag = false;
				for (long tag : tags) {
					if (tempTag.getTagId() == tag) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					eventTagsDao.delete(tempTag);
				}
			}

			// delete event ads
			advertisementsDao.delteEventAd(eventDto.getId());

			// update event with ads
			if (eventDto.getAdvertisements() != null) {
				for (Long adId : eventDto.getAdvertisements()) {
					advertisementsDao.linkAd4Event(eventDto.getId(), adId);
				}
			}
			status = "Event updated successfully";
		} catch (Exception e) {

			e.printStackTrace();
			status = "Error while updating event";
		}

		return status;

	}

	/*
	 * method to create event
	 */

	@Transactional
	public String createEvent(AllEventsDtoAngNew eventdto) {
		String status = "";
		try {

			Events event = new Events();
			event.setEventName(eventdto.getGeneral().getEventName());
			event.setEventAddress(eventdto.getGeneral().getEventAddress());
			event.setEventToTime(eventdto.getGeneral().getEventToTime());
			event.setEventFromTime(eventdto.getGeneral().getEventFromTime());
			event.setEventShortDesc(eventdto.getGeneral().getEventShortDesc());
			event.setEventLongDesc(eventdto.getGeneral().getEventLongDesc());
			event.setKeywords(eventdto.getGeneral().getKeywords());
			event.setEventCreatedBy(eventdto.getGeneral().getEventCreatedBy());
			event.setUniversityId(eventdto.getGeneral().getUniversityId());
			event.setCapacity(eventdto.getGeneral().getCapacity());
			event.setEventTypeId(eventdto.getGeneral().getEvenType().getId());

			if (eventdto.getGeneral().getFeatured() == null
					|| !eventdto.getGeneral().getFeatured()) {
				event.setFeatured(false);
			} else {
				event.setFeatured(true);
			}

			if (eventdto.getGeneral().getPublished() == null
					|| !eventdto.getGeneral().getPublished()) {
				event.setPublished(false);
			} else {
				event.setPublished(true);
			}

			eventsDao.save(event);
			// information related to EVENTS table saved
			Long eventId = event.getId();

			// SkillSchedule saving

			for (Long tagId : eventdto.getTags()) {
				EventTags eventTag = new EventTags();
				eventTag.setEventId(eventId);
				eventTag.setTagId(tagId);
				eventTagsDao.save(eventTag);
			}

			for (EventSocialBadgeDto eventSocialBadge : eventdto
					.getSocialBadge()) {

				EventSocialBadge socialBadge = new EventSocialBadge();
				socialBadge.setEventId(eventId);
				socialBadge.setSocialBadgeId(eventSocialBadge.getBadgeId());
				socialBadge.setDescription(eventSocialBadge.getDescription());
				eventSocialBadgeDao.save(socialBadge);

			}

			for (SkillScheduleDto skillSchedule : eventdto.getSkillSch()) {

				EventSkills eventSkill = new EventSkills();
				eventSkill.setEventId(eventId);
				eventSkill.setSkillId(skillSchedule.getSelected_skills());
				eventSkillsDao.save(eventSkill);

				EventSkillSchedule schdule = new EventSkillSchedule();
				schdule.setEventId(eventId);
				schdule.setEventSkillId(eventSkill.getId());
				schdule.setEventStartTime(skillSchedule.getStartDate());
				schdule.setEventEndTime(skillSchedule.getEndDate());
				eventSkillScheduleDao.save(schdule);
			}

			for (Long intrestId : eventdto.getInterests()) {
				EventInterests eventInterest = new EventInterests();
				eventInterest.setEventId(eventId);
				eventInterest.setInterestId(intrestId);
				eventInterestDao.save(eventInterest);
			}

			// saving sponsers
			if (eventdto.getGeneral().getSponsor() != null) {
				for (String sponsors : eventdto.getGeneral().getSponsor()
						.split(",")) {
					Sponsor sponser = new Sponsor();
					sponser.setSponsorName(sponsors);
					sponsorDao.save(sponser);

					EventSponsor eventSponsor = new EventSponsor();
					eventSponsor.setEventId(eventId);
					eventSponsor.setSponsorId(sponser.getId());

					eventSponsorDao.save(eventSponsor);
				}
			}

			// create event with ads
			for (Long adId : eventdto.getAdvertisements()) {
				advertisementsDao.linkAd4Event(eventId, adId);
			}

			status = "Event created successfully";
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error while creating event";
		}
		return status;
	}

	/**
	 * Procedure for getting all the information about single event
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * */
	@Transactional
	public EventDetailDto getEventDetails(long id)
			throws IllegalAccessException, InvocationTargetException {
		Events event = eventsDao.getEvent(id);
		EventDetailDto eventdto = new EventDetailDto();

		if (event != null) {
			eventdto.setId(event.getId());
			eventdto.setEventName(event.getEventName());
			eventdto.setEventAddress(event.getEventAddress());
			eventdto.setEventFromTime(event.getEventFromTime());
			eventdto.setEventToTime(event.getEventToTime());
			eventdto.setEventShortDesc(event.getEventShortDesc());
			eventdto.setEventLongDesc(event.getEventLongDesc());
			eventdto.setEventCreatedBy(event.getEventCreatedBy());
			eventdto.setCapacity(event.getCapacity());
			eventdto.setFeatured(event.getFeatured());
			eventdto.setPublished(event.getPublished());
			eventdto.setKeyword(event.getKeywords());

			// Getting Social Badge row Data.

			List<BadgeDto> badgeDt = eventSocialBadgeDao.getBadgeRowData(event
					.getId());
			eventdto.setBadgeDto(badgeDt);

			// getting skill row data.

			List<SkillBadgeRowDto> skillBadgeDt = eventSkillScheduleDao
					.getSkillBadgeRowData(event.getId());
			eventdto.setSkillBadgeRowDto(skillBadgeDt);

			// getting sponsor name
			List<SponsorDto> spDto = sponsorDao
					.getSponsorByEvent(event.getId());
			String sponsor = "";
			int count = 0;
			for (SponsorDto sp : spDto) {
				count++;
				if (count != spDto.size()) {
					sponsor += sp.getSponsorName() + ",";
				} else {
					sponsor += sp.getSponsorName();
				}
			}
			eventdto.setSponsor(sponsor);

			// getting interest
			List<Long> interest = interestDao.getInterestByEventId(event
					.getId());
			eventdto.setInterest(interest);

			// getting event type
			EventType eventType = eventTypeDao.getEventType(event
					.getEventTypeId());

			eventdto.setEvenType(eventType.getEventType());

			List<TagDto> tags = tagDao.getTagsByEvent(event.getId());
			Map<Long, Boolean> tagMap = new HashMap<Long, Boolean>();

			for (TagDto tag : tags) {
				tagMap.put(tag.getId(), tag.getFlag());
			}
			eventdto.setTags(tagMap);

			Map<String, Boolean> tagMp = new HashMap<String, Boolean>();
			for (TagDto tag : tags) {
				tagMp.put(tag.getTagName(), tag.getFlag());
			}
			eventdto.setTagName(tagMp);
			// getting all the information about the skill of events
			List<SkillsMobDto> skills = tagDao.getSkillsByEventMob(event
					.getId());
			Map<String, List<SkillEventDetailDto>> skillsMap = new HashMap<String, List<SkillEventDetailDto>>();
			for (SkillsMobDto skillMob : skills) {

				// System.out.println("categoryId" + skillMob.getId());
				// List<Skills> eventskills =
				// skillDao.getSkills(skillMob.getId());
				List<SkillEventDetailDto> skillevent = tagDao.getSkillsEvent(
						event.getId(), skillMob.getId());

				skillsMap.put(skillMob.getCategoryName(), skillevent);
			}
			eventdto.setSkills(skillsMap);
		}
		return eventdto;

	}

	@Transactional
	public EventEditDto getEventDetailsEdit(long id)
			throws IllegalAccessException, InvocationTargetException {
		Events event = eventsDao.getEvent(id);
		EventEditDto eventdto = new EventEditDto();

		if (event != null) {
			eventdto.setId(event.getId());
			eventdto.setEventName(event.getEventName());
			eventdto.setEventAddress(event.getEventAddress());
			eventdto.setEventFromTime(event.getEventFromTime());
			eventdto.setEventToTime(event.getEventToTime());
			eventdto.setEventShortDesc(event.getEventShortDesc());
			eventdto.setEventLongDesc(event.getEventLongDesc());
			eventdto.setEventCreatedBy(event.getEventCreatedBy());
			eventdto.setCapacity(event.getCapacity());
			eventdto.setFeatured(event.getFeatured());
			eventdto.setPublished(event.getPublished());
			eventdto.setKeyword(event.getKeywords());

			// Getting Social Badge row Data.

			List<BadgeDto> badgeDt = eventSocialBadgeDao.getBadgeRowData(event
					.getId());
			eventdto.setBadgeDto(badgeDt);

			// getting skill row data.

			List<SkillBadgeRowDto> skillBadgeDt = eventSkillScheduleDao
					.getSkillBadgeRowData(event.getId());
			eventdto.setSkillBadgeRowDto(skillBadgeDt);

			// getting sponsor name
			List<SponsorDto> spDto = sponsorDao
					.getSponsorByEvent(event.getId());
			String sponsor = "";
			int count = 0;
			for (SponsorDto sp : spDto) {
				count++;
				if (count != spDto.size()) {
					sponsor += sp.getSponsorName() + ",";
				} else {
					sponsor += sp.getSponsorName();
				}
			}
			eventdto.setSponsor(sponsor);

			// getting interest
			List<Long> interest = interestDao.getInterestByEventId(event
					.getId());
			eventdto.setInterest(interest);

			// getting event type
			EventType eventType = eventTypeDao.getEventType(event
					.getEventTypeId());

			eventdto.setEvenType(eventType.getEventType());

			List<TagDto> tags = tagDao.getTagsByEvent(event.getId());
			Map<Long, Boolean> tagMap = new HashMap<Long, Boolean>();

			for (TagDto tag : tags) {
				tagMap.put(tag.getId(), tag.getFlag());
			}
			eventdto.setTags(tagMap);

			// getting all the information about the skill of events
			List<SkillsMobDto> skills = tagDao.getSkillsByEventMob(event
					.getId());
			Map<String, List<SkillEventDetailDto>> skillsMap = new HashMap<String, List<SkillEventDetailDto>>();
			for (SkillsMobDto skillMob : skills) {

				// System.out.println("categoryId" + skillMob.getId());
				// List<Skills> eventskills =
				// skillDao.getSkills(skillMob.getId());
				List<SkillEventDetailDto> skillevent = tagDao.getSkillsEvent(
						event.getId(), skillMob.getId());

				skillsMap.put(skillMob.getCategoryName(), skillevent);
			}
			eventdto.setSkills(skillsMap);
		}
		return eventdto;

	}

	// enrolling event
	@Transactional
	public String enrollEvent(Long userId, Long eventId) {
		String status = "";
		try {

			EnrolledEvents enrollEvent = null;

			enrollEvent = enrollEventDao.getUserEvent(userId, eventId);

			if (enrollEvent == null) {
				enrollEvent = new EnrolledEvents();
				enrollEvent.setEventId(eventId);
				enrollEvent.setUserId(userId);
				enrollEvent.setIsAttended(true);
				enrollEvent.setIsCompleted(true);
				enrollEvent.setEventCheckedIn(true);
				enrollEvent.setDeletedFlag(false);

				enrollEventDao.save(enrollEvent);
				status = "Successfully enrolled for event";
			} else {
				if (enrollEvent.getDeletedFlag() == false) {
					status = "User already enrolled for event";
				} else {
					enrollEvent.setDeletedFlag(false);
					enrollEventDao.saveOrUpdate(enrollEvent);
					status = "Successfully enrolled for event";
				}

			}

		} catch (Exception e) {
			status = "Error while enrolling";
		}

		return status;
	}

	/*
	 * Unenrolling event
	 */
	@Transactional
	public String unenrollEvent(Long userId, Long eventId) {
		// check whether delete the entire event record from table or just add
		// deleted flag
		String status = "";
		try {
			EnrolledEvents enrollEvent = null;
			enrollEvent = enrollEventDao.getUserEvent(userId, eventId);
			if (enrollEvent == null) {
				status = "Event does not exist";
			} else {
				if (enrollEvent.getDeletedFlag()) {
					status = "User already unenrolled";
				} else {
					enrollEvent.setDeletedFlag(true);
					enrollEventDao.saveOrUpdate(enrollEvent);
					// enrollEventDao.delete(enrollEvent);
					status = "Successfully unenrolled for event";
				}
			}

		} catch (Exception e) {
			status = "Error while unenrolling";
		}

		return status;
	}

	@Transactional
	public List<AllEventsDto> filterEvents(Long userId, String searchParam,
			String fromDate, String toDate, List<Long> skillIds,
			List<Long> tagIds, List<Long> interestIds) {
		List<AllEventsDto> allEvents = new ArrayList<AllEventsDto>();

		List<Events> events = eventsDao.filterEvents(userId, searchParam,
				fromDate, toDate, skillIds, tagIds, interestIds);
		System.out.println("events" + events);

		for (Events event : events) {
			EventsDto eventdto = new EventsDto();
			eventdto.setId(event.getId());
			eventdto.setEventName(event.getEventName());
			eventdto.setEventAddress(event.getEventAddress());
			eventdto.setEventFromTime(event.getEventFromTime());
			eventdto.setEventToTime(event.getEventToTime());
			eventdto.setEventShortDesc(event.getEventShortDesc());
			eventdto.setEventLongDesc(event.getEventLongDesc());
			eventdto.setEventCreatedBy(event.getEventCreatedBy());
			eventdto.setUniversityId(event.getUniversityId());
			eventdto.setCapacity(event.getCapacity());
			eventdto.setFeatured(event.getFeatured());
			eventdto.setPublished(event.getPublished());
			// getting event type
			EventType eventType = eventTypeDao.getEventType(event
					.getEventTypeId());
			EventTypeDto evenTypeDto = new EventTypeDto();
			evenTypeDto.setId(eventType.getId());
			evenTypeDto.setEventType(eventType.getEventType());

			eventdto.setEvenType(evenTypeDto);

			// getting interest
			List<EventInterestDto> eventInterests = eventInterestDao
					.getEventInterests(event.getId());
			eventdto.setEventInterest(eventInterests);

			// we have event general information
			// getting tags information for the events
			List<TagDto> tags = tagDao.getTagsByEvent(event.getId());

			// getting all the information about the skill of events
			List<SkillsDto> skills = tagDao.getSkillsByEvent(event.getId());

			AllEventsDto alleventdto = new AllEventsDto();
			alleventdto.setGeneral(eventdto);
			alleventdto.setSkills(skills);
			alleventdto.setTags(tags);

			allEvents.add(alleventdto);
			// eventsDto.add(eventdto);
		}

		return allEvents;

	}

	// get event service.
	@Transactional
	public TotalEventDtoMob filterEventsMob(Long userId, String searchParam,
			String fromDate, String toDate, List<Long> skillIds,
			List<Long> tagIds, List<Long> interestIds, Boolean featured,
			Boolean enrolled, Boolean upcoming, Integer start, Integer limit) {
		List<AllEventsDtoMob> allEvents = new ArrayList<AllEventsDtoMob>();
		TotalEventDtoMob totalEvent = new TotalEventDtoMob();

		List<EventsNewDto> events = eventsDao.filterEventsMob(userId,
				searchParam, fromDate, toDate, skillIds, tagIds, interestIds,
				featured, enrolled, upcoming, ((start - 1) * limit), limit);
		// System.out.println(events);

		for (EventsNewDto event : events) {
			AllEventsDtoMob eventdto = new AllEventsDtoMob();
			eventdto.setId(event.getId());
			eventdto.setEventName(event.getEventName());
			eventdto.setEventAddress(event.getEventAddress());
			eventdto.setEventFromTime(event.getEventFromTime());
			eventdto.setEventToTime(event.getEventToTime());
			eventdto.setEventShortDesc(event.getEventShortDesc());
			eventdto.setEventLongDesc(event.getEventLongDesc());
			eventdto.setEventCreatedBy(event.getEventCreatedBy());
			eventdto.setCapacity(event.getCapacity());
			eventdto.setFeatured(event.getFeatured());
			eventdto.setPublished(event.getPublished());
			eventdto.setEnrollEvent(event.getEnrollEvent());
			// getting event type
			EventType eventType = eventTypeDao.getEventType(event
					.getEventTypeId());

			eventdto.setEvenType(eventType.getEventType());

			List<TagDto> tags = tagDao.getTagsByEvent(event.getId());
			Map<String, Boolean> tagMap = new HashMap<String, Boolean>();

			for (TagDto tag : tags) {
				tagMap.put(tag.getTagName(), tag.getFlag());
			}
			eventdto.setTags(tagMap);

			// List<InterestDto> interests =
			// interestDao.getInterest(event.getId());
			// Map<String, Boolean> interestMap = new HashMap<String,
			// Boolean>();
			//
			// for (InterestDto interest : interests) {
			// interestMap.put(interest.getInterestName(), interest.getFlag());
			// }
			// eventdto.setInterest(interestMap);

			// getting all the information about the skill of events
			List<SkillsMobDto> skills = tagDao.getSkillsByEventMob(event
					.getId());
			System.out.println("length:" + skills.size());
			Map<String, Integer> skillsMap = new HashMap<String, Integer>();
			for (SkillsMobDto skillMob : skills) {
				skillsMap.put(skillMob.getCategoryName(),
						skillMob.getTotalSubSkills());
			}
			eventdto.setSkills(skillsMap);

			allEvents.add(eventdto);
		}

		totalEvent.setAllEvents(allEvents);
		totalEvent.setPageNumber(start);
		totalEvent.setTotalEvents(allEvents.size());

		return totalEvent;

	}

	@Transactional
	public FilterScreenDto getFilterScreen(Long universityId)
			throws IllegalAccessException, InvocationTargetException {
		List<Tags> tags = tagDao.getAllTags();
		List<Interests> interests = interestDao.getAllInterest();

		List<TagScreenDto> tagScreen = new ArrayList<TagScreenDto>();
		List<InterestScreenDto> interestScreen = new ArrayList<InterestScreenDto>();

		for (Tags tag : tags) {
			TagScreenDto tagscr = new TagScreenDto();
			BeanUtils.copyProperties(tagscr, tag);
			tagScreen.add(tagscr);
		}

		for (Interests intr : interests) {
			InterestScreenDto intrscr = new InterestScreenDto();
			BeanUtils.copyProperties(intrscr, intr);
			interestScreen.add(intrscr);
		}

		List<SkillCategories> skillsCategory = skillCategoryDao
				.getAllSkillsCategory();
		List<SkillCategoryDto> skillCategoryScreen = new ArrayList<SkillCategoryDto>();

		for (SkillCategories category : skillsCategory) {
			List<Skills> skills = skillDao.getSkills(category.getId());
			List<SkillScreenDto> skillsScreen = new ArrayList<SkillScreenDto>();

			for (Skills skl : skills) {
				SkillScreenDto sklscr = new SkillScreenDto();
				BeanUtils.copyProperties(sklscr, skl);
				skillsScreen.add(sklscr);
			}

			SkillCategoryDto cat = new SkillCategoryDto();
			cat.setId(category.getId());
			cat.setCategoryName(category.getCategoryName());
			cat.setSkiills(skillsScreen);

			skillCategoryScreen.add(cat);
		}

		List<AdDto> adList = new ArrayList<AdDto>();
		// for (Advertisements ad : advertisementsDao.getAllAdsOfUniveristy(
		// universityId, null, null, null, null)) {
		// AdDto adDto = new AdDto();
		// adDto.setId(ad.getId());
		// adDto.setName(ad.getAdName());
		// adDto.setPublished(ad.isAdPublished());
		// adDto.setWebURL(ad.getAdWebURL());
		// adDto.setDescription(ad.getAdDescription());
		// adList.add(adDto);
		// }
		// adList = advertisementsDao.getAllAdsOfUniveristy(universityId, true,
		// null, null, null, null);

		adList = advertisementsDao.getAllAdsOfUniveristyCreateEvent();
		FilterScreenDto filterScreen = new FilterScreenDto();
		filterScreen.setInterests(interestScreen);
		filterScreen.setTags(tagScreen);
		filterScreen.setSkillsCategory(skillCategoryScreen);
		filterScreen.setAdvertisement(adList);

		return filterScreen;
	}

	/*
	 * getting types of events.
	 */
	@Transactional
	public List<EventTypeDto> getEventTypes() throws IllegalAccessException,
			InvocationTargetException {
		List<EventType> eventTypes = eventTypeDao.getAllEventType();
		List<EventTypeDto> eventsTypeDto = new ArrayList<EventTypeDto>();

		for (EventType type : eventTypes) {
			EventTypeDto typeDto = new EventTypeDto();
			BeanUtils.copyProperties(typeDto, type);
			eventsTypeDto.add(typeDto);
		}

		return eventsTypeDto;
	}

	@Transactional
	public List<EventDetailDto> getAllEventsOfCurrentUniveristy(
			Long universityId, String eventName, Date fromDate, Date toDate,
			Integer start, Integer limit) {
		List<Events> allEvents = eventsDao.getAllEventsOfUniveristy(
				universityId, eventName, fromDate, toDate, start, limit);

		List<EventDetailDto> eventDtoList = new ArrayList<EventDetailDto>();
		for (Events event : allEvents) {
			EventDetailDto eventDto = new EventDetailDto();
			eventDto.setId(event.getId());
			eventDto.setEventName(event.getEventName());
			eventDto.setEventFromTime(event.getEventFromTime());
			eventDto.setEventToTime(event.getEventToTime());
			eventDto.setEventShortDesc(event.getEventShortDesc());
			eventDto.setEventLongDesc(event.getEventLongDesc());
			eventDto.setEventAddress(event.getEventAddress());
			eventDto.setEventCreatedBy(event.getEventCreatedBy());
			eventDto.setFeatured(event.getFeatured());
			eventDto.setCapacity(event.getCapacity());
			eventDto.setEvenType(eventTypeDao.getEventType(
					event.getEventTypeId()).getEventType());
			eventDto.setPublished(event.getPublished());
			eventDtoList.add(eventDto);
		}
		// System.out.println("event dto list" +eventDtoList);
		return eventDtoList;
	}

	@Transactional
	public Integer getAllEventsOfCurrentUniveristyCount(Long universityId,
			String eventName, Date fromDate, Date toDate, Integer start,
			Integer limit) {

		return eventsDao.getAllEventsOfUniveristyCount(universityId, eventName,
				fromDate, toDate, start, limit);
	}

}
