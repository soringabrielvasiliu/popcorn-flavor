<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PopcornFlavor</title>
    <link href="${pageContext.request.contextPath}/css/homepage.css" rel="stylesheet" type="text/css">
    
    <!-- jQuery library (served from Google) -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <!-- bxSlider Javascript file -->
    <script src="${pageContext.request.contextPath}/js/jquery.bxslider.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <!-- bxSlider CSS file -->
    <link href="${pageContext.request.contextPath}/css/jquery.bxslider.css" rel="stylesheet" />
    
  </head>
  
  <body>
	<span id="homepage-container">
    <div class="header-footer">
      <div class="logo-picture-and-info">
        <div class="home-profile">
        <c:choose>
          <c:when test="${sessionScope.username != null}">
                <a href="${pageContext.request.contextPath}/account/profile.html">PROFILE</a>
                <a href="${pageContext.request.contextPath}/account/logout.html">LOGOUT</a>
              </c:when>
              <c:otherwise>
                <a href="${pageContext.request.contextPath}/account/login.html" class="login">LOGIN</a>
                <a href="${pageContext.request.contextPath}/account/register.html" class="register">REGISTER</a>
              </c:otherwise>
          </c:choose>
        </div>
        <a href="${pageContext.request.contextPath}/homepage.html">
          <img src="${pageContext.request.contextPath}/resources/images/pop3.png" alt="logo"/>
        </a>
      </div>

      <form class="search-bar"  action="${pageContext.request.contextPath}/find.html"  method="post" commandName="search-form">
		<input class="search" id="searchName" type="text"  placeholder="Find Movies, TV Shows and Actors" name="searchName"/>
		<input class="button" type="submit" value="Search">
      </form>
        
        <nav class="menu">
            <ul class="clearfix">             
              <li>
                <a href="#">MOVIES<span class="arrow">&#9660;</span></a>
                <ul class="sub-menu">
                    <li><a href="#">Movies</a></li>
                    <li><a href="#">TV Series</a></li>
                    <li><a href="#">Genres</a></li>
                    <li><a href="#">Video Games</a></li>
                    <li><a href="#">Coming Soon</a></li>
                </ul>
              </li>
              <li><a href="#">ACTORS</a></li>
              <li>
                <a href="#">POPULAR<span class="arrow">&#9660;</span></a>
                <ul class="sub-menu">
                  <li><a href="#">Most Popular</a></li>
                  <li><a href="#">User Favorites</a></li>
                </ul>
              </li>             
            </ul>
          </nav>

        <div class="footer-links">
            <a href="#">About</a>
            <a href="#">Help</a>
            <a href="#">Facebook</a>
            <a href="#">Twitter</a>
      	</div>
    </div>

    <div class="homepage-content">
	    <ul class="bxslider">
	      <li><img src="${pageContext.request.contextPath}/resources/images/slider1.jpg"/></li>
	      <li><img src="${pageContext.request.contextPath}/resources/images/slider2.jpg"/></li>
	      <li><img src="${pageContext.request.contextPath}/resources/images/slider3.jpg"/></li>
	      <li><img src="${pageContext.request.contextPath}/resources/images/slider4.jpg"/></li>
	    </ul>
	    <div id="bx-pager">
		  <a data-slide-index="0" href=""><img src="${pageContext.request.contextPath}/resources/images/slider1.jpg"/></a>
		  <a data-slide-index="1" href=""><img src="${pageContext.request.contextPath}/resources/images/slider2.jpg" title="Joy"/></a>
		  <a data-slide-index="2" href=""><img src="${pageContext.request.contextPath}/resources/images/slider3.jpg"/></a>
		  <a data-slide-index="3" href=""><img src="${pageContext.request.contextPath}/resources/images/slider4.jpg"/></a>
		</div>
    </div>
 	</span>
    
  <script src='./js/main.js'></script>
  </body>
</html>