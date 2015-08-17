<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Popcorn Flavor</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <div class ="search-bar">
      <spring:form method="post" commandName="search-form" >
            <form method="post" commandName="movieName"  class="form-search-bar">
              <input type="text" id="ceva" name="searchName"/>
              <input  type="submit" value="Go!" />
            </form>
      </spring:form>
    </div> 
    <div>
      <form:form method="post"  modelAttribute="message">
          <c:forEach var="movie" items="${message}" varStatus="status">
          <p>${movie.idMovie}</p>
            <p>${movie.title}</p>
            <p>${movie.type}</p>
            <p>${movie.beginYear}</p>
            <p>${movie.endYear}</p>
            <p>${movie.plot}</p>
              
    </c:forEach>
    </form:form>
    
    </div>
    <div class="container" id="container">
        <div class="row">
        <a href="${pageContext.request.contextPath}/account/logout.html" class="pull-right new-account">Logout</a>
          <span class="pull-right login-title custom-username-span">${sessionScope.username}</span>
          <br><br>
        <h1 class="text-center">Welcome to <i>PopcornFlavor</i></h1>
        </div>
        <br>
        <div class="table-responsive">
          <a href="${pageContext.request.contextPath}/addMovie.html" class="btn add-movie-btn">Add new movie</a>
          <br>
          <table class="table table-striped table-hover table-condensed">
            <thead>
              <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Begin Year</th>
                <th>End Year</th>
                <th>Type</th>
                <th>Plot</th>
                <th>Total Voters</th>
                <th>Total Rating</th>
                <th>Img</th>
                <th>Option</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="mv" items="${listMovies}">
                <tr>
                  <td>${mv.idMovie}</td>
                  <td>${mv.title}</td>
                  <td>${mv.beginYear}</td>
                  <td>${mv.endYear}</td>
                  <td>${mv.type}</td>
                  <td>${mv.plot}</td>
                  <td>${mv.totalVoters}</td>
                  <td>${mv.totalRating}</td>
                  <td>${mv.img}</td>
                  <td>
                    <a href="${pageContext.request.contextPath}/editMovie/${mv.idMovie}.html" title="Edit"><i class="glyphicon glyphicon-edit"></i></a> | 
                    <a href="${pageContext.request.contextPath}/deleteMovie/${mv.idMovie}.html" onclick="return confirm('Are you sure?')" title="Delete"><i class="glyphicon glyphicon-trash"></i></a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
    </div>
  </body>
</html>