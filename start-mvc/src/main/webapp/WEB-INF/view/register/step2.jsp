<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!--스프링이 제공하는 폼 태그를 사용--->
<!doctype html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입</title>
</head>
<body>
    <h2>회원 정보 입력</h2>
    <form:form action="step3" method = "post" modelAttribute="data">
        <p>
            <label>이메일:</label>
            <form:input path="email"/>
        </p>
        <p>
            <label>이름:</label>
            <form:input path="name"/>
        </p>
        <p>
            <label>비밀번호:</label>
            <form:password path="password"/>
        </p>
        <p>
            <label>비밀번호 확인:</label>
            <form:password path="confirmPassword"/>
        </p>
        <input type="submit" value="가입 완료">
    </form:form>
</body>
</html>