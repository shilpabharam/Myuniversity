package com.codecoop.myuniversity.core.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BooleanType;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.Advertisements;
import com.codecoop.myuniversity.core.dto.AdDto;

@Component
public class AdvertisementsDao extends BaseDao<Advertisements>{

	public void createAd(Advertisements ad) {
		Session session = getCurrentSession();
		session.saveOrUpdate(ad);
	}

	//getting only published advertisements for creating events
	public List<AdDto> getAllAdsOfUniveristyCreateEvent(){
		Session session = getCurrentSession();
		String queryString = "SELECT ID as id,UNI_ID as uniId,"
				+ "	AD_NAME as name, FROM_DATE as fromDate,TO_DATE as toDate,"
				+ " AD_WEB_URL as webURL,AD_PUBLISHED as isPublished,AD_DESCRIPTION as description "
				+ " FROM ADVERTISEMENTS "
				+ " WHERE AD_PUBLISHED=true and TO_DATE >=now()"
				+ " ORDER BY AD_NAME;";
		
		SQLQuery query = session.createSQLQuery(queryString);
		
		query.setResultTransformer(Transformers.aliasToBean(AdDto.class));
		query.addScalar("id",LongType.INSTANCE);
		query.addScalar("name");
		query.addScalar("fromDate");
		query.addScalar("toDate");
		query.addScalar("webURL");
		query.addScalar("isPublished",BooleanType.INSTANCE);
		query.addScalar("description");
		query.addScalar("uniId",LongType.INSTANCE);
		
		return (List<AdDto>)query.list();		
	}
	
	@SuppressWarnings("unchecked")
	public List<AdDto> getAllAdsOfUniveristy(Long universityId,Boolean published,
			Date fromDate, Date toDate, Integer start, Integer tot){
		Session session = getCurrentSession();
		String qu="SELECT ID as id,UNI_ID as uniId,AD_NAME as name,FROM_DATE as fromDate,TO_DATE as toDate,AD_WEB_URL as webURL,AD_PUBLISHED as isPublished,AD_DESCRIPTION as description FROM ADVERTISEMENTS";
		if (fromDate != null || toDate != null || published != null) {
			qu += " where ";
			if (fromDate != null) {
				qu += "FROM_DATE >=: fromDate ";
			}
			if (fromDate != null && toDate != null) {
				qu += " and ";
			}
			if (toDate != null) {
				qu += "TO_DATE <=: toDate ";
			}
			if (fromDate != null || toDate != null) {
				qu += " and ";
			}
			if (fromDate != null || published != null) {
				qu += " TO_DATE >=now()";
			}
			/*if (published != null || toDate != null) {
				qu += " and ";
			}
			if (published != null) {
				qu += " AD_PUBLISHED  is "+published;
			}*/
			
		}
		qu+=" order by AD_NAME asc, IF( DATE_CREATED > DATE_MODIFIED ,DATE_CREATED , DATE_MODIFIED) desc";
		if (start != null || tot != null) {
			qu+=" LIMIT ";
			if(start != null){
				qu+=":start,";	
			}
			if(tot != null){
				qu+=":tot";	
			}

		}

		SQLQuery query = session.createSQLQuery(qu);

		query.setResultTransformer(Transformers.aliasToBean(AdDto.class));
		if(fromDate != null){
			query.setParameter("fromDate", fromDate);
		}
		if(toDate != null){
			query.setParameter("toDate", toDate);
		}
		if(start != null){
			query.setParameter("start", start);
		}
		if(tot != null){
			query.setParameter("tot", tot);
		}
		query.addScalar("id",LongType.INSTANCE);
		query.addScalar("name");
		query.addScalar("fromDate");
		query.addScalar("toDate");
		query.addScalar("webURL");
		query.addScalar("isPublished",BooleanType.INSTANCE);
		query.addScalar("description");
		query.addScalar("uniId",LongType.INSTANCE);
		return (List<AdDto>)query.list();
	}

	
	public List<AdDto> filterAllAdsOfUniveristy(Long universityId,Boolean published,
			Date fromDate, Date toDate, Integer start, Integer tot){
		Session session = getCurrentSession();
		String qu="SELECT ID as id,UNI_ID as uniId,AD_NAME as name,FROM_DATE as fromDate,TO_DATE as toDate,AD_WEB_URL as webURL,AD_PUBLISHED as isPublished,AD_DESCRIPTION as description FROM ADVERTISEMENTS";
		if (fromDate != null || toDate != null || published != null) {
			qu += " where ";
			if (fromDate != null) {
				qu += "FROM_DATE >=: fromDate ";
			}
			if (fromDate != null && toDate != null) {
				qu += " and ";
			}
			if (toDate != null) {
				qu += "TO_DATE <=: toDate ";
			}
			if (fromDate != null || toDate != null) {
				qu += " and ";
			}
			if (fromDate != null || published != null) {
				qu += " TO_DATE >=now()";
			}
			
		}
		qu+=" order by AD_NAME asc, IF( DATE_CREATED > DATE_MODIFIED ,DATE_CREATED , DATE_MODIFIED) desc";
		if (start != null || tot != null) {
			qu+=" LIMIT ";
			if(start != null){
				qu+=":start,";	
			}
			if(tot != null){
				qu+=":tot";	
			}

		}

		SQLQuery query = session.createSQLQuery(qu);

		query.setResultTransformer(Transformers.aliasToBean(AdDto.class));
		if(fromDate != null){
			query.setParameter("fromDate", fromDate);
		}
		if(toDate != null){
			query.setParameter("toDate", toDate);
		}
		if(start != null){
			query.setParameter("start", start);
		}
		if(tot != null){
			query.setParameter("tot", tot);
		}
		query.addScalar("id",LongType.INSTANCE);
		query.addScalar("name");
		query.addScalar("fromDate");
		query.addScalar("toDate");
		query.addScalar("webURL");
		query.addScalar("isPublished",BooleanType.INSTANCE);
		query.addScalar("description");
		query.addScalar("uniId",LongType.INSTANCE);
		return (List<AdDto>)query.list();
	}

