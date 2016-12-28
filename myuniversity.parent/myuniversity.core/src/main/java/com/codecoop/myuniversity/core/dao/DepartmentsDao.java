package com.codecoop.myuniversity.core.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import com.codecoop.myuniversity.core.domain.Departments;


@Component
public class DepartmentsDao extends BaseDao<Departments> {

	public void createDepartment(Departments department) {

		Session session = getCurrentSession();
		session.saveOrUpdate(department);
	}
	
	@SuppressWarnings("unchecked")
	public List<Departments> getAllDepartments(){
		Session session = getCurrentSession();
		Criteria crit = session.createCriteria(Departments.class);
		return crit.list();
		
	}

}
