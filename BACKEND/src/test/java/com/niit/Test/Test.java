package com.niit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pavithran.dao.BillingaddressDAO;
import com.pavithran.dao.CartDAO;
import com.pavithran.dao.CategoryDAO;
import com.pavithran.dao.ProductDAO;
import com.pavithran.dao.RoleDAO;
import com.pavithran.dao.ShippingaddressDAO;
import com.pavithran.dao.SupplierDAO;
import com.pavithran.dao.UserDAO;
import com.pavithran.model.Billingaddress;
import com.pavithran.model.Cart;
import com.pavithran.model.Category;
import com.pavithran.model.Product;
import com.pavithran.model.Role;
import com.pavithran.model.Shippingaddress;
import com.pavithran.model.Supplier;
import com.pavithran.model.User;

public class Test {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.pavithran.*");
		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("CategoryDAO");
		UserDAO UserDao = (UserDAO) context.getBean("UserDAO");
		ProductDAO ProductDao = (ProductDAO) context.getBean("ProductDAO");
		BillingaddressDAO BillingaddressDao = (BillingaddressDAO) context.getBean("BillingaddressDAO");
		CartDAO CartDao = (CartDAO) context.getBean("CartDAO");
		SupplierDAO SupplierDao = (SupplierDAO) context.getBean("SupplierDAO");
		ShippingaddressDAO ShippingaddressDao = (ShippingaddressDAO) context.getBean("ShippingaddressDAO");
		RoleDAO RoleDao = (RoleDAO) context.getBean("RoleDAO");
		
		Category category = (Category) context.getBean("category");
		User user = (User) context.getBean("user");
		Product product = (Product) context.getBean("product");
		Billingaddress billingaddress = (Billingaddress) context.getBean("billingaddress");
		Cart cart = (Cart) context.getBean("cart");
		Supplier supplier = (Supplier) context.getBean("supplier");
		Shippingaddress shippingaddress = (Shippingaddress) context.getBean("shippingaddress");
		Role role = (Role) context.getBean("role");
		
		
		category.setCategoryName("Watches");
		category.setCategoryDescription("this product shows time");
		category.setCategoryName("bracelets");
		category.setCategoryDescription("hand wear");
		categoryDAO.saveOrUpdate(category);
		
		
		user.setUserName("pavithran");
		user.setEmailId("pavithran@gmail.com");
		user.setPassword("done");
		
		user.setContactNumber("98763856835");
		user.setAddress("tambaram");
		user.setZipcode(75426);

		role.setUserName("surya");
		role.setEmailId("abc@gmail.com");
		role.setContactNumber("67597597567");
		
		user.setRole(role);
		role.setUser(user);
		
		UserDao.saveOrUpdate(user);
		RoleDao.saveOrUpdate(role);
		
		
		product.setProductName("watches sonata");
		ProductDao.saveOrUpdate(product);
		
		billingaddress.setAddress("krishna nagar");
		billingaddress.setContactNumber("89746686865");
		BillingaddressDao.saveOrUpdate(billingaddress);
		
		
		cart.setProductName("anto");
		CartDao.saveOrUpdate(cart);
		
		
		supplier.setSupplierName("aaaaaa");
		supplier.setContactNumber(87968764);
		SupplierDao.saveOrUpdate(supplier);
		
		
		shippingaddress.setAddress("dhoni");
		shippingaddress.setUserName("runnnnn");
		ShippingaddressDao.saveOrUpdate(shippingaddress);

	}

}
