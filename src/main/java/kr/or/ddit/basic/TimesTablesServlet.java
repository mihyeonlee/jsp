package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// write객체를 통해 html 작성 
		PrintWriter writer = resp.getWriter();
		// println으로 html 작성
		writer.println("<html>");
		writer.println(" <head></head>");
		writer.println(" <body>");
		writer.println(" 	<table border='1'>");
		//
		for(int i=1;i<10;i++) {
			writer.println("<tr>");
			for(int j=2;j<10;j++) {
			writer.println("<td>"+j+" * "+i+" = "+(i*j)+"</td>");
			}
			writer.println("</tr>");
		}
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
		writer.flush();
		writer.close();
		
		
	}
	
}
