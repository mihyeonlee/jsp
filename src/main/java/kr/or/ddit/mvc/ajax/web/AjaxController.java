package kr.or.ddit.mvc.ajax.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.member.model.MemberVO;

@Controller
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@RequestMapping("/ajax/view")
	public String view() {
		return "ajax/view";//jsp
	}
	
	// consume, produce
	// consumes : 사용자가 보내는 contentType을 제한
	// produces : 사용자가 응답 받기 희망(Accept header, jquery - dataType)하는 mimeType을 제한  
	//                                            나는 xml만 처리할 수 있다.
	@ResponseBody
	@RequestMapping(path="/ajax/json",
					consumes = {"application/json"},
					produces = {"application/xml","application/json"})
	public MemberVO json(@RequestBody MemberVO memberVO) {
		logger.debug("body:{}",memberVO);
		memberVO.setAlias("곰");
		return memberVO;
	}
	
}
