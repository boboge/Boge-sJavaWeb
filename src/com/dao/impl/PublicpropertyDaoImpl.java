package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.PublicpropertyDao;
import com.pojo.Myproperty;
import com.pojo.Publicproperty;

@Repository("publicpropertyDao")
public class PublicpropertyDaoImpl<T> extends BaseDaoImpl<T> implements PublicpropertyDao<T> {

	public List<Publicproperty> findAllUn(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb) {
		String hqlString = "from Publicproperty p where ( p.status='1' or p.status='2') and p.userid='"+publicpropertyDb.getUserid()+"'" + addWhere(publicpropertyDb);
		if (sort != null && order != null) {
			hqlString += "order by " + sort + " " + order;
		}
		return getSession().createQuery(hqlString).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	
	private String addWhere(Publicproperty publicproperty) {
		String hql = "";
//		if (user.getUsername() != null && !user.getUsername().trim().equals("")) {
//			hql += " and u.username like '%%" + user.getUsername().trim()
//					+ "%%' ";
//
//		}
//		if (user.getUserage() != null && !user.getUserage().trim().equals("")) {
//			hql += " and u.userage like '%%" + user.getUserage().trim()
//					+ "%%' ";
//
//		}
		return hql;

	}

	public void addOrUpdate(Publicproperty publicpropertyDb) {
		getHibernateTemplate().saveOrUpdate(publicpropertyDb);	
		
	}

	public long getTotle() {
		Query totle = getSession().createQuery("select count(*) from Publicproperty p");
		return (Long)totle.uniqueResult();
	}

	public List<Publicproperty> findAllOk(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb) {
		String hqlString = "from Publicproperty p where ( p.status='3') and p.userid='"+publicpropertyDb.getUserid()+"'" + addWhere(publicpropertyDb);
		if (sort != null && order != null) {
			hqlString += "order by " + sort + " " + order;
		}
		return getSession().createQuery(hqlString).setFirstResult((page - 1) * rows).setMaxResults(rows).list();

	}

	public List<Publicproperty> findAll(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb) {
		String hqlString = "from Publicproperty p where ( p.status='2') " + addWhere(publicpropertyDb);
		if (sort != null && order != null) {
			hqlString += " order by " + sort + " " + order;
		}
		return getSession().createQuery(hqlString).setFirstResult((page - 1) * rows).setMaxResults(rows).list();

	}

	public List<Publicproperty> findOkAll(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb) {
		String hqlString = "from Publicproperty p where ( p.status='3')" + addWhere(publicpropertyDb);
		if (sort != null && order != null) {
			hqlString += " order by " + sort + " " + order;
		}
		return getSession().createQuery(hqlString).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
}
