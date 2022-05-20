package com.example.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
import com.example.demo.ifaces.CrudRepository;
@Repository
public class ProductRepository implements CrudRepository<Product> {

	private JdbcTemplate template;
	
	@Autowired
	public ProductRepository(JdbcTemplate template) {
		super();
		this.template = template;
	}

	public ProductRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(Product t) {
		
		String sql = "insert into venki_product1 values(?,?,?)";
		
		return template.update(sql, t.getProductId(),t.getProductName(),
				t.getPrice());
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		String sql ="select * from venki_product1";
		return template.query(sql, BeanPropertyRowMapper
				.newInstance(Product.class));
	}

	@Override
	public Product findById(int id) {
		
		//Optional<Product> option = Optional.empty();
		try {
			String sql="select * from venki_product1 where product_id=?";
			
			return template.queryForObject(sql,BeanPropertyRowMapper.newInstance(Product.class),id );
			//option=Optional.of(pro);
		}catch(Exception e) {
			System.out.println("*************");
			return null;
		}
		
	}

	@Override
	public int update(Product t) {
		String sql ="update venki_product1 set product_name=? where product_id=?";
		 
		return template.update(sql, t.getProductName(),t.getProductId());
	}

	@Override
	public int remove(int id) {
		
		String sql ="delete  from venki_product1 where product_id=?";
		return template.update(sql, id);
	}
	
	
	
	

}
