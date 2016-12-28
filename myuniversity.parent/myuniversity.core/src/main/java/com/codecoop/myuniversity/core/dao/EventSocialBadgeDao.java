package com.codecoop.myuniversity.core.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.EventSocialBadge;
import com.codecoop.myuniversity.core.dto.BadgeDto;

@Component
public class EventSocialBadgeDao extends BaseDao<EventSocialBadge> {

	@SuppressWarnings("unchecked")
	public List<EventSocialBadge> findEventSocialBadgeId(long eventId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventSocialBadge.class);
		crit.add(Restrictions.eq("eventId", eventId));
		return crit.list();
	}

	public EventSocialBadge findEventIdSocialBadgeId(long eventId,
			long socialBadgeId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventSocialBadge.class);
		crit.add(Restrictions.eq("eventId", eventId));
		crit.add(Restrictions.eq("socialBadgeId", socialBadgeId));
		return (EventSocialBadge) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<EventSocialBadge> getBySocialId(Long socialBadgeId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventSocialBadge.class);
		crit.add(Restrictions.eq("socialBadgeId", socialBadgeId));
		return crit.list();

	}

	@SuppressWarnings("unchecked")
	public List<BadgeDto> getBadgeRowData(Long eventId) {

		String sql = "select BADGE_NAME badgeName,SOCIAL_BADGE_ID socialBadgeId,DESCRIPTION description "
				+ "from EVENT_SOCIAL_BADGE es,SOCIAL_BADGES sb "
				+ "where EVENT_ID=:eventId and sb.ID=es.SOCIAL_BADGE_ID;";
		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("eventId", eventId);
		qry.addScalar("socialBadgeId", LongType.INSTANCE);
		qry.addScalar("badgeName");
		qry.addScalar("description");
		qry.setResultTransformer(Transformers.aliasToBean(BadgeDto.class));
		return (List<BadgeDto>) qry.list();

	}

}
