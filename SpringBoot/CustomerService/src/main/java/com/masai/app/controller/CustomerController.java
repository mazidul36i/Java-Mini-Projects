package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.app.model.Customer;
import com.masai.app.model.CustomerDTO;
import com.masai.app.model.LoginDTO;
import com.masai.app.model.UpdatePassDTO;
import com.masai.app.service.CustomerService;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService cService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer Customer) {
		Customer customer2 = cService.registerCustomer(Customer);
		return new ResponseEntity<Customer>(customer2, HttpStatus.CREATED);
	}
	
	@GetMapping("/customers/{cid}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable("cid") Integer customerId) {
		Customer customer = cService.getCustomerById(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomerHandler(@RequestBody LoginDTO loginDTO) {
		Customer customer = cService.loginCustomer(loginDTO.getEmail(), loginDTO.getPassword());
		return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/customers/updatepass")
	public ResponseEntity<Customer> updateCustomerPasswordHandler(@RequestBody UpdatePassDTO passDto) {
		Customer customer = cService.updateCustomerPassword(passDto.getEmail(), passDto.getOldPassword(), passDto.getNewPassword());
		return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerDetailsHandler() {
		List<Customer> customers = cService.getAllCustomerDetails();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{cid}")
	public ResponseEntity<Customer> deleteCustomerByIdHandler(@PathVariable("cid") Integer customerId) {
		Customer customer = cService.deleteCustomerById(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers/address")
	public ResponseEntity<List<Customer>> getCustomerDetailsByAddressHandler(@RequestParam("address") String address) {
		List<Customer> customers = cService.getCustomerDetailsByAddress(address);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@PutMapping("/customers/{cid}")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody @Valid Customer customer) {
		Customer customer2 = cService.updateCustomer(customer);
		return new ResponseEntity<Customer>(customer2, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers/age")
	public ResponseEntity<List<Customer>> getCustomersBetweenAgeHandler(@RequestParam("start") Integer start_age, @RequestParam("end") Integer end_age) {
		List<Customer> customers = cService.getCustomersBetweenAge(start_age, end_age);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/customers/dto")
	public ResponseEntity<List<CustomerDTO>> getNameAddressAgeOfAllCustomersHandler() {
		List<CustomerDTO> customerDTOs = cService.getNameAddressAgeOfAllCustomers();
		return new ResponseEntity<List<CustomerDTO>>(customerDTOs, HttpStatus.OK);
	}
}
