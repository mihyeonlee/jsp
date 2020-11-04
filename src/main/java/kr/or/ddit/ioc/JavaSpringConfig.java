//package kr.or.ddit.ioc;
//
//import org.springframework.context.annotation.Bean;
//
//import kr.or.ddit.member.dao.MemberDao;
//import kr.or.ddit.member.dao.MemberDaoI;
//import kr.or.ddit.member.service.MemberService;
//import kr.or.ddit.member.service.MemberServiceI;
//
//public class JavaSpringConfig {
//	
//	//boardRepository, boardService
//	//메소드 이름 ==> 스프링 빈 이름
//	
//	//xml : <bean id="boardRepository(메소드이름)" class = "BoardRepository"/>
//	@Bean
//	public MemberDaoI memberDao() {
//		// 반복생성하지 않는다. 처음생성한것만 사용
//		return new MemberDao();
//	}
//
//	//xml : <bean id="boardService(메소드이름)" class = "boardService"/>
//	@Bean
//	public MemberServiceI memberService() {
//		MemberServiceI memberService = new MemberService();
//		memberService.
//		
//		return boardService;
//	}
//
//}
