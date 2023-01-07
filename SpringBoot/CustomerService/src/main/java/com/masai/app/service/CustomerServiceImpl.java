package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exceptions.CustomerException;
import com.masai.app.model.Customer;
import com.masai.app.model.CustomerDTO;
import com.masai.app.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cDao;

	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		Customer c = cDao.save(customer);
		if (c != null)
			return c;
		throw new CustomerException("Failed to save the given customer details!");
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		return cDao.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer doesn't exists with the given id: " + customerId));
	}

	@Override
	public Customer loginCustomer(String email, String password) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomerPassword(String username, String oldPassword, String newPassword)
			throws CustomerException {
		Customer customer = cDao.findByEmail(username)
				.orElseThrow(() -> new CustomerException("Customer doesn't exists"));
		if (oldPassword != customer.getPassword())
			throw new CustomerException("Invalid password!");
		customer.setPassword(newPassword);
		cDao.save(customer);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		List<Customer> customers = cDao.findAll();
		if (customers == null || customers.size() == 0)
			throw new CustomerException("No customer found to be load!");
		return customers;
	}

	@Override
	public Customer deleteCustomerById(Integer customerId) throws CustomerException {
		Customer customer = cDao.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer doesn't exists"));
		cDao.delete(customer);
		return customer;
	}

	@Override
	public List<Customer> getCustomerDetailsByAddress(String address) throws CustomerException {
		List<Customer> customers = cDao.findByAddress(address);
		if (customers == null || customers.size() == 0)
			throw new CustomerException("No customer exists with the address: " + address);
		return customers;
	}

	@Override
	public Customer updateCustomer(Customer c) throws CustomerException {
		cDao.findById(c.getCustomerId())
				.orElseThrow(() -> new CustomerException("Customer doesn't exists"));
		Customer c2 = cDao.save(c);
		if (c2 != null) return c2;
		throw new CustomerException("Failed to update customer!");
	}

	@Override
	public List<Customer> getCustomersBetweenAge(Integer start_age, Integer end_age) throws CustomerException {
		List<Customer> customers = cDao.findCustomersBetweenAge(start_age, end_age);
		if (customers == null || customers.size() == 0)
			throw new CustomerException("No customer found with age between "+ start_age + " and " + end_age);
		return customers;
	}

	@Override
	public List<CustomerDTO> getNameAddressAgeOfAllCustomers() throws CustomerException {
		List<CustomerDTO> customerDTOs = null;// = cDao.getCustomersDTO();
		if (customerDTOs == null || customerDTOs.size() == 0)
			throw new CustomerException("No customer found to be load!");
		return customerDTOs;
	}

}
