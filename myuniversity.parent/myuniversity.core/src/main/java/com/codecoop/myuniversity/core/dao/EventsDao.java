package com.codecoop.myuniversity.core.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BooleanType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.codecoop.myuniversity.core.domain.Events;
import com.codecoop.myuniversity.core.dto.EventsNewDto;

@Component
public class EventsDao extends BaseDao<Events> {
	public Events getEvent(long id) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Events.class);
		crit.add(Restrictions.eq("id", id));
		return (Events) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Events> getAllEvents(Long universityId, Integer start,
			Integer limit) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Events.class);
		crit.add(Restrictions.eq("universityId", universityId));
		crit.setFirstResult(start);
		crit.setMaxResults(limit);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Events> getAllEventsOfUniveristy(Long universityId,String eventName,
			Date fromDate, Date toDate, Integer start, Integer limit) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Events.class);
		crit.add(Restrictions.eq("universityId", universityId));
		if(!StringUtils.isEmpty(eventName)){
			crit.add(Restrictions.like("eventName", eventName,MatchMode.ANYWHERE));
		}
		if (fromDate != null && toDate != null) {
			crit.add(Restrictions.ge("eventFromTime", fromDate));
			crit.add(Restrictions.le("eventToTime", toDate));
		}else{
			crit.add(Restrictions.ge("eventToTime", new Date()));
		}
		
		crit.addOrder(Order.asc("eventFromTime"));
		
		if (start != null && limit != null) {
			crit.setFirstResult(start);
			crit.setMaxResults(limit);
		}
		System.out.println("list" +crit.list());
		return crit.list();
	}

	public Integer getAllEventsOfUniveristyCount(Long universityId,String eventName,
			Date fromDate, Date toDate, Integer start, Integer limit) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Events.class);
		crit.add(Restrictions.eq("universityId", universityId));
		if(!StringUtils.isEmpty(eventName)){
			crit.add(Restrictions.like("eventName", eventName,MatchMode.ANYWHERE));
		}
		
		if (fromDate != null && toDate != null) {
			crit.add(Restrictions.ge("eventFromTime", fromDate));
			crit.add(Restrictions.le("eventToTime", toDate));
		}
	else{
		crit.add(Restrictions.ge("eventToTime", new Date()));
	}
		System.out.println("event dto list" +crit.list());
		return crit.list().size();
	}

	@SuppressWarnings("unchecked")
	public List<Events> filterEvents(Long userId, String searchParam,
			String fromDate, String toDate, List<Long> skillIds,
			List<Long> tagIds, List<Long> interestIds) {
		boolean searchParamFlag = false, dateFlag = false, skillIdsFlag = false, tagIdsFlag = false, mflag = true;

		String sql = "select distinct e.ID as id, e.EVENT_NAME as eventName, e.EVENT_ADDRESS as eventAddress,"
				+ " e.EVENT_FROM_TIME as eventFromTime, e.EVENT_TO_TIME as eventToTime,  e.EVENT_SHORT_DESC as eventShortDesc,"
				+ " e.EVENT_LONG_DESC as eventLongDesc, e.EVENT_CREATED_BY as eventCreatedBy, "
				+ " e.UNIVERSITY_ID as universityId, e.CAPACITY as capacity, e.FEATURED as featured, "
				+ " e.PUBLISHED as published, e.EVENT_TYPE_ID as eventTypeId"
				+ " from EVENTS e left outer join EVENT_SKILLS es "
				+ " on e.ID=es.EVENT_ID left outer join EVENT_TAGS et "
				+ " on e.ID=et.EVENT_ID left outer join EVENT_INTERESTS ei  "
				+ " on e.ID=ei.EVENT_ID";

		if (searchParam.isEmpty() && fromDate.isEmpty() && toDate.isEmpty()
				&& skillIds.isEmpty() && tagIds.isEmpty()
				&& interestIds.isEmpty()) {
			if (userId == null) {
				sql += " ";
				sql += ";";
				mflag = false;
			} else {
				sql += " inner join ENROLLED_EVENTS ee on ee.EVENT_ID=e.ID where ee.USER_ID=:userId and ";
				sql += ";";
				mflag = false;
			}

		} else {
			if (userId == null) {
				sql += " where ";
			} else {
				sql += " inner join ENROLLED_EVENTS ee on ee.EVENT_ID=e.ID where ee.USER_ID=:userId and ";
			}
		}

		if (!searchParam.isEmpty()) {
			sql += "EVENT_NAME like :searchParam or EVENT_SHORT_DESC like :searchParam or EVENT_LONG_DESC like :searchParam ";
			searchParamFlag = true;
		}

		if (!fromDate.isEmpty() && !toDate.isEmpty()) {
			if (searchParamFlag) {
				sql += " and (EVENT_FROM_TIME>=:fromDate and EVENT_TO_TIME<=:toDate) ";
			} else {
				sql += "EVENT_FROM_TIME>=:fromDate and EVENT_TO_TIME<=:toDate ";
			}
			dateFlag = true;
		}

		if (!skillIds.isEmpty()) {
			if (searchParamFlag || dateFlag) {
				sql += "and SKILL_ID in (:skillIds) ";
			} else {
				sql += "SKILL_ID in (:skillIds) ";
			}
			skillIdsFlag = true;
		}

		if (!tagIds.isEmpty()) {
			if (searchParamFlag || dateFlag || skillIdsFlag) {
				sql += "and TAG_ID in (:tagIds) ";
			} else {
				sql += "TAG_ID in (:tagIds) ";
			}
			tagIdsFlag = true;
		}

		if (!interestIds.isEmpty()) {
			if (searchParamFlag || dateFlag || skillIdsFlag || tagIdsFlag) {
				sql += "and INTEREST_ID in (:interestIds)";
			} else {
				sql += "INTEREST_ID in (:interestIds)";
			}
		}

		if (mflag) {
			sql += ";";
		}

		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		if (userId != null) {
			qry.setParameter("userId", userId);
		}

		if (!searchParam.isEmpty()) {
			qry.setParameter("searchParam", "%" + searchParam + "%");
		}
		if (!fromDate.isEmpty() && !toDate.isEmpty()) {
			qry.setParameter("fromDate", fromDate);
			qry.setParameter("toDate", toDate);
		}
		if (!skillIds.isEmpty()) {
			qry.setParameterList("skillIds", skillIds);
		}
		if (!tagIds.isEmpty()) {
			qry.setParameterList("tagIds", tagIds);
		}
		if (!interestIds.isEmpty()) {
			qry.setParameterList("interestIds", interestIds);
		}

		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("eventName");
		qry.addScalar("eventAddress");
		qry.addScalar("eventFromTime");
		qry.addScalar("eventToTime");
		qry.addScalar("eventShortDesc");
		qry.addScalar("eventLongDesc");
		qry.addScalar("eventCreatedBy", LongType.INSTANCE);
		qry.addScalar("universityId", LongType.INSTANCE);
		qry.addScalar("capacity", IntegerType.INSTANCE);
		qry.addScalar("featured", BooleanType.INSTANCE);
		qry.addScalar("published", BooleanType.INSTANCE);
		qry.addScalar("eventTypeId", LongType.INSTANCE);

		qry.setResultTransformer(Transformers.aliasToBean(Events.class));
		return (List<Events>) qry.list();

	}

	@SuppressWarnings("unchecked")
	public List<EventsNewDto> filterEventsMob(Long userId, String searchParam,
			String fromDate, String toDate, List<Long> skillIds,
			List<Long> tagIds, List<Long> interestIds, Boolean featured,
			Boolean enrolled, Boolean upcoming, Integer start, Integer limit) {
		String keySearch = "";
		boolean enrolledFlag = false, searchParamFlag = false, dateFlag = false, skillIdsFlag = false, tagIdsFlag = false, mflag = true, interestIdflag = false, featuredFlag = false;

		String sql = "select distinct e.ID as id, e.EVENT_NAME as eventName, e.EVENT_ADDRESS as eventAddress,"
				+ " e.EVENT_FROM_TIME as eventFromTime, e.EVENT_TO_TIME as eventToTime,  e.EVENT_SHORT_DESC as eventShortDesc,"
				+ " e.EVENT_LONG_DESC as eventLongDesc, e.EVENT_CREATED_BY as eventCreatedBy, "
				+ " e.UNIVERSITY_ID as universityId, e.CAPACITY as capacity, e.FEATURED as featured, "
				+ " e.PUBLISHED as published, e.EVENT_TYPE_ID as eventTypeId,"
				+ " if(ee.DELETED_FLAG is null or ee.DELETED_FLAG=true, false, true) as enrollEvent"
				+ " from ENROLLED_EVENTS ee right outer join EVENTS e "
				+ " on ee.EVENT_ID=e.ID and  ee.USER_ID=:userId "
				+ " left outer join EVENT_SKILLS es "
				+ " on e.ID=es.EVENT_ID left outer join EVENT_TAGS et "
				+ " on e.ID=et.EVENT_ID left outer join EVENT_INTERESTS ei "
				+ " on e.ID=ei.EVENT_ID ";

		if (searchParam.isEmpty() && fromDate.isEmpty() && toDate.isEmpty()
				&& skillIds.isEmpty() && tagIds.isEmpty()
				&& interestIds.isEmpty()) {
			mflag = false;
		}

		if (!searchParam.isEmpty()) {
			searchParam = searchParam + "%";
			keySearch = "%" + searchParam + "%";
			sql += "where (EVENT_NAME like :searchParam or EVENT_SHORT_DESC like :searchParam or EVENT_LONG_DESC like :searchParam or KEYWORDS like :keySearch) ";
			searchParamFlag = true;
		}

		if (!fromDate.isEmpty() && !toDate.isEmpty()) {
			if (searchParamFlag) {
				sql += " and (EVENT_FROM_TIME>=:fromDate and EVENT_TO_TIME<=:toDate) ";
			} else {
				sql += "where EVENT_FROM_TIME>=:fromDate and EVENT_TO_TIME<=:toDate ";
			}
			dateFlag = true;
		}

		if (!skillIds.isEmpty()) {
			if (searchParamFlag || dateFlag) {
				sql += "and SKILL_ID in (:skillIds) ";
			} else {
				sql += "where SKILL_ID in (:skillIds) ";
			}
			skillIdsFlag = true;
		}

		if (!tagIds.isEmpty()) {
			if (searchParamFlag || dateFlag || skillIdsFlag) {
				sql += "and TAG_ID in (:tagIds) ";
			} else {
				sql += "where TAG_ID in (:tagIds) ";
			}
			tagIdsFlag = true;
		}

		if (!interestIds.isEmpty()) {
			if (searchParamFlag || dateFlag || skillIdsFlag || tagIdsFlag) {
				sql += "and INTEREST_ID in (:interestIds)";
			} else {
				sql += "where INTEREST_ID in (:interestIds)";
			}
			interestIdflag = true;
		}

		if (featured) {
			if (searchParamFlag || dateFlag || skillIdsFlag || tagIdsFlag
					|| interestIdflag) {
				sql += "and featured=:featured ";
			} else {
				sql += "where featured=:featured ";
			}
			featuredFlag = true;
		}

		if (enrolled) {
			if (searchParamFlag || dateFlag || skillIdsFlag || tagIdsFlag
					|| interestIdflag || featuredFlag) {
				sql += "and ee.USER_ID is not null and ee.DELETED_FLAG=false ";
			} else {
				sql += "where ee.USER_ID is not null and ee.DELETED_FLAG=false ";
			}
			enrolledFlag = true;
		}

		if (searchParamFlag || dateFlag || skillIdsFlag || tagIdsFlag
				|| interestIdflag || featuredFlag || enrolledFlag) {
			if (upcoming) {
				sql += "and EVENT_FROM_TIME > current_timestamp() and EVENT_FROM_TIME <= (current_timestamp()+INTERVAL 10 DAY) ";
				sql += "and PUBLISHED=true ";
			} else {
				sql += "and EVENT_FROM_TIME > current_timestamp() ";
				sql += "and PUBLISHED=true ";
			}
		} else {
			if (upcoming) {
				sql += "and EVENT_FROM_TIME > current_timestamp() and EVENT_FROM_TIME <= (current_timestamp()+INTERVAL 10 DAY) ";
				sql += "and PUBLISHED=true ";
			} else {
				sql += "where EVENT_FROM_TIME > current_timestamp() ";
				sql += "and PUBLISHED=true ";
			}
		}

		sql += "order by EVENT_FROM_TIME asc";
		
		System.out.println("query");
		System.out.println(sql);

		// sql += " ;";

		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		if (userId != null) {
			qry.setParameter("userId", userId);
		}

		if (!searchParam.isEmpty()) {
			qry.setParameter("searchParam", searchParam + "%");
			qry.setParameter("keySearch", keySearch);

		}
		if (!fromDate.isEmpty() && !toDate.isEmpty()) {
			qry.setParameter("fromDate", fromDate);
			qry.setParameter("toDate", toDate);
		}
		if (!skillIds.isEmpty()) {
			qry.setParameterList("skillIds", skillIds);
		}
		if (!tagIds.isEmpty()) {
			qry.setParameterList("tagIds", tagIds);
		}
		if (!interestIds.isEmpty()) {
			qry.setParameterList("interestIds", interestIds);
		}
		if (featured) {
			qry.setParameter("featured", featured);
		}

		qry.setFirstResult(start);
		qry.setMaxResults(limit);

		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("eventName");
		qry.addScalar("eventAddress");
		qry.addScalar("eventFromTime");
		qry.addScalar("eventToTime");
		qry.addScalar("eventShortDesc");
		qry.addScalar("eventLongDesc");
		qry.addScalar("eventCreatedBy", LongType.INSTANCE);
		qry.addScalar("universityId", LongType.INSTANCE);
		qry.addScalar("capacity", IntegerType.INSTANCE);
		qry.addScalar("featured", BooleanType.INSTANCE);
		qry.addScalar("published", BooleanType.INSTANCE);
		qry.addScalar("eventTypeId", LongType.INSTANCE);
		qry.addScalar("enrollEvent", BooleanType.INSTANCE);

		qry.setResultTransformer(Transformers.aliasToBean(EventsNewDto.class));
		return (List<EventsNewDto>) qry.list();

	}
}
