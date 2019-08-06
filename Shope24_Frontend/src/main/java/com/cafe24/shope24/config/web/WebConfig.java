package com.cafe24.shope24.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"com.cafe24.shope24.controller", "com.cafe24.shope24.exception", "com.cafe24.shope24.controller.api"})
@Import({MVCConfig.class, MessageConfig.class, FileuploadConfig.class})
public class WebConfig{
}
