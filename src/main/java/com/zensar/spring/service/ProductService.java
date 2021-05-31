package com.zensar.spring.service;

import com.zensar.spring.model.Product;

public interface ProductService {
	
	public Product insertProduct(Product product);
	
	public Iterable<Product> getAllProducts();
	
	public Product getProductById(int productId);
	
	public Product deleteProduct(int productId);
	
	public Product updateProduct(int productId, Product updateProduct);

}
