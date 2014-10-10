package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.Dormitory;
import com.pojo.Myproperty;
import com.pojo.Publicproperty;
import com.service.PublicpropertyService;
import com.util.Constants;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="publicpropertyAction")
public class PublicpropertyAction extends BaseAction implements ModelDriven<Publicproperty> {
	
	Publicproperty publicproperty = new Publicproperty();
	
	@Autowired
	private PublicpropertyService publicpropertyService;
	
	Map session =	(Map) ActionContext.getContext().getSession();
	
	public Publicproperty getModel() {
		// TODO Auto-generated method stub
		return publicproperty;
	}
	
	private int page; //当前页,名字必须为page
	private int rows ; //每页大小,名字必须为rows
	private String sort; //排序字段
	private String order; //排序规则
	
	public void queryAllUn() { //获取审核中和修理中
		 publicproperty.setUserid((String)session.get(Constants.USERID_SESSION));
		 Publicproperty publicpropertyDb = new Publicproperty();
		 BeanUtils.copyProperties(publicproperty, publicpropertyDb);//拷贝属性
		  Map publicpropertyMap = new HashMap<String, String>();
		  publicpropertyMap  = publicpropertyService.findAllUn(page, rows, sort, order, publicpropertyDb);
		  writeJson(publicpropertyMap);
	  }
	
	public void addOrUpdate() { //获取审核中和修理中
	      Map map = new HashMap<String, String>();
	      try {
	    	  if (publicproperty.getUserid().equals("")) {
		    	  publicproperty.setUserid((String)session.get(Constants.USERID_SESSION));
			}
	    	  if (publicproperty.getDname().equals("")) {
	    		  System.out.println("dname为空");
	    		  Dormitory d  =  publicpropertyService.find((String)session.get(Constants.USERID_SESSION));
	  	    	if (d==null) {
	  	    		publicproperty.setDname("");
	  			}else {
	  				publicproperty.setDname(d.getDname());
	  			}
			}	    	
	    	 Publicproperty publicpropertyDb = new Publicproperty();
	    	 BeanUtils.copyProperties(publicproperty, publicpropertyDb);//拷贝属性
	    	 publicpropertyService.addOrUpdate(publicpropertyDb);
	    	 map.put("mes", "操作成功");
			} catch (Exception e) {
				e.printStackTrace();
			    map.put("mes", "操作失败");
			}	
		     	writeJson(map);
	}
	
	public void queryAllOk() {
		
		 publicproperty.setUserid((String)session.get(Constants.USERID_SESSION));
		 Publicproperty publicpropertyDb = new Publicproperty();
		 BeanUtils.copyProperties(publicproperty, publicpropertyDb);//拷贝属性
		  Map publicpropertyMap = new HashMap<String, String>();
		  publicpropertyMap = publicpropertyService.findAllOk(page, rows, sort, order, publicpropertyDb);
		  writeJson(publicpropertyMap);

	}
	
	public void delete() {
		
		  Map map = new HashMap<String, String>();
		  try {
		   publicpropertyService.delete(publicproperty.getId());
	        	map.put("mes", "操作成功");	
		  }catch (Exception e) {
			    map.put("mes", "操作失败");
			}
		  writeJson(map);
	}
	
	public void queryAll() {  //管理员获得所有提交订单
		 Publicproperty publicpropertyDb = new Publicproperty();
		 BeanUtils.copyProperties(publicproperty, publicpropertyDb);//拷贝属性
		  Map publicpropertyMap = new HashMap<String, String>();
		  publicpropertyMap = publicpropertyService.findAll(page, rows, sort, order, publicpropertyDb);
		  writeJson(publicpropertyMap);
	}
	
	public void queryOkAll() { //管理员获得所有处理完订单
		 Publicproperty publicpropertyDb = new Publicproperty();
		 BeanUtils.copyProperties(publicproperty, publicpropertyDb);//拷贝属性
		  Map publicpropertyMap = new HashMap<String, String>();
		  publicpropertyMap = publicpropertyService.findOkAll(page, rows, sort, order, publicpropertyDb);
		  writeJson(publicpropertyMap);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	
}
