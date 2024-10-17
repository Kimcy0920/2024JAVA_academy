package config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Bean
//	public HandlerMapping handlerMapping() {
//		RequestMappingHandlerMapping hm = new RequestMappingHandlerMapping(); // 컨트롤러 매핑
//		hm.setOrder(0);
//		return hm;
//	}

//	@Bean
//	public HandlerAdapter handlerAdapter() {
//		RequestMappingHandlerAdapter ha = new RequestMappingHandlerAdapter(); // 컨트롤러 검색
//		return ha;
//	}

//  WebMvcConfigurer 인터페이스를 사용하면 아래 두 코드를 사용하지 않아도 됨.
//	@Bean
//	public HandlerMapping simpleHandlerMapping() {
//		SimpleUrlHandlerMapping hm = new SimpleUrlHandlerMapping();
//		Map<String, Object> pathMap = new HashMap<>();
//		pathMap.put("/**", defaultServletHandler());
//		hm.setUrlMap(pathMap);
//		return hm;
//	}

//	@Bean
//	public HttpRequestHandler defaultServletHandler() {
//		DefaultServletHttpRequestHandler handler = new DefaultServletHttpRequestHandler(); // 객체 생성 시 서블릿 역할을 함.
//		return handler;
//	}

//	@Bean
//	public HandlerAdapter requestHandlerAdapter() {
//		HttpRequestHandlerAdapter ha = new HttpRequestHandlerAdapter();
//		return ha;
//	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		return vr;
	}

}
