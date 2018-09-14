package com.sg.common.config.resources;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 添加自定义的资源目录
     * 将/myResource/* 映射到 classpath:/myResource/*目录
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myResource/**").addResourceLocations("classpath:/myResource/");
        super.addResourceHandlers(registry);
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //spring.view.prefix=/WEB-INF/jsp/
        //spring.view.suffix=.jsp
        registry.jsp("/WEB-INF/views/", ".jsp");
        //registry.freeMarker();
        //registry.velocity();
        //registry.groovy();
    }
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .useJaf(false)
                .defaultContentType(MediaType.APPLICATION_JSON);
    }
}
