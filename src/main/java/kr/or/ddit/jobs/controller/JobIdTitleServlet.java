package kr.or.ddit.jobs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jobs.model.JobsVO;
import kr.or.ddit.jobs.service.JobsService;


@WebServlet("/jobIdTitle")
public class JobIdTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobsService jobsService = new JobsService();
		List<JobsVO> jobIdTitle = jobsService.getJobIdTitle();
		request.setAttribute("jobIdTitle", jobIdTitle);
		request.getRequestDispatcher(request.getContextPath()+"jobs/jobsIdTitleView.jsp").forward(request, response);
	}

}
