package com.customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.dao.CustomerDao;
import com.customer.dao.CustomerDaoImplement;
import com.customer.dao.TestDaoImplement;
import com.customer.entity.Customer;

@Controller
public class CustomerController {
	
	
	CustomerDaoImplement customerDaoImp;
	
//	@RequestMapping("/")
//	public String home() {
//		System.out.println("hello dear ;) ");
//		return "index";
//	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Customer customer= new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm( @ModelAttribute("customer") Customer newCustomer  ) {
		customerDaoImp = new CustomerDaoImplement();
		customerDaoImp.addCustomer(newCustomer);
		//System.out.println(id);
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String showList(Model model) {
		
		customerDaoImp = new CustomerDaoImplement();
		List<Customer> customers= customerDaoImp.getCustomers();
		model.addAttribute("customer", customers);
		//System.out.println(customers);
		return "list";
	}
	
	@RequestMapping("/asd")
	public String asd(Model model) {
		int n= 4;
		model.addAttribute("hello",n);
		
		return "asd";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		
		String name="haider";
		model.addAttribute("customer", name);
		return "test";
		
	}
	
	@RequestMapping("/newForm")
	public String newForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "new-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate( @RequestParam("customerId") int id  ,Model model) {
		
		customerDaoImp = new CustomerDaoImplement();
		
		// get the customer from database using customerID	
		Customer myCustomer = customerDaoImp.getCustomer(id);
		
		model.addAttribute("customer", myCustomer);
		return "customer-form";
	}
	
	@RequestMapping("/delete")
	public String delete( @RequestParam("customerId") int id  ,Model model) {
		
		customerDaoImp = new CustomerDaoImplement();
		
		// get the customer from database using customerID	
		customerDaoImp.delete(id);
		
		return "redirect:/list";
	}
	
	
	
}










