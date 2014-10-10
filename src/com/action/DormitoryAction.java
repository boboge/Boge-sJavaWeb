package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.Dormitory;
import com.pojo.Myproperty;
import com.service.DormitoryService;
import com.util.Constants;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="dormitoryAction")
@Results( { @Result(name = "success", location = "/user/myDormitory.jsp"),
	@Result(name = "error", location = "/error.jsp") }) 
public class DormitoryAction extends BaseAction implements ModelDriven<Dormitory> {
	Dormitory dormitory =  new Dormitory();
	Map session =	(Map) ActionContext.getContext().getSession();	
	public Dormitory getModel() {
		return dormitory;
	}
	
	@Autowired
	private DormitoryService dormitoryService;
	
	public void getInfo(){
		Map<String, Object> map = new HashMap<String, Object>();
       Dormitory dormitorydb = dormitoryService.findByUserid((String)session.get(Constants.USERID_SESSION));
       map.put("dormitory", dormitorydb);
       writeJson(map);
		
	}
	
	public String addOrUpdate() { //获取审核中和修理中
	      Map map = new HashMap<String, String>();
	      try {
	    	  if (dormitory.getUserid().equals("")) {
	    		  dormitory.setUserid((String)session.get(Constants.USERID_SESSION));
			}
	    		Dormitory dormitoryDB =  new Dormitory();
	    	 BeanUtils.copyProperties(dormitory, dormitoryDB);//拷贝属性
	    	 dormitoryService.addOrUpdate(dormitoryDB);
	    		map.put("mes", "操作成功");
			} catch (Exception e) {
			    map.put("mes", "操作失败");
			}	
				return SUCCESS;
	}



}
