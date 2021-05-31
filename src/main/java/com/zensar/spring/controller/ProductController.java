package com.zensar.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.spring.model.Product;
import com.zensar.spring.service.ProductService;

@Controller
//@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class ProductController {
	@Autowired
	private ProductService service;

	@RequestMapping("/productDetail")
	public String productDetail() {
		return "productDetail";
	}

	@RequestMapping("/insertProduct")
	public String insertProduct(@ModelAttribute Product product, Model model) {
		Product insertedProduct = service.insertProduct(product);
		model.addAttribute("insertedProduct", insertedProduct);
		return "insertProduct";
	}

	@RequestMapping("/getAllProducts")
	public String getAllProducts(HttpServletRequest req, HttpServletResponse resp, @ModelAttribute Product product) {
		Iterable<Product> list = service.getAllProducts();
		req.setAttribute("list", list);
		System.out.println(list);
		return "getAllProducts";
	}

	@RequestMapping("/getProduct")
	public String getProduct() {
		return "getProduct";
	}

	@RequestMapping("/getProductById")
	public String getProductById(@ModelAttribute Product product, @RequestParam(name = "productId") int productId,
			HttpServletRequest request, Model model) {
		Product p = service.getProductById(productId);
		System.out.println(p);
		if (p.getProductId() == productId) {
			model.addAttribute("product", p);
			return "getProductById";
		} else {
			return "getProductError";
		}

	}

	@RequestMapping("/deleteProductById")
	public String deleteProductById() {
		return "deleteProductById";
	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(@ModelAttribute Product product, @RequestParam(name = "productId") int productId,
			Model model) {
		Product dp = service.deleteProduct(productId);
		if (dp.getProductId() == productId) {
			model.addAttribute("product", dp);
			return "deleteProduct";
		} else {
			return "getProductError";
		}

	}

	@RequestMapping("/updatedProduct")
	public String updatedProduct() {
		return "updatedProduct";
	}

	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute Product product, @RequestParam("productId") int productId,
			Model model) {

		Product updatedProduct = service.updateProduct(productId, product);
		if (updatedProduct.getProductId() == productId) {
			model.addAttribute("updatedProduct", updatedProduct);
			return "updateProduct";
		} else {
			return "deleteError";
		}

	}
}
