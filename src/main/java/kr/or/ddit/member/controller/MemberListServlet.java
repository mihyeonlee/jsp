package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
   
	@Override
		public void init() throws ServletException {
			memberService = new MemberService();
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//page															jsp에서 page 받아오기
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		// jsp에서 현재페이지정보를 알기위해서 저장
		request.setAttribute("page", page);
		
		//pageSize
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str == null ? 7: Integer.parseInt(pageSize_str);
		request.setAttribute("pageSize", pageSize);
		
		//pageVO                     									페이지 vo객체를 만들어 Service에 전송
		PageVO pageVO = new PageVO(page, pageSize);
		
		//서비스호출, 결과저장
		Map<String, Object> map = memberService.getPageMember(pageVO);
		request.setAttribute("memberList", map.get("memberList"));
		request.setAttribute("pages", map.get("pages"));
		
		//jsp에 던지기
		request.getRequestDispatcher(request.getContextPath()+"member/memberList.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
}
