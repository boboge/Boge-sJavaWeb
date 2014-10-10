package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.Dormitory;
import com.pojo.Publicproperty;

public interface PublicpropertyService {

	Map findAllUn(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb);

	void addOrUpdate(Publicproperty publicpropertyDb);

	void delete(Integer id);

	Dormitory find(String string);

	Map findAllOk(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb);

	Map findAll(int page, int rows, String sort, String order,
			Publicproperty publicpropertyDb);

	Map findOkAll(int page, int rows, String sort,
			String order, Publicproperty publicpropertyDb);

}
