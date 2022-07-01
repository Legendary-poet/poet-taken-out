package com.superpoet.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mp配置类
 */

@Configuration
public class MybatisPlusConfig {

    @Bean  //交给spring管理  如果不加这个注解，页面分页实现不了
    public MybatisPlusInterceptor mybatisPlusConfig1(){//不加1的话，显示这个名字已经注入过冲突，运行不了，而取消注解就无法实现分页
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
