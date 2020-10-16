package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {
	
	public MemberVO getMember(String userId);
	
	public List<MemberVO> selectAllMember();
	
	public List<MemberVO> getPageMember(SqlSession sqlSession ,PageVO pageVo);
	
	public int getMemberTotalCnt(SqlSession sqlSession);
	
	
}
