package kr.or.ddit.config.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;


import kr.or.ddit.mvc.view.ExcelDownloadView;
import kr.or.ddit.mvc.view.ProfileImgDownloadView;
import kr.or.ddit.mvc.view.ProfileImgView;

/*<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<!-- 추가를 해줘야함 inclued -->
		<!-- kr.or.ddit 패키지 하위의 클래스 중 @Controller 어노테이션이 붙은 클래스를 스캔하여 스프링 빈으로 생성 -->
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		<context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
	</context:component-scan>*/

@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"},useDefaultFilters = false,
								includeFilters = {@Filter(type=FilterType.ANNOTATION,classes = {Controller.class,ControllerAdvice.class})})
//<mvc:annotation-driven/>
@EnableWebMvc
public class ApplicationContext extends WebMvcConfigurerAdapter{
	
	//<mvc:default-servlet-handler/> => extends 한다 (WebMvcConfigurerAdapter)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/*<bean id="profileImgDownloadView" class="kr.or.ddit.mvc.view.ProfileImgDownloadView"/>
	<bean id="profileImgView" class="kr.or.ddit.mvc.view.ProfileImgView"/>
	<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
	<bean id="excelView" class="kr.or.ddit.mvc.view.ExcelDownloadView"/>*/
	
	@Bean
	public ProfileImgDownloadView profileImgDownloadView() {
		return new ProfileImgDownloadView();
	}
	@Bean
	public ProfileImgView profileImgView() {
		return new ProfileImgView();
	}
	@Bean
	public MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView();
	}
	@Bean
	public ExcelDownloadView excelView() {
		return new ExcelDownloadView();
	}
	
	/*	<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<property name="order" value="1"/>
		</bean>
	*/
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		beanNameViewResolver.setOrder(1);
		return beanNameViewResolver;
	}
	
	/*<bean id="titlesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>classpath:kr/or/ddit/config/tiles/tiles-definition.xml</value>
			</list>
		</property>
	</bean> */
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("classpath:kr/or/ddit/config/tiles/tiles-definition.xml");
		return tilesConfigurer;
	}
	
//	<bean id ="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"></bean>
	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {
		return new CommonsMultipartResolver();
	}
	
//	<bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver"/>
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	/*<mvc:interceptors>
	 	<mvc:interceptor>
	 		<mvc:mapping path="/**"/>
	 		<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
	 			<property name="paramName" value="lang"/>
	 		</bean>
	 	</mvc:interceptor>
	 </mvc:interceptors>*/
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("lang");
		
		registry.addInterceptor(changeInterceptor).addPathPatterns("/**");
	}
	
//	<mvc:resources mapping="/resources/**" location="/WEB-INF/views/error/" />
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/views/error/");
		
	}
	
	
}
