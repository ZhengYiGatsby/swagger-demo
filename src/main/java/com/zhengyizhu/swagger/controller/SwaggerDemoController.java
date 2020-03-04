package com.zhengyizhu.swagger.controller;

import com.zhengyizhu.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
@Api(tags = "swagger学习")
@RestController
@RequestMapping("/swaggerdemo")
public class SwaggerDemoController {
    @GetMapping("returnHellow")
    public String returnHellow() {
        return "hellow";
    }
    @ApiOperation("返回用户实体接口（路径传参）")
    @PostMapping("returnUser")
    public User returnUser( @ApiParam("用户实体路径传参") User user){
        return user;
    }
    @ApiOperation("返回用户实体接口（json传参）")
    @PostMapping("returnUser1")
    public User returnUser1( @RequestBody @ApiParam("用户实体json传参") User user){
        return user;
    }
}
