package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.Skills;

@Component
public class SkillsDao extends BaseDao<Skills> {

	@SuppressWarnings("unchecked")
	public List<Skills> getSkills(Long skillCategoryId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Skills.class);
		crit.add(Restrictions.eq("skillCategoryId", skillCategoryId));
		return crit.list();
	}
}
