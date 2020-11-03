package kr.or.ddit.config.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateStringConverter implements Converter<String, Date>{
	
	//인자 source에는 2020-11-03 문자 있다.
	@Override
	public Date convert(String source) {
		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date to= null;
		try {
			to = fm.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return to;
	}
	
}
