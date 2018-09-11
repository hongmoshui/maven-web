package hongmoshui.com.cnblogs.www.work.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

import hongmoshui.com.cnblogs.www.base.controller.BaseController;
import hongmoshui.com.cnblogs.www.base.model.Result;
import hongmoshui.com.cnblogs.www.work.service.TestService;

@Controller
public class TestController extends BaseController
{
    @Autowired
    private transient TestService testService;

    @RequestMapping(value = "/test/redis/setValue", method = RequestMethod.GET)
    public void setValue(HttpServletRequest request, HttpServletResponse response, String key, String value)
    {
        JSONObject json = new JSONObject();
        Result result = testService.setValue(key, value);
        json.put("result", result);
        writeResponse(json, request, response);
    }

    @RequestMapping(value = "/test/redis/getValue", method = RequestMethod.GET)
    public void getValue(HttpServletRequest request, HttpServletResponse response, String key)
    {
        JSONObject json = new JSONObject();
        Result result = testService.getValue(key);
        json.put("result", result);
        writeResponse(json, request, response);
    }

    @RequestMapping(value = "/test/redis/delValue", method = RequestMethod.GET)
    public void delValue(HttpServletRequest request, HttpServletResponse response, String key)
    {
        JSONObject json = new JSONObject();
        Result result = testService.delValue(key);
        json.put("result", result);
        writeResponse(json, request, response);
    }

    @RequestMapping(value = "/test/queryUserInfoByName", method = RequestMethod.GET)
    public void queryUserInfoByName(HttpServletRequest request, HttpServletResponse response, String name)
    {
        JSONObject json = new JSONObject();
        Result result = testService.queryUserInfoByName(name);
        json.put("result", result);
        writeResponse(json, request, response);
    }
}
