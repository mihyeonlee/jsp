package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberService implements MemberServiceI {
	
	private MemberDaoI memberDao; 
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	@Override
	public MemberVO getMember(String userId) {
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return memberDao.selectAllMember();
	}

	@Override
	public Map<String, Object> getPageMember(PageVO pageVO) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList",memberDao.getPageMember(sqlSession,pageVO));
		
		//15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야한다.
		int totalCnt = memberDao.getMemberTotalCnt(sqlSession);
		int pages = (int)Math.ceil(15d/7);
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	}

}
