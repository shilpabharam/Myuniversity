package com.codecoop.myuniversity.core.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.codecoop.myuniversity.core.domain.Roles;

@Component
public class RolesDao extends BaseDao<Roles> {
	
	public Roles findByRoleName(String roleName){
		Session session=getCurrentSession();
		Criteria crit=session.createCriteria(Roles.class);
		crit.add(Restrictions.eq("roleName", roleName));
		return (Roles) crit.uniqueResult();
	}
	

}
