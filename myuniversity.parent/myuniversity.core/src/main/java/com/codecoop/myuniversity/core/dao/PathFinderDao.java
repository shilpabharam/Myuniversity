package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.PathFinder;

@Component
public class PathFinderDao extends BaseDao<PathFinder> {

	@SuppressWarnings("unchecked")
	public List<PathFinder> getAllResources(Integer start, Integer limit) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(PathFinder.class);
		crit.addOrder(Order.asc("createdDate"));
		crit.setFirstResult(start);
		crit.setMaxResults(limit);
		return crit.list();
	}

	public Integer getAllResourcesCount() {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(PathFinder.class);
		return crit.list().size();
	}

	public PathFinder getResources(Long id) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(PathFinder.class);
		crit.add(Restrictions.eq("id", id));
		return (PathFinder) crit.uniqueResult();
	}
}
