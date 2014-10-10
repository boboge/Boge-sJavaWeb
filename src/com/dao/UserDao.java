package com.dao;

import java.util.List;

import com.pojo.User;
import com.util.DataGridModel;



public interface UserDao<T> extends BaseDao<T> {
    void save(User transientInstance);
	 User findById(Integer id);
	 User findByIdUseGet(User user);
	 User findByNameAndPwd(String name, String pwd);
	List<User> getAllUsers(DataGridModel dModel, User user);
	long getTotle();
	
}
