<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Popcorn Flavor</title>
</head>
<body>

	<spring:form method="post" commandName="mv" >
		<table border="0" cellpadding="2" cellspacing="2">
			<tr>
				<td>ID Movie</td>
				<td><spring:input path="idMovie" readonly="true"/></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><spring:input path="title"/></td>
			</tr>
			<tr>
				<td>Begin Year</td>
				<td><spring:input path="beginYear"/></td>
			</tr>
			<tr>
				<td>End Year</td>
				<td><spring:input path="endYear"/></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><spring:input path="type"/></td>
			</tr>
			<tr>
				<td>Plot</td>
				<td><spring:input path="plot"/></td>
			</tr>
			<tr>
				<td>Total Voters</td>
				<td><spring:input path="totalVoters"/></td>
			</tr>
			<tr>
				<td>Total Rating</td>
				<td><spring:input path="totalRating"/></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><spring:input path="img"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</spring:form>

</body>
</html>