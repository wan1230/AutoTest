package com.course.cases;

import com.course.config.Testconfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备，获取httpclient")
    public void beforeTest(){
        //给Testconfig 里定义的变量赋值
        Testconfig.getUserInfoUrl= ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        Testconfig.addUserUrl=ConfigFile.getUrl(InterfaceName.ADDUSER);
        Testconfig.getUserListUrl=ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        Testconfig.loginUrl=ConfigFile.getUrl(InterfaceName.LOGIN);
        Testconfig.updateUserInfoUrl=ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        //httpclient
        Testconfig.defaultHttpClient=new DefaultHttpClient();


    }
    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        //👇，取第一条数据
        LoginCase loginCase=session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(Testconfig.loginUrl);

    }

    @Test(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        //取第二条数据
        LoginCase loginCase=session.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(Testconfig.loginUrl);
    }



}
