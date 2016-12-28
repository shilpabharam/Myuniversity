package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.EventInterests;
import com.codecoop.myuniversity.core.dto.EventInterestDto;

@Component
public class EventInterestDao extends BaseDao<EventInterests> {

	@SuppressWarnings("unchecked")
	public List<EventInterestDto> getEventInterests(long eventId) {
		String sql = "select INTEREST_ID as id, INTEREST_NAME as interestName "
				+ "from INTERESTS i, EVENT_INTERESTS ei "
				+ "where i.ID=ei.INTEREST_ID and EVENT_ID=:eventId order by INTEREST_ID ;";

		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("eventId", eventId);
		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("interestName");
		qry.setResultTransformer(Transformers
				.aliasToBean(EventInterestDto.class));
		return (List<EventInterestDto>) qry.list();
	}
	
	public EventInterests findByInterestAndEventId(long eventId, long interestId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventInterests.class);
		crit.add(Restrictions.eq("interestId", interestId));
		crit.add(Restrictions.eq("eventId", eventId));
		return (EventInterests) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<EventInterests> findEventInterests(long eventId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventInterests.class);
		crit.add(Restrictions.eq("eventId", eventId));
		return crit.list();
	}
	
}
