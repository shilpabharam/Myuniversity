package com.codecoop.myuniversity.core.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;


import com.codecoop.myuniversity.core.domain.SocialBadges;

@Component
public class SocialBadgesDao extends BaseDao<SocialBadges> {

	public void createSocialBAdges(SocialBadges socialBadge) {
		Session session = getCurrentSession();
		session.saveOrUpdate(socialBadge);
	}

	@SuppressWarnings("unchecked")
	public List<SocialBadges> getSocialBadges() {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SocialBadges.class);
		return crit.list();
	}

	public SocialBadges getById(Long id) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SocialBadges.class);
		crit.add(Restrictions.eq("id", id));
		return (SocialBadges) crit.uniqueResult();
	}
	
}
