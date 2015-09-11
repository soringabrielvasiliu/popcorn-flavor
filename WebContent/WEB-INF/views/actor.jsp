<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Josefin+Sans" />
<title>Popcorn Flavor | Actor</title>
<link href="${pageContext.request.contextPath}/css/actor.css" rel="stylesheet" type="text/css">
</head>
<body>
	<span id="actor-container" modelAttribute="mv">
		<div class="header-footer">
			<div class="logo-picture-and-info">
				<div class="home-profile">
				<c:choose>
					<c:when test="${sessionScope.username != null}">
  				  		<a href="${pageContext.request.contextPath}/homepage.html">HOME</a>
  				  		<a href="${pageContext.request.contextPath}/account/profile.html">PROFILE</a>
  				  		<a href="${pageContext.request.contextPath}/account/logout.html">LOGOUT</a>
  				  	</c:when>
  				  	<c:otherwise>
  				  		<a href="${pageContext.request.contextPath}/homepage.html">HOME</a>
  				  		<a href="${pageContext.request.contextPath}/account/login.html" class="login">LOGIN</a>
               			<a href="${pageContext.request.contextPath}/account/register.html" class="register">REGISTER</a>
  				  	</c:otherwise>
  				</c:choose>
				</div>
				<a href="${pageContext.request.contextPath}/homepage.html">
					<img src="${pageContext.request.contextPath}/resources/images/pop3.png" alt="logo"/>
				</a>
				<c:choose>
					<c:when test="${mv.lastName != null}">
						<h1>${mv.firstName} ${mv.lastName}</h1>
					</c:when>
					<c:otherwise>
						<h1>${mv.firstName}</h1>
					</c:otherwise>
				</c:choose>				
			</div>
			
			<form class="search-bar"  action="${pageContext.request.contextPath}/find.html" method="post" commandName="search-form" >
  			         <input class="search" type="text"  placeholder="Find Movies, TV Shows and Actors" name="searchName"/>
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
		
		<div class="content-container">
		
			<c:if test="${mv.img == null && mv.dateBirth==null && mv.dateDeath == null && mv.nickname == null && mv.height == null && mv.biography ==null}">
				<p>There is no information about this actor</p>
			</c:if>
			<c:if test="${mv.img != null}">
				<img class="actor-picture" src="${mv.img}" alt="actor picture">
			</c:if>
					
			<div class="overview">	
				<c:if test="${mv.dateBirth != null}">
				<p><b>Date of Birth:</b> ${mv.dateBirth}</p> 
				</c:if>
				
				<c:if test="${mv.dateDeath != null}">
				<p><b>Date of Death:</b> ${mv.dateDeath}</p> 
				</c:if>
				
				<c:if test="${mv.nickname != null}">
				<p><b>Nicknames:</b> ${mv.nickname}</p> 
				</c:if>
				
				<c:if test="${mv.height != null}">
				<p><b>Height:</b> ${mv.height}</p>
				</c:if> 
			</div>
				
			<c:if test="${mv.biography != null}">
			<p class="bio">${mv.biography}</p>
			</c:if>
			
			<div class="hisWork" modelAttribute="otherMovies">
				<c:forEach var="m" items="${otherMovies}">
          	 		<p> <a href="${pageContext.request.contextPath}/movie/${m.idMovie}.html" > ${m.title} </a> </p>
          		 	<p><b>Role: </b> ${m.role} <b> Year:</b> ${m.year} </p> 
    			</c:forEach>
			</div>	
			
		</div>	
	</span>
</body>
</html>