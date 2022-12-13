package com.masai.app.service;

import java.util.List;

import com.masai.app.exception.ProductException;
import com.masai.app.model.Product;
import com.masai.app.model.ProductDTO;

public interface ProductService {

	public Product registerProduct(Product p) throws ProductException;

	public List<Product> getAllProducts() throws ProductException;

	public Product updateProdcut(Product p) throws ProductException;

	public Product deleteProductById(Integer pid) throws ProductException;

	public List<Product> getsProductByCategory(String category) throws ProductException;

	public List<ProductDTO> getProductNameQtyPrice() throws ProductException;
}
