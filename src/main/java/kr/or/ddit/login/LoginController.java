package kr.or.ddit.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@WebServlet 혹은 web.xml url-mappring을 통해 url 획득, class로 서블릿을 만들어야 하는 이유
@RequestMapping("/login") 
//참조하는게 없기 때문에 Controller만 적어도 된다.
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	//url 매핑은 2가지 메소드, 
	
	//localhost/login/view  순서:클래스매핑 -> 메소드매핑
	@RequestMapping("/view.do")
	public String getView() {
		logger.debug("LoginController.getView()");
		//응답은 jsp그대로 사용 => spring에서는 관습적으로 WEB-INF에 저장 -> 사용자의 jsp접근을 막겠다.
		return "login/view";
	}

}
