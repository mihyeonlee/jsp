<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript">
$(document).ready(function(){
	//client side에서는 서버사이드 변수나 값을 사용가능 
	memberAjax("${param.userid}");
	//memberAjax(${param.userid}); ==> 잘못된코드

	memberAjax("brown");
	//memberAjax(brown); ==> 잘못된코드
	
	$('#modifyBtn').on("click",function(){
		document.location="/member/update?userid=${param.userid}"
	})
	
	$('#profileDownBtn').on("click",function(){
		document.location="/profileImgDownloadView?userid=${param.userid}"
	});

});

function memberAjax(userid){
	$.ajax({url : "/member/memberAjax",
		data : {userid : userid},
		method : "get",
		success : function(data){
			$("#profile").attr("src", "${cp}/profileImg?userid="+data.memberVO.userid)
			$("#userid").html(data.memberVO.userid);
			$("#usernm").html(data.memberVO.usernm);
			$("#addr1").html(data.memberVO.addr1);
			$("#addr2").html(data.memberVO.addr2);
			$("#alias").html(data.memberVO.alias);
			$("#zipcode").html(data.memberVO.zipcode);
			$("#reg_dt").html(data.memberVO.fmt_reg_dt);
			$("#profileDownBtn").html(data.memberVO.realfilename);
			
		}
});

}

</script>
title : memberAjaxPage
			<form class="form-horizontal" role="form">

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<%-- 							<img src="${cp }/profile/${memberVo.filename }"/> --%>
							<!-- 사용자의 아이디보내서 확인  -->
							<img id="profile" /><br>
							<button type="button" class="btn btn-default" id="profileDownBtn" >다운로드 : </button>
							
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="control-label" id="userid"></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">

							<label class="control-label" id="usernm"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label" id="alias"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<label class="control-label" id="pass">******</label>
						</div>
					</div>

					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label" id="addr1"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label" id="addr2"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label" id="zipcode"></label>
						</div>
					</div>
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
							<label class="control-label" id="reg_dt"></label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a href="${cp }/member/memberUpdateView?userid=${memberVO.userid}"><button
									type="button" class="btn btn-default">사용자 수정</button></a>
						</div>
					</div>
				</form>
</html>
