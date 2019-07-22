package com.cafe24.shope24.config.app.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shope24.repository", "com.cafe24.shope24.service", "com.cafe24.shope24.aspect"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {
	
}
