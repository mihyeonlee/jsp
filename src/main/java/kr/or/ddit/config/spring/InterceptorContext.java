package kr.or.ddit.config.spring;


import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kr.or.ddit.mvc.interceptor.PerformanceCheckInterceptor;
import kr.or.ddit.mvc.interceptor.SessionCheckInterceptor;

/*<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<!-- 추가를 해줘야함 inclued -->
		<!-- kr.or.ddit 패키지 하위의 클래스 중 @Controller 어노테이션이 붙은 클래스를 스캔하여 스프링 빈으로 생성 -->
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		<context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
	</context:component-scan>*/

//@Configuration
public class InterceptorContext extends WebMvcConfigurerAdapter{
	
	
/*interceptor 설정
	<mvc:interceptors>
		<mvc:interceptor>
			<mvc:mapping path="/**"/>
			<bean class="kr.or.ddit.mvc.interceptor.PerformanceCheckInterceptor"></bean>
		</mvc:interceptor>
		
		<mvc:interceptor>
			<mvc:mapping path="/**"/>
			<mvc:exclude-mapping path="/login/**"/>
			<mvc:exclude-mapping path="/js/**"/>
			<mvc:exclude-mapping path="/css/**"/>
			<mvc:exclude-mapping path="/resources/**"/>
			<bean class="kr.or.ddit.mvc.interceptor.SessionCheckInterceptor"></bean>
		</mvc:interceptor>
	</mvc:interceptors>*/
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new PerformanceCheckInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new SessionCheckInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/login/**","/js/**","/css/**","/resources/**");
	}
	

	
	
}
