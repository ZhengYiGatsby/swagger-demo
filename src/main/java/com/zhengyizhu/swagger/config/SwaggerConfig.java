package com.zhengyizhu.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.TreeMap;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // Environment(org.springframework.core.env.Environment) 用于获取当前运行环境
    @Bean
    public Docket docket(Environment environment){
        // 规定一个项目运行的特殊环境（这里是在以dev或test结尾的application配置文件运行的环境下）
        // 这里就可以用于判断是否是生产环境来决定是否开启swagger
        Profiles profiles = Profiles.of("dev","test");
        //获取项目当前运行的环境，看是否和上面规定的环境一致（通过application.properties来看，看它选择是dev还是pro配置文件）
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //用于设置是否开启swagger
                .enable(flag)
                // 用于给swagger分组，达到个人管个人接口的目的
                .groupName("朱正义")
                .select()
                //RequestHandlerSelectors配置要扫描的接口的方式（basePackage-->按包扫描）
                //withClassAnnotation()/withMethodAnnotation()扫描类上/方法上的注解如withClassAnnotation(RestController.class)
                //这样类上有@RestController这个注解的类就会被扫描到
                .apis(RequestHandlerSelectors.basePackage("com.zhengyizhu.swagger.controller"))
                //过滤（如包下面再过滤出来一些包，只有过滤到的包才能被扫描到）如下就只会扫描到com.zhengyizhu.swagger下的controller包
                //待验证
                //.paths(PathSelectors.ant("/controller/**"))
                .build()
                ;
    }
    private ApiInfo apiInfo(){
        // 作者信息
       Contact contact = new Contact("zhuzhengyi", "www.zhengyizhu.com", "2627269927@qq.com");
        return new ApiInfo(
                //文档标题
                "Swagger学习demo",
                //文档描述
                "到后来才发现人生和自我都不是用来战胜的，是用来相处的   -- 少年派的奇幻漂流",
                "1433233.0",
                "www.zhengyizhu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
    }
    // 多个人协同开发则配置多个Dockt的Bean，用于分组自己管理自己的项目接口
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("猪猪侠");
    }
}
