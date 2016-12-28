package com.codecoop.myuniversity.core.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.SocialBadgePoints;
import com.codecoop.myuniversity.core.dto.EventsSocialBadgesPoints;

@Component
public class SocialBadgePointsDao extends BaseDao<SocialBadgePoints> {

	@SuppressWarnings("unchecked")
	public List<SocialBadgePoints> getSocialBadgePointData(Long universityId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SocialBadgePoints.class);
		crit.add(Restrictions.eq("universityId", universityId));
		return crit.list();
	}

	public SocialBadgePoints getSocialPoints(String socialBadgeName,
			Long universityId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SocialBadgePoints.class);
		crit.add(Restrictions.eq("socialBadgeName", socialBadgeName));
		crit.add(Restrictions.eq("universityId", universityId));
		return (SocialBadgePoints) crit.uniqueResult();
	}

	public SocialBadgePoints getSocialPointsByBadgeName(String socialBadgeName) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SocialBadgePoints.class);
		crit.add(Restrictions.eq("socialBadgeName", socialBadgeName));
		return (SocialBadgePoints) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<EventsSocialBadgesPoints> getEventsSocialBadgesPoints(
			Long userId) {
		String sql = "SELECT SOCIAL_BADGE_ID AS id, FLOOR(((COUNT(*)/ NUMBER_OF_EVENTS)))*10 AS points, "
				+ "sb.BADGE_NAME AS badgeName, sb.BADGE_DESCRIPTION as badgeDescription "
				+ "FROM EVENT_SOCIAL_BADGE esb, SOCIAL_BADGES sb "
				+ "WHERE EVENT_ID IN(select EVENT_ID FROM ENROLLED_EVENTS ee "
				+ "WHERE ee.USER_ID=:userId) "
				+ "AND sb.ID=esb.SOCIAL_BADGE_ID " + "GROUP BY SOCIAL_BADGE_ID";

		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("userId", userId);
		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("points", IntegerType.INSTANCE);
		qry.addScalar("badgeName");
		qry.addScalar("badgeDescription");
		qry.setResultTransformer(Transformers
				.aliasToBean(EventsSocialBadgesPoints.class));
		return (List<EventsSocialBadgesPoints>) qry.list();
	}
}
