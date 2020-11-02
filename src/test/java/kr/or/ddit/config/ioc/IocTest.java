package kr.or.ddit.config.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

public class IocTest {
	private static final Logger logger = LoggerFactory.getLogger(IocTest.class);
	public static void main(String[] args) {
		//스프링 빈 사용설명서를 사용하여 스프링 컨테이너를 생성
		//스프링 컨테이너로 : applicationContext
		//사용설명서 위치를 인자로 받는다
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:kr/or/ddit/config/spring/ioc/ioc.xml");
		
		
		//스프링 컨테이너로 부터 스프링 빈을 받아서 사용
		//컨테이너에게 원하는 스프링 빈을 요청 하여 받는 과정(DL : Dependency Lookup)
		//두번째 인자로 클래스정보를 입력
		BoardService boardService = context.getBean("boardService",BoardService.class);
		if(boardService.getBoardRepository() != null) {
			System.out.println("boardRepository is not null");
		}
		
		logger.debug("getBoard:{}",boardService.getBoard(1));
		
		//스프링빈 boardServiceC를 DL 하여 getBoard(1) 메서드를 call
		BoardServiceI boardServiceC = (BoardServiceI)context.getBean("boardServiceC");
		
		logger.debug("boardServiceC.getBoard(1):{}",boardServiceC.getBoard(1));
	}
}
