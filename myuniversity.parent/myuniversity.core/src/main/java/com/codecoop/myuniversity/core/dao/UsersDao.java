package com.codecoop.myuniversity.core.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.Users;

@Component
public class UsersDao extends BaseDao<Users> {

	public void addOrUpdateUser(Users user) {
		Session session = getCurrentSession();
		session.saveOrUpdate(user);
	}

	public Users isUserExist(String username) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("email", username));
		return (Users) crit.uniqueResult();
	}

	public Users login(String username, String password) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("email", username));
		crit.add(Restrictions.eq("password", password));
		return (Users) crit.uniqueResult();

	}

	public Users getUserByEmail(String email) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("email", email));
		return (Users) crit.uniqueResult();

	}

	public Users forgotPasswordWeb(String email) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("email", email));
		crit.add(Restrictions.eq("userRole",1L));
		System.out.println((Users) crit.uniqueResult());
		return (Users) crit.uniqueResult();
		

	}

	public Users forgotPasswordMob(String email) {
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("email", email));
		crit.add(Restrictions.eq("userRole",2L));
		return (Users) crit.uniqueResult();

	}
}
