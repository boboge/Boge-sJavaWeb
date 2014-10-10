package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.pojo.User;
import com.util.DataGridModel;

@Repository("userDao")
public class UserDaoImpl<T> extends BaseDaoImpl<T> implements UserDao<T> {

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByIdUseGet(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByNameAndPwd(String name, String pwd) {
		String sql = "select u from User u where u.name = '" + name + "' and u.password = '" + pwd + "'";
		Query query = getSession().createQuery(sql);
		User user = (User) query.uniqueResult();
		return user;
	}

	public List<User> getAllUsers(DataGridModel dModel, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getTotle() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void save(User transientInstance) {
		// TODO Auto-generated method stub

	}

}
