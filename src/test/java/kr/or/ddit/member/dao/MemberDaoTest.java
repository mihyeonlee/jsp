package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberDaoTest.class);
	@Test
	public void getMemberTest() {
		
		/***Given***/
		MemberDao memberDao = new MemberDao();
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
		MemberDao memberDao = new MemberDao();
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
		MemberDao memberDao = new MemberDao();
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
		MemberDao memberDao = new MemberDao();
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

}
