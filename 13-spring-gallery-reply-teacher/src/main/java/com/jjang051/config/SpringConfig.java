package com.jjang051.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// web.xml
public class SpringConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	//프로젝트에 사용할 Beans 정의하기 위한 class지정
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	// 한글 깨짐 방지....
	@Override
	protected Filter[]  getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
	//파일업로드 세팅....
	protected void customizeRegistration(Dynamic registration) {
		//null  절대경로,maxFileSize(파일 하나당 업로드 용량),maxRequestSize 여러개가 전달될때 처리할 수 있는 사이즈,임시 파일로 저장할 수 있는 사이즈
		MultipartConfigElement config = new MultipartConfigElement(null,1024*1024*100,1024*1024*1000,0);
		registration.setMultipartConfig(config);
	}
}





