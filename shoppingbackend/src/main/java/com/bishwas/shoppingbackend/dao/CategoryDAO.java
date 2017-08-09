package com.bishwas.shoppingbackend.dao;

import java.util.List;

import com.bishwas.shoppingbackend.dto.Category;

public interface CategoryDAO {

	
	List<Category> list();
	Category get(int id);
}
