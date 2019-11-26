package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url ;
    private ResourceBundle bundle;
//  用来存储cookies信息的变量
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        //1.读取配置文件。1.1写properties 的文件名即可。会自动去resource下去找。 1.2要加上字符编码。
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        //2.读取url
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        // 读取path（uri）
        String uri = bundle.getString("test.getcookies.uri");
        //拼接测试链接
        String testUrl = this.url+uri;
        //获取到URL
        HttpGet get = new HttpGet(testUrl);
        //生成HttpClient的对象
        DefaultHttpClient client = new DefaultHttpClient();
        //执行get请求
        HttpResponse response = client.execute(get);
        //将结果转换成字符串，保存到result
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        /*
        * 获取cookies信息。
        *HttpClient  获取不到cookies信息。换成DefaultHttpClient。
        * */
        this.store = client.getCookieStore();
        //返回cookies list
         List<Cookie> cookieList = store.getCookies();
         //for 循环 获取list。
        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name =" + name + "cookie value = " +value);


        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        //获取路径
        String uri = bundle.getString("test.postwithcookies.uri");
        //拼接测试URL
        String testUrl = this.url+uri;
        //get   请求
        HttpGet get = new HttpGet(testUrl);

        //客户端
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookies信息, 知识点，把cookies信息传进客户端
        client.setCookieStore(this.store);
        //访问
        HttpResponse response = client.execute(get);
        //获取响应状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("statusCode = "+statusCode);
        if (statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }

    }
}
