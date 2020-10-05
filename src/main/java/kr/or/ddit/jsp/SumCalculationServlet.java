package kr.or.ddit.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * Servlet implementation class SumCalculationServlet
 */
@WebServlet("/sumCalculation")
public class SumCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SumCalculationServlet.class);
	//입력화면 요청처리(form.jsp)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/form.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int sumResult = 0;
		
		for(int i=start;i <=end;i++) {
			sumResult += i;
		}
		logger.debug("sumResult : {}",sumResult);
		
		request.getSession().setAttribute("sumResult", sumResult+"");
		request.getRequestDispatcher("jsp/sumResult.jsp").forward(request, response);
		
	}

}
