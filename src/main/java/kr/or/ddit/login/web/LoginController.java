package kr.or.ddit.login.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;

//@WebServlet 혹은 web.xml url-mappring을 통해 url 획득, class로 서블릿을 만들어야 하는 이유
//참조하는게 없기 때문에 Controller만 적어도 된다.
@SessionAttributes("rangers")
@RequestMapping("/login") 
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@ModelAttribute("rangers")
	public List<String> ranger(){
		logger.debug("ranger()");
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		
		return rangers;
	}
	
	//localhost/login/mavView
	@RequestMapping("/mavView")
	public ModelAndView mavView(@ModelAttribute("rangers") List<String> rangers,
			@ModelAttribute("test") MemberVO memberVO) {
		ModelAndView mav = new ModelAndView();
		logger.debug("mavView rangers:{}",rangers);
		//view name 설정
		mav.setViewName("main");
		
		mav.getModel().put("msg", "success");
		mav.getModelMap().addAttribute("msg","fail");
		
		return mav;
	}
	
	// localhost/login/view  순서:클래스매핑 -> 메소드매핑
	// 요청 메소드가 GET일 때만 처리 method = RequestMethod.GET **복수 처리가능 method = {RequestMethod.GET,RequestMethod.POST}
	@RequestMapping(path="/view",method = RequestMethod.GET)
	@GetMapping()
	public String getView() {
		logger.debug("LoginController.getView()");
		
		//응답은 jsp그대로 사용 => spring에서는 관습적으로 WEB-INF에 저장 -> 사용자의 jsp접근을 막겠다.
		return "login/view";
	}
	
	//파라미터이름(name)과 동일한 메소드 인자를 선언하면
	//스프링 프레임워크가 자동으로 바인딩 해준다.
	//값을 담을 수 있는 객체를 메소드 인자로 선언한 경우에도 필드명과 파라미터 명이 동일하면 자동으로 바인딩 처리를 해준다
	//이때 값을 담는 객체(form전송 data)를 스프링 프레임워크에서는 command객체라고 명명한다.  HttpSession객체도 인자 가능
	
	//Model: view객체에서 응답을 생성할 때 참조할 데이터를 담는 객체 
	//		 jsp/servlet 기반의 request 역할을 담당 HttpServletRequest객체에 담아도 되지만 특정뷰에서 처리를 못하는경우도 있기때문에 그렇게 쓰지 않는다.
	
	@RequestMapping(path="/process", params = {"userid"})
	public String process(String userid, String pass, MemberVO memberVO, HttpSession session, Model model, 
						@RequestParam(name="email", 
									required=false, 
									defaultValue = "brown@line.kr") String user_id) {
		
		logger.debug("LoginController.process() {}/{}/{}",userid,pass,memberVO);
		logger.debug("user_id:{}",user_id);
		MemberVO memberVo = memberService.getMember(userid);
		logger.debug("memberVo:{}",memberVo);
		
		//db에서 조회한 사용자 정보가 존재하면 main.jsp
		//존재하지 않으면 login.jsp로 이동  prefix : /WEB-INF/views/
		if(memberVo != null && memberVO.getPass().equals(memberVo.getPass())) {
			session.setAttribute("S_MEMBER", memberVo);
			model.addAttribute("to_day", new Date());
			//jsp/servlet 기반에서 사용한 코드 : request.setAttribute("to_day", new Date());
			return "main";
		}else {
			model.addAttribute("msg","fail");
			return "login/view";
		}
		
	}
	
	//localhost/login/unt/dd
	@RequestMapping("/unt/{unt_cd}")
	public String untMain(@PathVariable("unt_cd") String unt_cd) {
		logger.debug("unt_cd : {}", unt_cd );
		return "main";
	}
	
	

}
