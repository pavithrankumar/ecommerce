package com.pavithran.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pavithran.dao.BillingaddressDAO;
import com.pavithran.dao.CartDAO;
import com.pavithran.dao.CategoryDAO;
import com.pavithran.dao.ProductDAO;
import com.pavithran.dao.RoleDAO;
import com.pavithran.dao.ShipmentDAO;
import com.pavithran.dao.SupplierDAO;
import com.pavithran.dao.UserDAO;
import com.pavithran.daoImpl.BillingaddressDAOImpl;
import com.pavithran.daoImpl.CartDAOImpl;
import com.pavithran.daoImpl.CategoryDAOImpl;
import com.pavithran.daoImpl.ProductDAOImpl;
import com.pavithran.daoImpl.RoleDAOImpl;
import com.pavithran.daoImpl.ShipmentDAOImpl;
import com.pavithran.daoImpl.SupplierDAOImpl;
import com.pavithran.daoImpl.UserDAOImpl;
import com.pavithran.model.Billingaddress;
import com.pavithran.model.Cart;
import com.pavithran.model.Category;
import com.pavithran.model.Product;
import com.pavithran.model.Role;
import com.pavithran.model.Shipment;
import com.pavithran.model.Supplier;
import com.pavithran.model.User;

@Configuration

@EnableTransactionManagement
public class hiberConfig {
	
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Billingaddress.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Shipment.class);
		sessionBuilder.addAnnotatedClass(Role.class);
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired(required = true)
	@Bean(name = "CategoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "UserDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "ProductDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "BillingaddressDAO")
	public BillingaddressDAO getBillingaddresstDAO(SessionFactory sessionFactory) {
		return new BillingaddressDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "CartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory) {
		return new CartDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "SupplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "ShipmentDAO")
	public ShipmentDAO getShipmentDAO(SessionFactory sessionFactory) {
		return new ShipmentDAOImpl(sessionFactory);
	}
	@Autowired(required = true)
	@Bean(name = "RoleDAO")
	public RoleDAO getRoleDAO(SessionFactory sessionFactory) {
		return new RoleDAOImpl(sessionFactory);
	}
}
