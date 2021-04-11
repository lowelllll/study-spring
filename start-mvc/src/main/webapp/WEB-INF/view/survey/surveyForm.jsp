<%@ page contentType="text/html; charset=utf-8" %>
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
        <p>1. 당신의 역할은?<br/>
            <label><input type="radio" name="responses[0]" value="서버">서버 개발자</label>
            <label><input type="radio" name="responses[0]" value="프론트">프론트 개발자</label>
            <label><input type="radio" name="responses[0]" value="풀스택">풀스택 개발자</label>
        </p>
        <p>1. 가장 많이 쓰는 개발도구는?<br/>
            <label><input type="radio" name="responses[1]" value="eclipse">eclipse</label>
            <label><input type="radio" name="responses[1]" value="intellij">intellij</label>
            <label><input type="radio" name="responses[1]" value="sublimetext">sublimetext</label>
        </p>
        <p>
            3. 하고싶은말 <br/>
            <input type="text" name="responses[2]">
        </p>
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