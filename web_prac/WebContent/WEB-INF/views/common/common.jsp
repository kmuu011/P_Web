<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    
<%
String uri = request.getRequestURI();
String rPath = request.getContextPath();
String title = "乃ㅇㅅㅇ乃";

%>

<c:set var="rPath" value="<%=rPath%>"/>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title><%=title%></title>
    <link href="<%=rPath%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=rPath%>/css/simple-sidebar.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=rPath%>/bs3/css/common.css"/>
    
    <script src="<%=rPath%>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=rPath%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="<%=rPath%>/bs3/js/common.js"></script>
	
</head>

 
 


