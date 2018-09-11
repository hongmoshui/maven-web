package hongmoshui.com.cnblogs.www.work.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hongmoshui.com.cnblogs.www.base.dao.RedisClientDao;
import hongmoshui.com.cnblogs.www.base.model.Result;
import hongmoshui.com.cnblogs.www.work.dao.TestDao;
import hongmoshui.com.cnblogs.www.work.model.UserInfo;
import hongmoshui.com.cnblogs.www.work.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService
{
    @Autowired
    private transient RedisClientDao redisClientDao;

    @Autowired
    private transient TestDao testDao;
    /**
     * 日志记录log
     */
    public transient Logger log = Logger.getLogger(getClass());

    @Override
    public Result setValue(String key, String value)
    {
        Result result = new Result();
        boolean setResult = redisClientDao.set(key, value);
        if (setResult)
        {
            result.setSuccess(true);
            result.setMessage("缓存成功!");
            log.info("call redis set success! redis key:" + key + ",value:" + value);
        }
        else
        {
            result.setSuccess(false);
            result.setMessage("缓存失败!");
            log.error("call redis set failed! redis key:" + key + ",value:" + value);
        }
        return result;
    }

    @Override
    public Result getValue(String key)
    {
        Result result = new Result();
        Object obj = redisClientDao.get(key);
        if (obj != null)
        {
            result.setSuccess(true);
            result.setMessage("取出成功!");
            result.put("value", obj);
            log.info("call redis get success! redis key:" + key + ",value:" + obj);
        }
        else
        {
            result.setSuccess(false);
            result.setMessage("取出失败!");
            log.error("call redis get failed! redis key:" + key + ",value:" + obj);
        }
        return result;
    }

    @Override
    public Result delValue(String key)
    {
        Result result = new Result();
        boolean delResult = redisClientDao.del(key);
        if (delResult)
        {
            result.setSuccess(true);
            result.setMessage("删除成功!");
            log.info("call redis get success! redis key:" + key);
        }
        else
        {
            result.setSuccess(false);
            result.setMessage("删除失败!");
            log.error("call redis get failed! redis key:" + key);
        }
        return result;
    }

    @Override
    public Result queryUserInfoByName(String name)
    {
        Result result = new Result();
        try
        {
            UserInfo userInfo = testDao.queryUserInfoByName(name);
            result.setSuccess(true);
            result.setMessage("查询成功!");
            result.put("userInfo", userInfo);
        }
        catch (Exception e)
        {
            result.setSuccess(false);
            result.setMessage("查询失败!");
            log.error(e);
        }
        return result;
    }

}
