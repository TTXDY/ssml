package com.aust.ssml.config;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/aust?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("a363150821");
        return dataSource;
    }
}

