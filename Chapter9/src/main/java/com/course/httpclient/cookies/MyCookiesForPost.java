package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
    public void testPostMethod() throws UnsupportedEncodingException,IOException {
        //获取路径
        String uri = bundle.getString("test.postwithparam.cookies.uri");
        //拼接测试地址
        String testUrl =this.url+uri;
        //声明一个Client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();


        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数,需要在pom 文件中引入Json 对象！！
        JSONObject param = new JSONObject();
        param.put("name","zhousui");
        param.put("age","25");



        //设置请求头信息 ，设置header
        post.setHeader("content-type","application/json");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);


        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息呢
        client.setCookieStore(this.store);

        //执行post方法
        HttpResponse response = client.execute(post);

        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        /*处理结果，判断返回结果是否符合预期.
        分两步：1.将返回的响应结果字符串转换成json对象
        2。具体的判断返回结果的值
        2.1获取到结果值
        */

        JSONObject resultJson=new JSONObject(result);

        String success = (String)resultJson.get("zhousui");
        String status = (String)resultJson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);



    }

}
