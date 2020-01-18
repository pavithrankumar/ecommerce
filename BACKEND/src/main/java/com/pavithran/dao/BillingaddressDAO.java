package com.pavithran.dao;

import java.util.List;

import com.pavithran.model.Billingaddress;

public interface BillingaddressDAO {
	
    public List<Billingaddress> list();
	
	public Billingaddress getByBillId(int billid);		
	
	public Billingaddress getByBillingAddress(String billingaddress);	
	
    public Billingaddress getByContactNumber(String contactnumber);
    
	public void saveOrUpdate(Billingaddress billingaddress);
		
	public void delete(String BillingAddress);
	
	public void editBillingAddress(Billingaddress billingaddress);
}
