/**
 * 
 */
/**
 * @author dell
 *
 */
package com.bishwas.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bishwas.shoppingbackend.dao.CategoryDAO;
import com.bishwas.shoppingbackend.dto.Category;

@Controller
public class PageController{
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/index", "/home"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		//Passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome",true);
		
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		
		return mv;
	}
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		
		//Passing the list of category
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		
		return mv;
	}
	
	/* Methods to display all the products and based on its category */
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("page");
		
		/* CategoryDAO to fetch a single category */
		Category category = null;
		category = categoryDAO.get(id);
		
		// Passing the list of category
		mv.addObject("title", category.getName());
		
		//Passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//Passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		
		return mv;
	}
	
	
//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam( value="greeting", required=false)String greeting){
//		if(greeting==null){
//			greeting="Hello There";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting",greeting);
//		return mv;
//	}
	
//	@RequestMapping(value="/test/{greeting}")
//	public ModelAndView test(@PathVariable( "greeting")String greeting){
//		if(greeting==null){
//			greeting="Hello There";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting",greeting);
//		return mv;
//	}
//	
}
