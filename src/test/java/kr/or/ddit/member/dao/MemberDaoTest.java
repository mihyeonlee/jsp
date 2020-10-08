package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {

	@Test
	public void test() {
		
		/***Given***/
		MemberDao memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserId("brown");
		answerMemberVO.setPassword("passBrown");
		
		/***When***/
		MemberVO memberVO = memberDao.getMember(userId);

		/***Then***/
		assertEquals("brown", memberVO.getUserId());
		assertEquals("passBrown", memberVO.getPassword());
		
		//결과가 실패인이유 
		assertEquals(answerMemberVO, memberVO);
		
	}

}
