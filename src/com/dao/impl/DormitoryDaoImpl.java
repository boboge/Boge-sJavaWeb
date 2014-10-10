package com.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.DormitoryDao;
import com.pojo.Dormitory;

@Repository("dormitoryDao")
public class DormitoryDaoImpl<T> extends BaseDaoImpl<T> implements DormitoryDao<T> {

	public Dormitory findByUserid(String string) {
	String hql = "from Dormitory d where d.userid='"+string+"'";
	Dormitory dormitory = new Dormitory();
	dormitory = (Dormitory) getSession().createQuery(hql).uniqueResult();
		return (Dormitory) getSession().createQuery(hql).uniqueResult();
	}

	public void addOrUpdate(Dormitory dormitoryDB) {
		getHibernateTemplate().saveOrUpdate(dormitoryDB);	
		
	}

}
