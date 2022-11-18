package com.yash.validator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.yash.model.Product;

@Component
public class ProductValidator implements Validator {

	   private static File convertMultiPartToFile(MultipartFile file ) throws IOException {
	        File convFile = new File( file.getOriginalFilename() );
	        FileOutputStream fos = new FileOutputStream( convFile );
	        fos.write( file.getBytes() );
	        fos.close();
	        return convFile;
	    }
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Product product = (Product) target;
	       MultipartFile file = product.getFile();
	        String mimetype = "";
	        try {
	            mimetype = new MimetypesFileTypeMap().getContentType(ProductValidator.convertMultiPartToFile(file));
	        } catch (Exception ex) {
	       }
	        String type = mimetype.split("/")[0];

	       if (!type.equals("image"))
	            errors.rejectValue("file", "spring.form.invalid.file.type");
	    }
	}

