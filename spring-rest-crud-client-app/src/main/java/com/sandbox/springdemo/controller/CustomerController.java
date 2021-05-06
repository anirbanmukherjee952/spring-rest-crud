package com.sandbox.springdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sandbox.springdemo.entity.Customer;
import com.sandbox.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final int PAGE_SIZE = 10;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String getCustomers(@RequestParam("pageNo") int pageNo,
							@RequestParam(name="searchTerm",required=false) String searchTerm,
							@RequestParam(name="sortBy",required=false) String sortBy,
							Model theModel) {
		
		int count = 0;
		int totalPages = 0;
		
		if (searchTerm==null || sortBy==null) {
			count = (int) customerService.countCustomers();
			totalPages = (int) Math.ceil(count/this.PAGE_SIZE);
			theModel.addAttribute("customers",customerService.getCustomers(pageNo,this.PAGE_SIZE));
		}
		else {
			count = (int) customerService.countCustomers(searchTerm);
			totalPages = (int) Math.ceil(count/this.PAGE_SIZE);
			theModel.addAttribute("customers",customerService.getCustomers(searchTerm,sortBy,pageNo,this.PAGE_SIZE));
			theModel.addAttribute("searchTerm",searchTerm);
			theModel.addAttribute("sortBy",sortBy);
		}
		theModel.addAttribute("pageNo",pageNo);
		theModel.addAttribute("totalPages",(totalPages>0)? totalPages: 1);
		return "list-customers";
		
	}
	
	@GetMapping("/add")
	public String showFormForAddCustomer(Model theModel) {
		theModel.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
	}
	
	@PostMapping("/add")
	public String processFormForAddCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,
										BindingResult theBindingResult) {
		if(theBindingResult.hasErrors())
			return "customer-form";
		customerService.addCustomer(theCustomer);
		return "redirect:/customer/list?pageNo=0";
	}
	
	@GetMapping("/update")
	public String showFormForUpdateCustomer(@RequestParam("id") int theId,
											Model theModel) {
		theModel.addAttribute("customer",customerService.getCustomer(theId));
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list?pageNo=0";
	}
}
