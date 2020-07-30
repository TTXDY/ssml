package com.aust.ssml.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
1.会在tomcat启动时，被执行
2.通过扩展AbstractAnnotationConfigDispatcherServletInitializer抽象类，可以将DispatcherServlet和Spring
应用上下文配置到Servlet容器中
 */
/*
这个类用于在web容器启动的时候创建对象，调用方法来初始化容器以及前段控制器。
 */
public class SpringWebmvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

//  @Override下面的方法名是否是你父类中所有的，如果没有则报错
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootContextConfig.class};
    }

    //指定配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebContextConfig.class};
    }

    /*
    DispatcherServlet启动的时候创建的上下文（上下文一）
    在创建这个上下文的时候会加载配置文件或配置类中声明的bean，getServletConfigClasses返回的配置类
    （如案例中的WebContextConfig类）中配置的bean会在这个时候被加载到该上下文中
     */

    //将DispatchedServlet映射到“/”
    @Override
    protected String[] getServletMappings() {//何种请求会被DispatcherServlet拦截
        return new String[]{"/"};
    }
}
