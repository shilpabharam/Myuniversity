package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.EventTags;

@Component
public class EventTagsDao extends BaseDao<EventTags> {

	public EventTags findByTagAndEventId(long eventId, long tagId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventTags.class);
		crit.add(Restrictions.eq("tagId", tagId));
		crit.add(Restrictions.eq("eventId", eventId));
		return (EventTags) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<EventTags> findEventTags(long eventId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventTags.class);
		crit.add(Restrictions.eq("eventId", eventId));
		return crit.list();
	}
}
