package com.grabkart.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisPool {

	private static final JedisPool pool = new JedisPool("localhost");

	private RedisPool() {
		
	}

	public static Jedis getResource() {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
		} catch (Exception e) {
			System.out.println("Exception in getting resource from pool: " + e.getMessage());
			return jedis;
		}
		return jedis;
	}
	
	public static void returnResource(Jedis jedis) {
		try {
			pool.returnResource(jedis);
		} catch (Exception e) {
			System.out.println("Exception in returning resource to pool: " + e.getMessage());
		}
	}
}

