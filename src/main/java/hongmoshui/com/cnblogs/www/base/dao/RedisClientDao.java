package hongmoshui.com.cnblogs.www.base.dao;

public interface RedisClientDao
{
    /**
     * 缓存字符串内容
     * @param key Redis key
     * @param value Redis value
     * @author 洪墨水
     */
    public boolean set(String key, String value);

    /**
     * 缓存对象内容
     * @param key Redis key
     * @param value Redis value
     * @author 洪墨水
     */
    public boolean set(String key, Object value);

    /**
     * 根据key，删除缓存中的对象内容
     * @param key Redis key
     * @param value Redis value
     * @author 洪墨水
     */
    public boolean del(String key);

    /**
     * 根据key，获取缓存中的内容
     * @param key Redis key
     * @param value Redis value
     * @author 洪墨水
     */
    public Object get(String key);

    public <T> T get(String key, Class<T> clazz);

}
