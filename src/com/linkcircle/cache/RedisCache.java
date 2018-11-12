/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: RedisCacheC.java
 * @Prject: CTDService
 * @Package: com.linkcircle.cache
 * @Description: TODO
 * @author: awbsheng@gmail.com
 * @date: 2017年8月25日 上午11:33:25
 * @version: V1.0
 */
package com.linkcircle.cache;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.linkcircle.utils.MD5;
import com.linkcircle.utils.SerializeUtil;

/** 
 * @ClassName: RedisCache 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年8月25日 上午11:33:25  
 */
public class RedisCache implements Cache {
	private static final Logger logger = Logger.getLogger(RedisCache.class);
	/** The ReadWriteLock. */
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private String id;
	private static final int DB_INDEX = 1;
	private final String COMMON_CACHE_KEY = "ctdnotice:";
	private static final String UTF8 = "utf-8";
	private static JedisConnectionFactory jedisConnectionFactory;

	/**
	 * 按照一定规则标识key
	 */
	private String getKey(Object key) {
		StringBuilder accum = new StringBuilder();
		accum.append(COMMON_CACHE_KEY);
		accum.append(this.id).append(":");
		accum.append(MD5.getMD5Str(String.valueOf(key)));
		return accum.toString();
	}
	/**
	 * redis key规则前缀
	 */
	private String getKeys() {
		return COMMON_CACHE_KEY + this.id + ":*";
	}
	public RedisCache() {
	}
	public RedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("必须传入ID");
		}
		logger.debug(">>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id);
		this.id = id;
	}
	@Override
	public String getId() {
		return this.id;
	}
	/* (non Javadoc) 
	 * @Title: clear
	 * @Description: TODO 
	 * @see org.apache.ibatis.cache.Cache#clear() 
	 */
	@Override
	public void clear() {
		JedisConnection connection = null;
		try {
			connection = jedisConnectionFactory.getConnection();
			connection.select(DB_INDEX);
			// 如果有删除操作，会影响到整个表中的数据，因此要清空一个mapper的缓存（一个mapper的不同数据操作对应不同的key）
			Set<byte[]> keys = connection.keys(getKeys().getBytes(UTF8));
			logger.debug("出现CUD操作，清空对应Mapper缓存======>" + keys.size());
			for (byte[] key : keys) {
				connection.del(key);
			}
			// 下面是网上流传的方法，极大的降低系统性能，没起到加入缓存应有的作用，这是不可取的。
			// jedis.flushDB();
			// jedis.flushAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	/* (non Javadoc) 
	 * @Title: getObject
	 * @Description: TODO
	 * @param arg0
	 * @return 
	 * @see org.apache.ibatis.cache.Cache#getObject(java.lang.Object) 
	 */
	@Override
	public Object getObject(Object key) {
		Object value = null;
		JedisConnection connection = null;
		try {
			connection = jedisConnectionFactory.getConnection();
			connection.select(DB_INDEX);
			value = SerializeUtil.unserialize(connection.get(getKey(key).getBytes(UTF8)));
			logger.debug("从缓存中获取-----" + this.id);
		} catch (Exception e) {
			logger.info(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return value;
	}
	/* (non Javadoc) 
	 * @Title: getReadWriteLock
	 * @Description: TODO
	 * @return 
	 * @see org.apache.ibatis.cache.Cache#getReadWriteLock() 
	 */
	@Override
	public ReadWriteLock getReadWriteLock() {
		return this.readWriteLock;
	}
	/* (non Javadoc) 
	 * @Title: getSize
	 * @Description: TODO
	 * @return 
	 * @see org.apache.ibatis.cache.Cache#getSize() 
	 */
	@Override
	public int getSize() {
		int result = 0;
		JedisConnection connection = null;
		try {
			connection = jedisConnectionFactory.getConnection();
			connection.select(DB_INDEX);
			Set<byte[]> keys = connection.keys(getKeys().getBytes(UTF8));
			if (null != keys && !keys.isEmpty()) {
				result = keys.size();
			}
			logger.debug(this.id + "---->>>>总缓存数:" + result);
		} catch (Exception e) {
			logger.info(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return result;
	}
	/* (non Javadoc) 
	 * @Title: putObject
	 * @Description: TODO
	 * @param arg0
	 * @param arg1 
	 * @see org.apache.ibatis.cache.Cache#putObject(java.lang.Object, java.lang.Object) 
	 */
	@Override
	public void putObject(Object key, Object value) {
		JedisConnection connection = null;
		try {
			connection = jedisConnectionFactory.getConnection();
			connection.select(DB_INDEX);
			byte[] keys = getKey(key).getBytes(UTF8);
			connection.set(keys, SerializeUtil.serialize(value));
			logger.debug("添加缓存--------" + this.id);
		} catch (Exception e) {
			logger.info(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	/* (non Javadoc) 
	 * @Title: removeObject
	 * @Description: TODO
	 * @param arg0
	 * @return 
	 * @see org.apache.ibatis.cache.Cache#removeObject(java.lang.Object) 
	 */
	@Override
	public Object removeObject(Object key) {
		Object value = null;
		JedisConnection connection = null;
		try {
			connection = jedisConnectionFactory.getConnection();
			connection.select(DB_INDEX);
			value = connection.del(getKey(key).getBytes(UTF8));
			logger.debug("LRU算法从缓存中移除-----" + this.id);
			// getSize();
		} catch (Exception e) {
			logger.info(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return value;
	}
	public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		RedisCache.jedisConnectionFactory = jedisConnectionFactory;
	}
	public static JedisConnectionFactory getJedisConnectionFactory() {
		return jedisConnectionFactory;
	}
}
