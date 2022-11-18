package com.yash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT")
public class Product {
	     @Id
	     @Column(name="PRODUCTID")
		private String productId;
	     
	     @Column(name="NAME")
	     @Size(min = 5,message = "{spring.form.name.min.size}")
		private String name;
	     
	     @Column(name="UNIT_PRICE")
		private int unitPrice;
	     
	     @Column(name="CATEGORY")
		private String category;
	     
	     @Column(name="DESCRIPTION")
		private String description;
	     
	     @Column(name="MANUFACTURER")
		private String manufacturer;
	     
	     @Transient //to avoid to store in Db
	     private MultipartFile file;

		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Product(String productId, String name, int unitPrice, String category, String description,
				String manufacturer) {
			super();
			this.productId = productId;
			this.name = name;
			this.unitPrice = unitPrice;
			this.category = category;
			this.description = description;
			this.manufacturer = manufacturer;
		}

		@Override
		public String toString() {
			return "Product [productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + ", category="
					+ category + ", description=" + description + ", manufacturer=" + manufacturer + "]";
		}

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(int unitPrice) {
			this.unitPrice = unitPrice;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public MultipartFile getFile() {
			return file;
		}

		public void setFile(MultipartFile file) {
			this.file = file;
		}

		
}
