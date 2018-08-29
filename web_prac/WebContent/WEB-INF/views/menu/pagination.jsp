<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String rPath = request.getContextPath();
%>

	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	  <c:if test="${empty pi.sch}">
	  	<c:if test="${pi.firstPage!=1}">
		  	<li class="page-item">
		      <a class="page-link" href="<%=rPath%>/depart/departList?page=${pi.firstPage-pi.pageCnt}" tabindex="-1">PRE</a>
		    </li>
		</c:if>
		<c:forEach	begin="${pi.firstPage}" end="${pi.lastPage}" var="p">
			<li class="page-item ${pi.page eq p ? 'active':''}"><a class="page-link" href="<%=rPath%>/depart/departList?page=${p}">${p}</a></li>
		</c:forEach>
	    <c:if test="${pi.lastPage!=pi.totalPage}">
		    <li class="page-item">
		      <a class="page-link" href="<%=rPath%>/depart/departList?page=${pi.firstPage+pi.pageCnt}">Next</a>
		    </li>
		</c:if>
		</c:if>
		<c:if test="${!empty pi.sch}">
			  	<c:if test="${pi.firstPage!=1}">
		  	<li class="page-item">
		      <a class="page-link" href="<%=rPath%>/depart/departList?page=${pi.firstPage-pi.pageCnt}&search=${pi.sch}&op=${pi.op}" tabindex="-1">PRE</a>
		    </li>
		</c:if>
		<c:forEach	begin="${pi.firstPage}" end="${pi.lastPage}" var="p">
			<li class="page-item ${pi.page eq p ? 'active':''}"><a class="page-link" href="<%=rPath%>/depart/departList?page=${p}&search=${pi.sch}&op=${pi.op}">${p}</a></li>
		</c:forEach>
	    <c:if test="${pi.lastPage!=pi.totalPage}">
		    <li class="page-item">
		      <a class="page-link" href="<%=rPath%>/depart/departList?page=${pi.firstPage+pi.pageCnt}&search=${pi.sch}&op=${pi.op}">Next</a>
		    </li>
		</c:if>
		</c:if>
		
		
	  </ul>
	</nav>

