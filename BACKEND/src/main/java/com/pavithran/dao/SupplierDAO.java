package com.pavithran.dao;

import java.util.List;

import com.pavithran.model.Supplier;

public interface SupplierDAO {
	

	public List<Supplier> list();
	
	public Supplier getBySupplierName(String suppliername);		
	
	public Supplier getBySupplierId(int supplierid);	
	
    public Supplier getByContactNumber(String contactnumber);
    
	public void saveOrUpdate(Supplier supplier);
		
	public void delete(int supplierid);
}
