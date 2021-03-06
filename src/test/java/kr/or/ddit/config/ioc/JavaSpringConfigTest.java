package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardServiceI;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JavaSpringConfig.class})
public class JavaSpringConfigTest {
	
	@Resource(name="boardRepository")
	private BoardRepositoryI boardRepository;
	
	@Resource(name="boardService")
	private BoardServiceI boardService;
	//
	@Test
	public void beanTest() {
		/***Given***/

		
		/***When***/
		BoardVo boardVo = boardService.getBoard(1);
		/***Then***/
		assertNotNull(boardService);
		assertNotNull(boardRepository);
		assertEquals("내용", boardVo.getContent());
	}

}
