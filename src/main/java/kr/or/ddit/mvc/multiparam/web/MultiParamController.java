package kr.or.ddit.mvc.multiparam.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/multi")
@Controller //컴포넌트 스캔에 의해 스캔대상이 되는 클래스가 되는것
public class MultiParamController {
	private static final Logger logger = LoggerFactory.getLogger(MultiParamController.class);
	//http://localhost/multi/view
	//복수개의 파라미터를 전송할 수 있는 화면을 요청
	@RequestMapping("/view")
	public String view() {
		return "multi/view"; //WEB-INF/views/multi/view.jsp
		
	}
	//복수개의 파라미터 전송을 처리하는 메소드
	//userid라는 이름의 파라미터로 복수개의 값이 전달됨
	@RequestMapping("/submit")
	public String submit(@RequestParam("userid") List<String> usersList, String[] userid) {
		logger.debug("userList : {} " , usersList );
		logger.debug("userArr : {}",(Object)userid);
		logger.debug("rangers");
		
		return "multi/view";
	}
}
