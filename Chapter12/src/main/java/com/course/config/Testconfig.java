package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class Testconfig {
    public static String loginUrl;
    public static String addUserUrl;
    public static String getUserInfoUrl;
    public static String getUserListUrl;
    public static String updateUserInfoUrl;
//注意导的包
    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore store;
}
