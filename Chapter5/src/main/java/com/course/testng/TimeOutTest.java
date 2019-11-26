package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException{
        //3秒内没有响应超时。
        Thread.sleep(2000);
    }
    @Test(timeOut = 2000)
    //
    public void testFailed() throws InterruptedException{
        Thread.sleep(3000);
    }
}
