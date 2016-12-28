package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.EventSkillSchedule;
import com.codecoop.myuniversity.core.domain.EventSkills;
import com.codecoop.myuniversity.core.dto.SkillBadgeRowDto;

@Component
public class EventSkillScheduleDao extends BaseDao<EventSkillSchedule> {
	
	
	@SuppressWarnings("unchecked")
	public List<SkillBadgeRowDto> getSkillBadgeRowData(Long eventId){
		
		String sql = "select SKILL_ID skillId,SKILL_NAME skillName,EVENT_START_TIME eventStartTime,EVENT_END_TIME eventEndTime "
				+ "from EVENT_SKILL_SCHEDULE ess,EVENT_SKILLS es,SKILLS sk "
				+ "where ess.EVENT_ID=:eventId and ess.EVENT_SKILL_ID=es.ID "
				+ "and es.SKILL_ID=sk.ID;";
		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("eventId", eventId);
		qry.addScalar("skillId", LongType.INSTANCE);
		qry.addScalar("skillName");
		qry.addScalar("eventStartTime");
		qry.addScalar("eventEndTime");
		qry.setResultTransformer(Transformers.aliasToBean(SkillBadgeRowDto.class));
		return (List<SkillBadgeRowDto>) qry.list();
		
	}
	public EventSkillSchedule findByEventSkillId(long eventSkillId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventSkillSchedule.class);
		crit.add(Restrictions.eq("eventSkillId", eventSkillId));
		return (EventSkillSchedule) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<EventSkillSchedule> findByEventId(long eventId) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(EventSkillSchedule.class);
		crit.add(Restrictions.eq("eventId", eventId));
		return (List<EventSkillSchedule>) crit.uniqueResult();
	}


}
