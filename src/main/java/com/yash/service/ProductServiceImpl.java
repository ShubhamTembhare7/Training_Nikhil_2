package com.yash.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Product;
import com.yash.repository.ProductDao;
@Service
public class ProductServiceImpl implements ProductService{
  
	@Autowired
	ProductDao pd;
	@Override
	public List<Product> getAllProduct() {
		
		return pd.getAllProduct();
	}
	@Override
	public Product getProductById(int id) {
		
		return pd.getProductById(id);
	}
	@Override
	public List<Product> getByCategory(String cat) {
		
		return pd.getByCategory(cat);
	}
	
	public List<Product> getAllproductsByCategory(String category)
	{
		return pd.getAllProduct().stream().filter(p->p.getCategory().equals(category)).collect(Collectors.toList());
	}
	@Override
	public void insertProduct(Product p) {
		pd.insertProduct(p);
		
	}
	@Override
	public int deleteById(int id) {
		
		return pd.deleteById(id);
	}
	@Override
	public void UpdateProduct(Product P) {
		pd.UpdateProduct(P);
		
	}
}
