package com.cafe24.shope24.config.web.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan({"com.cafe24.shope24.controller", "com.cafe24.shope24.exception", "com.cafe24.shope24.controller.api"})
@Import({MVCConfig.class, /*SecurityConfig.class,*/ MessageConfig.class, FileuploadConfig.class, SwaggerConfig.class})
public class WebConfig{
}
