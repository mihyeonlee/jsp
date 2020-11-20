package kr.or.ddit.batch.yogurt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

import kr.or.ddit.batch.yogurt.model.CycleVO;
import kr.or.ddit.batch.yogurt.model.DailyVO;

public class YogurtProcessor implements ItemProcessor<CycleVO, List<DailyVO>>{
	private static final Logger logger = LoggerFactory.getLogger(YogurtProcessor.class);
	
	//jobLauncher를 실행하면서 두번째 인자로 넣어준 jobParameter 값을 SPEl을 통해 주입
	//단 jobParameters에 접근하기 위해서는 해당 스프링 빈의 scope를 step으로 지정해야한다.
	@Value("#{jobParameters[ym]}")
	private String ym;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public List<DailyVO> process(CycleVO item) throws Exception {
		// 생성 월이 2020 11월
		// cid=1, pid=100, day=2, cnt=3
		// ==>
		// cid=1, pid=100, dt=20201102, cnt=3
		// cid=1, pid=100, dt=20201109, cnt=3
		// cid=1, pid=100, dt=20201116, cnt=3
		// cid=1, pid=100, dt=20201123, cnt=3
		// cid=1, pid=100, dt=20201130, cnt=3
		
		logger.debug("ym : {}, item : {}",ym,item);
		
		List<DailyVO> dailyVOList = new ArrayList<DailyVO>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(ym.substring(0,4))); //202011
		calendar.set(Calendar.MONTH, Integer.parseInt(ym.substring(4))-1); //11 캘린더는 0~11까지 월을 센다. 
		calendar.set(calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); //30
		
		//calendar 2020 11 30
		Date endTime = calendar.getTime();
		String endTimeStr = sdf.format(endTime);
		int endTimeInt = Integer.parseInt(endTimeStr);
		
		//해당 월의 1일로 설정
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date dt = calendar.getTime();
		String dtStr = sdf.format(dt);
		int dtInt = Integer.parseInt(dtStr);
		//calendar 2020 11 01
		
		while(endTimeInt >= dtInt) {
			
			//calendar 날짜가 item의 애음요일과 같을 때만 dailyVO를 생성
			if(item.getDay() == calendar.get(Calendar.DAY_OF_WEEK)) {
				DailyVO dailyVO = new DailyVO();
				dailyVO.setCid(item.getCid());
				dailyVO.setPid(item.getPid());
				dailyVO.setDt(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
				dailyVO.setCnt(item.getCnt());
				
				dailyVOList.add(dailyVO);
			}
			//다음 날짜로 설정
			calendar.set(calendar.DAY_OF_MONTH, calendar.get(calendar.DAY_OF_MONTH)+1);
			dt = calendar.getTime();
			dtStr = sdf.format(dt);
			dtInt = Integer.parseInt(dtStr);
		}
		
		return dailyVOList;
	}
	
}