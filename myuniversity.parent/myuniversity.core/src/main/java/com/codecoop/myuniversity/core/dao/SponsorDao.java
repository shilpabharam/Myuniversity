package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import org.hibernate.type.LongType;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.Sponsor;
import com.codecoop.myuniversity.core.dto.SponsorDto;


@Component
public class SponsorDao extends BaseDao<Sponsor> {
	
	public void saveSponsor(String sponsorName) {
		Sponsor sponsor = new Sponsor();
		Session session = getCurrentSession();
		sponsor.setSponsorName(sponsorName);
		session.saveOrUpdate(sponsor);
	}
	
	@SuppressWarnings("unchecked")
	public List<SponsorDto> getSponsorByEvent(Long eventId) {
		
		String sql = "select SPONSOR_ID as id, SPONSOR_NAME as sponsorName from SPONSOR sp,EVENT_SPONSOR esp where EVENT_ID=:eventId and esp.SPONSOR_ID=sp.ID;";
		SQLQuery qry = getCurrentSession().createSQLQuery(sql);
		qry.setParameter("eventId", eventId);
		qry.addScalar("id", LongType.INSTANCE);
		qry.addScalar("sponsorName");

		qry.setResultTransformer(Transformers.aliasToBean(SponsorDto.class));
		return (List<SponsorDto>) qry.list();
	}

}
