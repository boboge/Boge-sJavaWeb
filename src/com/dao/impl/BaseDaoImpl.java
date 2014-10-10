package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.BaseDao;
@Repository("baseDao")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>  {

	public void delete(Integer id) {
		System.out.println("___________id"+id);
		getHibernateTemplate().delete(findById(id));

	}

	public Object findById(Integer id) {
		try {
			System.out.println("!@!@!@!"+id);
			Object object = (Object) getSession().get(Object.class, id);

			return object;
		} catch (RuntimeException re) {
			throw re;
		}
	}

//	public void delete(String hql, Integer id) {
//		try {
//		getSession().createQuery(hql+id).executeUpdate();
//		} catch (RuntimeException re) {
//			re.printStackTrace();
//			throw re;
//		}	
//	}
	
	
	
	public void delete(String hql, Object... param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		try {
		q.executeUpdate();
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}	
		
	}

	
	public Object findByHql(String hql) {
		return getSession().createQuery(hql).uniqueResult();
	}

	public void save(T o) {
		this.getSession().save(o);
	}

	public void update(T o) {
		this.getSession().update(o);
	}

	public void saveOrUpdate(T o) {
		this.getSession().saveOrUpdate(o);
	}

	public void merge(T o) {
		this.getSession().merge(o);
	}

	public void delete(T o) {
		this.getSession().delete(o);
	}

	public List<T> find(String hql, List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	public List<T> find(String hql, Object... param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	public List<T> find(String hql, int page, int rows, List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public List<T> find(String hql, int page, int rows, Object... param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public T get(Class<T> c, Serializable id) {
		return (T) this.getSession().get(c, id);
	}

	public T get(String hql, Object... param) {
		List l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return (T) l.get(0);
		}
		return null;
	}

	public T get(String hql, List<Object> param) {
		List l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return (T) l.get(0);
		}
		return null;
	}

	public T load(Class<T> c, Serializable id) {
		return (T) this.getSession().load(c, id);
	}

	public Long count(String hql, Object... param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	public Long count(String hql, List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	public Integer executeHql(String hql) {
		Query q = this.getSession().createQuery(hql);
		return q.executeUpdate();
	}

}
