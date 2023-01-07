package com.masai.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Customer;
import com.masai.app.model.CustomerDTO;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE email = :email")
	public Optional<Customer> findByEmail(@Param("email") String email);

	@Query("SELECT c FROM Customer c WHERE email = :adr")
	public List<Customer> findByAddress(@Param("adr") String address);

	@Query("SELECT c FROM Customer c WHERE age BETWEEN :age_s AND :age_e")
	public List<Customer> findCustomersBetweenAge(@Param("age_s") Integer start_age, @Param("age_e") Integer end_age);

//	@Query("SELECT new com.masai.app.model.CustomerDTO(c.name, c.address, c.age) FROM Customer c")
//	public List<CustomerDTO> getCustomersDTO();

}
