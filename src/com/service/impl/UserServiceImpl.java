package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import com.util.DataGridModel;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private UserDao<User> userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User findById(Integer id) {
		return null;
	}

	public User findByIdUseGet(User user) {
		return null;
	}

	public User findByNameAndPwd(String name, String pwd) {
		return userDao.get("from User u where u.name=? and u.password=?", name,pwd);
	}

	public List<User> getAllUsers(DataGridModel dModel, User user) {
		return null;
	}

	public long getTotle() {
		return 0;
	}

	public void save(User transientInstance) {

	}

	public void test() {

	}

	public User getInfo(String string) {
		return  userDao.get("from User u where u.userid=?", string);
	}

	public void addOrUpdate(User userDB) {
		userDao.saveOrUpdate(userDB);
		
	}

	public Map findAll(int page, int rows, String sort, String order, User user) {
		Map map = new HashMap();
		List<Object> values = new ArrayList<Object>();
		String hql = " from User u ";
//		if (myproperty != null) {// 添加查询条件
//			if (myproperty.getBed() != null && !myproperty.getBed().trim().equals("")) {
//				hql += " and t.name like '%%" + myproperty.getBed().trim() + "%%' ";
//			}
//		}
		if (sort != null && order != null) {
			hql += " order by " + sort + " " + order;
		}
		String totalHql = " select count(*) " + hql;
		map.put("total", userDao.count(totalHql, values));
		map.put("rows", userDao.find(hql,page,rows, values));
		return map;	
		}

	public void delete(Integer id) {
		userDao.delete("delete from User u where u.id = ?",id);
	}

}
