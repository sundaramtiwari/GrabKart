/**
 * 
 */
package com.grabkart.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;

import com.grabkart.cache.RedisPool;
import com.grabkart.dao.GrabKartDao;
import com.grabkart.entity.Product;
import com.grabkart.entity.User;
import com.grabkart.util.GrabKartUtil;
import com.grabkart.util.JsonUtil;

/**
 * @author Sundaram
 *
 */
public class GrabKartServiceImpl implements GrabKartService {

	private Jedis jedis;

	private static final Logger logger = Logger.getLogger(GrabKartServiceImpl.class);

	@Autowired
	private  GrabKartDao grabKartDao;

	@Override
	public boolean register(User user) {
		boolean userCreated = false;
		try {
			userCreated = grabKartDao.createUser(user);
			if (userCreated) {
				// Cache user details
				jedis = RedisPool.getResource();
				if (jedis != null) {
					jedis.hmset(user.getUserName(), GrabKartUtil.getUserMap(user));
					logger.info("User added to cache: " + user);
					RedisPool.returnResource(jedis);
				}
			}
		} catch (Exception e) {
			System.out.println("Unable to create user: " + user);
		}
		return userCreated;
	}

	@Override
	public User login(User loginUser) {
		User user = null;
		// Check user in cache
		try {
			jedis = RedisPool.getResource();
			if (jedis != null) {
				String userStr = jedis.hget(loginUser.getUserName(), "user");
				if (userStr != null)  {
					ObjectMapper mapper = JsonUtil.getObjectMapper();
					User userRetrieved = mapper.readValue(userStr, User.class);
					if (userRetrieved.getPassword().equals(loginUser.getPassword())) {
						user = userRetrieved;
						logger.info("User retrieved from cache: " + user);
					}
				}
				RedisPool.returnResource(jedis);
			}
		} catch (Exception e) {
			System.out.println("Error retrieveing user details from cache: " + e.getMessage());
		}

		// If user not in cache
		if (user == null) {
			user = grabKartDao.login(loginUser);
			if (user != null) {
				// Cache user
				jedis = RedisPool.getResource();
				if (jedis != null) {
					jedis.hmset(user.getUserName(), GrabKartUtil.getUserMap(user));
					logger.info("User added to cache: " + user);
					RedisPool.returnResource(jedis);
				}
			}
		}
		return user;
	}

	@Override
	public List<Product> getProductList() {
		return grabKartDao.getProductList();
	}

	@Override
	public List<Product> getProductListForSeller(User userRetrieved) {
		return grabKartDao.getProductListForSeller(userRetrieved);
	}

}
 