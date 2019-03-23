package com.daisihao.app;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.daisihao"})
public class Application extends WebMvcConfigurerAdapter {

    //在springBoot中使用fastjson的第一种方式，在启动类继承WebMvcConfigurerAdapter，然后重写其中的configureMessageConverters方法
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建FastJson的消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //创建FastJson的配置对象
        FastJsonConfig config = new FastJsonConfig();
        //配置返回json格式化
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //将配置传给转换器
        converter.setFastJsonConfig(config);
        converters.add(converter);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
