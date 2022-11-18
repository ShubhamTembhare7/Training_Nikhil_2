package com.yash.service;

import java.util.List;

import com.yash.model.Product;

public interface ProductService {
	
public List<Product> getAllProduct();

public Product getProductById(int id);

public List<Product> getByCategory(String cat);

public List<Product> getAllproductsByCategory(String category);

public void insertProduct(Product p);

public int deleteById(int id);

public void UpdateProduct(Product P);
}
