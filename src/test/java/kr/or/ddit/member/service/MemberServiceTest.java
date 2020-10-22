package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.extensions.TestSetup;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	MemberServiceI memberService;
	@Before
	public void setup() {
		memberService = new MemberService();
		String userid = "lmh";
		memberService.deleteMember(userid);
	}
	
	@Test
	public void test() {
		/***Given***/
		String userId = "brown";
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserid("brown");
		answerMemberVO.setPass("brownPass");
		
		/***When***/
		MemberVO memberVO = memberService.getMember(userId);

		/***Then***/
//		assertEquals("brown", memberVO.getUserid());
//		assertEquals("brownPass", memberVO.getPass());
		
		//결과가 실패인이유 
		assertEquals(answerMemberVO.getUserid(), memberVO.getUserid());
	}
	
	@Test
	public void getPageMemberTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1,7);
		
		/***When***/
		Map<String, Object> map = memberService.getPageMember(pageVO);
		List<MemberVO> memberList =  (List<MemberVO>)map.get("memberList");
		
		//생성해야할 page수
		int pages = (int)map.get("pages");
		/***Then***/
		assertEquals(7, memberList.size());
		assertEquals(3, pages);
	}
	
	@Test
	public void localeListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		
		for(Locale locale : locales) {
			logger.debug(locale.toString());
		}
	}
	
	@Test
	public void insertMembertest() {
		/***Given***/
		MemberVO memberVo = new MemberVO("lmh","pass1234","pc-03","이미현","대전 중구 중앙로 76","영민빌딩 4층 404호","34904","d:\\profile\\lmh.png","lmh.png");

		
		/***When***/
		int insertCnt = memberService.insertMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	@Test
	public void updateMembertest() {
		/***Given***/
		MemberVO memberVo = new MemberVO("lmh","pass1234","미밍","이미현","대전 중구 중앙로 76","영민빌딩 4층 404호","34904",null,null);
		/***When***/
		int updateCnt = memberService.updateMember(memberVo);
		
		/***Then***/
		assertEquals(1,updateCnt);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
