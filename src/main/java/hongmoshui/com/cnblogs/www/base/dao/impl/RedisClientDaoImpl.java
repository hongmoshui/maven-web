package hongmoshui.com.cnblogs.www.base.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;

import hongmoshui.com.cnblogs.www.base.dao.RedisClientDao;
import hongmoshui.com.cnblogs.www.base.service.RedisClientService;
import redis.clients.jedis.Jedis;

@Repository("redisClientDao")
public class RedisClientDaoImpl implements RedisClientDao
{
    @Autowired
    private transient RedisClientService redisClientService;

    /**
     * 日志记录log
     */
    public transient Logger log = Logger.getLogger(getClass());

    @Override
    public boolean set(String key, String value)
    {
        Jedis jedis = null;
        boolean jedisConnExcption = false;
        try
        {
            jedis = redisClientService.getResource();
            String setResult = jedis.set(key, value);
            jedisConnExcption = true;
            return setResult == null ? false : true;
        }
        catch (Exception e)
        {
            log.error(e);
            jedisConnExcption = false;
            return jedisConnExcption;
        }
        finally
        {
            redisClientService.returnJedisResource(jedis, jedisConnExcption);
        }
    }

    @Override
    public boolean set(String key, Object value)
    {
        Jedis jedis = null;
        boolean jedisConnExcption = false;
        try
        {
            String jsonValue = JSON.toJSONString(value);
            jedis = redisClientService.getResource();
            String setResult = jedis.set(key, jsonValue);
            jedisConnExcption = true;
            return setResult == null ? false : true;
        }
        catch (Exception e)
        {
            log.error(e);
            jedisConnExcption = false;
            return false;
        }
        finally
        {
            redisClientService.returnJedisResource(jedis, jedisConnExcption);
        }
    }

    @Override
    public boolean del(String key)
    {
        Jedis jedis = null;
        boolean jedisConnExcption = false;
        try
        {
            jedis = redisClientService.getResource();
            Long del = jedis.del(key);
            jedisConnExcption = true;
            return del == null || del == 0 ? false : true;
        }
        catch (Exception e)
        {
            log.error(e);
            jedisConnExcption = false;
            return false;
        }
        finally
        {
            redisClientService.returnJedisResource(jedis, jedisConnExcption);
        }
    }

    @Override
    public Object get(String key)
    {
        Jedis jedis = null;
        boolean jedisConnExcption = false;
        try
        {
            jedis = redisClientService.getResource();
            Object value = jedis.get(key);
            return value;
        }
        catch (Exception e)
        {
            log.error(e);
            jedisConnExcption = false;
            return null;
        }
        finally
        {
            redisClientService.returnJedisResource(jedis, jedisConnExcption);
        }
    }

    @Override
    public <T> T get(String key, Class<T> clazz)
    {
        Jedis jedis = null;
        boolean jedisConnExcption = false;
        try
        {
            jedis = redisClientService.getResource();
            String value = jedis.get(key);
            return JSON.parseObject(value, clazz);
        }
        catch (Exception e)
        {
            log.error(e);
            jedisConnExcption = false;
            return null;
        }
        finally
        {
            redisClientService.returnJedisResource(jedis, jedisConnExcption);
        }
    }
}
