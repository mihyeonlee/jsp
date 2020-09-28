<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	// 문서로딩이 다 된뒤에 초기화된다.
	$(function(){
		$('#gp').on('click',function(){
			var get = $('input:radio[name="select"]:checked').val();
			console.log(get);
			if(get=='POST'){
					$('#ff').attr('method','POST');
				}else{
					$('#ff').attr('method','GET');
					}
		})
	})
		

</script>
</head>
<body>
	<%-- 파라미터 : client 서버로 요청을 보낼때 추가적으로 낸 값 
				ex.로그인 요청시:사용사 id,비밀번호
		
		파라미터는 내부적으로 Map<String,String[]> 객체로 관리를 한다
							파라미터이름, 파라미터 값들 
							=> 동일한 이름의 파라미터를 여러개 보낼 수 있다
							
		**request 객체에 있는 파라미터 관련 메서드 4가지
		String getParameter(String param) : param에 해당하는 파라미터 값을 조회한다
											파라미터맵에서 첫번째 값을 반환
		String[] getParameterValues(String param) : param에 해당하는 모든 파라미터 값을 반환한다.
		Map<String, String[]> getParameterMap() : request 객체에 생성된 파라미터 맵을 반환
		
		Enumeration<String> getParameterNames() : request 객체에 담긴 모든 파라미터 이름을 반환 
		
	 --%>
	 
	 
	 <%-- 한글 파라미터 설정
	 		get : server.xml <Connector URIEncoding = "utf-8">
	 		post : request.setCharacterEncoding("utf-8");
	 			   request.getParameter()메서드를 호출하기 전에 설정을 해줘야 한다. 
	  --%>
	 <%-- action : 요청을 보낼 경로 
	 	  method : 요청 방식 (form에서는 GET,POST 두가지만 가능하며 deault는 GET)		
	 --%>
	 <form action="<%=request.getContextPath() %>/request/getRequestResponse.jsp" method="GET" id="ff">
		 user id : <input type="text" name="userId" value="초록"><br>
		 user id : <input type="text" name="userId" value="라임"><br>
		 password : <input type="password" name ="password" value="1111"><br>
		 <input type="radio" name="select" value="GET" checked="checked">GET
		 <input type="radio" name="select" value="POST">POST
		 <br><br>
	 <input type="reset" value="초기화">
	 <input type="submit" value="전송" id="gp">
	 
	 </form>
	 
	 GET POST 두가지를 선택할 수 있는 라디오 버튼을 만들어서 
	 FORM전송시 사용자가 GET,POST 방식을 지정할 수 있도록 
	 
</body>
</html>