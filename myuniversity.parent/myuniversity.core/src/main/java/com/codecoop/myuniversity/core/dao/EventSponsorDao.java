package com.codecoop.myuniversity.core.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.EventSponsor;

@Component
public class EventSponsorDao extends BaseDao<EventSponsor> {

	@SuppressWarnings("unchecked")
	public List<EventSponsor> findEventSponsor(long eventId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventSponsor.class);
		crit.add(Restrictions.eq("eventId", eventId));
		return crit.list();
	}

}
