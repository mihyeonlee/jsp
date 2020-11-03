package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.Bean;

import kr.or.ddit.board.repository.BoardRepository;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

public class JavaSpringScanConfig {
	
	//boardRepository, boardService
	//메소드 이름 ==> 스프링 빈 이름
	
	//xml : <bean id="boardRepository(메소드이름)" class = "BoardRepository"/>
	@Bean
	public BoardRepositoryI boardRepository() {
		// 반복생성하지 않는다. 처음생성한것만 사용
		return new BoardRepository();
	}

	//xml : <bean id="boardService(메소드이름)" class = "boardService"/>
	@Bean
	public BoardServiceI boardService() {
		BoardService boardService = new BoardService();
		boardService.setBoardRepository(boardRepository());
		//아래와같이 직접 new연산자를 통해 생성한 객체는 스프링빈이 아니다
		//@Bean 어노테이션이 붙은 메서드를 호출해야 스프링 컨테이너에서 관리되는 스프링빈을 얻을 수 있다.
		//boardService.setBoardRepository(new BoardRepository());
		
		return boardService;
	}

}
