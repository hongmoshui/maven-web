package hongmoshui.com.cnblogs.www.base.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

public class BaseController
{
    private transient Logger log = Logger.getLogger(getClass());

    /**
     * 封装响应信息
     * @param json JSONObject
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return 响应信息
     */
    protected String writeResponse(JSONObject json, HttpServletRequest request, HttpServletResponse response)
    {
        String rsp = null;
        String jsonStr = json.toJSONString();
        response.setContentType("application/json; charset=UTF-8");

        // 返回接口响应报文
        PrintWriter writer = null;
        try
        {
            writer = response.getWriter();
            writer.write(jsonStr);
            rsp = jsonStr;
        }
        catch (IOException e)
        {
            log.warn("response wrtie excpetion! ", e);
            rsp = "response wrtie excpetion!";
        }
        finally
        {
            // 关闭输出流
            if (null != writer)
            {
                writer.close();
            }
        }

        return rsp;
    }
}
