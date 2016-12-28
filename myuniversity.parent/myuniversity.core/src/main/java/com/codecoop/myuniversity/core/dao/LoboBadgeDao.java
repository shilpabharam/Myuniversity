package com.codecoop.myuniversity.core.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.LoboBadge;

@Component
public class LoboBadgeDao extends BaseDao<LoboBadge> {

	public LoboBadge getByLoboBadgeName(String loboBadgeName){
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(LoboBadge.class);
		crit.add(Restrictions.eq("loboBadgeName", loboBadgeName));
		return (LoboBadge) crit.uniqueResult();
	}
}
