package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BooleanType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.Tags;
import com.codecoop.myuniversity.core.dto.SkillEventDetailDto;
import com.codecoop.myuniversity.core.dto.SkillsDto;
import com.codecoop.myuniversity.core.dto.SkillsMobDto;
import com.codecoop.myuniversity.core.dto.TagDto;

@Component
public class TagDao extends BaseDao<Tags> {

	@SuppressWarnings("unchecked")
	public List<Tags> getAllTags() {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Tags.class);
		crit.addOrder(Order.asc("tagName"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TagDto> getTagsByEvent(Long eventId) {
		String sql = "select t.ID as id, TAG_NAME as tagName, if(t.ID=et.TAG_ID, true, false) as  flag from EVENT_TAGS et right outer join TAGS t on t.ID=et.TAG_ID and et.EVENT_ID=:eventId order by id";
		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("eventId", eventId);
		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("tagName");
		qry.addScalar("flag", BooleanType.INSTANCE);
		qry.setResultTransformer(Transformers.aliasToBean(TagDto.class));
		return (List<TagDto>) qry.list();
	}

	@SuppressWarnings("unchecked")
	public List<SkillsDto> getSkillsByEvent(Long eventId) {
		String sql = "select s.ID as id, SKILL_NAME as skillName, CATEGORY_NAME as categoryName,true as flag "
				+ "from EVENT_SKILLS es, SKILLS s, SKILL_CATEGORIES sc "
				+ "where es.SKILL_ID=s.ID and sc.ID=s.SKILL_CATEGORY_ID and EVENT_ID=:eventId order by id;";
		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("eventId", eventId);
		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("skillName");
		qry.addScalar("categoryName");
		qry.addScalar("flag", BooleanType.INSTANCE);
		qry.setResultTransformer(Transformers.aliasToBean(SkillsDto.class));
		return (List<SkillsDto>) qry.list();
	}

	@SuppressWarnings("unchecked")
	public List<SkillsMobDto> getSkillsByEventMob(Long eventId) {
		String sql = "select sc.ID as id, CATEGORY_NAME as categoryName, count(*) as totalSubSkills "
				+ "from  SKILL_CATEGORIES sc, SKILLS s, EVENT_SKILLS es "
				+ "where sc.ID=s.SKILL_CATEGORY_ID and es.SKILL_ID=s.ID and es.EVENT_ID=:eventId "
				+ "group by categoryName "
				+ "union "
				+ "select sc.ID as id, CATEGORY_NAME as categoryName, 0 as totalSubSkills "
				+ "from SKILL_CATEGORIES sc "
				+ "where sc.ID not in(select id from "
				+ "(select sc.ID as id, CATEGORY_NAME as categoryName, count(*) as count "
				+ "from  SKILL_CATEGORIES sc, SKILLS s, EVENT_SKILLS es "
				+ "where sc.ID=s.SKILL_CATEGORY_ID and es.SKILL_ID=s.ID and es.EVENT_ID=:eventId "
				+ "group by categoryName) " + "as temp)";

		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("eventId", eventId);
		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("categoryName");
		qry.addScalar("totalSubSkills", IntegerType.INSTANCE);
		qry.setResultTransformer(Transformers.aliasToBean(SkillsMobDto.class));
		return (List<SkillsMobDto>) qry.list();
	}

	@SuppressWarnings("unchecked")
	public List<SkillEventDetailDto> getSkillsEvent(Long eventId,
			Long categoryId) {
		String sql = "select s.ID as id, s.SKILL_NAME as skillName"
				+ " from EVENT_SKILLS es, SKILLS s, SKILL_CATEGORIES sc "
				+ "where es.SKILL_ID=s.ID and sc.ID=s.SKILL_CATEGORY_ID and EVENT_ID=:eventId and SKILL_CATEGORY_ID=:categoryId ;";
		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("categoryId", categoryId);
		qry.setParameter("eventId", eventId);
		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("skillName");
		qry.setResultTransformer(Transformers
				.aliasToBean(SkillEventDetailDto.class));
		return (List<SkillEventDetailDto>) qry.list();
	}

}
