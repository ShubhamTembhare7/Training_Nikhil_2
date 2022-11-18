package com.yash.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.yash.model.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p1=new Product();
		p1.setProductId(rs.getString(1));
		p1.setCategory(rs.getString(2));
		p1.setDescription(rs.getString(3));
		p1.setManufacturer(rs.getString(4));
		p1.setName(rs.getString(5));		
		p1.setUnitPrice(rs.getInt(6));
		return p1;
	}
	
}
