package com.TISpjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.TISpjh.model.DataDto02;

@Configuration
public class RootAppContext {
	
	// 직접등록 (model 에 @Component 를 넣지 않아도 됨
	@Bean
	public DataDto02 dataDto02() {
		return new DataDto02();
	}
}
