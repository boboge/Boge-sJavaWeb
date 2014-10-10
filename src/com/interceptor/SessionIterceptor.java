package com.interceptor;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.http.HttpRequest;

import com.util.Constants;
import com.action.LoginAction;
import com.action.UserAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
@Results( { @Result(name = "success", location = "/index.jsp"),
	@Result(name = "error", location = "/error.jsp") }) 
public class SessionIterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
        ActionContext ctx = ActionContext.getContext();   
	        Map session = (Map) ctx.getSession();   
	        Action action = (Action) invocation.getAction();   
	        if (action instanceof LoginAction) {  
	            System.out.println("登陆界面");
	            return invocation.invoke();   
	        } 
	      
	        String userid = (String) session.get(Constants.USERID_SESSION);   
	        System.out.println("在线用户userid："+userid);
	        if (userid == null || userid.equals("")) {   
	            System.out.println("session超时");
	       return action.LOGIN;
	        } else {   
	            return invocation.invoke();   
	        } 
	        
	    }   

}
