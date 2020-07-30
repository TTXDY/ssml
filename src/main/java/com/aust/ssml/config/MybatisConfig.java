package com.aust.ssml.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Import(DataSourceConfig.class)
public class MybatisConfig {

    private static Resource[] resolveMapperLocations() {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<String> mapperLocations = new ArrayList<>();
        //名字为Mapper.xml结尾的接口映射文件
        mapperLocations.add("classpath:mapper/*Mapper.xml");
        List<Resource> resources = new ArrayList();
        if (mapperLocations != null) {
            for (String mapperLocation : mapperLocations) {
                try {
                    Resource[] mappers = resourceResolver.getResources(mapperLocation);
                    resources.addAll(Arrays.asList(mappers));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resources.toArray(new Resource[resources.size()]);
    }

    @Bean
    public static SqlSessionFactoryBean sessionFactoryBean(DataSource dataSource){ // 参数起到注入的效果
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(resolveMapperLocations());
        return factoryBean;
    }

    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sessionFactoryBean");
        configurer.setBasePackage("com.aust.ssml.mapper");
        return configurer;
    }
}