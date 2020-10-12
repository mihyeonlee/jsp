package kr.or.ddit.jobs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.jobs.model.JobsVO;

public class JobsDao implements JobsDaoI{

	@Override
	public List<JobsVO> getJobIdTitle() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<JobsVO> jobIdTitleList = sqlSession.selectList("getJobIdTitle");
		
		return jobIdTitleList;
	}

}
