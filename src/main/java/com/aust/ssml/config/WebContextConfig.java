package com.aust.ssml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
// 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
// 并用于构建bean定义，初始化Spring容器。
@Configuration
@EnableWebMvc
@ComponentScan("com.aust.ssml.controller")

public class WebContextConfig implements WebMvcConfigurer {

    //配置JSP视图解析器
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver()       ;
        //设置url的前缀必须是pages
        viewResolver.setPrefix("/WEB-INF/views/");
        //设置视图格式必须是jsp后缀
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //静态资源不走控制器
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
