<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>
	// 해당 html 로딩이 완료 되었을 때 실행되는 이벤트 핸들러 함수
	$(document).ready(function() {
		// ajax call을 통해 1페이지에 해당하는 사용자 정보를 json으로 받는다
		//memberListAjax(1);
		memberListAjaxHTML(1);
		
		$('#memberList').on('click',"tr", function() {
			// data-userid <tr>태그에 적어놓음
			var userid = $(this).data("userid");
			console.log("userid:" + userid);
			
			document.location = "/member/memberAjaxPage?userid=" + userid;
		});
		
	});// document

	function memberListAjax(p){
		$.ajax({url :"/member/listAjax",
			data : {page : p, pageSize : 5},
			//data : "page=1&pageSize=5",
			//data : JSON.stringify({page : 1, pageSize : 5}), => 받을때 Controller에서  @RequestBody 써야한다  JSON <---> OBEJECT (마샬링,언마샬링)
			method : "get",
			success : function(data){
				// console.log(data)
				var i = 0; // 의미없는 함수로 브레이크포인트 걸수잇음

				//memberList tbody영역에 들어갈 html문자열 생성
				var html = ""
				for(var i=0; i<data.memberList.length;i++){
					var member = data.memberList[i];
					//var length = ${memberList.size()};  이렇게는 가져다 쓸수 있음
					html += "<tr data-userid='"+ data.memberList[i].userid + "' >";
					html += "  <td>" + member.userid + "</td>";
					html += "  <td>" + member.usernm + "</td>";
					html += "  <td>" + member.alias + "</td>";
					html += "  <td>" + member.fmt_reg_dt + "</td>";
					html += "</tr>";
				}
				$("#memberList").html(html);
				// 페이지 내비게이션 html 문자열 동적으로 생성하기
				var html = "";
				for(var i=1; i<=data.pages;i++){
					if(i == data.pageVO.page)
						html += "<li class='active'><span>" + i + "</span></li>";
					else
							// <a href = "javascript"
						html += "<li><a href=\"javascript:memberListAjax(" + i + ");\">" + i + "</a></li>";
				}
				$("#pageList").html(html);
				
			}
		});// list ajax
	} // memberListAjax(p)

	function memberListAjaxHTML(p){
		$.ajax({url :"/member/listAjaxHTML",
			data : {page : p, pageSize : 5},
			//data : "page=1&pageSize=5",
			//data : JSON.stringify({page : 1, pageSize : 5}), => 받을때 Controller에서  @RequestBody 써야한다  JSON <---> OBEJECT (마샬링,언마샬링)
			method : "get",
			success : function(data){
				var html = data.split("$$$SEPERRATOR$$$")
				$("#memberList").html(html[0]);
				$("#pageList").html(html[1]);
				//$("ul.pagination")
				//구분자로 나눈다음에 넣으면 된다.
			}
				
		});// list ajax
	}



	
</script>


<div class="row">
	tiles : memberListContent.jsp
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				<!--테이블내에서 가지고오려는 데이터를 나눌때 tbody많이 사용 -->
				<tbody id="memberList">
					
				</tbody>
			</table>
		</div>

		<a class="btn btn-default pull-right"
			href="${cp }/member/memberRegistView">사용자 등록</a> page:${page }
		<div class="text-center">
			<ul class="pagination" id="pageList">
				
			</ul>
		</div>
	</div>
</div>
</html>
