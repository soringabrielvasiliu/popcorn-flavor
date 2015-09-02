<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Popcorn Flavor</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
    
    <!-- jQuery library (served from Google) -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <!-- bxSlider Javascript file -->
    <script src="${pageContext.request.contextPath}/js/jquery.bxslider.min.js"></script>
    <!-- bxSlider CSS file -->
    <link href="${pageContext.request.contextPath}/css/jquery.bxslider.css" rel="stylesheet" />
    
  </head>
  
  <body>
  	<jsp:include page="header.jsp" />
  	
  	<ul class="bxslider">
  		<li><img src="${pageContext.request.contextPath}/resources/images/slider1.jpg"/></li>
  		<li><img src="${pageContext.request.contextPath}/resources/images/slider2.jpg"/></li>
  		<li><img src="${pageContext.request.contextPath}/resources/images/slider3.jpg"/></li>
  		<li><img src="${pageContext.request.contextPath}/resources/images/slider4.jpg"/></li>
  	</ul>
  	
  	<jsp:include page="footer.jsp" />
  	
  	<script src="${pageContext.request.contextPath}/js/main.js"></script>
  </body>
</html>