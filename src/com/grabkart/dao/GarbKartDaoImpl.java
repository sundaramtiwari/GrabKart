/**
 * 
 */
package com.grabkart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.grabkart.entity.Product;
import com.grabkart.entity.User;

/**
 * @author Sundaram
 *
 */
public class GarbKartDaoImpl implements GrabKartDao {

	private static String[] params;
	private static String[] values;

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void init(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public boolean createUser(User user) {
		boolean userCreated = false;
		try {
			List findByNamedQuery = hibernateTemplate.
					findByNamedQueryAndNamedParam("findUsersByUsername", "userName", user.getUserName());
			
			if (findByNamedQuery.isEmpty()) {
				hibernateTemplate.save(user);
				userCreated = true;
			}

		} catch (DataAccessException e) {
			System.out.println(e);
		}
		return userCreated;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User login(User user) {
		User userFetched = null;
		try {
			params = new String[]{"userName", "password"};
			values = new String[]{user.getUserName(), user.getPassword()};
			List<User> findByNamedQuery = hibernateTemplate.
					findByNamedQueryAndNamedParam("findUserByUserNameAndPassword", params , values);
			
			if (findByNamedQuery.isEmpty()) {
				return userFetched;
			}
			else {
				userFetched = findByNamedQuery.get(0);
			}

		} catch (DataAccessException e) {
			System.out.println(e);
		}
		return userFetched;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductList() {
		List<Product> findByNamedQuery = null;
		try {
			findByNamedQuery = hibernateTemplate.
					findByNamedQuery("fetchProductsList");

		} catch (DataAccessException e) {
			System.out.println(e);
		}
		return findByNamedQuery;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductListForSeller(User userRetrieved) {
		List<Product> findByNamedQuery = null;
		try {
			findByNamedQuery = hibernateTemplate.
					findByNamedQueryAndNamedParam("fetchProductsListBySellerId", "sellerId", userRetrieved.getId());

		} catch (DataAccessException e) {
			System.out.println(e);
		}
		return findByNamedQuery;
	}

}
