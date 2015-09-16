<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/find.css" rel="stylesheet" type="text/css">
<title>PopcornFlavor | Search Result</title>
</head>
<body>

<span  modelAttribute="searchResultsActors">
	<c:choose>
		<c:when test="fn:length(${searchResultsActors}) > 0">
		<h3>Search result for actors</h3>
		<c:forEach var="actor" items="${searchResultsActors}" varStatus="status">
				<c:choose>
					<c:when test="${mv.lastName != null}">
						<a href="${pageContext.request.contextPath}/actor/${actor.idActor}.html">${mv.firstName} ${mv.lastName}</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/actor/${actor.idActor}.html">${mv.firstName}</a>
					</c:otherwise>
				</c:choose>	
		</c:forEach>
		</c:when>
		<c:otherwise>
			<h3>There are no search result for actors</h3>
		</c:otherwise>
	</c:choose>
	
</span>
    
<span  modelAttribute="searchResultsMovies">
	<h3>Search result for movies</h3>
	<c:forEach var="movie" items="${searchResultsMovies}" varStatus="status">
		<a href="${pageContext.request.contextPath}/movie/${movie.idMovie}.html">${movie.title} - ${movie.type}</a>
	</c:forEach>
</span>

</body>
</html>