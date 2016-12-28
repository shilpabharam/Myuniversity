package com.codecoop.myuniversity.core.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.EnrolledEvents;


@Component
public class EnrollEventDao extends BaseDao<EnrolledEvents> {
	
	public EnrolledEvents getUserEvent(Long userId, Long eventId){
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EnrolledEvents.class);
		crit.add(Restrictions.eq("userId", userId));
		crit.add(Restrictions.eq("eventId", eventId));
		return (EnrolledEvents) crit.uniqueResult();	
	}

}
