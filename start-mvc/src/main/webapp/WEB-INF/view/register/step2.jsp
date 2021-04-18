<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--스프링이 제공하는 폼 태그를 사용--->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><spring:message code="member.register"/></title>
</head>
<body>
<h2><spring:message code="member.info"/></h2>
<form:form action="step3" method="post" modelAttribute="data">
    <p>
        <label><spring:message code="email"/>:</label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </p>
    <p>
        <label><spring:message code="name"/>:</label>
        <form:input path="name"/>
        <form:errors path="name"/>
    </p>
    <p>
        <label><spring:message code="password"/>:</label>
        <form:password path="password"/>
        <form:errors path="password"/>
    </p>
    <p>
        <label><spring:message code="password.confirm"/>:</label>
        <form:password path="confirmPassword"/>
        <form:errors path="confirmPassword"/>
    </p>
    <input type="submit" value="<spring:message code="register.btn"/>">
</form:form>
</body>
</html>