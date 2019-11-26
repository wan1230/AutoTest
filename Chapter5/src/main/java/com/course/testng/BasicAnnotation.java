package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase3(){
        System.out.println("这是测试用例3");
    }
    @Test
    public  void testCase1(){
        System.out.printf("testcase1:Thread ID :%s%n",Thread.currentThread().getId());
        System.out.println("这是测试用例1");

    }
    //可以单独运行测试用例2，在用例2上右击然后运行。
    @Test
    public void testcase2(){
        System.out.printf("testcas2:Thread ID :%s%n",Thread.currentThread().getId());
        System.out.println("这是测试用例2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before这是在测试方法之前运行的");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after这是在测试方式之后运行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是在类之前执行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类之后执行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");

    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }

}
