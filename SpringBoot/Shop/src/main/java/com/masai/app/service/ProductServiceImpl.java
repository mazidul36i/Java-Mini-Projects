package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.exception.ProductException;
import com.masai.app.model.Product;
import com.masai.app.model.ProductDTO;
import com.masai.app.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao pdao;

	@Override
	public Product registerProduct(Product p) throws ProductException {
		Product product = pdao.save(p);
		if (product != null)
			return product;
		throw new ProductException("Failed to save the given product!");
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		List<Product> products = pdao.findAll();
		if (products == null || products.size() == 0)
			throw new ProductException("No product found to be load!");
		return products;
	}

	@Override
	public Product updateProdcut(Product p) throws ProductException {
		Product product = pdao.findById(p.getProductId())
				.orElseThrow(() -> new ProductException("Product doesn't exists on database!"));
		return pdao.save(p);
	}

	@Override
	public Product deleteProductById(Integer pid) throws ProductException {
		Product product = pdao.findById(pid)
				.orElseThrow(() -> new ProductException("Product doesn't exists on database!"));
		pdao.deleteById(pid);
		return product;
	}

	@Override
	public List<Product> getsProductByCategory(String category) throws ProductException {
		List<Product> products = pdao.getProductByCategory(category);
		if (products == null || products.size() == 0)
			throw new ProductException("No product found with category: " + category);
		return products;
	}

	@Override
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException {
		List<ProductDTO> productsDTO = pdao.getProductNameQtyPrice();
		if (productsDTO == null || productsDTO.size() == 0)
			throw new ProductException("No product found to be load!");
		return productsDTO;
	}

}
