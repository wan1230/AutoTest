package com.course.cases;

import com.course.config.Testconfig;
import com.course.utils.DatabaseUtil;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserCase {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口测试")
    //👆，依赖登录成功
    public void addUser() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase =sqlSession.selectOne("addUserCase","1");
        System.out.printf(addUserCase.toString());
        System.out.println(Testconfig.addUserUrl);
    }
}
