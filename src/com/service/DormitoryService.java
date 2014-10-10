package com.service;

import com.pojo.Dormitory;

public interface DormitoryService {

	Dormitory findByUserid(String string);

	void addOrUpdate(Dormitory dormitoryDB);

}
