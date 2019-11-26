package com.course.cases;

import com.course.config.Testconfig;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserListTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取用户列表")
    public void getUserList() throws IOException {
        SqlSession sqlSession= DatabaseUtil.getSqlSession();
        GetUserListTest getUserListTest=sqlSession.selectOne("getUserListCase","1");
        System.out.println(getUserListTest.toString());
        System.out.println(Testconfig.getUserListUrl);
    }
}
