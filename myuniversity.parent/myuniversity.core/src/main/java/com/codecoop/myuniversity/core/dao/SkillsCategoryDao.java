package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.SkillCategories;

@Component
public class SkillsCategoryDao extends BaseDao<SkillCategories> {

	@SuppressWarnings("unchecked")
	public List<SkillCategories> getAllSkillsCategory() {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SkillCategories.class);
		return crit.list();
	}

}
