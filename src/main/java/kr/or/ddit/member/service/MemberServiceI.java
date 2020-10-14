package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.model.MemberVO;

public interface MemberServiceI {

	MemberVO getMember(String userId);
	
	public List<MemberVO> selectAllMember();

}
