package com.example.jpatutorials.config;

/**
 * 定制servlet容器
 */
//@Component   implements EmbeddedServletContainerCustomizer
public class CustomizationBean {

  /*    *//**
   * 定制方法一：实现EmbeddedServletContainerCustomizer
   * @param container
   *//*
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        //container.setPort(9000);
    }

    *//**
   * 定制方法二：注入EmbeddedServletContainerFactory
   * @return
   *//*
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(9001);
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        //优先级高于配置在/static/error文件夹里面的404.html页面
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/403.html"));
        return factory;
    }*/
}
