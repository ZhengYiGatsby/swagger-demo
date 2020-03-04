# Swagger

## 接口文档工具，使接口文档可以自动同步更新，同时还可以对接口进行测试

## 使用

### SpringBoot配置

- 导入依赖：一个核心依赖，一个UI界面

	- 新建Swageer配置类

		- 两个注解

			- @Configuration:用于被Spring发现
			- @EnableSwagger2:用于开启Swagger2

		- 一个Bean-->Docket：用于配置Swager2

### 访问：ip/端口号/swagger-ui.html

- swagger-ui.html页面在swagger-ui这个jar包里面可以找到

### 注意

- 多人开发只需复制Swagger配置类里面的Docket这个Bean，在修改参数就行
- 正式项目中，发布项目时一定要关闭Swagger，以防接口暴露。可以通过org.springframework.core.env.Environment
这个类来监听，具体操作请看代码。

## 学习Swagger2的视频网址

### 自己学习做的项目（github）

