package com.bishwas.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bishwas.shoppingbackend.dao.CategoryDAO;
import com.bishwas.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	private static List<Category> categories = new ArrayList<>();
	
	static{
		
		Category category = new Category();
		//adding first category
		
		category.setId(1);
		category.setName("Televsion");
		category.setDescription("This is Description of telveiosn");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		//adding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is Description of Mobile");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		//adding Third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is Description of Laptop");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
		
		
		
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
		
		// Enchanced for loop
		for(Category category : categories){
			if(category.getId() == id) return category;
			
		}
		
		return null;
	}
	

}
