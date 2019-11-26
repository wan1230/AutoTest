package com.course.cases;

import com.course.config.Testconfig;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoTest {


    @Test(dependsOnGroups = "loginTrue",description = " 获取性别为男的用户信息")
    public void getUserInfo() throws IOException {
        SqlSession sqlSession= DatabaseUtil.getSqlSession();
        GetUserInfoTest getUserInfoTest =sqlSession.selectOne("getUserInfoCase","1");
        System.out.println(getUserInfoTest.toString());
        System.out.println(Testconfig.getUserInfoUrl);
    }
}
