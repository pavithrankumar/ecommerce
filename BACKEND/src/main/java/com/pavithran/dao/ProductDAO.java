package com.pavithran.dao;

import java.util.List;

import com.pavithran.model.Product;

public interface ProductDAO {

	public List<Product> list();
	
	public Product getByProductId(int productid);
	
	public Product getByProductName(String productname);
	
	public void saveOrUpdate(Product product);
	
	public void delete(int product_id);

	public List<Product> getBySupplierName(String suppliername);

	public List<Product> getByFeatured();
}
