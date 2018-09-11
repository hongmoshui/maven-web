package hongmoshui.com.cnblogs.www.base.model;

import java.util.HashMap;

/**
 * 结果集封装
 * @author 洪墨水
 */
public class Result extends HashMap<String, Object>
{
    /**
     * 序列化ID
     * @author 洪墨水
     */
    private static final long serialVersionUID = -8242720434439722646L;

    public Result()
    {
        super(2);
    }
    
    /**
     * 调用结果【true:调用成功,false:调用失败】
     * @author 洪墨水
     */
    public boolean isSuccess()
    {
        return (boolean) get("success");
    }

    public void setSuccess(boolean success)
    {
        put("success", success);
    }

    /**
     * 调用后的反馈信息
     * @author 洪墨水
     */
    public String getMessage()
    {
        return (String) get("message");
    }

    public void setMessage(String message)
    {
        put("message", message);
    }

    /**
     * 错误码
     * @author 洪墨水
     */
    public String getCode()
    {
        return (String) get("code");
    }

    public void setCode(String code)
    {
        put("code", code);
    }

}
