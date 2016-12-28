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
import com.codecoop.myuniversity.core.domain.SkillBadges;
import com.codecoop.myuniversity.core.dto.CategoryScoreDto;
import com.codecoop.myuniversity.core.dto.SkillScoreDto;

@Component
public class SkillBadgeDao extends BaseDao<SkillBadges> {

	public SkillBadges getByBadgeNameAndUniversityId(String skillBadgeName,
			Long universityId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SkillBadges.class);
		crit.add(Restrictions.eq("skillBadgeName", skillBadgeName));
		crit.add(Restrictions.eq("universityId", universityId));
		return (SkillBadges) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<SkillBadges> getSkillBadgeData(Long universityId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(SkillBadges.class);
		crit.add(Restrictions.eq("universityId", universityId));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<SkillScoreDto> getSkillPoints(Long userId) {
		String sql = "select eventId, s.SKILL_CATEGORY_ID as categoryId,sc.CATEGORY_NAME as categoryName, s.ID as skillId, s.SKILL_NAME as skillName, points from "
				+ "(select esc.EVENT_ID as eventId, sc.ID as categoryId, sc.CATEGORY_NAME, es.SKILL_ID skillId, s.SKILL_NAME, SUM(FLOOR(TIME_TO_SEC(TIMEDIFF(esc.EVENT_END_TIME, esc.EVENT_START_TIME))/(60*60))) as points "
				+ "from EVENT_SKILLS es, EVENT_SKILL_SCHEDULE esc, ENROLLED_EVENTS ee, SKILLS s, SKILL_CATEGORIES sc "
				+ "where ee.DELETED_FLAG=0 AND es.SKILL_ID=s.ID and s.SKILL_CATEGORY_ID=sc.ID and es.ID=esc.EVENT_SKILL_ID and esc.EVENT_ID=ee.EVENT_ID and ee.USER_ID=:userId "
				+ "group by  es.SKILL_ID "
				+ "order by sc.ID) "
				+ "as temp "
				+ "right outer join SKILLS s "
				+ "on s.ID=temp.skillId "
				+ "inner join SKILL_CATEGORIES sc "
				+ "on sc.ID=s.SKILL_CATEGORY_ID; ";
		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("userId", userId);
		qry.addScalar("eventId", LongType.INSTANCE);
		qry.addScalar("categoryId", LongType.INSTANCE);
		qry.addScalar("categoryName");
		qry.addScalar("skillId", LongType.INSTANCE);
		qry.addScalar("skillName");
		qry.addScalar("points", IntegerType.INSTANCE);
		qry.setResultTransformer(Transformers.aliasToBean(SkillScoreDto.class));
		return (List<SkillScoreDto>) qry.list();
	}

	@SuppressWarnings("unchecked")
	public List<CategoryScoreDto> getCategoryPoints(Long userId) {
		String sql = "select ID as categoryId, CATEGORY_NAME as categoryName, IFNULL(points, 0) as points from "
				+ "(select esc.EVENT_ID as eventId, sc.ID as categoryId, sc.CATEGORY_NAME as categoryName, SUM(FLOOR(TIME_TO_SEC(TIMEDIFF(esc.EVENT_END_TIME, esc.EVENT_START_TIME))/(60*60))) as points "
				+ "from EVENT_SKILLS es, EVENT_SKILL_SCHEDULE esc, ENROLLED_EVENTS ee, SKILLS s, SKILL_CATEGORIES sc "
				+ "where ee.DELETED_FLAG=0 AND es.SKILL_ID=s.ID and s.SKILL_CATEGORY_ID=sc.ID and es.ID=esc.EVENT_SKILL_ID and esc.EVENT_ID=ee.EVENT_ID and ee.USER_ID=:userId "
				+ "group by  sc.ID "
				+ "order by sc.ID) "
				+ "as temp "
				+ "right join SKILL_CATEGORIES sc "
				+ "on temp.categoryId=sc.ID;";

		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("userId", userId);
		qry.addScalar("categoryId", LongType.INSTANCE);
		qry.addScalar("categoryName");
		qry.addScalar("points", IntegerType.INSTANCE);
		qry.setResultTransformer(Transformers
				.aliasToBean(CategoryScoreDto.class));
		return (List<CategoryScoreDto>) qry.list();
	}

}
