package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Log4j
@RestController
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class Demo {
    // 首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到的用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");//mysql.xml里的id
    }

    //新增用户
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加新用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        //需要用到model
       return template.insert("addUser",user);

    }
    //更新
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "更新用户",httpMethod = "POST")
    public int updateUser(@RequestBody User user){
       return template.update("updateUser",user);
    }

    //删除1
    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户",httpMethod = "DELETE")
    public int deleteUser(@RequestBody User user){
        return template.delete("deleteUser",user);
    }
    //删除 传一个参数，ID，唯一的标示。可以是其他的参数.请求方式也可以写成get
    @RequestMapping(value = "/delUser",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户",httpMethod = "DELETE")
    public int delUser(@RequestParam int id){
        return template.delete("deleteUser",id);


    }}
