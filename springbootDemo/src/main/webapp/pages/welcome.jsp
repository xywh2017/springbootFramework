<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<c:url value="arrays.txt" var="url"/>
	<spring:url value="arrays.txt" htmlEscape="true" var="springUrl" />
	Spring URL: test1
	<br>
	JSTL URL: test2
	<br>
	Message: test3
</body>

</html>
