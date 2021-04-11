<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>응답내용</title>
</head>
<body>
    <p>응답내용</p>
    <ul>
        <c:forEach var="response" items="${ansData.responses}" varStatus="status">
            <li>${status.index + 1}번 문항: ${response}</li>
        </c:forEach>
    </ul>
<p>응답자 사는곳: ${ansData.res.location}</p>
<p>응답자 나이: ${ansData.res.age}</p>
</body>
</html>