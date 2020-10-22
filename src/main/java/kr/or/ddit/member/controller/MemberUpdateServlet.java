package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);
	MemberServiceI memberService;
    @Override
    	public void init() throws ServletException {
    		memberService = new MemberService();
    	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO memberVo =  memberService.getMember(request.getParameter("userid"));
		logger.debug("memberVo : {}",memberVo);
		
		request.setAttribute("memberVo", memberVo);
		
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		
		logger.debug("parameter : {},{},{},{},{},{},{}", userid, usernm, alias, pass, addr1, addr2, zipcode);
		Part profile = request.getPart("realFilename");
		logger.debug("file : {}", profile.getHeader("Content-Disposition"));
		
		String filename=null;
		String filePath=null;
		String realfilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		String extension = FileUploadUtil.getExtension(realfilename);
		
		if(profile.getSize() > 0) {
			logger.debug("사이즈가 영보다 크다.");
			filename = UUID.randomUUID().toString();
			filePath = "D:\\profile\\" + filename + "." + extension;
			profile.write(filePath);
		}else {
			logger.debug("사이즈가 영보다 작다");
			realfilename = null;
		}
		
		//사용자 정보 등록
		MemberVO memberVo = new MemberVO(userid, pass, alias, usernm, addr1, addr2, zipcode, filePath, realfilename);
		int cnt = memberService.updateMember(memberVo);
		logger.debug("memberVo, cnt:{},{}",memberVo,cnt);
		
		if(cnt ==1) {
			response.sendRedirect(request.getContextPath()+"/member?userid="+userid);
		}
		
		
		
		
		
		
		
	}

}
