/**
 * 
 */
package com.grabkart.dao;

import java.util.List;

import com.grabkart.entity.Product;
import com.grabkart.entity.User;

/**
 * @author Sundaram
 *
 */
public interface GrabKartDao {

	public boolean createUser(User user);

	public User login(User user);

	public List<Product> getProductList();

	public List<Product> getProductListForSeller(User userRetrieved);

}
