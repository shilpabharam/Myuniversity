package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.EventType;

@Component
public class EventTypeDao extends BaseDao<EventType> {

	public EventType getEventType(Long id) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventType.class);
		crit.add(Restrictions.eq("id", id));
		return (EventType) crit.uniqueResult();

	}

	@SuppressWarnings("unchecked")
	public List<EventType> getAllEventType() {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventType.class);
		return crit.list();
	}
}
