package com.aust.ssml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
// 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
// 并用于构建bean定义，初始化Spring容器。
@Configuration
@ComponentScan("com.aust.ssml.service")
@ComponentScan("com.aust.ssml.mapper")
@Import(MybatisConfig.class)

//事务管理注解，开启事务支持后，然后在访问数据库的service方法上添加注释@Transactional便可
//等同于xml配置文件中的 <tx:annotation-driven />
@EnableTransactionManagement

//该注解默认会扫描该类所在的包下所有的配置类，相当于之前的 <context:component-scan>。
@ComponentScan("com.aust.ssml.service")
public class RootContextConfig {
    /*
     * 配置事务管理
     * */
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }
}
