<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<c:if test="${!empty result}">
<script>
alert("${result}개의 부서가 등록되었습니다.");
location.href = '${rPath}/depart/departList';
</script>
</c:if>

<c:if test="${resultD == -1}">
<script>
alert("삭제가 일부 실패했습니다.");
location.href = '${rPath}/depart/departList';
</script>
</c:if>

<c:if test="${resultD > 0}">
<script>
alert("${resultD}개의 삭제가 성공하였습니다.");
location.href = '${rPath}/depart/departList';
</script>
</c:if>



<body>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>

<div>
	<select name="op">
		<option value="diNum">부서번호</option>
		<option value="diCode">부서코드</option>
		<option value="diName">부서이름</option>
		<option value="diDesc">부서설명</option>
	</select>
	<input type="text" name="search" onkeyup="doEnter(event)">
	<button onclick="search()">검색</button>
</div>
<br>
<table class="table table-hover table-bordered">
	<thead>
		<tr>
			<th><input type="checkbox" onclick="allChk(this)"></th>
			<th>부서 번호</th>
			<th>부서 코드</th>
			<th>부서 이름</th>
			<th>부서 설명</th>
		</tr>
	</thead>
	
	<tbody id="tBody">
	<c:forEach var="di" items="${di}">
		<tr>
			<td><input type="checkbox" name="chk" value="${di.diNum}"></td>
			<td>${di.diNum}</td>
			<td>${di.diCode}</td>
			<td><a onclick='view("${di.diNum}")' href="#">${di.diName}</a></td>
			<td><a onclick='view("${di.diNum}")' href="#">${di.diDesc}</a></td>
		</tr>
					
	</c:forEach>
	</tbody>
</table>

<div class="btns" style="text-align:center">
<button onclick="addRow()" >부서 추가</button>

<button onclick="saveRow()" name="show">부서 저장</button>

<button onclick="delRow()">부서 삭제</button>
</div>


<br>

<div class="page" style="text-align:center">
	<jsp:include page="/WEB-INF/views/menu/pagination.jsp"></jsp:include>
</div>


</div>
<script>
	document.querySelector('input[name=search]').focus();

	document.querySelector('button[name=show]').style.visibility = 'hidden';
	
	function addRow(){
		document.querySelector('button[name=show]').style.visibility = 'visible';
		var html = '<tr>';
		html += '<td>&nbsp;</td>'
		html += '<td>&nbsp;</td>'
		html += '<td><input type="text" name="diCode"></td>'
		html += '<td><input type="text" name="diName"></td>'
		html += '<td><input type="text" name="diDesc"></td>'
		html += '</tr>'		 
		
		var obj = document.querySelector("#tBody");
		
		obj.insertAdjacentHTML('beforeend', html);
		
	}
	
	function makeParam(name, option){
		var selector = 'input[name=' + name + ']';
		
		if(option){
			selector += option;
		}
		
		if(!document.querySelector(selector)){
			selector = 'select[name=' + name + ']';
		}
		
		var param = document.querySelectorAll(selector);
		
		var params = "";
		
		for(var i=0 ; i<param.length ; i++){
			params += name + '=' + param[i].value + '&';
		}
		
		return params;
	}
	
	function saveRow(){
		var diCode = document.querySelector('input[name=diCode]');
		
		var param = makeParam("diCode");
		param += makeParam("diName");
		param += makeParam("diDesc");
		
		location.href = '${rPath}/depart/insert?' + param;
		
	}
	
	function delRow(){
		var r = document.querySelector('input[name=chk]:checked');
		
		if(r){
		var param = makeParam("chk",":checked");
		
		location.href = "${rPath}/depart/remove?" + param;
		} else{
			alert("삭제할 부서를 체크해주세요");
		}
	}
	
/* 	function allChk(r){
		document.querySelectorAll('input[name=chk]').forEach(
				(el)=>{el.checked = r.checked}
				);
	} */
	
	function allChk(e){
		var c = document.querySelectorAll('input[name=chk]');
		for(var i=0 ; i<c.length ; i++){
			c[i].checked = e.checked;
		}
	}
	
	function search(){
		param = makeParam("search");
		param += makeParam("op");
		
		location.href = '${rPath}/depart/departList?'+param;
		
	}
	
	function doEnter(e){
		if(e.keyCode === 13){
			search();
		}
	}
	
	function view(e){
		location.href="${rPath}/depart/departView?diNum=" +e;
		
	}
	
	
</script>


<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


