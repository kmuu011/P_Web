<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>

<table class="table table-bordered">
	<tr>
		<th>부서 번호 : ${di.diNum}</th>
		<th>부서 코드 : ${di.diCode}</th>
		<th>부서 이름 : ${di.diName}</th>
	</tr>
	<tr>
		<th colspan="3"> - 부서 설명 - <br><br>${di.diDesc}</th>
	</tr>
		
</table>


</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