	public List<AdDto> filterAllAdsOfUniveristyOnlyPublished(Long universityId,Boolean published,
			Date fromDate, Date toDate, Integer start, Integer tot){
		Session session = getCurrentSession();
		String qu="SELECT ID as id,UNI_ID as uniId,AD_NAME as name,FROM_DATE as fromDate,TO_DATE as toDate,AD_WEB_URL as webURL,AD_PUBLISHED as isPublished,AD_DESCRIPTION as description FROM ADVERTISEMENTS";
		if (fromDate != null || toDate != null || published != null) {
			qu += " where AD_PUBLISHED=true ";
		}
		qu+=" order by AD_NAME asc, IF( DATE_CREATED > DATE_MODIFIED ,DATE_CREATED , DATE_MODIFIED) desc";
		if (start != null || tot != null) {
			qu+=" LIMIT ";
			if(start != null){
				qu+=":start,";	
			}
			if(tot != null){
				qu+=":tot";	
			}
		}

		SQLQuery query = session.createSQLQuery(qu);

		query.setResultTransformer(Transformers.aliasToBean(AdDto.class));
		if(start != null){
			query.setParameter("start", start);
		}
		if(tot != null){
			query.setParameter("tot", tot);
		}
		
		query.addScalar("id",LongType.INSTANCE);
		query.addScalar("name");
		query.addScalar("fromDate");
		query.addScalar("toDate");
		query.addScalar("webURL");
		query.addScalar("isPublished",BooleanType.INSTANCE);
		query.addScalar("description");
		query.addScalar("uniId",LongType.INSTANCE);
		return (List<AdDto>)query.list();
	}
	

	@SuppressWarnings("unchecked")
	public List<AdDto> getAdsByEventId(Long eventId){
		Session session = getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT ID as id,UNI_ID as uniId,AD_NAME as name,FROM_DATE as fromDate,TO_DATE as toDate,AD_WEB_URL as webURL,AD_PUBLISHED as isPublished,AD_DESCRIPTION as description FROM ADVERTISEMENTS where ID in (select AD_ID from EVENTS_ADS where EVENT_ID=:eventId)");
		query.setParameter("eventId", eventId);
		query.setResultTransformer(Transformers.aliasToBean(AdDto.class));
		query.addScalar("id",LongType.INSTANCE);
		query.addScalar("name");
		query.addScalar("fromDate");
		query.addScalar("toDate");
		query.addScalar("webURL");
		query.addScalar("isPublished",BooleanType.INSTANCE);
		query.addScalar("description");
		query.addScalar("uniId",LongType.INSTANCE);
		return (List<AdDto>)query.list();
	}

	public int deleteAd(Long adId){
		Session session = getCurrentSession();
		SQLQuery query1 = session.createSQLQuery("delete from EVENTS_ADS where AD_ID=:adId");
		query1.setParameter("adId", adId);
		query1.executeUpdate();
		SQLQuery query2 = session.createSQLQuery("delete from ADVERTISEMENTS where ID=:adId");
		query2.setParameter("adId", adId);
		return query2.executeUpdate();
	}

	public int linkAd4Event(Long eventId,Long adId){
		Session session = getCurrentSession();
		SQLQuery query = session.createSQLQuery("insert into EVENTS_ADS (EVENT_ID, AD_ID) values (:eventId, :adId)"); 
		query.setParameter("eventId", eventId);
		query.setParameter("adId", adId);
		return query.executeUpdate();
	}

	public int delteEventAd(Long eventId){
		Session session = getCurrentSession();
		SQLQuery query = session.createSQLQuery("delete from EVENTS_ADS where EVENT_ID=:eventId");
		query.setParameter("eventId", eventId);
		return query.executeUpdate();
	}
}
