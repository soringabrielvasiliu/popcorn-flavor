<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/movie.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Josefin+Sans" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.bxslider.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<title>Popcorn Flavor | Movie</title>
</head>
<body>
	<span id="movie-container">
	<div class="header-footer"  modelAttribute="mv">
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
			<h1>${mv.title}</h1>
			<h1>${mv.type}</h1>
			<c:choose>
				<c:when test="${mv.type == 'MOVIE'}">
					<c:if test="${mv.beginYear != null }">
						<h2>${mv.beginYear}</h2> 
					</c:if>	
				</c:when>
				<c:when test="${mv.type == 'SERIES'}">
					<c:if test="${mv.beginYear != null && mv.endYear != '????'}">
						<h2>${mv.beginYear} - ${mv.endYear}</h2> 
					</c:if>
					<c:if test="${mv.beginYear != null && mv.endYear == '????'}">
						<h2>${mv.beginYear} - </h2> 
					</c:if>
				</c:when>
			</c:choose>
			<c:if test="${mv.totalRating != 0 }">
			<c:forEach var="i" begin="1" end="${fn:substringBefore(mv.totalRating / mv.totalVoters, '.')}">
				<img class="pop" src="${pageContext.request.contextPath}/resources/images/second.png">
			</c:forEach>
			</c:if>
			<span modelAttribute="verifyWatchlist" class="button-watchlist">
					<c:choose>
						<c:when test="${verifyWatchlist != null}">
							<button id="add-watchlist">Add to Watchlist</button>
						</c:when>
						<c:otherwise>
							<button id="remove-watchlist">Remove from Watchlist</button>
						</c:otherwise>
					</c:choose>	
			</span>
			<span modelAttribute="verifyMoviePref" class="button-pref">
					<c:choose>
						<c:when test="${verifyMoviePref != null}">
							<button id="MoviePref">Add to Preferences</button>
						</c:when>
						<c:otherwise>
							<button id="remove-moviepref">Remove from preferences</button>
						</c:otherwise>
					</c:choose>	
			</span>
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
		<div class="movie-info" modelAttribute="mv">
			<div class='image-wrapper'>
				<c:if test="${mv.img != null}">
					<img class="movie-picture" src="${mv.img}">
				</c:if>
			</div>	
			<c:choose>
				<c:when test="${mv.plot != null }">
					<div class="plot">${mv.plot}</div>
				</c:when>
				<c:otherwise>
					<div class="plot">This movie doesn't have a plot</div>
				</c:otherwise>
			</c:choose>		
		</div>
		
		<hr>
		<h2>Genre</h2>
		<div class="movie-genre">
			<c:forEach var="columnHeader" items="${genre}">
				<p><c:out value="${columnHeader}"/></p>
			</c:forEach>
		</div>
		
		<hr>
		<h2>Cast</h2>	
		<div class="movie-cast" modelAttribute="cast">
			<c:forEach var="m" items="${cast}">
				<c:choose>
					<c:when test="${m.lastName != null}">
						<a href="${pageContext.request.contextPath}/actor/${m.idActor}.html">${m.firstName} ${m.lastName} - ${m.role}</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/actor/${m.idActor}.html">${m.firstName} - ${m.role}</a>
					</c:otherwise>
				</c:choose>	
			</c:forEach>
		</div>	
		
		<hr>
		<h2>Comment Section</h2>
		<div class="rating-and-comment">
			<c:choose>
				<c:when test="${sessionScope.username != null}">
		    	<div class="rating-and-comment" modelAttribute="verifyRating">
		    		<c:choose>
		    			<c:when test="${verifyRating != null}">
			    			<form method ="post" commandName="yourComment" >
								<label><input type="radio"  value="1" name="rating"><img src="${pageContext.request.contextPath}/resources/images/third.png"></label>
								<label><input type="radio"  value="2" name="rating"><img src="${pageContext.request.contextPath}/resources/images/first.png"></label>
								<label><input type="radio"  value="3" name="rating"><img src="${pageContext.request.contextPath}/resources/images/second.png"></label>
								<label><input type="radio"  value="4" name="rating"><img src="${pageContext.request.contextPath}/resources/images/first.png"></label>
								<label><input type="radio"  value="5" name="rating"><img src="${pageContext.request.contextPath}/resources/images/third.png"></label>
								<input type="text" placeholder="Enter your comment here" name="comment"/>
								<input class="button" type="submit" value="Post">
							</form>
						</c:when>
						<c:otherwise>
							<form method ="post" commandName="yourComment" >
								<input type="text" placeholder="Enter your comment here" name="comment"/>
								<input class="button" type="submit" value="Post" id="commWithoutRating">
							</form>
						</c:otherwise>
						</c:choose>
					    		
				</div>
				</c:when>
				<c:otherwise>
					<p>Please login to comment</p>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="comments"  modelAttribute="comments">
			<hr>
			<c:forEach var="comm" items="${comments}">
				<p>${comm.username}</p>
				<p>${comm.comment}</p>
				<p>${comm.date}</p>
				<hr>
			</c:forEach>
		</div>
		
	</div>
	</span>
</body>
</html>