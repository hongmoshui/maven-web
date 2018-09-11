package hongmoshui.com.cnblogs.www.base.service.impl;

import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

import hongmoshui.com.cnblogs.www.base.service.RedisClientService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service("redisClientService")
public class RedisClientServiceImpl implements RedisClientService
{

    /**
     * redis连接池
     */
    public static JedisPool jedisPool;
    static
    {
        ResourceBundle resourceBudle = ResourceBundle.getBundle("properties.redis");
        // 最大活动链接数
        int maxActive = Integer.parseInt(resourceBudle.getString("redis.pool.maxActive"));
        // 最大空闲数，数据库连接的最大空闲时间
        int maxIdle = Integer.parseInt(resourceBudle.getString("redis.pool.maxIdle"));
        // 最大等待时间
        int maxWait = Integer.parseInt(resourceBudle.getString("redis.pool.maxWait"));
        // ip地址
        String ip = resourceBudle.getString("redis.ip");
        // 端口号
        int port = Integer.parseInt(resourceBudle.getString("redis.port"));
        // 访问超时时长
        int timeout = Integer.parseInt(resourceBudle.getString("redis.timeout"));
        // 密码
        String password = resourceBudle.getString("redis.password");

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(maxActive);
        // 设置最大空闲数
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 设置超时时间
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        // 初始化连接池
        jedisPool = new JedisPool(jedisPoolConfig, ip, port, timeout, password);
    }

    @Override
    public Jedis getResource()
    {
        return jedisPool.getResource();
    }

    @Override
    public void returnJedisResource(Jedis jedis, boolean jedisConnExcption)
    {
        if (jedis != null)
        {
            if (jedisConnExcption)
            {
                jedisPool.returnBrokenResource(jedis);
            }
            else
            {
                try
                {
                    jedisPool.returnResource(jedis);
                }
                catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
