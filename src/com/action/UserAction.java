package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.pojo.Dormitory;
import com.pojo.User;
import com.service.UserService;
import com.util.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="userAction")
@Results( { @Result(name = "success", location = "/user/change.jsp"),
	@Result(name = "error", location = "/error.jsp") }) 
public class UserAction extends BaseAction implements ModelDriven<User> {
	
	User user = new User();
	public User getModel() {
		return user;
	}

	Map session = (Map) ActionContext.getContext().getSession();

	
	private int page; //当前页,名字必须为page
	private int rows ; //每页大小,名字必须为rows
	private String sort; //排序字段
	private String order; //排序规则

	@Autowired //相当于get and set
	private UserService userService;
	
	
	public void login() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user1 = userService.findByNameAndPwd(user.getName(), user.getPassword());
			if (user1==null) {
				map.put("msg", "0");
			}else {
				map.put("msg", "1");
			}
		writeJson(map);
	}
	
	public void getInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user1 = userService.getInfo((String)session.get(Constants.USERID_SESSION));
	       map.put("user", user1);
	       writeJson(map);
	}
	
	public void addOrUpdate() {
	      Map map = new HashMap<String, String>();
	      try {
	    		User userDB =  new User();
	    	 BeanUtils.copyProperties(user, userDB);//拷贝属性
	    	 userService.addOrUpdate(userDB);
	    		map.put("msg", "1");
			} catch (Exception e) {
			    map.put("msg", "0");

			}	
	      writeJson(map);
              
	}
	
	public void userList() {
		Map map = new HashMap();
		  map  = userService.findAll(page,rows,sort,order,user);
	       writeJson(map);
	}
	
	public void delete() {
		  Map map = new HashMap<String, String>();
		  try {
		   userService.delete(user.getId());
  	        	map.put("msg", "操作成功");	
		  }catch (Exception e) {
			    map.put("msg", "操作失败");
			}
		  writeJson(map);
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
