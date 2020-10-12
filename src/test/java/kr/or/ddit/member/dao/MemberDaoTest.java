package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {

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
		assertEquals(answerMemberVO, memberVO);
		
	}
	
	@Test
	public void selectAllMemberTest() {
		
		/***Given***/
		MemberDao memberDao = new MemberDao();
		/***When***/
		List<MemberVO> memberList = memberDao.selectAllMember();
		
		/***Then***/
		assertEquals(5, memberList.size());
		// 첫번째 id값이 brown이어야한다
		assertEquals("brown", memberList.get(0).getUserid());
		
	}

}
