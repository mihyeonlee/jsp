package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberDaoTest.class);
	/*테스트 메소드 실행 사이클: 
	  @BeforeClass (클래스실행될때 딱한번 초기화)
			@Before => @Test => @After
			@Before => @Test => @After
			@Before => @Test => @After
	  @AfterClass (static으로 해야해서 잘사용안함)
	 */
	MemberDaoI memberDao;
	
	@Before
	public void setup() {
		/***Given***/
		memberDao = new MemberDao();
//		String userid = "lmh";
		
//		memberDao.deleteMember(userid);
	}
	
	
	@Test
	public void getMemberTest() {
		
		/***Given***/
		String userid = "brown";
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserid("brown");
		answerMemberVO.setPass("brownPass");
		
		/***When***/
		MemberVO memberVO = memberDao.getMember(userid);

		/***Then***/
//		assertEquals("brown", memberVO.getUserId());
//		assertEquals("brownPass", memberVO.getPassword());
		
		//결과가 실패인이유 
		assertEquals(answerMemberVO.getUserid(), memberVO.getUserid());
		
	}
	
	@Test
	public void selectAllMemberTest() {
		
		/***Given***/
		/***When***/
		List<MemberVO> memberList = memberDao.selectAllMember();
		
		/***Then***/
		assertEquals(15, memberList.size());
		// 첫번째 id값이 brown이어야한다
//		assertEquals("brown", memberList.get(0).getUserid());
		
	}
	
	@Test
	public void getPageMemberTest() {
		
		/***Given***/
		PageVO pageVO = new PageVO(1,7);
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		//int page = 1;
		
		/***When***/
		List<MemberVO> memberList = memberDao.getPageMember(sqlSession,pageVO);
		
		/***Then***/
		assertEquals(7, memberList.size());
		
		
	}
	
	@Test
	public void getMemberTotalCnt() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		/***When***/
		int totalCnt = memberDao.getMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15, totalCnt);
	}
	
	@Test
	public void test() {
		/***Given***/
		
		/***When***/
		logger.debug("{}",Math.ceil(15d/7));
		
		/***Then***/
	}
	
	@Test
	public void insertMembertest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		MemberVO memberVo = new MemberVO("lmh","pass1234","pc-03","이미현","대전 중구 중앙로 76","영민빌딩 4층 404호","34904","d:\\profile\\lmh.png","lmh.png");
		/***When***/
		int insertCnt = memberDao.insertMember(memberVo);
		
		/***Then***/
		assertEquals(1,insertCnt);
	}
	@Test
	public void updateMembertest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		MemberVO memberVo = new MemberVO("lmh","pass1234","미밍","이미현","대전 중구 중앙로 76","영민빌딩 4층 404호","34904",null,null);
		/***When***/
		int updateCnt = memberDao.updateMember(memberVo);
		
		/***Then***/
		assertEquals(1,updateCnt);
	}

}
