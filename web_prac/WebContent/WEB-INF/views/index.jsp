<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>


<%
session.setAttribute("str","456");
request.setAttribute("str","211");
pageContext.setAttribute("str","789");
RequestDispatcher rd = request.getRequestDispatcher("/user/login");
rd.forward(request, response);
%>
<body>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>

<c:set var="str1" value="456" scope="request"/>
<c:set var="str" value="789"/>

</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


