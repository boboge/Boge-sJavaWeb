package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.Myproperty;

public interface MypropertyService  {
	Map findAllUn(int page,int rows,String sort,String order,Myproperty myproperty);
	void addOrUpdate(Myproperty myproperty1);
	Map findAllOk(int page, int rows, String sort, String order,
			Myproperty mypropertyDb);
	void delete(Integer id);
	Map findAll(int page, int rows, String sort, String order,
			Myproperty mypropertyDb);
	Map findOkAll(int page, int rows, String sort, String order,
			Myproperty mypropertyDb);

}
