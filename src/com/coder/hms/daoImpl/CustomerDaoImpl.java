/**
 * @author Coder ACJHP
 * @Email hexa.octabin@gmail.com
 * @Date 15/07/2017
 */
package com.coder.hms.daoImpl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.coder.hms.connection.DataSourceFactory;
import com.coder.hms.dao.CustomerDAO;
import com.coder.hms.entities.Customer;

public class CustomerDaoImpl implements CustomerDAO {

	private Session session;
	private DataSourceFactory dataSourceFactory;
	private final Logger LOGGER = Logger.getLogger(CustomerDaoImpl.class.getName());
	
	public CustomerDaoImpl() {
		
		dataSourceFactory = new DataSourceFactory();
		DataSourceFactory.createConnection();

	}
	
	@Override
	public Customer findCustomerByName(String name, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerByDocumentId(long DocumentNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		session = dataSourceFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> customerList = query.getResultList();
		session.close();
		LOGGER.info(customerList.toString());
		
		return customerList;
	}

	public void save(Customer theCustomer) {
		session = dataSourceFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(theCustomer);
		session.getTransaction().commit();
		session.close();
		
	}

	public List<Customer> getCustomerByReservId(long id) {
		session = dataSourceFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query<Customer> query = session.createQuery("from Customer where ReservationId=:id", Customer.class);
		query.setParameter("id", id);
		List<Customer> customerList = query.getResultList();
		session.close();
		LOGGER.info(customerList.toString());
		
		return customerList;
	}

}