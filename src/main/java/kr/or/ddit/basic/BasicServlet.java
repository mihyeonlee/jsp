package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 생성방법
// 1. HttpServlet 클래스를 상속한다
// 2. doXXX 메서드를 구현한다.
// 3. servlet은 정적 자료와 다르게 이름이 없다.
//	  localhost/ServletTest/index.html
//	  localhost/BasicServlet.java 매핑없이는 이렇게 접속할 수 없다.
//	  url - 서블릿 매핑하는 작업
//	  url의 이름을 직접 생성해줘야한다. (web.xml)
public class BasicServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8"); // 컨텐트타입은 정해져있는 부분
		//resp.setCharacterEncoding("utf-8"); 컨텐트타입을 지정안해주기 때문에 잘안된다. 컴이 알아서 해주기때문에 깨질수도 그리고 메모리많이 잡아먹음
		// writer 객체를 통해 html문서를 생성해준다.
		PrintWriter writer =  resp.getWriter();
		writer.println("<html>");
		writer.println("	<head></head>");
		writer.println("	<body>현재시간 : "+ new Date() +"</body>"); // 동적으로 시간이 변경되게 할꺼다.
		writer.println("</html>");
		writer.flush(); //닫기
		writer.close(); //닫기
	}
	
	
	
	
}
