package kr.or.ddit.jobs.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVO;

public class JobsDaoTest {

	@Test
	public void getJobIdTitleTest() {
		/***Given***/
		JobsDao jobsDao = new JobsDao();
		
		/***When***/
		List<JobsVO> jobIdTitleList = jobsDao.getJobIdTitle();
		
		/***Then***/
		assertEquals(19, jobIdTitleList.size());
	}

}
