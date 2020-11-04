package kr.or.ddit.member.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

@Service("memberService")
public class MemberService implements MemberServiceI {
	
	@Resource(name="memberDao") // 필드안에서도 주입받아 사용해야 빈임.
	private MemberDaoI memberDao; 
	
	public MemberService() {
		//memberDao = new MemberDao(); 필드안에 객체를 생성하는 형식은 bean이 아니다 사용하면 안됨.
	}
	
	public MemberDaoI getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDaoI memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public MemberVO getMember(String userId) {
		return memberDao.getMember(userId);
	}
	

//	@Override
//	public List<MemberVO> selectAllMember() {
//		return memberDao.selectAllMember();
//	}
//
//	@Override
//	public Map<String, Object> getPageMember(PageVO pageVO) {
//		
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("memberList",memberDao.getPageMember(sqlSession,pageVO));
//		
//		//15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야한다.
//		int totalCnt = memberDao.getMemberTotalCnt(sqlSession);
//		int pages = (int)Math.ceil(15d/7);
//		map.put("pages", pages);
//		
//		sqlSession.close();
//		return map;
//	}
//
//	@Override
//	public int insertMember(MemberVO memberVo) {
//		return memberDao.insertMember(memberVo);
//	}
//
//	@Override
//	public int deleteMember(String userid) {
//		return memberDao.deleteMember(userid);
//	}
//
//	@Override
//	public int updateMember(MemberVO memberVo) {
//		return memberDao.updateMember(memberVo);
//	}

}
