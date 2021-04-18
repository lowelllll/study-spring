<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>설문조사</title>
</head>
<body>
<h2>설문조사</h2>
<form action="" method="post">
    <c:forEach var="question" items="${questions}" varStatus="status">
        ${status.index + 1}.${question.title} <br>
        <c:if test="${question.choice}">
            <c:forEach var="option" items="${question.options}">
                <label>
                    <input type="radio" name="responses[${status.index}]" value="${option}">
                        ${option}
                </label>
            </c:forEach>
        </c:if>
        <c:if test="${!question.choice}">
            <input type="text" name="responses[${status.index}]">
        </c:if>
        <br/>
    </c:forEach>
    <p>
        사는곳: <br/>
        <input type="text" name="res.location">
    </p>
    <p>
        나이: <br/>
        <input type="text" name="res.age">
    </p>
    <input type="submit" value="전송">
</form>
</body>
</html>