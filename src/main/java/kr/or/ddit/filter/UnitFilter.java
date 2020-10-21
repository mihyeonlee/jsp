package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


//@WebFilter("/*")
public class UnitFilter implements Filter {
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//새로운 request 객체를 생성  (ServletRequest이기 때문에 HttpServletRequest 로 형변환해줘야한다.)
		UnitHttpServletRequestWrapper req = 
				new UnitHttpServletRequestWrapper((HttpServletRequest)request);
		//UNT_CD 파라미터를 새롭게 추가 
		//url에 UNT_CD=***  넣으면 ***로 설정된다.
		req.setUnit();
		
		//(톰캣이 만든) request대신 (우리가 만든) req를 넣으면 된다.
		chain.doFilter(req, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
