package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.ResourceBundle;

public class DatabaseUtil {
  public static SqlSession getSqlSession() throws IOException {
      //获取配置的资源文件,留意resources 导入的包是org.apache.ibatis下的
      Reader reader=Resources.getResourceAsReader("databaseConfig.xml");

      SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
    //sqlSession就是能够执行配置文件中的sql语句。
      SqlSession sqlSession = factory.openSession();


      return sqlSession;
  }
}
