package com.masai.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.app.model.Product;
import com.masai.app.model.ProductDTO;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query("SELECT p FROM Product p WHERE p.category = :cat")
	public List<Product> getProductByCategory(@Param("cat") String cat);
	
	@Query("SELECT new com.masai.app.model.ProductDTO(p.productName, p.quantity, p.price) FROM Product p")
	public List<ProductDTO> getProductNameQtyPrice();
	
}
