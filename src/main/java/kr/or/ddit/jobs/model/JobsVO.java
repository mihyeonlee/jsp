package kr.or.ddit.jobs.model;

public class JobsVO {
	
	String JOB_ID;
	String JOB_TITLE;
	int MIN_SALARY;
	int MAX_SALARY;
	String CREATE_DATE;
	String UPDATE_DATE;
	
	public String getJOB_ID() {
		return JOB_ID;
	}
	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}
	public String getJOB_TITLE() {
		return JOB_TITLE;
	}
	public void setJOB_TITLE(String jOB_TITLE) {
		JOB_TITLE = jOB_TITLE;
	}
	public int getMIN_SALARY() {
		return MIN_SALARY;
	}
	public void setMIN_SALARY(int mIN_SALARY) {
		MIN_SALARY = mIN_SALARY;
	}
	public int getMAX_SALARY() {
		return MAX_SALARY;
	}
	public void setMAX_SALARY(int mAX_SALARY) {
		MAX_SALARY = mAX_SALARY;
	}
	public String getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(String cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	public String getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	public void setUPDATE_DATE(String uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}
	
	
	
	

}
