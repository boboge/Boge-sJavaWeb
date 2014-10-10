package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dao.MypropertyDao;
import com.pojo.Myproperty;
import com.service.MypropertyService;

@Service("mypropertyService")
public class MypropertyServiceImpl implements MypropertyService {
	private MypropertyDao<Myproperty> mypropertyDao;

	public MypropertyDao getMypropertyDao() {
		return mypropertyDao;
	}

	public void setMypropertyDao(MypropertyDao mypropertyDao) {
		this.mypropertyDao = mypropertyDao;
	}

	public Map findAllUn(int page, int rows, String sort, String order,
			Myproperty myproperty) {
		Map map = new HashMap();
		List<Object> values = new ArrayList<Object>();
		String hql = " from Myproperty m where ( m.status='1' or m.status='2') and m.userid='"+myproperty.getUserid()+"'";
		if (sort != null && order != null) {
			hql += " order by " + sort + " " + order;
		}
//		if (myproperty != null) {// 添加查询条件
//			if (myproperty.getBed() != null && !myproperty.getBed().trim().equals("")) {
//				hql += " and t.name like '%%" + myproperty.getBed().trim() + "%%' ";
//			}
//		}
		String totalHql = " select count(*) " + hql;
		map.put("total", mypropertyDao.count(totalHql, values));
		map.put("rows", mypropertyDao.find(hql,page,rows, values));
		return map;
	}



	public void addOrUpdate(Myproperty myproperty1) {
	     mypropertyDao.saveOrUpdate(myproperty1);
		
	}

	public Map findAllOk(int page, int rows, String sort,
			String order, Myproperty mypropertyDb) {
		Map map = new HashMap();
		List<Object> values = new ArrayList<Object>();
		String hql = " from Myproperty m where ( m.status='3') and m.userid='"+mypropertyDb.getUserid()+"'";
		if (sort != null && order != null) {
			hql += " order by " + sort + " " + order;
		}
//		if (myproperty != null) {// 添加查询条件
//			if (myproperty.getBed() != null && !myproperty.getBed().trim().equals("")) {
//				hql += " and t.name like '%%" + myproperty.getBed().trim() + "%%' ";
//			}
//		}
		String totalHql = " select count(*) " + hql;
		map.put("total", mypropertyDao.count(totalHql, values));
		map.put("rows", mypropertyDao.find(hql,page,rows, values));
		return map;
	}

	public void delete(Integer id) {
           mypropertyDao.delete("delete from Myproperty m where m.id = ?", id);		
	}


	public Map findAll(int page, int rows, String sort,
			String order, Myproperty mypropertyDb) {
		Map map = new HashMap();
		List<Object> values = new ArrayList<Object>();
		String hql = " from Myproperty m where ( m.status='2') ";

		if (mypropertyDb != null) {// 添加查询条件
			if (mypropertyDb.getUserid() != null && !mypropertyDb.getUserid().trim().equals("")) {
				hql += " and m.userid = '" + mypropertyDb.getUserid().trim() + "'";
			}			
			if (mypropertyDb.getBed() != null && !mypropertyDb.getBed().trim().equals("")) {
				hql += " and m.bed = '" + mypropertyDb.getBed().trim() + "'";
			}
			if (mypropertyDb.getChair() != null && !mypropertyDb.getChair().trim().equals("")) {
				hql += " and m.chair = '" + mypropertyDb.getChair().trim() + "' ";
			}
			if (mypropertyDb.getCupboard() != null && !mypropertyDb.getCupboard().trim().equals("")) {
				hql += " and m.cupboard = '" + mypropertyDb.getCupboard().trim() + "' ";
			}
			if (mypropertyDb.getDesk() != null && !mypropertyDb.getDesk().trim().equals("")) {
				System.out.println("1111111");
				hql += " and m.desk = '" + mypropertyDb.getDesk().trim() + "' ";
			}
			
		}
		if (sort != null && order != null) {
			hql += " order by " + sort + " " + order;
		}
		String totalHql = " select count(*) " + hql;
		map.put("total", mypropertyDao.count(totalHql, values));
		map.put("rows", mypropertyDao.find(hql,page,rows, values));
		System.out.println(hql);
		return map;
		}

	public Map findOkAll(int page, int rows, String sort,
			String order, Myproperty mypropertyDb) {
		Map map = new HashMap();
		List<Object> values = new ArrayList<Object>();
		String hql = " from Myproperty m where ( m.status='3') ";
		if (sort != null && order != null) {
			hql += " order by " + sort + " " + order;
		}
//		if (myproperty != null) {// 添加查询条件
//			if (myproperty.getBed() != null && !myproperty.getBed().trim().equals("")) {
//				hql += " and t.name like '%%" + myproperty.getBed().trim() + "%%' ";
//			}
//		}
		String totalHql = " select count(*) " + hql;
		map.put("total", mypropertyDao.count(totalHql, values));
		map.put("rows", mypropertyDao.find(hql,page,rows, values));
		return map;
	}

	public long getTotle() {
		// TODO Auto-generated method stub
		return 0;
	}

}
