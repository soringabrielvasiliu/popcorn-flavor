<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <header>     
          <a href="${pageContext.request.contextPath}/homepage.html">
          	<img class="logo" src="${pageContext.request.contextPath}/resources/images/pop3.png" alt="logo"/>
          </a>
          <nav class="menu">
            <ul class="clearfix">     				
      				<li>
                <a href="#">MOVIES<span class="arrow">&#9660;</span></a>
                <ul class="sub-menu">
                    <li><a href="#">MOVIES</a></li>
                    <li><a href="#">TV SERIES</a></li>
                    <li><a href="#">GENRES</a></li>
                    <li><a href="#">VIDEO GAMES</a></li>
                    <li><a href="#">COMING SOON</a></li>
                </ul>
              </li>
              <li><a href="#">ACTORS</a></li>
      				<li>
                <a href="#">POPULAR<span class="arrow">&#9660;</span></a>
                <ul class="sub-menu">
                  <li><a href="#">MOST POPULAR</a></li>
                  <li><a href="#">USER FAVORITES</a></li>
                </ul>
              </li>     				
            </ul>
          </nav>			
  				<form class="search_bar" method="post" commandName="search-form">
  			         <input class="search" type="text"  placeholder="Find Movies, TV Shows and Actors"/>
  			         <input class="button" type="submit" value="Search">
  				</form>
  				
          <div class="connection" > 				  				  
  				  <c:choose>
  				  	<c:when test="${sessionScope.username != null}">
  				  		<a href="${pageContext.request.contextPath}/account/logout.html" class="logout">logout</a>
  				  		<a href="${pageContext.request.contextPath}/account/profile.html" class="profile">profile</a>
  				  	</c:when>
  				  	<c:otherwise>
                		<a href="${pageContext.request.contextPath}/account/login.html" class="login">login</a>
               			<a href="${pageContext.request.contextPath}/account/register.html" class="register">register</a>
              		</c:otherwise>
  				  </c:choose>  		
          </div>
    </header>
</body>
</html>