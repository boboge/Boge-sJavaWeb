package com.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	public void writeJson(Object object) {
		try {
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(object));
			System.out.println(object.getClass().getName()+"  :  "+JSON.toJSONString(object));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
