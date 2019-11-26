package com.course.cases;

import com.course.config.Testconfig;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "更改用户信息")
    public void updateUserInfo() throws IOException {
        SqlSession sqlSession= DatabaseUtil.getSqlSession();
        UpdateUserInfoTest updateUserInfoTest = sqlSession.selectOne("updateUserInfoCase","1");
        System.out.println(updateUserInfoTest.toString());
        System.out.println(Testconfig.updateUserInfoUrl);
    }
    @Test(dependsOnGroups = "loginTrue",description = "删除用户")
    public void deleteUser() throws IOException {

        SqlSession sqlSession= DatabaseUtil.getSqlSession();
        UpdateUserInfoTest updateUserInfoTest = sqlSession.selectOne("updateUserInfoCase","2");
        System.out.println(updateUserInfoTest.toString());
        System.out.println(Testconfig.updateUserInfoUrl);
    }
}
