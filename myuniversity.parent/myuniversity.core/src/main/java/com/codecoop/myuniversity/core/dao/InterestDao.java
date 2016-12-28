package com.codecoop.myuniversity.core.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BooleanType;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.Interests;
import com.codecoop.myuniversity.core.dto.InterestDto;

@Component
public class InterestDao extends BaseDao<Interests> {

	@SuppressWarnings("unchecked")
	public List<InterestDto> getInterest(long userId) {
		String sql = "select ID as id, INTEREST_NAME as interestName, false as flag "
				+ "from INTERESTS where ID not in "
				+ "(select INTEREST_ID from USER_INTERESTS where USER_ID=:userId)"
				+ " union "
				+ "select ui.INTEREST_ID as id, i.INTEREST_NAME as interestName, true as flag "
				+ "from USER_INTERESTS ui, INTERESTS i "
				+ "where USER_ID=:userId and ui.INTEREST_ID=i.ID order by interestName ";

		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("userId", userId);
		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("interestName");
		qry.addScalar("flag", BooleanType.INSTANCE);
		qry.setResultTransformer(Transformers.aliasToBean(InterestDto.class));
		return (List<InterestDto>) qry.list();
	}

	public void saveInterest(String interestName) {
		Interests interest = new Interests();
		Session session = getCurrentSession();
		interest.setInterestName(interestName);
		session.saveOrUpdate(interest);
	}

	@SuppressWarnings("unchecked")
	public List<Interests> getAllInterest() {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Interests.class);
		crit.addOrder(Order.asc("interestName"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Long> getInterestByEventId(long eventId) {
		List<Long> selectedInterest = new ArrayList<Long>();
		String sql = "select INTEREST_ID id from INTERESTS i,EVENT_INTERESTS et where EVENT_ID=:eventId and et.INTEREST_ID=i.id;";
		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("eventId", eventId);
		qry.addScalar("id", LongType.INSTANCE);
		qry.setResultTransformer(Transformers.aliasToBean(InterestDto.class));
		List<InterestDto> interests = qry.list();

		for (InterestDto interest : interests) {
			selectedInterest.add(interest.getId());
		}

		return selectedInterest;
	}
}
