package com.zensar.spring.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.spring.model.Product;
import com.zensar.spring.repository.ProductRepository;
import com.zensar.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Product insertProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Iterable<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProductById(int productId) {
		if (repository.existsById(productId)) {
			Product product = repository.getOne(productId);
			return product;
		} else {
			return new Product(0, "", 0);
		}
	}

	@Override
	public Product deleteProduct(int productId) {
		Product product = repository.getOne(productId);
		if (repository.existsById(productId)) {
			repository.deleteById(productId);
			return product;
		} else {
			return new Product(0, "", 0);
		}

	}

	@Override
	public Product updateProduct(int productId, Product updatedProduct) {
		if (repository.existsById(productId)) {
			Product product = repository.getOne(productId);
			product.setProductId(updatedProduct.getProductId());
			product.setProductName(updatedProduct.getProductName());
			product.setProductCost(updatedProduct.getProductCost());
			Product p = repository.save(updatedProduct);
			return p;
		} else {
			return new Product(0, "", 0);
		}

	}

}
