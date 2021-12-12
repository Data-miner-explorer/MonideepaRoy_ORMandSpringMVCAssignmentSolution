package com.greatlearning.CRMapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customers")
public class customersController {

	@Autowired
	// use @Qualifier if you happen to have more than 1 candidate bean that can be injected 
	private CustomersService CustomersService;

	@RequestMapping("/list")
	public String listCustomers( Model model ) {
		List<customers> customers = CustomersService.findAll();
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@RequestMapping("/new")
	public String showFormForAdd( Model model ) {
		customers customers = new customers();
		
		model.addAttribute( "newCustomers", true );
		model.addAttribute( "customers", customers );
		
		return "edit-customers";
	}
	
	@RequestMapping("/edit")
	public String showFormForEdit(
		@RequestParam("id") int id,
		Model model
	) {
		customers customers = CustomersService.findById( id );
		
		model.addAttribute( "newCustomers", false );
		model.addAttribute( "customers", customers );
		
		return "edit-customers";
	}
	
	@PostMapping("/save")
	public String savecustomers(
		@RequestParam("id") int id,
		@RequestParam("FirstName") String FirstName,
		@RequestParam("LastName") String LastName,
		@RequestParam("Email") String Email
	) {
		customers customers = null;
		
		if( id == 0 ) {
			customers = new customers( FirstName, LastName, Email );
		} else {
			customers = CustomersService.findById( id );
			customers.setFirstName( FirstName );
			customers.setLastName( LastName );
			customers.setEmail( Email ); 
		}
		
		CustomersService.save( customers );
				
		return "redirect:/customers/list";
	}
	
	@RequestMapping("/delete")
	public String deletecustomers( @RequestParam("id") int id ) {
		CustomersService.deleteById( id );
		
		return "redirect:/customers/list";
	}
}
