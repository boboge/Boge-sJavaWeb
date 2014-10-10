package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DormitoryDao;
import com.dao.PublicpropertyDao;
import com.pojo.Dormitory;
import com.pojo.Publicproperty;
import com.service.PublicpropertyService;

@Service("publicpropertyService")
public class PublicpropertyServiceImpl implements PublicpropertyService {
	@Autowired
	private PublicpropertyDao<Publicproperty> publicpropertyDao;
	@Autowired
	private DormitoryDao<Dormitory> dormitoryDao;
	


	public Map findAllUn(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb) {
		Map map = new HashMap();
		List<Object> values = new ArrayList<Object>();
		String hql = " from Publicproperty p where ( p.status='1' or p.status='2') and p.userid='"+publicpropertyDb.getUserid()+"'";
		if (sort != null && order != null) {
			hql += " order by " + sort + " " + order;
		}
//		if (publicpropertyDb != null) {// 添加查询条件
//			if (publicpropertyDb.getBed() != null && !publicpropertyDb.getBed().trim().equals("")) {
//				hql += " and t.name like '%%" + publicpropertyDb.getBed().trim() + "%%' ";
//			}
//		}
		String totalHql = " select count(*) " + hql;
		map.put("total", publicpropertyDao.count(totalHql, values));
		map.put("rows", publicpropertyDao.find(hql,page,rows, values));
		return map;
	}


	public void addOrUpdate(Publicproperty publicpropertyDb) {
		publicpropertyDao.saveOrUpdate(publicpropertyDb);
	}




	public void delete(Integer id) {
		publicpropertyDao.delete("delete from Publicproperty p where p.id=?", id);
		
	}


	public Dormitory find(String string) {
		return dormitoryDao .get("from Dormitory d where d.userid = ? ", string);
		
	}


	public Map findAllOk(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb) {
		Map map = new HashMap();
		List<Object> values = new ArrayList<Object>();
		String hql = " from Publicproperty p where ( p.status='3') and p.userid='"+publicpropertyDb.getUserid()+"'";
		if (sort != null && order != null) {
			hql += " order by " + sort + " " + order;
		}
//		if (publicpropertyDb != null) {// 添加查询条件
//			if (publicpropertyDb.getBed() != null && !publicpropertyDb.getBed().trim().equals("")) {
//				hql += " and t.name like '%%" + publicpropertyDb.getBed().trim() + "%%' ";
//			}
//		}
		String totalHql = " select count(*) " + hql;
		map.put("total", publicpropertyDao.count(totalHql, values));
		map.put("rows", publicpropertyDao.find(hql,page,rows, values));
		return map;
	}


	public Map findAll(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb) {
		Map map = new HashMap();
		List<Object> values = new ArrayList<Object>();
		String hql = " from Publicproperty p where ( p.status='2') ";
		if (sort != null && order != null) {
			hql += " order by " + sort + " " + order;
		}
//		if (publicpropertyDb != null) {// 添加查询条件
//			if (publicpropertyDb.getBed() != null && !publicpropertyDb.getBed().trim().equals("")) {
//				hql += " and t.name like '%%" + publicpropertyDb.getBed().trim() + "%%' ";
//			}
//		}
		String totalHql = " select count(*) " + hql;
		map.put("total", publicpropertyDao.count(totalHql, values));
		map.put("rows", publicpropertyDao.find(hql,page,rows, values));
		return map;	
		}


	public Map findOkAll(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb) {
		Map map = new HashMap();
		List<Object> values = new ArrayList<Object>();
		String hql = " from Publicproperty p where ( p.status='3') ";
		if (sort != null && order != null) {
			hql += " order by " + sort + " " + order;
		}
//		if (publicpropertyDb != null) {// 添加查询条件
//			if (publicpropertyDb.getBed() != null && !publicpropertyDb.getBed().trim().equals("")) {
//				hql += " and t.name like '%%" + publicpropertyDb.getBed().trim() + "%%' ";
//			}
//		}
		String totalHql = " select count(*) " + hql;
		map.put("total", publicpropertyDao.count(totalHql, values));
		map.put("rows", publicpropertyDao.find(hql,page,rows, values));
		return map;		}



}
