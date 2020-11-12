package kr.or.ddit.config.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

//<context:property-placeholder location="classpath:kr/or/ddit/config/db/db.properties"/>
// ${key} => key
@PropertySource("classpath:kr/or/ddit/config/db/db.properties")
@Configuration
public class DataSourceContext {
	@Autowired
	private Environment env;
	
	/*<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
	 	<property name="url" value="${jdbc.url}"/>  => set
	 	<property name="driverClassName" value="${jdbc.driver}"/>
	 	<property name="username" value="${jdbc.username}"/>
	 	<property name="password" value="${jdbc.password}"/>
	 </bean>
	 */
	// <bean> 빈 엘레먼트는 => @Bean 빈 어노테이션으로 변경한다. 메소드명이 id 이다.
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	/* SqlSessionFactoryBean.getObject() 메소드가 호출된다.
	 * <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
	 	<property name="configLocation" value="classpath:kr/or/ddit/config/db/mybatis-config.xml"/>
	 	<property name="dataSource" ref="dataSource"/>
	 </bean>
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		factoryBean.setConfigLocation(new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xml"));
		factoryBean.setDataSource(dataSource()); //다른 스프링빈을 호출하는건 해당메소드이름 쓰면된다.
		
		return factoryBean.getObject();
	}
	
	/*<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
	 	<!-- 만들지 않으면 기본생성자없다는 오류가남 -->
	 	<constructor-arg ref="sqlSessionFactoryBean"/>
	 
	 SqlSessionTemplate()는 인자로 SqlSessionFactory를 받으니 sqlSessionFactoryBean으로 반환타입을 설정하면 오류가남 그래서 
	 sqlSessionFactoryBean()메소드의 반환타입을 SqlSessionFactory로 바꿔준다.
	 
	 </bean>*/
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean());
		
		return sqlSessionTemplate;
	}
	
	/*<bean class="org.springframework.web.servlet.view.tiles3.TilesViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"></property>
		<property name="order" value="0"></property>
	</bean>*/
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		tilesViewResolver.setOrder(0);
		
		return tilesViewResolver;
	}
	
	/*<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="order" value="2"/>	 
		<property name="prefix" value="/WEB-INF/views/"/>
		<property name="suffix" value=".jsp"/>
	</bean>*/
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
	
	

}
