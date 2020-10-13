package kr.or.ddit.jobs.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVO;

public class JobsServiceTest {

	@Test
	public void getJobIdTitleTest() {
		/***Given***/
		JobsService jobsService = new JobsService();
		
		/***When***/
		List<JobsVO> getJobIdTitleList = jobsService.getJobIdTitle();

		/***Then***/
		assertEquals(19, getJobIdTitleList.size());
	}

}
