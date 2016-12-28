package com.codecoop.myuniversity.core.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.UserInterests;

@Component
public class UsersInterstDao extends BaseDao<UserInterests> {

	public void saveInterestId(Long interestId,long userId){
		
		UserInterests userInterest=new UserInterests();
		Session session = getCurrentSession();
		userInterest.setInterestId(interestId);
		userInterest.setUserId(userId);
		session.saveOrUpdate(userInterest);	
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInterests> getUserInterests(long userId ){
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(UserInterests.class);
		crit.add(Restrictions.eq("userId", userId));
		return crit.list();
		
	}

}
