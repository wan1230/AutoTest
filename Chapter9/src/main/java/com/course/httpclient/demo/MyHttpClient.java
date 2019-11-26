package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        String result;
        HttpClient client=new DefaultHttpClient();
        HttpGet get=new HttpGet("http://baidu.com");
        HttpResponse response=client.execute(get);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

    }


}
