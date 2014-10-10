package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.dao.MypropertyDao;
import com.pojo.Myproperty;

@Repository("mypropertyDao")
public class MypropertyDaoImpl<T> extends BaseDaoImpl<T> implements MypropertyDao<T> {

	public List<Myproperty> findAllUn(int page, int rows, String sort,
			String order, Myproperty myproperty) {
		String hqlString = "from Myproperty m where ( m.status='1' or m.status='2') and m.userid='"+myproperty.getUserid()+"'" + addWhere(myproperty);
		if (sort != null && order != null) {
			hqlString += "order by " + sort + " " + order;
		}
		return getSession().createQuery(hqlString).setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	
	private String addWhere(Myproperty myproperty) {
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

	public long getTotle() {
		Query totle = getSession().createQuery("select count(*) from Myproperty u");
		return (Long)totle.uniqueResult();
	}

	public void addOrUpdate(Myproperty myproperty1) {
		getHibernateTemplate().saveOrUpdate(myproperty1);	
		
	}

	public List<Myproperty> findAllOk(int page, int rows, String sort,
			String order, Myproperty mypropertyDb) {
		String hqlString = "from Myproperty m where ( m.status='3') and m.userid='"+mypropertyDb.getUserid()+"'" + addWhere(mypropertyDb);
		if (sort != null && order != null) {
			hqlString += "order by " + sort + " " + order;
		}
		return getSession().createQuery(hqlString).setFirstResult((page - 1) * rows).setMaxResults(rows).list();

	}

	public List<Myproperty> findAll(int page, int rows, String sort,
			String order, Myproperty mypropertyDb) {
		String hqlString = "from Myproperty m where ( m.status='2')" + addWhere(mypropertyDb);
		if (sort != null && order != null) {
			hqlString += "order by " + sort + " " + order;
		}
		return getSession().createQuery(hqlString).setFirstResult((page - 1) * rows).setMaxResults(rows).list();

	}

	public List<Myproperty> findOkAll(int page, int rows, String sort,
			String order, Myproperty mypropertyDb) {
		String hqlString = "from Myproperty m where ( m.status='3')" + addWhere(mypropertyDb);
		if (sort != null && order != null) {
			hqlString += "order by " + sort + " " + order;
		}
		return getSession().createQuery(hqlString).setFirstResult((page - 1) * rows).setMaxResults(rows).list();

	}

}
