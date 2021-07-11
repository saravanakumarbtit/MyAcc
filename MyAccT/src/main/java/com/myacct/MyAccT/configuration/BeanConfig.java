package com.myacct.MyAccT.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myacct.MyAccT.service.MyAccTService;
import com.myacct.MyAccT.service.MyAccTServiceImpl;

@Configuration
public class BeanConfig {

	@Bean
	public MyAccTService myacctservice() {
		return new MyAccTServiceImpl();
		
	}
}
