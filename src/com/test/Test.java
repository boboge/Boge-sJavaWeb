package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.service.UserService;



public class Test {
	@org.junit.Test
	public void test() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext ("WebRoot/WEB-INF/applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.test();
		
	}
	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext ("WebRoot/WEB-INF/applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.test();
	}

}
