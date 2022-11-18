package com.yash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yash.repository.ProductDao;

@SpringBootApplication
public class T2ProductDemoApplication implements CommandLineRunner{
	
	@Autowired
	ProductDao productDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(T2ProductDemoApplication.class, args);
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		productDao.deleteById(1229);
		
	}

}
