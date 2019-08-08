package com.cafe24.shope24.config.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shope24.repository", "com.cafe24.shope24.service", "com.cafe24.shope24.aspect"})
@Import({AppSecurityConfig.class})
public class AppConfig {
	
}
