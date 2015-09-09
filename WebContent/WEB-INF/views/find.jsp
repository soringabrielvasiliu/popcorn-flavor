<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<span  modelAttribute="searchResultsActors">
          <c:forEach var="actor" items="${searchResultsActors}" varStatus="status">
          	<p><a href="${pageContext.request.contextPath}/actor/${actor.idActor}.html" >${actor.firstName}  ${actor.lastName}</a>   </p>  
    	</c:forEach>
    </span>
    
     <span  modelAttribute="searchResultsMovies">
          <c:forEach var="movie" items="${searchResultsMovies}" varStatus="status">
          	<p><a href="${pageContext.request.contextPath}/movie/${movie.idMovie}.html" >${movie.title}  ${movie.type}</a></p>   
    	</c:forEach>
    </span>

</body>
</html>