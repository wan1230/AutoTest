package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    // 读application配置，后缀名不需要带着。
    //工具类一般命名为静态方法

    private static ResourceBundle bundle =ResourceBundle.getBundle("application", Locale.CHINA);
    public static String getUrl(InterfaceName name){
        //只能interface name 定义的接口才能传进来
        String address = bundle.getString("test.url");
        String uri = "";
        //testUrl=address+uri，拼接成最后的访问路径。
        String testUrl ;
        if(name == InterfaceName.GETUSERLIST){
            uri=bundle.getString("getUserList.uri");
        }
        if(name == InterfaceName.LOGIN){
            uri=bundle.getString("login.uri");
        }
        if(name == InterfaceName.ADDUSER){
            uri=bundle.getString("addUser.uri");
        }

        if(name == InterfaceName.GETUSERINFO){
            uri=bundle.getString("getUserInfo.uri");
        }

        if(name == InterfaceName.UPDATEUSERINFO){
            uri=bundle.getString("updateUserInfo.uri");
        }

        testUrl = address+uri;
        return testUrl ;
    }
}
