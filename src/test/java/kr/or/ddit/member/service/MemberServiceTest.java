package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	@Test
	public void test() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
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
		MemberServiceI memberService = new MemberService();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
