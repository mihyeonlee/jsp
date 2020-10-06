package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplit {
	private static final Logger logger = LoggerFactory.getLogger(CookieSplit.class);
	//cookieString 문자열 변수에 담긴 값은 
	//쿠키이름1=쿠키값1; 쿠키이름2=쿠키값2; ...형태로 구성
	//구성된 쿠키 이름과 값은 상황에 따라 변경될 수 있음
	private String cookieString = "USERNM=brown; REMEMBERME=Y; ";
	
	public static void main(String[] args) {
		CookieSplit cookieSplit = new CookieSplit();
		logger.debug(cookieSplit.getCookieValue("USERNM"));		//기대되는 값 brown
		logger.debug(cookieSplit.getCookieValue("REMEMBERME"));	//기대되는 값 Y
	}
	
	//cookieString 필드를 분석하여 메서드 인자로 넘어온 cookieName에 해당하는 쿠키가 있을경우
	//해당 쿠키의 값을 반환하는 메서드
	public String getCookieValue(String cookieName) {
		String cookieValue = null;
		//쿠키를 나눔
		String cookies[] = cookieString.split("; ");
		String cn[];
		//쿠키의 이름과 값을 분류
		for(int i=0;i<cookies.length;i++) {
			cn = cookies[i].split("=");
			//인자값과 같은 쿠키이름을 찾아 값을 반환
			if(cn[0].equals(cookieName)) {
				cookieValue = cn[1];
				break;
			}
		}
		return cookieValue;
	}

}
