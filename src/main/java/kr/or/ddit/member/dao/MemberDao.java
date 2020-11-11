package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberDao")
public class MemberDao implements MemberDaoI {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVO getMember(String userId) {
//		SqlSession sqlSession = MybatisUtil.getSqlSession();

		MemberVO memberVO = sqlSession.selectOne("member.getMember", userId);
//		sqlSession.close();

		return memberVO;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		List<MemberVO> memberList = sqlSession.selectList("member.selectAllMember");

		return memberList;
	}

	@Override
	public List<MemberVO> getPageMember(PageVO pageVO) {
		return sqlSession.selectList("member.getPageMember", pageVO);
	}

	@Override
	public int getMemberTotalCnt() {
		return sqlSession.selectOne("member.getMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVO memberVo) {
		return sqlSession.insert("member.insertMember", memberVo);
	}

	@Override
	public int deleteMember(String userid) {
		int deleteCnt = sqlSession.delete("member.deleteMember", userid);
		return deleteCnt;
	}

	@Override
	public int updateMember(MemberVO memberVo) {
		int updateCnt = sqlSession.update("member.updateMember", memberVo);

		return updateCnt;
	}

}
