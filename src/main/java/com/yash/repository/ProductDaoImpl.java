package com.yash.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.yash.mapper.ProductMapper;
import com.yash.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	JdbcTemplate jdbctemplate;
	@Override
	public List<Product> getAllProduct() {
		String sql="select * from Product";
		return jdbctemplate.query(sql, new ProductMapper());
	}
	@Override
	public Product getProductById(int id) {
		
		String sql="select * from product where productId=?";
		return jdbctemplate.queryForObject(sql, new Object[] {id} ,new ProductMapper());
	}

	public List<Product> getByCategory(String cat) {
        // TODO Auto-generated method stub



       String query="select * from product where category='"+cat+"'";
        return jdbctemplate.query(query, new ProductMapper());
    }
	@Override
	public void insertProduct(Product p) {
		  String sql="insert into product (productid,category,description,manufacturer,name,unit_price) values (?,?,?,?,?,?)";
		     jdbctemplate.update(sql,new PreparedStatementSetter() {		       
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, p.getProductId());
	                ps.setString(2, p.getCategory());
	                ps.setString(3, p.getDescription());
	                ps.setString(4, p.getManufacturer());
	                ps.setString(5, p.getName());
	                ps.setInt(6, p.getUnitPrice());	                
	
	            }
		     });
	}
	@SuppressWarnings("deprecation")
	@Override
	public int deleteById(int id) {
	String sql="delete from product where productId=?";
	return jdbctemplate.update(sql,new PreparedStatementSetter()
			{

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, id);
				}
		
			});
	}
	@Override
	public void UpdateProduct(Product P) {
		String q="update Product set category='"+P.getCategory()+"',description='"+P.getDescription()+"',manufacturer='"+P.getManufacturer()+"',name='"+P.getName()+"',unit_price="+P.getUnitPrice()+" where product_id='"+P.getProductId()+"'";
		jdbctemplate.update(q);
		
	}}
		     
