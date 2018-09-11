package hongmoshui.com.cnblogs.www.work.service;

import hongmoshui.com.cnblogs.www.base.model.Result;

public interface TestService
{
    /**
     * 使用Redis缓存字符串
     * @param key Redis的key
     * @param value 字符串值
     * @author 洪墨水
     */
    Result setValue(String key, String value);

    /**
     * 从Redis缓存中取出数据
     * @param key
     * @author 洪墨水
     */
    Result getValue(String key);

    /**
     * 删除Redis中的一个数据
     * @param key Redis的key
     * @author hWX492476
     */
    Result delValue(String key);

    /**
     * 根据用户名称,查询用户信息
     * @param name 用户名称
     * @author 洪墨水
     */
    Result queryUserInfoByName(String name);
}
