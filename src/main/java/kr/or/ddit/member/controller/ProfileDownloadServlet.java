package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profileDownload")
public class ProfileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
	private static final Logger logger = LoggerFactory.getLogger(ProfileDownloadServlet.class);

	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		// 사용자 아이디 파라미터 확인
		String userid = request.getParameter("userid");
		
		// db에서 사용자 filename 확인
		MemberVO memberVo = memberService.getMember(userid);
		logger.debug("멤버:{}",memberVo);
		
		// 경로 확인 후 파일 입출력을 통해 응답생성
		// 파일 읽기
		// 응답 생성
		// response content-type 설정
		response.setHeader("Content-Disposition","attachment; filename=\"" + memberVo.getRealfilename());
		response.setContentType("application/octet-stream"); 
//		image/png
//		image/gif
//		image/jpg
//		response.addHeader(name, value); 이것도 사용가능
		
		if(memberVo.getFilename()!=null) {
			FileInputStream fis = new FileInputStream(memberVo.getFilename());// 파일 경로 읽기
			ServletOutputStream sos = response.getOutputStream();
			
			byte[] buffer = new byte[512];
			
			while (fis.read(buffer) != -1) {
				sos.write(buffer);
			}
			fis.close();
			sos.flush();
			sos.close();
		}


	}

}
