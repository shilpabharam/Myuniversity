package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.EventSkills;


@Component
public class EventSkillsDao extends BaseDao<EventSkills> {

	
	public EventSkills findBySkillAndEventId(long eventId, long skillId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventSkills.class);
		crit.add(Restrictions.eq("skillId", skillId));
		crit.add(Restrictions.eq("eventId", eventId));
		return (EventSkills) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<EventSkills> findByEventId(long eventId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventSkills.class);
		crit.add(Restrictions.eq("eventId", eventId));
		return (List<EventSkills>) crit.list();
	}

}
