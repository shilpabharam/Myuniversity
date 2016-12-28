package com.codecoop.myuniversity.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecoop.myuniversity.core.dao.AdvertisementsDao;
import com.codecoop.myuniversity.core.domain.Advertisements;
import com.codecoop.myuniversity.core.dto.AdDto;

@Service
public class AdvertisementsService {

	@Autowired
	AdvertisementsDao advertisementsDao;

	@Transactional
	public String creteAd(AdDto ad){
		Advertisements ads = new Advertisements();
		ads.setAdName(ad.getName());
		ads.setAdPublished(ad.isPublished());
		ads.setAdWebURL(ad.getWebURL());
		ads.setFromDate(ad.getFromDate());
		ads.setToDate(ad.getToDate());
		ads.setUniId(ad.getUniId()); 
		ads.setAdDescription(ad.getDescription());
		ads.setDateCreated(new Date());
		ads.setDateModified(new Date());
		advertisementsDao.save(ads);
		return "success";
	}


	@Transactional
	public String editAd(AdDto ad){
		Advertisements ads = new Advertisements();
		ads.setId(ad.getId());
		ads.setAdName(ad.getName());
		ads.setAdPublished(ad.isPublished());
		ads.setAdWebURL(ad.getWebURL());
		ads.setFromDate(ad.getFromDate());
		ads.setToDate(ad.getToDate());
		ads.setUniId(ad.getUniId()); 
		ads.setAdDescription(ad.getDescription());
		ads.setDateModified(new Date());
		advertisementsDao.saveOrUpdate(ads);
		return "success";
	}

	@Transactional
	public String deleteAd(Long adId){
		return advertisementsDao.deleteAd(adId) > 0 ? "success":"failed";
	}

	@Transactional
	public List<AdDto> getAllAdsOfUniveristy(Long universityId,
			Date fromDate, Date toDate, Integer start, Integer limit){
		List<AdDto> list = new ArrayList<AdDto>();
		list=advertisementsDao.getAllAdsOfUniveristy(universityId, true, null, null, start, limit);	
		return list;
	}
	public List<AdDto> getAllAdsOfUniveristyPublishOnly(Long universityId,
			Date fromDate, Date toDate, Integer start, Integer limit){
		
		List<AdDto> list = new ArrayList<AdDto>();
		list=advertisementsDao.filterAllAdsOfUniveristyOnlyPublished(universityId, true, null, null, start, limit);
		return list;
	}
	

	@Transactional
	public List<AdDto> getAdsOnEvent(Long eventId){
		return advertisementsDao.getAdsByEventId(eventId);
	}

	@Transactional
	public String linkAd4Event(Long eventId,Long adId){
		advertisementsDao.linkAd4Event(eventId, adId);
		return "success";
	}

	@Transactional
	public String delteEventAd(Long eventId){
		return advertisementsDao.delteEventAd(eventId) > 0 ? "success":"failed";
	}



}
