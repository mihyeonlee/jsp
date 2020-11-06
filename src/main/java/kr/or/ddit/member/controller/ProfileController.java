package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.mvc.view.ProfileImgView;

@Controller
public class ProfileController {
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	@Resource(name = "memberService")
	private MemberServiceI memberService;

	@RequestMapping("/profileImgView")
	public String profileImgView(String userid, Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는것

		MemberVO memverVo = memberService.getMember(userid);
		model.addAttribute("filepath", memverVo.getFilename());

		return "profileImgView";
	}

	@RequestMapping("/profileImgDownloadView")
	public String profileImgDownloadView(String userid, Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는것

		MemberVO memberVo = memberService.getMember(userid);
		model.addAttribute("filepath", memberVo.getFilename());
		model.addAttribute("realFilename",memberVo.getRealfilename());

		return "profileImgDownloadView";
	}

	@RequestMapping("/profileImg")
	public void profileImg(String userid, HttpServletResponse response) throws IOException {

		// db에서 사용자 filename 확인
		MemberVO memberVo = memberService.getMember(userid);
		logger.debug("멤버:{}", memberVo);

		// response content-type 설정
		response.setContentType("application/octet-stream");
//		image/png
//		image/gif
//		image/jpg
//		response.addHeader(name, value); 이것도 사용가능

		if (memberVo.getFilename() != null) {
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

	@RequestMapping("/profileImgDownload")
	public void profileImgDownload(String userid, HttpServletResponse response) throws IOException {

		// db에서 사용자 filename 확인
		MemberVO memberVo = memberService.getMember(userid);
		logger.debug("멤버:{}", memberVo);

		// 경로 확인 후 파일 입출력을 통해 응답생성
		// 파일 읽기
		// 응답 생성 다운로드하기위한
		response.setHeader("Content-Disposition", "attachment; filename=\"" + memberVo.getRealfilename());

		// response content-type 설정
		response.setContentType("application/octet-stream");

		if (memberVo.getFilename() != null) {
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
