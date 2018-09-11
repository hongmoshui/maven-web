package hongmoshui.com.cnblogs.www.base.service;

import redis.clients.jedis.Jedis;

public interface RedisClientService
{
    /**
     * 获取redis资源连接
     * @return Jedis redis资源连接
     * @author 洪墨水
     */
    public Jedis getResource();

    /**
     * 释放redis资源连接
     * @param jedis redis资源连接
     * @param jedisConnExcption redis连接获取是否有异常
     * @author 洪墨水
     */
    public void returnJedisResource(Jedis jedis, boolean jedisConnExcption);
}
