package com.service.impl;

import org.springframework.stereotype.Service;

import com.dao.DormitoryDao;
import com.pojo.Dormitory;
import com.service.DormitoryService;

@Service("dormitoryService")
public class DormitoryServiceImpl implements DormitoryService {
	
	private DormitoryDao<Dormitory> dormitoryDao;

	public DormitoryDao getDormitoryDao() {
		return dormitoryDao;
	}

	public void setDormitoryDao(DormitoryDao dormitoryDao) {
		this.dormitoryDao = dormitoryDao;
	}

	public Dormitory findByUserid(String string) {
		return dormitoryDao.get("from Dormitory d where d.userid = ?", string);
	}

	public void addOrUpdate(Dormitory dormitoryDB) {
		dormitoryDao.saveOrUpdate(dormitoryDB);
		
	}

}
