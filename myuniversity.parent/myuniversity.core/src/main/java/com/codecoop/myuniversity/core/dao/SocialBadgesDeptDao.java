package com.codecoop.myuniversity.core.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.SocialBadgesDept;

@Component
public class SocialBadgesDeptDao extends BaseDao<SocialBadgesDept> {

	@SuppressWarnings("unchecked")
	public List<SocialBadgesDept> getBySocialId(Long socialBadgeId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SocialBadgesDept.class);
		crit.add(Restrictions.eq("socialBadgeId", socialBadgeId));
		return crit.list();

	}

	public SocialBadgesDept getByBadgeIdAndDepartmentId(Long socialBadgeId,
			Long deptId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SocialBadgesDept.class);
		crit.add(Restrictions.eq("socialBadgeId", socialBadgeId));
		crit.add(Restrictions.eq("departmentId", deptId));
		return (SocialBadgesDept) crit.uniqueResult();

	}

	@SuppressWarnings("unchecked")
	public List<SocialBadgesDept> getByBadgeId(Long socialBadgeId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SocialBadgesDept.class);
		crit.add(Restrictions.eq("socialBadgeId", socialBadgeId));
		return crit.list();

	}

}
