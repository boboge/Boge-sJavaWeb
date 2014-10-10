package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.User;
import com.service.UserService;
import com.util.Constants;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="loginAction")
@Results( { @Result(name = "success", location = "/index.jsp"),
	@Result(name = "error", location = "/error.jsp") }) 
public class LoginAction extends BaseAction implements ModelDriven<User> {

	User user = new User();
	public User getModel() {
		return user;
	}
	@Autowired //相当于get and set
	private UserService userService;
	
	public void login() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user1 = userService.findByNameAndPwd(user.getName(), user.getPassword());
			if (user1==null) {
				map.put("msg", "0");
			}else if(user1.getFlag().equals("1")) {
				map.put("msg", "1");
				ActionContext.getContext().getSession().put(Constants.USERNAME_SESSION,user1.getName());
				ActionContext.getContext().getSession().put(Constants.USERID_SESSION,user1.getUserid());
			}else if(user1.getFlag().equals("2")) {
				map.put("msg", "2");
				ActionContext.getContext().getSession().put(Constants.USERNAME_SESSION,user1.getName());
				ActionContext.getContext().getSession().put(Constants.USERID_SESSION,user1.getUserid());
			}else if(user1.getFlag().equals("3")) {
				map.put("msg", "3");
				ActionContext.getContext().getSession().put(Constants.USERNAME_SESSION,user1.getName());
				ActionContext.getContext().getSession().put(Constants.USERID_SESSION,user1.getUserid());
			}
		writeJson(map);
	}
	public String loginout() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.clear();
		return SUCCESS;
	}
}
