package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController    //告诉application，这是需要被扫描的类
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)    //配置访问路径,method 固定写法，必须以这样的方式访问
    @ApiOperation(value="通过这个方法可以获取到Cookies",httpMethod = "GET")  //swagger
    public String getCookies(HttpServletResponse response) {
        //HttpServletRequest 装请求信息的类
        //HttpServletResponse 装响应信息的类
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    /*
     *要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value = "/get/With/Cookies", method = RequestMethod.GET)
    @ApiOperation(value="需要携带cookies信息访问",httpMethod = "GET")

    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        //cookies 数组：key value ,多对
        //判断对象是否为空
        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息来";
        }
        //验证cookies
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")) {
                return "恭喜！这是一个需要携带cookies信息才能访问的请求";
            }
        }
        return "你必须携带cookies信息来";

    }
    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式 URL ：key=value&&key=value
     * ip:port/get/with/param?start=10&end=20
     * 知识点 注解：@RequestParam
     * 模拟商品列表
     */
    @RequestMapping(value = "/get/With/param", method = RequestMethod.GET)
    @ApiOperation(value="需要携带参数访问的get方法1",httpMethod = "GET")

    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("蓝忘机",22);
        myList.put("魏无羡",28);
        myList.put("朱一龙",30);
        return myList;

    }
    /**
     * 第二种实现方法：URL ：ip:port/get/with/param/10/20
     * 注解也与第一种不同
     */
    @RequestMapping(value="get/with/param/{start}/{end}")
    @ApiOperation(value="需要携带参数访问的get方法2",httpMethod = "GET")

    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("蓝忘机",22);
        myList.put("魏无羡",28);
        myList.put("朱一龙",30);
        myList.put("周俊",32);
        return myList;
    }
}
