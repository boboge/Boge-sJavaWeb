package com.action;

import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.Myproperty;
import com.service.MypropertyService;
import com.util.Constants;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="mypropertyAction")
public class MypropertyAction extends BaseAction implements ModelDriven<Myproperty> {
	
	Myproperty myproperty = new Myproperty();	
	
	Map session = (Map) ActionContext.getContext().getSession();
	
	public Myproperty getModel() {
		return myproperty;
	}
	private int page; //当前页,名字必须为page
	private int rows ; //每页大小,名字必须为rows
	private String sort; //排序字段
	private String order; //排序规则
	
	@Autowired
	MypropertyService mypropertyService;
	
	public void queryAllUn() { //获取审核中和修理中
	 myproperty.setUserid((String)session.get(Constants.USERID_SESSION));
	 Myproperty mypropertyDb = new Myproperty();
	 BeanUtils.copyProperties(myproperty, mypropertyDb);//拷贝属性
	  Map mypropertyMap = new HashMap<String, String>();
	  mypropertyMap  = mypropertyService.findAllUn(page, rows, sort, order, mypropertyDb);
	  writeJson(mypropertyMap);

  }
	
	public void addOrUpdate() { //获取审核中和修理中
	      Map map = new HashMap<String, String>();
	      try {
	    	  if (myproperty.getUserid().equals("")) {
		    	  myproperty.setUserid((String)session.get(Constants.USERID_SESSION));
			}
	    	  Myproperty mypropertyDb = new Myproperty();
	    	 BeanUtils.copyProperties(myproperty, mypropertyDb);//拷贝属性
	    		mypropertyService.addOrUpdate(mypropertyDb);
	    		map.put("mes", "操作成功");
			} catch (Exception e) {
			    map.put("mes", "操作失败");
			}	
		     	writeJson(map);
	}
	
	public void queryAllOk() { //所要已处理订单
		
		 myproperty.setUserid((String)session.get(Constants.USERID_SESSION));
		 Myproperty mypropertyDb = new Myproperty();
		 BeanUtils.copyProperties(myproperty, mypropertyDb);//拷贝属性
		  Map mypropertyMap = new HashMap<String, String>();
		  mypropertyMap  = mypropertyService.findAllOk(page, rows, sort, order, mypropertyDb);
		  writeJson(mypropertyMap);

	}
	
	public void delete() {
		
		  Map map = new HashMap<String, String>();
		  try {
		   mypropertyService.delete(myproperty.getId());
  	        	map.put("mes", "操作成功");	
		  }catch (Exception e) {
			    map.put("mes", "操作失败");
			}
		  writeJson(map);
	}
	
	public void queryAll() {  // 查找所有的记录(管理员)
		 Myproperty mypropertyDb = new Myproperty();
		 BeanUtils.copyProperties(myproperty, mypropertyDb);//拷贝属性
		  Map mypropertyMap = new HashMap<String, String>();
		  mypropertyMap = mypropertyService.findAll(page, rows, sort, order, mypropertyDb);
		  writeJson(mypropertyMap);
	}
	
	public void queryOkAll() {  // 查找所有的处理完记录(管理员)
		 Myproperty mypropertyDb = new Myproperty();
		 BeanUtils.copyProperties(myproperty, mypropertyDb);//拷贝属性
		  Map mypropertyMap = new HashMap<String, String>();
		  mypropertyMap = mypropertyService.findOkAll(page, rows, sort, order, mypropertyDb);
		  writeJson(mypropertyMap);
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
