package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: linxueqin
 * @Description: Swagger2配置类
 * @date: Created on 2018/11/21 11:04
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build();
    }
    
    /**
     * @Description 创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * @Date 2018/11/21 11:18
     * @Param []
     * @return springfox.documentation.service.ApiInfo
     **/
    private ApiInfo apiInfo() {
        /*
         * select()函数返回一个ApiSelectorBuilder
         * 实例用来控制哪些接口暴露给Swagger来展现，
         * 本例采用指定扫描的包路径来定义，Swagger
         * 会扫描该包下所有Controller定义的API，
         * 并产生文档内容（除了被@ApiIgnore指定的请求）。
         **/
        return new ApiInfoBuilder()
                .title("Swagger2构建RESTful APIs")
                .description("今天心情美美哒 http://com.example.demo/")
                .termsOfServiceUrl("http://com.example.demo/")
                .contact("linxq")
                .version("1.0")
                .build();
    }
}
