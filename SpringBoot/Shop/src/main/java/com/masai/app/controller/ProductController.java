package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.Product;
import com.masai.app.model.ProductDTO;
import com.masai.app.service.ProductServiceImpl;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl pService;

	@PostMapping("/products")
	public ResponseEntity<Product> registerProductHandler(@Valid @RequestBody Product p) {
		Product product = pService.registerProduct(p);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProductsHandler() {
		List<Product> products = pService.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@PutMapping("/products/{pid}")
	public ResponseEntity<Product> updateProductHandler(@Valid @RequestBody Product p, @PathVariable("pid") Integer pid) {
		p.setProductId(pid);
		Product product = pService.updateProdcut(p);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<Product> deleteProductByIdHandler(@PathVariable("pid") Integer pid) {
		Product product = pService.deleteProductById(pid);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping("/products/{cat}")
	public ResponseEntity<List<Product>> getProductByCategoryHandler(@PathVariable("cat") String cat) {
		List<Product> products = pService.getsProductByCategory(cat);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/productsDTO")
	public ResponseEntity<List<ProductDTO>> getProductNameQtyPriceHandler() {
		List<ProductDTO> productsDTO = pService.getProductNameQtyPrice();
		return new ResponseEntity<List<ProductDTO>>(productsDTO, HttpStatus.OK);
	}

}
