package hongmoshui.com.cnblogs.www.work.dao;

import org.mybatis.spring.annotation.MapperScan;

import hongmoshui.com.cnblogs.www.work.model.UserInfo;

@MapperScan
public interface TestDao
{
    /**
     * 根据用户名称,查看用户信息
     * @param name 用户名称
     * @return UserInfo 用户信息
     * @author 洪墨水
     */
    UserInfo queryUserInfoByName(String name);

}
