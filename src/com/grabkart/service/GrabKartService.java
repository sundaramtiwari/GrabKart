/**
 * 
 */
package com.grabkart.service;

import java.util.List;

import com.grabkart.entity.Product;
import com.grabkart.entity.User;

/**
 * @author Sundaram
 *
 */
public interface GrabKartService {

	public boolean register(User user);

	public User login(User user);

	public List<Product> getProductList();

	public List<Product> getProductListForSeller(User userRetrieved);

}
