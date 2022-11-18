package com.yash.repository;

import java.util.List;

import com.yash.model.Product;

public interface ProductDao {
public List<Product> getAllProduct();

public Product getProductById(int id);

public List<Product> getByCategory(String cat);

public void insertProduct(Product p);

public int deleteById(int id);

public void UpdateProduct(Product P);

}
