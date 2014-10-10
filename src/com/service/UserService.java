package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.User;
import com.util.DataGridModel;

public interface UserService {
    User findByNameAndPwd(String name,String pwd);
	void save(User transientInstance);
	 User findById(Integer id);
	 User findByIdUseGet(User user);
	List<User> getAllUsers(DataGridModel dModel, User user);
	void test();
	User getInfo(String string);
	void addOrUpdate(User userDB);
	Map<String, Object> findAll(int page, int rows, String sort, String order, User user);
	void delete(Integer id);


}
