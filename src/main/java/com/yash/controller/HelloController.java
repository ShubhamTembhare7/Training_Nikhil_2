package com.yash.controller;

import java.io.File;
import java.util.List;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yash.logger.ProcessingTimeInterceptor;
import com.yash.model.Product;
import com.yash.service.ProductService;
import com.yash.validator.ProductValidator;

@Controller
public class HelloController {

	@Autowired
	ProductService ps;
	
	@Autowired
	ProductValidator validator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	private static final Logger LOGGER=Logger.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String getMaster(ModelMap model) {
		LOGGER.error("Hello Developer");
		model.addAttribute("product", ps.getAllProduct());

		return "getAllproducts";
	}

	@GetMapping("/getId")
	public String getProductById(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("product", ps.getProductById(id));
		// return "first";
		return "oneProduct";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/category/{cat}")
	public String getByCategory(ModelMap model, @PathVariable String cat) {
   LOGGER.error("Hello Get");
		System.out.println(ps.getByCategory(cat));
		model.addAttribute("product", ps.getByCategory(cat));
		return "category";
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET, value = "/all/{category}") public
	 * String getAllProductsByCategory(ModelMap model, @PathVariable("category")
	 * String category) {
	 * 
	 * List<Product> products = ps.getAllproductsByCategory(category);
	 * model.addAttribute("product", products); return "getAllproducts"; }
	 */
	// another way
	/*
	 * @RequestMapping(method = RequestMethod.GET,value = "/get") public String
	 * getProductsByCategory(ModelMap model,@RequestParam("id")int productId) {
	 * 
	 * Product p1=ps.getProductById(productId); model.addAttribute("product", p1);
	 * return "getAllproducts"; }
	 * 
	 */
	@GetMapping("/add")
	public String getProductAddForm(ModelMap model) {
		/*
		 * Product p1=new Product();
		 * 
		 * p1.setProductId("1211"); p1.setName("Shubham");
		 * 
		 */ model.addAttribute("newproduct", new Product());
		// return "first";
		return "addProduct";
	}
	
	@PostMapping("/add")
	public String addProduct(@ModelAttribute("newproduct") @Valid Product product,  BindingResult result,HttpServletRequest request) {
		if(result.hasErrors()) 
			return "addProduct";
		
		MultipartFile productImage=product.getFile();
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		try {
			productImage.transferTo(new File(rootDirectory+"resources\\images\\"+product.getProductId()+".jpg"));
		}catch(Exception ex) {}
		ps.insertProduct(product);
		return "redirect:/hello";
	}
	
	/*
	 * @DeleteMapping("/deleteId") public String
	 * getDeleteProductById(@RequestParam("id") int id, ModelMap model) {
	 * model.addAttribute("product", ps.deleteById(id)); // return "first"; return
	 * "hello"; }
	 */
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.DELETE},value = "/Delete")
    public String DeleteProduct(@RequestParam int id) {
            ps.deleteById(id);
        
        return "redirect:/hello";
    }
	@RequestMapping(method = RequestMethod.GET,value = "/Update")
	public String getUpdateProductForm(@RequestParam int id,ModelMap model) {
	
		Product p=new Product();
		p=ps.getProductById(id);
		model.addAttribute("name", p.getName());
		model.addAttribute("productId", p.getProductId());
		model.addAttribute("category", p.getCategory());
		model.addAttribute("description", p.getDescription());
		model.addAttribute("manufacturer", p.getManufacturer());
		model.addAttribute("unitPrice", p.getUnitPrice());
		model.addAttribute("newProduct",p);
		return "addproduct";
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/Update")
	public String UpdateProduct(@RequestParam int id,@ModelAttribute("newProduct") Product product) {
	
		ps.UpdateProduct(product);
		return "redirect:/hello";
	}
    

}
