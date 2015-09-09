<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Josefin+Sans" />
<title>Popcorn Flavor | Movie</title>
<link href="${pageContext.request.contextPath}/css/actor.css" rel="stylesheet" type="text/css">
</head>
<body>
	<span id="container"  modelAttribute="mv">
		<div class="left-container">
			<div class="logo-picture-and-info"><img src="./img/pop3.png" alt="logo" width="150px" height="150px">
			<h1>${mv.title} </h1>
			<h2 >${mv.type}</h2>
			</div>
			<form class="search_bar" method="post" commandName="search-form">
  			         <input class="search" type="text"  placeholder="Find Movies, TV Shows and Actors"/>
  			         <input class="button" type="submit" value="Search">
  			</form>
  			<footer>
  			<div class="footer_links">
		        <a href="#">About</a>
		        <a href="#">Help</a>
		        <img src="./img/reea.png" alt="reea sigla">
		        <a href="#">Facebook</a>
		        <a href="#">Twitter</a>
			</div>
			</footer>
		</div>	
		<div class="right-container">
			<img src=${mv.img} alt="actor picture" class="page-picture">
			<h1> More Info about ${mv.title} </h>
			<h2> Overview </h2>
			<c:if test="${mv.beginYear != null }">
			<p> <b> Year :</b>${mv.beginYear} </p> 
			</c:if>
			<c:if test="${mv.type == 'SERIES' }">
			<p> <b> Year finish :</b>${mv.endYear} </p> 
			</c:if>
			<c:if test="${mv.totalRating != 0 }">
			<p> <b> Rating :</b> ${mv.totalRating / mv.totalVoters}  </p>  
			</c:if>
			<c:if test="${mv.plot != null }">
			<h2> Plot </h2>
			<a> <b> Plot :</b> ${mv.plot} </a>
			</c:if>

		</div>
	</span>
	<span modelAttribute="genre">
	<c:forEach var="columnHeader" items="${genre}">
	<p>  <c:out value="${columnHeader}" /> </p>
	</c:forEach>
	
	</span>
	<span modelAttribute="cast">
		<c:forEach var="m" items="${cast}">
          	 <a href="${pageContext.request.contextPath}/actor/${m.idActor}.html" >  <p>${m.firstName} ${m.lastName} ${m.role}</p> </a>
    	</c:forEach>
	</span>
</body>
</html>